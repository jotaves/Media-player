 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.imd.interfaces;

/**
 * Classe do tipo Interface que descreve as funções obrigatorias para as classes DAO.
 *
 * @author João Victor Bezerra Barboza
 * @author Pedro Arthur Medeiros Fernandes
 */

public interface GenericDao {

    public boolean adicionar(Object o);

    public void remover(Object o);
    //public void listarTodos();
}
