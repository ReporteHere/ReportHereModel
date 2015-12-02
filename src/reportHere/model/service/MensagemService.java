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
import reportHere.model.base.service.BaseMensagemService;
import reportHere.model.dao.MensagemDAO;
import reportHere.model.pojo.Mensagem;

public class MensagemService implements BaseMensagemService{

    public void create(Mensagem e) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            MensagemDAO dao = new MensagemDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Mensagem readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Mensagem mensagem = new Mensagem();
        try {
            MensagemDAO dao = new MensagemDAO();
            mensagem = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return mensagem;
    }

    public List<Mensagem> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Mensagem> lista = new ArrayList<Mensagem>();
        try {
            MensagemDAO dao = new MensagemDAO();
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
