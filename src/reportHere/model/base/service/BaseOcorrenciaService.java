/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.base.service;

import java.util.List;
import java.util.Map;
import reportHere.model.pojo.Ocorrencia;

public interface BaseOcorrenciaService{

    public void create(Ocorrencia e) throws Exception;

    public Ocorrencia readById(Long id) throws Exception;

    public List<Ocorrencia> readByCriteria(Map<String, Object> criteria) throws Exception;

    public List<Ocorrencia> readByCriteraEncaminhamento(Map<String, Object> criteria) throws Exception;

    public void update(Ocorrencia e) throws Exception;
    
    public List<Map<String, Object>> readCountOcorrencias() throws Exception;

    public List<Map<String, Object>> readCountOcorrenciasPorDepartamento() throws Exception;

    public List<Map<String, Object>> readByStatusOcorrencia(Map<String, Object> criteria) throws Exception;
}
