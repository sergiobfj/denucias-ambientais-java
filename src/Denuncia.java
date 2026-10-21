public class Denuncia {
    private final int id;
    private final String tipo;
    private final String descricao;
    private final String local;
    private final String denunciante;
    private String status;

    public Denuncia(int id, String tipo, String descricao, String local, String denunciante) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.local = local;
        this.denunciante = denunciante;
        this.status = "RECEBIDA";
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void exibir() {
        System.out.println("\nID: " + id + " | Tipo: " + tipo + " | Status: " + status);
        System.out.println("Descrição: " + descricao);
        System.out.println("Local: " + local);
        System.out.println("Denunciante: " + denunciante);
    }
}
