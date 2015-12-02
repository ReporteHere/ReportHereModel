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
import reportHere.model.base.service.BaseTipoUsuarioService;
import reportHere.model.dao.TipoUsuarioDAO;
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioService  implements BaseTipoUsuarioService{

    public void create(TipoUsuario e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public TipoUsuario readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoUsuario tipoUsuario = null;
        try {
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            tipoUsuario = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoUsuario;}

    public List<TipoUsuario> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoUsuario> lista = new ArrayList<TipoUsuario>();
        try {
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        }
        catch(Exception e){
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    public void update(TipoUsuario pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try{
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            dao.update(pojo, conn);
            conn.commit();
            conn.close();
        }
        catch(Exception e){
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try{
            TipoUsuarioDAO dao = new TipoUsuarioDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        }
        catch(Exception e){
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
