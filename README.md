# Denúncias Ambientais

Sistema de console em Java para registrar e classificar denúncias ambientais na região da Caatinga.

## Sobre

Roda no terminal (sem interface gráfica). Qualquer cidadão, identificado ou anônimo, registra uma denúncia e o sistema classifica a gravidade automaticamente conforme o tipo.

| Tipo | Base do cálculo da gravidade |
|------|------------------------------|
| Queimada | Área atingida (ha) e proximidade de área habitada |
| Desmatamento | Área desmatada (ha) e se é área protegida |
| Descarte irregular | Volume (m³), tipo de resíduo e proximidade de água |

**Gravidade:** `BAIXA` · `MEDIA` · `ALTA` · `CRITICA`
**Status:** `RECEBIDA` · `EM_ANALISE` · `PROCEDENTE` · `IMPROCEDENTE`

## Funcionalidades

- Registrar denúncia (queimada, desmatamento ou descarte irregular)
- Classificar a gravidade automaticamente
- Listar e filtrar (por tipo, status ou gravidade)
- Atualizar status e remover denúncias
- Persistir tudo em SQLite local

## Tecnologias

- **Java 17**
- **SQLite** via JDBC (`org.xerial:sqlite-jdbc`)
- **Maven**

## Como rodar

```bash
git clone https://github.com/sergiobfj/denuncias-ambientais.git
cd denuncias-ambientais
mvn compile exec:java
```

O banco `denuncias.db` é criado sozinho na primeira execução.

## POO aplicada

- **Abstração** · `Ocorrencia` (abstrata) com `calcularGravidade()`
- **Herança** · `Queimada`, `Desmatamento`, `DescarteIrregular` estendem `Ocorrencia`
- **Polimorfismo** · cada tipo calcula a gravidade à sua maneira
- **Encapsulamento** · atributos `private` com getters/setters

## Estrutura

```
src/main/java/br/com/denuncias/
├── Main.java          # menu de console
├── model/             # Ocorrencia, subtipos, Local, Denunciante, enums
└── dao/               # ConexaoSQLite, OcorrenciaDAO
```
