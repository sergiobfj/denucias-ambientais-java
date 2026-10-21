# Denúncias Ambientais

Projeto de faculdade em Java para registrar denúncias ambientais na Caatinga pelo terminal.
Esta é uma versão inicial e enxuta, usando apenas a biblioteca padrão do Java.

## O que funciona

- Cadastrar queimada, desmatamento ou descarte irregular.
- Informar descrição, local e nome do denunciante (opcional para denúncia anônima).
- Listar denúncias, alterar seu status e excluir pelo ID.
- Tratar opções inválidas, campos vazios e IDs inexistentes.

Os dados ficam em uma `ArrayList` e são perdidos ao fechar o programa.
Banco de dados, cálculo de gravidade, filtros e herança ficam para a próxima etapa.
Esta versão ainda não atende ao requisito final de persistência em banco relacional.

## Como executar

Instale um **JDK 17 ou superior**, com `java` e `javac` no PATH. No PowerShell, na pasta do projeto:

```powershell
.\executar.cmd
```

Também é possível compilar e executar diretamente, sem Maven ou dependências:

```powershell
javac --release 17 -encoding UTF-8 -d out src/Main.java src/Denuncia.java
java -cp out Main
```

## Estrutura

```text
src/
  Main.java       # Menu, leitura de dados e lista em memória
  Denuncia.java   # Dados da denúncia e alteração de status
docs/             # Enunciado e proposta originais
executar.cmd      # Compila e abre o programa no Windows
README.md
.gitignore
```

A pasta `out/` é gerada ao compilar. O código usa classes, objetos, atributos privados,
construtor, métodos, lista, condições, laços e tratamento básico de exceções.
