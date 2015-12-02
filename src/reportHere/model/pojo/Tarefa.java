/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import reportHere.model.base.BasePOJO;

public class Tarefa extends BasePOJO{

    private String descricao;
    private String data;
    private Float gasto;
    private Boolean status;
    private Funcionario funcionario;
    private Ocorrencia ocorrencia;

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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the gasto
     */
    public Float getGasto() {
        return gasto;
    }

    /**
     * @param gasto the gasto to set
     */
    public void setGasto(Float gasto) {
        this.gasto = gasto;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

}
