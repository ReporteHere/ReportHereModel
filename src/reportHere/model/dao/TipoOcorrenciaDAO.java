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
import reportHere.model.pojo.TipoOcorrencia;

public class TipoOcorrenciaDAO implements BaseDAO<TipoOcorrencia> {

    public static final String CRITERION_NOME_I_LIKE = "criterionNomeILike";

    public void create(TipoOcorrencia e, Connection conn) throws Exception {

        String sql = "INSERT INTO tipo_ocorrencia(nome) VALUES (?) RETURNING id";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public TipoOcorrencia readById(Long id, Connection conn) throws Exception {
        
        String sql = "SELECT * FROM tipo_ocorrencia WHERE id = ?";
        TipoOcorrencia pojo = null; 
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            pojo = new TipoOcorrencia();
            pojo.setId(rs.getLong("id"));
            pojo.setNome(rs.getString("nome"));
        }
        
        rs.close();
        ps.close();
        return pojo;
    }

    public List<TipoOcorrencia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "SELECT * FROM tipo_ocorrencia WHERE 1=1 ";
        List<TipoOcorrencia> lista = new ArrayList<TipoOcorrencia>();
        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);

        if(criterioNomeILike!=null && !criterioNomeILike.isEmpty()){
            sql += " AND nome ILIKE '%"+criterioNomeILike+"%'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            TipoOcorrencia pojo = new TipoOcorrencia();
            pojo.setId(rs.getLong("id"));
            pojo.setNome(rs.getString("nome"));

            lista.add(pojo);
        }
        rs.close();
        ps.close();

        return lista;
    }

    public void update(TipoOcorrencia e, Connection conn) throws Exception {
        
        String sql = "UPDATE tipo_ocorrencia SET nome = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();

    }

    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM tipo_ocorrencia WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ps.execute();
        ps.close();
    }

    
}