package br.ufrn.imd.users;

public abstract class Usuario implements Comparable<Usuario>{

    protected String nome;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean ePremium() {
        return false;
    }

    @Override
    public String toString() {
        return nome + " " + senha;
    }

    @Override
    public int compareTo(Usuario o) {
        return this.nome.compareTo(o.getNome());
    }

}
