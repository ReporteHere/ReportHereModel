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
import reportHere.model.base.service.BaseOcorrenciaService;
import reportHere.model.dao.OcorrenciaDAO;
import reportHere.model.pojo.Ocorrencia;

public class OcorrenciaService implements BaseOcorrenciaService{

    public void create(Ocorrencia e) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            dao.create(e, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }

    public Ocorrencia readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Ocorrencia ocorrencia = new Ocorrencia();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            ocorrencia = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return ocorrencia;
    }

    public List<Ocorrencia> readByCriteria(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Ocorrencia> lista = new ArrayList<Ocorrencia>();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
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

    public List<Ocorrencia> readByCriteraEncaminhamento(Map<String, Object> criteria) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Ocorrencia> lista = new ArrayList<Ocorrencia>();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            lista = dao.readByCriteriaEncaminhamento(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }

    public void update(Ocorrencia e) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            dao.update(e,conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
    }
        public List<Map<String, Object>> readCountOcorrencias() throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            lista = dao.readCountOcorrencias(conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }

    public List<Map<String, Object>> readCountOcorrenciasPorDepartamento() throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            lista = dao.readCountOcorrenciasPorDepartamento(conn);
            conn.commit();
            conn.close();
        } catch (Exception ex) {
            conn.rollback();
            conn.close();
            throw ex;
        }
        return lista;
    }

    public List<Map<String, Object>> readByStatusOcorrencia(Map<String, Object> criteria) throws Exception {
              Connection conn = ConnectionManager.getInstance().getConnection();
        List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
        try {
            OcorrenciaDAO dao = new OcorrenciaDAO();
            lista = dao.readByStatusOcorrencia(conn, criteria);
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
