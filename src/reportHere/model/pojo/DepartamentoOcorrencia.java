/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import java.util.Date;

public class DepartamentoOcorrencia{

    private Usuario usuario;
    private Ocorrencia ocorrencia;
    private Date data;

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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}
