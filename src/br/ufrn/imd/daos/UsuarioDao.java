/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.daos;

import br.ufrn.imd.estrututas.abb.NodeArvore;
import br.ufrn.imd.estrututas.abb.TADArvore;
import br.ufrn.imd.interfaces.GenericDao;
import br.ufrn.imd.users.Usuario;
import br.ufrn.imd.users.UsuarioComum;
import br.ufrn.imd.users.execoes.LoginExeption;

/**
 * Classe que implementa O banco de Usuarios.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */
public class UsuarioDao implements GenericDao {

    private static TADArvore<Usuario> usuarios;
    private static UsuarioDao uniqueInstance;

    UsuarioDao() {
    }

    /**
     * Construtor da classe
     * @return Instância da classe
     */
    public static synchronized UsuarioDao getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new UsuarioDao();
            usuarios = new TADArvore<>();
        }
        return uniqueInstance;
    }

    /**
     * Verificar usuário pelo nome na árvore binária de busca
     * @param nome Nome do usuário
     * @return true, se o nome existir na árvore; false, se não for
     */
    public boolean verificarUsuario(String nome) {
        Usuario u = new UsuarioComum(nome, "");
        return usuarios.buscarArvore(u) != null;
    }

    /**
     * Verificar usuário pelo nome e senha na árvore binária de busca
     * @param nome Nome do usuário
     * @param senha Senha do usuário
     * @return true, se o usuário existir na árvore; false, se não
     * @throws br.ufrn.imd.users.execoes.UsuarioExeption
     */
    public boolean verificarUsuarioESenha(String nome, String senha) throws LoginExeption{
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);
        if(!(n != null && nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha()))){
            throw new LoginExeption("Usuário não exite!");
        }
        return true;
    }

    /**
     * Verifica se um usuário é premium
     * @param nome Nome do usuário
     * @param senha Senha do usuário
     * @return true, se o usuário for premium; false, se não
     */
    public boolean ePremium(String nome, String senha) {
        Usuario u = new UsuarioComum(nome, senha);
        NodeArvore<Usuario> n = usuarios.buscarArvore(u);
        return nome.equals(n.getConteudo().getNome()) && senha.equals(n.getConteudo().getSenha()) && n.getConteudo().ePremium();
    }

    /**
     * Retorna a árvore com todos os usuários
     * @return
     */
    public TADArvore<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Adicionar um usuário à lista
     * @param o Usuário a ser adicionado
     * @return true, se o usuário foi adicionado; false, se não
     */
    @Override
    public boolean adicionar(Object o) {
        return usuarios.inserir((Usuario) o);
    }

    /**
     * Remover um usuário da lista
     * @param o Usuário a ser removido
     */
    @Override
    public void remover(Object o) {
        usuarios.remover((Usuario) o);
    }
}
