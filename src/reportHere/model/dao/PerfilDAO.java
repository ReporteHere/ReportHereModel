/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reportHere.model.base.BaseDAO;
import reportHere.model.pojo.Perfil;

public class PerfilDAO implements BaseDAO<Perfil> {

    public static final String CRITERION_NOME_I_LIKE = "criterionNomeILike";

    public void create(Perfil pojo, Connection conn) throws Exception {
        String sql = "INSERT INTO perfil(nome) VALUES(?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, pojo.getNome());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pojo.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Perfil readById(Long id,Connection conn) throws Exception {
        Perfil perfil = null;
        String sql = "SELECT * FROM perfil where id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
                perfil = new Perfil();
                perfil.setId(id);
                perfil.setNome(rs.getString("nome"));
        }
        rs.close();
        ps.close();
        return perfil;
    }

    public List<Perfil> readByCriteria(Map<String, Object> criteria,Connection conn) throws Exception {

        List<Perfil> lista = new ArrayList<Perfil>();
        String sql = "SELECT * FROM perfil where 1 = 1 ";

        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);
        if(criterioNomeILike != null){
            sql += " AND nome ILIKE '%"+criterioNomeILike+"%'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Perfil perfil = new Perfil();
            perfil.setId(rs.getLong("id"));
            perfil.setNome(rs.getString("nome"));
            lista.add(perfil);
        }
        return lista;
    }

    public void update(Perfil e,Connection conn) throws Exception {
        String sql = "UPDATE perfil SET nome = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM perfil WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ps.execute();
        ps.close();
    }


}
