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
import reportHere.model.pojo.TipoUsuario;

public class TipoUsuarioDAO implements BaseDAO<TipoUsuario>{


    public static final String CRITERION_NOME_I_LIKE = "nome";

    public void create(TipoUsuario pojo, Connection conn) throws Exception {
        String sql = "INSERT INTO tipo_usuario(nome) VALUES(?) RETURNING id;";
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

    public TipoUsuario readById(Long id,Connection conn) throws Exception {
        TipoUsuario tipoUsuario = null;
        String sql = "SELECT id,nome FROM tipo_usuario WHERE id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
                tipoUsuario = new TipoUsuario();
                tipoUsuario.setId(id);
                tipoUsuario.setNome(rs.getString("nome"));
        }
        rs.close();
        ps.close();
        return tipoUsuario;
    }

    public List<TipoUsuario> readByCriteria(Map<String, Object> criteria,Connection conn) throws Exception {

        List<TipoUsuario> lista = new ArrayList<TipoUsuario>();
        String sql = "SELECT id,nome FROM tipo_usuario where 1 = 1 ";

        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);
        if(criterioNomeILike != null){
            sql += " AND nome ILIKE '%"+criterioNomeILike+"%'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getLong("id"));
            tipoUsuario.setNome(rs.getString("nome"));
            lista.add(tipoUsuario);
        }
        return lista;
    }

    public void update(TipoUsuario e,Connection conn) throws Exception {
        String sql = "UPDATE tipo_usuario SET nome = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM tipo_usuario WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ps.execute();
        ps.close();
    }

}
