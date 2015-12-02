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
import reportHere.model.base.service.BaseTipoOcorrenciaService;
import reportHere.model.dao.TipoOcorrenciaDAO;
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaService implements BaseTipoOcorrenciaService {

    public void create(TipoOcorrencia e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            TipoOcorrenciaDAO dao = new TipoOcorrenciaDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public TipoOcorrencia readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoOcorrencia pojo = null;
        try {
            TipoOcorrenciaDAO dao = new TipoOcorrenciaDAO();
            pojo = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return pojo;
    }

    public List<TipoOcorrencia> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoOcorrencia> lista = new ArrayList<TipoOcorrencia>();
        try {
            TipoOcorrenciaDAO dao = new TipoOcorrenciaDAO();
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

    public void update(TipoOcorrencia e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoOcorrenciaDAO dao = new TipoOcorrenciaDAO();
            dao.update(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try{
            TipoOcorrenciaDAO dao =  new TipoOcorrenciaDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        }
        catch(Exception ex){
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
