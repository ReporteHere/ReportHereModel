/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.pojo;

import java.util.Date;
import reportHere.model.base.BasePOJO;

public class StatusOcorrencia extends BasePOJO{

        private Status status;
        private Ocorrencia ocorrencia;
        private Date data;

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
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
