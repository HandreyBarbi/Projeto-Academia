package model;

import java.sql.Date;

public class Treino {
    private int id;
    private int aluno_id;
    private String tipo_treino;
    private String descricao;
    private int duracao_minutos;
    private Date data_inicio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAluno() {
        return aluno_id;
    }

    public void setIdAluno(int idAluno) {
        this.aluno_id = idAluno;
    }

    public String getTipoTreino() {
        return tipo_treino;
    }

    public void setTipoTreino(String tipoTreino) {
        this.tipo_treino = tipoTreino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracaoMinutos() {
        return duracao_minutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracao_minutos = duracaoMinutos;
    }

    public Date getDataInicio() {
        return data_inicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.data_inicio = dataInicio;
    }
}
