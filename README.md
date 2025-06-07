# 💪 Projeto academia

O sistema segue uma abordagem modular, com separação clara entre interface, regras de negócio e acesso a dados. Sendo também, uma aplicação Java com um menu principal com opções para gerenciar alunos e treinos, com interface de linha de comando (CLI), conexão com banco de dados MySQL e Operações CRUD completas. Desenvolvido como parte do trabalho acadêmico A3, para a disciplina de Programação de solução computacionais.

---

## ⚙️ Como funciona? 

Geral
- Menu Principal: Interface inicial com opções para acessar os módulos de Alunos ou Treinos
- Módulo de Alunos: Permite cadastrar, listar, editar, excluir e buscar alunos
- Módulo de Treinos: Permite cadastrar e gerenciar treinos associados a alunos

## Componentes Principais

1.Estrutura de Pacotes

 - Aplicacao: Contém a classe Main com a lógica principal do programa.
 - DAO: Classes de acesso a dados (AlunoDAO e TreinoDAO)
 - Model: Classes que representam as entidades do sistema (Aluno e Treino)
 - Util: Classe utilitária para conexão com o banco de dados
   
2.Funcionalidades

Para Alunos:

  - Cadastro com nome, CPF, data de nascimento, telefone e e-mail
  - Listagem de todos os alunos cadastrados
  - Edição de informações dos alunos
  - Exclusão de alunos
  - Busca por ID ou nome

Para Treinos:

  - Cadastro de treinos associados a alunos
  - Especificação de tipo de treino, descrição, duração e data de início

3.Fluxo do Programa

 - Inicia na classe Main, que estabelece conexão com o banco de dados
 - Exibe o menu principal com opções para Alunos ou Treinos
 - Cada módulo possui seu próprio menu com operações específicas
 - Todas as operações são persistidas no banco de dados MySQL

---

## 🛠️ Tecnologias

- Java (versão 8+)
- MySQL (Driver JDBC)
- Padrão DAO (Data Access Object)
- Live share (Extensão)
  
---

## 🧠 Desafios enfrentados

- Buscar conhecimento sobre banco de dados e Java. 
- Conexão com banco de dados.
- Programar em Java.
- Organização no GitHub.
  

---

## 📚 O que aprendemos?

- Integração com banco de dados.
- Aprimoramos o conhecimento em Java.
- Manuseio de IDEs e bancos de dados.

---
