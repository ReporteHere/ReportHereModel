/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import reportHere.model.ConnectionManager;
import reportHere.model.base.service.BaseStatusOcorrenciaService;
import reportHere.model.dao.StatusOcorrenciaDAO;
import reportHere.model.pojo.StatusOcorrencia;

public class StatusOcorrenciaService implements BaseStatusOcorrenciaService{

    public void create(StatusOcorrencia e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            StatusOcorrenciaDAO dao = new StatusOcorrenciaDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public List<StatusOcorrencia> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<StatusOcorrencia> lista = new ArrayList<StatusOcorrencia>();
        try {
            StatusOcorrenciaDAO dao = new StatusOcorrenciaDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }

}
