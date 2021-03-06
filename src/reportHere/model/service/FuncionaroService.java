/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reportHere.model.ConnectionManager;
import reportHere.model.base.service.BaseFuncionarioService;
import reportHere.model.dao.FuncionarioDAO;
import reportHere.model.pojo.Funcionario;

public class FuncionaroService implements BaseFuncionarioService {

    public void create(Funcionario e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Funcionario readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Funcionario funcionario = new Funcionario();
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            funcionario = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return funcionario;
    }

    public List<Funcionario> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Funcionario> lista = new ArrayList<Funcionario>();
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
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

    public void update(Funcionario e) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
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
            FuncionarioDAO dao = new FuncionarioDAO();
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
