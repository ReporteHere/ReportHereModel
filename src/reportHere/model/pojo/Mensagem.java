/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import reportHere.model.base.BasePOJO;

public class Mensagem extends BasePOJO {

    private String descricao;
    private Ocorrencia ocorrencia;
    private String tipo;

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the ocorrencia
     */
    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    /**
     * @param ocorrencia the ocorrencia to set
     */
    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
