package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {
    public void Cadastrar(Aluno aluno){
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.createConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getCpf());
            pstm.setDate(3, new java.sql.Date(aluno.getData_nascimento().getTime()));
            pstm.setString(4, aluno.getTelefone());
            pstm.setString(5, aluno.getEmail());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
