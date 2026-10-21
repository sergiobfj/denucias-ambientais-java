import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final ArrayList<Denuncia> denuncias = new ArrayList<>();
    private static int proximoId = 1;

    public static void main(String[] args) {
        System.out.println("Denúncias Ambientais na Caatinga");
        System.out.println("Versão básica: os dados ficam apenas na memória.");

        boolean executando = true;
        while (executando) {
            System.out.println("\n1 - Cadastrar denúncia");
            System.out.println("2 - Listar denúncias");
            System.out.println("3 - Alterar status");
            System.out.println("4 - Excluir denúncia");
            System.out.println("0 - Sair");

            try {
                int opcao = lerInteiro("Escolha: ");
                switch (opcao) {
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        listar();
                        break;
                    case 3:
                        alterarStatus();
                        break;
                    case 4:
                        excluir();
                        break;
                    case 0:
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro. Operação cancelada.");
            } catch (IllegalArgumentException erro) {
                System.out.println(erro.getMessage() + " Operação cancelada.");
            } catch (NoSuchElementException erro) {
                executando = false;
            }
        }

        entrada.close();
        System.out.println("Programa encerrado. Os dados desta sessão não são salvos.");
    }

    private static void cadastrar() {
        System.out.println("1 - Queimada | 2 - Desmatamento | 3 - Descarte irregular");
        int opcao = lerInteiro("Tipo: ");
        String tipo;
        switch (opcao) {
            case 1:
                tipo = "Queimada";
                break;
            case 2:
                tipo = "Desmatamento";
                break;
            case 3:
                tipo = "Descarte irregular";
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido.");
        }

        String descricao = lerTexto("Descrição: ");
        String local = lerTexto("Local (município/estado): ");
        System.out.print("Nome do denunciante (Enter para anônimo): ");
        String nome = entrada.nextLine().trim();
        if (nome.isEmpty()) {
            nome = "Anônimo";
        }

        Denuncia denuncia = new Denuncia(proximoId, tipo, descricao, local, nome);
        denuncias.add(denuncia);
        proximoId++;
        System.out.println("Denúncia cadastrada. ID: " + denuncia.getId());
    }

    private static void listar() {
        if (denuncias.isEmpty()) {
            System.out.println("Nenhuma denúncia cadastrada.");
        }
        for (Denuncia denuncia : denuncias) {
            denuncia.exibir();
        }
    }

    private static Denuncia buscar(int id) {
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getId() == id) {
                return denuncia;
            }
        }
        throw new IllegalArgumentException("Denúncia não encontrada.");
    }

    private static void alterarStatus() {
        Denuncia denuncia = buscar(lerInteiro("ID da denúncia: "));
        System.out.println("1 - RECEBIDA | 2 - EM_ANALISE | 3 - PROCEDENTE | 4 - IMPROCEDENTE");
        int opcao = lerInteiro("Novo status: ");
        String[] status = {"RECEBIDA", "EM_ANALISE", "PROCEDENTE", "IMPROCEDENTE"};
        if (opcao < 1 || opcao > status.length) {
            throw new IllegalArgumentException("Status inválido.");
        }
        denuncia.setStatus(status[opcao - 1]);
        System.out.println("Status atualizado.");
    }

    private static void excluir() {
        Denuncia denuncia = buscar(lerInteiro("ID da denúncia: "));
        denuncias.remove(denuncia);
        System.out.println("Denúncia excluída.");
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(entrada.nextLine().trim());
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        String texto = entrada.nextLine().trim();
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Preencha o campo obrigatório.");
        }
        return texto;
    }
}
