# 🏆 Challenge TOTVS — Análise de Transcrições com LLMs

> Solução desenvolvida para o Challenge TOTVS em parceria com a FIAP, com foco em Domain Driven Design (DDD).

---

## 👥 Grupo

| Nome | RM |
|---|---|
| Enzo Amá Fatobene | 562136 |
| João Victor Rodrigues de Mattos | 564249 |
| Leonardo Borges da Costa | 565966 |
| Paulo Henrique Barboza de Oliveira Ramos | 562179 |
| Pedro Henrique Araujo de Abreu | 561924 |

---

## 📌 Sobre o Projeto

Este projeto tem como objetivo resolver uma dor identificada na empresa **TOTVS**: vendedores apresentavam dificuldade em extrair o máximo de valor informacional das reuniões com clientes.

A solução consiste em uma **API REST** desenvolvida com **Spring Boot** que recebe transcrições de reuniões e, por meio do modelo de IA **Gemini 3.5-flash**, gera relatórios e insights automaticamente — garantindo que nenhuma informação relevante seja perdida.

O projeto foi estruturado seguindo os princípios de **Domain Driven Design (DDD)**, com o domínio no centro das decisões de arquitetura e desenvolvimento.

---

## 🛠️ Tecnologias Utilizadas

- **IntelliJ IDEA** — IDE para desenvolvimento e organização do projeto
- **Spring Boot** — Framework Java base da aplicação
- **Gemini 3.5-flash** — Modelo de IA para análise e geração de relatórios das transcrições
- **Git / GitHub** — Versionamento de código
- **Postman** — Ferramenta para teste dos endpoints (entrada e saída de dados)

> ⚠️ **Atenção:** O projeto está configurado para rodar na **JDK 25**. Versões anteriores ou posteriores podem causar erros de execução.

---

## 🗂️ Arquitetura de Pastas

```
ouro/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br.com.fiap.challenge.ouro/
│   │   │       ├── armazenamento/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── exception/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── OuroApplication.java
│   │   └── resources/
│   └── test/
├── .gitignore
├── pom.xml
└── README.md
```

---

## 📦 Descrição das Camadas

### `armazenamento`
Simula a persistência de dados por meio de listas (Arrays) em memória. Cada classe possui uma lista estática com métodos de adição e recuperação. Em versões futuras, essa camada será substituída pelo diretório `repository` com integração a um banco de dados.

### `controller`
O "coração" da aplicação. Contém `UsuarioController` e `ReuniaoController`, responsáveis pelos endpoints que gerenciam a entrada e saída de dados. Utiliza as anotações `@RestController`, `@RequestMapping`, `@GetMapping` e `@PostMapping`.

### `dto` (Data Transfer Object)
Classes do tipo `Record` (introduzidas no Java 16) que servem como objetos de transferência de dados. Para cada modelo existem DTOs distintos para entrada e saída, garantindo flexibilidade e segurança na tramitação de informações.

### `exception`
Exceções customizadas que herdam de `RuntimeException`. São lançadas quando regras de negócio não são atendidas ou quando verificações falham (como o formato de CNPJ).

### `model`
Entidades da aplicação: `Usuario` (classe abstrata), `Funcionario`, `Cliente`, `Reuniao` e `Insights`. A herança de `Funcionario` e `Cliente` a partir de `Usuario` permite o uso de `List<Usuario>` contemplando ambos os tipos.

### `service`
O "cérebro" da aplicação. Concentra toda a lógica de negócio, validações, conversões e persistência. Dividida em três tipos:

- **Serviços de modelo** — Conversão, validação (ex: CNPJ via Regex) e persistência dos modelos.
- **Serviços internos** — Utilitários reutilizáveis, como geração de IDs e ocultamento de senhas em respostas GET.
- **Serviço de API externa** — Integração com o **Gemini 3.5-flash** para análise de transcrições e geração de relatórios em `.md`.

---

## 📐 Diagrama UML

A solução conta com um diagrama UML desenvolvido no [Draw.io](https://draw.io), que contempla todas as classes e suas interações, incluindo a relação de herança (`extends`) entre `Funcionario`/`Cliente` e `Usuario`.

```
         ┌─────────────┐
         │   Usuario   │
         │─────────────│
         │ id          │
         │ nome        │
         │ senha       │
         │ idade       │
         └──────┬──────┘
       extends  │  extends
    ┌───────────┴────────────┐
    │                        │
┌───▼──────────┐    ┌────────▼──────┐
│ Funcionario  │    │    Cliente    │
│──────────────│    │───────────────│
│ cargo        │    │ CNPJ          │
│ cod_registro │    └───────┬───────┘
└──────┬───────┘            │ Participa
       │ Realiza            │
       └─────────┬──────────┘
                 ▼
          ┌─────────────┐
          │   Reuniao   │
          │─────────────│
          │ id          │
          │ data        │
          │ transcricao │
          │ participantes│
          └──────┬──────┘
                 ▼
          ┌─────────────┐
          │   Insights  │
          │─────────────│
          │ relatorio   │
          │ dashboard   │
          │ rel_simpl.  │
          └─────────────┘
```

---

## 🚀 Como Usar

### Pré-requisitos

- JDK 25 instalado
- [Postman](https://www.postman.com/) instalado
- Chave de API do Gemini (Google AI Studio)

### Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/EnzoOFato/Challenges_TOTVS_DDD.git
   ```

2. Insira sua chave da API do Gemini no campo indicado no código (não está inclusa por razões de segurança).

3. Execute a aplicação pela sua IDE (certifique-se de estar usando a JDK 25).

4. Acesse a coleção do Postman pelo link abaixo e realize as requisições.

### Ordem recomendada de requisições

Para melhor funcionamento, siga a ordem abaixo, sempre respeitando `POST` antes de `GET`:

```
Funcionário → Cliente → Reunião → Insights
```

Após o último `POST`, um relatório `.md` gerado pela IA estará disponível com base na transcrição fornecida.

---

## 🔗 Links Úteis

- 📂 **Repositório GitHub:** [Challenges_TOTVS_DDD](https://github.com/EnzoOFato/Challenges_TOTVS_DDD.git)
- 📬 **Coleção Postman:** [Acessar coleção](https://enzoamafatobene-5472715.postman.co/workspace/Enzo-Fatobene's-Workspace~0c29f1f0-bcd9-4dc3-8426-a1b647b9d877/collection/48437838-531f9e48-9785-4d44-ad7e-b4d6ba5c07f0?action=share&source=copy-link&creator=48437838)

---

## 🔭 Próximos Passos

- [ ] Integração com banco de dados (substituindo o armazenamento em memória)
- [ ] Implementação das regras de negócio específicas da TOTVS
- [ ] Geração de relatórios diretamente pela aplicação
- [ ] Integração com APIs externas adicionais (verificação de CEP, CNPJ oficial, múltiplos modelos de IA)
- [ ] Separação em microsserviços

---

## 📝 Considerações Finais

O projeto encontra-se em estágio inicial de desenvolvimento (Sprints 1 e 2 unificadas). O foco atual é a geração de relatórios simplificados a partir de transcrições de reuniões de vendas, reduzindo a perda de informações estratégicas no contexto da TOTVS.

---

> Desenvolvido com ❤️ pelo **Time Challenge 5** — FIAP 2026
