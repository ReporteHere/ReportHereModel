/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.service;

import java.sql.Connection;
import reportHere.model.ConnectionManager;
import reportHere.model.base.service.BaseDepartamentoOcorrenciaService;
import reportHere.model.dao.DepartamentoOcorrenciaDAO;
import reportHere.model.pojo.DepartamentoOcorrencia;

public class DepartamentoOcorrenciaService implements BaseDepartamentoOcorrenciaService{

    public void create(DepartamentoOcorrencia e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DepartamentoOcorrenciaDAO dao = new DepartamentoOcorrenciaDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }
}
