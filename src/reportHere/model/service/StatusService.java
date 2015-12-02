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
import reportHere.model.base.service.BaseStatusService;
import reportHere.model.dao.StatusDAO;
import reportHere.model.pojo.Status;

public class StatusService implements BaseStatusService{

    public void create(Status e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            StatusDAO dao = new StatusDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Status readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Status status = new Status();
        try {
            StatusDAO dao = new StatusDAO();
            status = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return status;
    }

    public List<Status> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Status> lista = new ArrayList<Status>();
        try {
            StatusDAO dao = new StatusDAO();
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

    public void update(Status e) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            StatusDAO dao = new StatusDAO();
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
        try {
            StatusDAO dao = new StatusDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
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
