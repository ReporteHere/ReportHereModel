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
import reportHere.model.base.service.BaseUsuarioService;
import reportHere.model.dao.UsuarioDAO;
import reportHere.model.pojo.Usuario;

public class UsuarioService implements BaseUsuarioService{

    public void create(Usuario e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Usuario readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Usuario usuario = new Usuario();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return usuario;
    }

    public List<Usuario> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario>  lista = new ArrayList<Usuario>();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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

    public void update(Usuario e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
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
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

        public Usuario login(String usuario, String senha) throws Exception {
        Usuario usuarioLogado = null;
        //senha = encode(senha);
        try {
            Connection conn = ConnectionManager.getInstance().getConnection();
            UsuarioDAO dao = new UsuarioDAO();
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put(UsuarioDAO.CRITERION_LOGIN_EQ, usuario);
            criteria.put(UsuarioDAO.CRITERION_SENHA_EQ, senha);
            List<Usuario> usuarios = dao.readByCriteria(criteria, conn);
            if (usuarios != null && usuarios.size()==1) {
                usuarioLogado = usuarios.get(0);
                if (!usuarioLogado.getLogin().equals(usuario)) {
                    usuarioLogado = null;
                } else {
                    if (!usuarioLogado.getSenha().equals(senha)) {
                        usuarioLogado = null;
                    }
                }
            }
            conn.close();
        } catch (Exception e) {
        }
        return usuarioLogado;
    }

    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Usuario> filtrarUsuarios(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            lista = dao.filtrarUsuario(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }
public List<Usuario> mostrarUsuarios(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario> lista = new ArrayList<Usuario>();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            lista = dao.mostrarUsuarios(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }

    public void updateOuvidor(Usuario e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
