/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import reportHere.model.base.BasePOJO;

public class Funcionario extends BasePOJO{

    private String nome;
    private Usuario usuario;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
