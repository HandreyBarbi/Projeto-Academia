package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import model.Aluno;

public class AlunoDAO {
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String telefone;
    private String email;

    public AlunoDAO(String nome, String cpf, Date data_nascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public AlunoDAO() {
        // Construtor vazio para uso do DAO
    }

    public void cadastrar(Connection conn, Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.executeUpdate();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
}
