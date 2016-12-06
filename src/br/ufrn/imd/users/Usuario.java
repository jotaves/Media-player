package br.ufrn.imd.users;

/**
 * Classe que implementa classe abstrata Usuario.
 *
* @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public abstract class Usuario implements Comparable<Usuario> {

    protected String nome;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    /**
     * Retorna nome do Usuario.
     *
     * @return nome do Usuario.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Pega a senha do Usuario.
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Verifica se o objeto pertence a classe UsuarioComum ou UsuarioPremium
     *
     * @return retorna true se o o bjeto for da classe UsuarioPremium e false
     * caso contrario.(neste caso sempre false por padrão).
     */
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
