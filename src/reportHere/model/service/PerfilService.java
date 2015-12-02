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
import reportHere.model.base.service.BasePerfilService;
import reportHere.model.dao.PerfilDAO;
import reportHere.model.pojo.Perfil;

public class PerfilService implements BasePerfilService {

    public void create(Perfil perfil) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            PerfilDAO dao = new PerfilDAO();
            dao.create(perfil, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    public Perfil readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Perfil perfil = null;
        try {
            PerfilDAO dao = new PerfilDAO();
            perfil = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return perfil;
    }

    public List<Perfil> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Perfil> lista = new ArrayList<Perfil>();
        try {
            PerfilDAO dao = new PerfilDAO();
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

    public void update(Perfil pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try{
            PerfilDAO dao = new PerfilDAO(); 
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
            PerfilDAO dao = new PerfilDAO();
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
