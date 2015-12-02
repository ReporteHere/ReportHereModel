/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import reportHere.model.base.BaseDAO;
import reportHere.model.pojo.Status;

public class StatusDAO implements BaseDAO<Status>{

    public static final String CRITERION_NOME_I_LIKE = "criterionNomeILike";

    public void create(Status pojo, Connection conn) throws Exception {

        String sql = "INSERT INTO status(status) VALUES(?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, pojo.getStatus());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pojo.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Status readById(Long id, Connection conn) throws Exception {

        Status status = null;
        String sql = "SELECT id,status FROM status WHERE id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
                status = new Status();
                status.setId(id);
                status.setStatus(rs.getString("status"));
        }
        rs.close();
        ps.close();
        return status;
    }

    public List<Status> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        List<Status> lista = new ArrayList<Status>();
        String sql = "SELECT id,status FROM Status WHERE 1 = 1 ";

        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);
        if(criterioNomeILike != null){
            sql += " AND nome ILIKE '%"+criterioNomeILike+"%'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Status status = new Status();
            status.setId(rs.getLong("id"));
            status.setStatus(rs.getString("status"));
            lista.add(status);
        }
        return lista;
    }

    public void update(Status e, Connection conn) throws Exception {

        String sql = "UPDATE status SET nome = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getStatus());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();

    }

    public void delete(Long id, Connection conn) throws Exception {

        String sql = "DELETE FROM status WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ps.execute();
        ps.close();
    }

}
