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

    /*
     * Esse ponto vocês começam a desenvolver o código de vocês.
     * Façam os métodos dentro da classe Main, que serão chamados para fazer o menu inicial, tela de alunos e tela de treinos.
     * Vocês podem criar outros métodos para organizar o código, mas não esqueçam de manter a lógica dentro da classe Main.
     */
    int choose;
    Scanner scanner = new Scanner(System.in);
   
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

    /*
     *   Nessa área vocês vão fazer os métodos para a CLI.
     *   Alunos, treinos, etc.
     */
    public class App { //Essa parte foi feita por Handrey
        public static void main(String[] args) throws Exception {
        }
        
    class MenuInicial{
        public void menu (int choose) {
        System.out.println(" --------------------");
        System.out.println(" -- Menu Principal --");
        System.out.println(" --------------------");
        System.out.println("");
        System.out.println(" Escolha uma das opções:");
        System.out.println(" [1] Alunos");
        System.out.println(" [2] Treinos");
        System.out.println(" [3] Sair");
        choose = scanner.nextInt();

        switch (choose) {
            case 1:
            menuAluno();
            break;
             case 2:
            menuTreino();
            break;
             case 3:
            Sair();
            break;

        }
    }
    }
    }

    class alunoMenu { //Murilo
    /*
    Murilo -> Cadastrar um novo aluno (nome, CPF, data de nascimento, telefone, e-mail)
    Murilo -> Listar todos os alunos cadastrados.
    Murilo -> Editar informações de um aluno existente.
    Handrey --> Excluir um aluno do sistema.
    Handrey --> Buscar aluno por nome ou CPF.
    */

    // Aqui
    public void menuAluno() {
        System.out.println(" ---------------------");
        System.out.println(" ---- Menu Alunos ----");
        System.out.println(" ---------------------");
        System.out.println(" [1] Cadastrar novo aluno");
        System.out.println(" [2] Listar alunos cadastrados");
        System.out.println(" [3] Editar informações de aluno");
        System.out.println(" [4] Excluir alunos");
        System.out.println(" [5] Buscar aluno");
        choose = scanner.nextInt();
        
        switch (choose){
            case 1: //cadastrar
            //num1;
            break;
            case 2: //listar
            //num2;
            break;
            case 3: //editar
            //num3;
            break;
            case 4: //excluir
            //num4;
            break;
            case 5: //buscar
            //num5;
            break;
        }
    
    }
    }

    class treinoMenu{ 
        public void menuTreino(){
     
            System.out.println(" --------------------");
            System.out.println(" -------Treino-------");
            System.out.println(" --------------------");
            System.out.println(" [1] Cadastrar treino");
            System.out.println(" [2] Listar treino");
            System.out.println(" [3] Atualizar informações cadastrais");
            System.out.println(" [4] Excluir treino");

            switch (choose){
            case 1: //cadastrar
            //num1;
            break;
            case 2: //listar
            //num2;
            break;
            case 3: //atualizar
            //num3;
            break;
            case 4: //excluir
            //num4;

        
        
        
        
        
        
        //Josy
        /*
    Cadastrar um treino para um aluno (tipo de treino, descrição, duração, data de início).
    Listar todos os treinos de um aluno específico.
    Editar informações de um treino.
    Excluir um treino.

        */
    }
    }
    class sair{ //Henrique
        public void Sair(){

        }
    }




    /**
     * Método para cadastrar um novo aluno.
     * Solicita os dados do aluno e insere no banco de dados.
     */

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
