/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.base.service;

import java.util.List;
import java.util.Map;
import reportHere.model.pojo.StatusOcorrencia;

public interface BaseStatusOcorrenciaService{

    public void create(StatusOcorrencia e) throws Exception;

    public List<StatusOcorrencia> readByCriteria(Map<String, Object> criteria) throws Exception;

}
