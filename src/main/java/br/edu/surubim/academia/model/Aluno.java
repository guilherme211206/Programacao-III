package br.edu.surubim.academia.model;


public class Aluno {
    private final int id;
    private final String nome;
    private final String telefone;
    private Plano plano;

    public Aluno(int id, String nome, String telefone, Plano plano) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }
        this.id = id;
        this.nome = nome.trim();
        this.telefone = telefone == null ? "" : telefone.trim();
        setPlano(plano);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public Plano getPlano() { return plano; }

    public void setPlano(Plano plano) {
        if (plano == null) throw new IllegalArgumentException("Plano inválido.");
        this.plano = plano;
    }
}
