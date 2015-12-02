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
import reportHere.model.base.service.BaseTarefaService;
import reportHere.model.dao.TarefaDAO;
import reportHere.model.pojo.Tarefa;

public class TarefaService implements BaseTarefaService{

    public void create(Tarefa e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TarefaDAO dao = new TarefaDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Tarefa readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Tarefa tarefa = new Tarefa();
        try {
            TarefaDAO dao = new TarefaDAO();
            tarefa = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return tarefa;
    }

    public List<Tarefa> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Tarefa> lista = new ArrayList<Tarefa>();
        try {
            TarefaDAO dao = new TarefaDAO();
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

    public void update(Tarefa e) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TarefaDAO dao = new TarefaDAO();
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
            TarefaDAO dao = new TarefaDAO();
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
