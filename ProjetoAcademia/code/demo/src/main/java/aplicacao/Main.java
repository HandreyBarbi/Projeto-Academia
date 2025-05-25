package aplicacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import dao.AlunoDAO;
import dao.TreinoDAO;
import model.Aluno;
import model.Treino;

public class Main {
    public static void main(String[] args) {
        // Exemplo de conexão, ajuste para o seu banco
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seubanco", "usuario", "senha")) {
            // Exemplo de uso:
            // cadastrarAluno();
            cadastrarTreino(connection);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static void cadastrarAluno() {
        Aluno aluno = criarNovoAluno();
        AlunoDAO alunoDAO = new AlunoDAO(
            aluno.getNome(),
            aluno.getCpf(),
            java.sql.Date.valueOf(aluno.getDataNascimento()),
            aluno.getTelefone(),
            aluno.getEmail()
        );
        alunoDAO.inserir(aluno);
    }

    public static Aluno criarNovoAluno() {
        Aluno aluno = new Aluno();
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nome: ");
            aluno.setNome(scanner.nextLine());

            System.out.print("CPF: ");
            aluno.setCpf(scanner.nextLine());

            System.out.print("Telefone: ");
            aluno.setTelefone(scanner.nextLine());

            System.out.print("Email: ");
            aluno.setEmail(scanner.nextLine());

            System.out.print("Data de nascimento (yyyy-MM-dd): ");
            try {
                String dataStr = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date data = sdf.parse(dataStr);
                aluno.setDataNascimento(data.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            } catch (java.text.ParseException | java.time.DateTimeException e) {
                System.err.println("Erro ao processar a data de nascimento: " + e.getMessage());
            }
        }
        return aluno;
    }

    public static void cadastrarTreino(Connection connection) {
        try (Scanner scanner = new Scanner(System.in)) {
            Treino treino = new Treino();

            System.out.print("ID do Aluno: ");
            treino.setIdAluno(Integer.parseInt(scanner.nextLine()));

            System.out.print("Tipo de treino: ");
            treino.setTipoTreino(scanner.nextLine());

            System.out.print("Descrição: ");
            treino.setDescricao(scanner.nextLine());

            System.out.print("Duração em minutos: ");
            treino.setDuracaoMinutos(Integer.parseInt(scanner.nextLine()));

            System.out.print("Data de início (yyyy-MM-dd): ");
            try {
                String dataStr = scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date data = sdf.parse(dataStr);
                treino.setDataInicio(new Date(data.getTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                TreinoDAO treinoDAO = new TreinoDAO(connection);
                treinoDAO.inserir(treino);
                System.out.println("Treino cadastrado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
