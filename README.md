# Denúncias Ambientais

Sistema de console em Java para **registrar e classificar denúncias ambientais na região da Caatinga**.

Projeto acadêmico da disciplina de **Programação Orientada a Objetos**.

---

## Sobre o projeto

A aplicação roda inteiramente no terminal (sem interface gráfica) e permite que denúncias ambientais
sejam registradas por qualquer cidadão — identificado ou anônimo — e classificadas automaticamente por
nível de gravidade.

São previstos três tipos de ocorrência, cada um com **sua própria regra de gravidade**:

| Tipo | Critérios previstos para o cálculo da gravidade |
|------|--------------------------------------------------|
| **Queimada** | Área atingida (hectares) e proximidade de área habitada |
| **Desmatamento** | Área desmatada (hectares) e se ocorreu em área protegida |
| **Descarte irregular** | Volume (m³), tipo de resíduo e proximidade de fonte de água |

A gravidade resultante será sempre um dos níveis: `BAIXA`, `MEDIA`, `ALTA` ou `CRITICA`.

Cada denúncia acompanhará um status dentro do fluxo de apuração: `RECEBIDA`, `EM_ANALISE`,
`PROCEDENTE` ou `IMPROCEDENTE`.

---

## Funcionalidades previstas

- Registrar uma nova denúncia (queimada, desmatamento ou descarte irregular)
- Classificar automaticamente a gravidade conforme a regra do tipo de ocorrência
- Listar todas as denúncias registradas
- Filtrar denúncias por tipo, status ou gravidade
- Atualizar o status de uma denúncia
- Remover uma denúncia
- Persistir todos os dados em banco SQLite local

---

## Tecnologias

- **Java 17**
- **SQLite** — persistência local, acessada via **JDBC** (driver `org.xerial:sqlite-jdbc`)
- **Maven** — gerenciamento de dependências e execução

---

## Pré-requisitos

- JDK 17 ou superior instalado (`java -version`)
- Maven instalado (`mvn -version`)
- Não é necessário instalar o SQLite separadamente: o driver JDBC cria o arquivo do banco
  automaticamente na primeira execução

---

## Conceitos de POO que serão aplicados

- **Abstração** — `Ocorrencia` será uma classe abstrata definindo o que toda denúncia ambiental tem em
  comum (descrição, data, local, denunciante, status) e declarando o método abstrato
  `calcularGravidade()`, sem decidir *como* essa gravidade é calculada.

- **Herança** — `Queimada`, `Desmatamento` e `DescarteIrregular` estenderão `Ocorrencia`, reaproveitando
  o comportamento comum e acrescentando apenas os atributos específicos de cada tipo (área atingida,
  área protegida, volume de resíduo etc.).

- **Polimorfismo** — o sistema trabalhará com listas de `Ocorrencia` e chamará `calcularGravidade()` sem
  saber qual é o tipo concreto; cada subclasse responderá com sua própria regra. Incluir um novo tipo de
  ocorrência no futuro não exigirá alterar o código que já consome a lista.

- **Encapsulamento** — os atributos das classes de modelo serão `private`, acessíveis apenas por getters
  e setters, protegendo o estado interno dos objetos e concentrando as validações em um único lugar.

---

## Estrutura de pastas planejada

Os arquivos `.java` abaixo **ainda serão criados** — nesta etapa existem apenas as pastas.

```
denuncias-ambientais/
├── README.md
├── .gitignore
├── pom.xml                          # a criar
└── src/main/java/br/com/denuncias/
    ├── Main.java                    # a criar — ponto de entrada e menu de console
    ├── model/                       # classes de domínio
    │   ├── Ocorrencia.java          # a criar — classe abstrata, calcularGravidade()
    │   ├── Queimada.java            # a criar — extends Ocorrencia
    │   ├── Desmatamento.java        # a criar — extends Ocorrencia
    │   ├── DescarteIrregular.java   # a criar — extends Ocorrencia
    │   ├── Local.java               # a criar — município, estado, coordenadas
    │   ├── Denunciante.java         # a criar — dados de quem denuncia (pode ser anônimo)
    │   ├── Status.java              # a criar — enum: RECEBIDA, EM_ANALISE, PROCEDENTE, IMPROCEDENTE
    │   └── Gravidade.java           # a criar — enum: BAIXA, MEDIA, ALTA, CRITICA
    └── dao/                         # camada de acesso a dados
        ├── ConexaoSQLite.java       # a criar — conexão JDBC e criação das tabelas
        └── OcorrenciaDAO.java       # a criar — operações de CRUD das ocorrências
```

---


