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
import reportHere.model.pojo.Mensagem;
import reportHere.model.pojo.Ocorrencia;

public class MensagemDAO{

    public static final String CRITERION_TIPO_DIFER = "diferente";
    public static final String CRITERION_OCORRENCIA_ID = "id";

    public void create(Mensagem e, Connection conn) throws Exception {

        String sql = "INSERT INTO mensagem(ocorrencia_fk, descricao, tipo) VALUES(?,?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getOcorrencia().getId());
        ps.setString(++i, e.getDescricao());
        ps.setString(++i, e.getTipo());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Mensagem readById(Long id, Connection conn) throws Exception {

        String sql = "SELECT descricao,ocorrencia_fk,tipo FROM mensagem WHERE id = ?";
        Mensagem msg = new Mensagem();
        PreparedStatement ps = conn.prepareStatement(sql);
        int i =0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            msg.setId(id);
            msg.setDescricao(rs.getString("descricao"));
            msg.setTipo(rs.getString("tipo"));

            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setId(rs.getLong("ocorrencia_fk"));
            msg.setOcorrencia(ocorrencia);
        }
        rs.close();
        ps.close();

        return msg;
    }

    public List<Mensagem> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "SELECT id,descricao,ocorrencia_fk,tipo FROM mensagem WHERE 1=1";

        Long criterioOcorrenciaId = Long.parseLong(criteria.get(CRITERION_OCORRENCIA_ID).toString());
        if(criterioOcorrenciaId > 0){
            sql+=" AND ocorrencia_fk = "+criterioOcorrenciaId;
        }

        String tipoIgual = (String) criteria.get(CRITERION_TIPO_DIFER);
        if(tipoIgual != null && !tipoIgual.trim().isEmpty()){
            sql+=" AND tipo = '"+tipoIgual+"'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Mensagem> lista = new ArrayList<Mensagem>();

        while(rs.next()){
            Mensagem msg = new Mensagem();
            msg.setId(rs.getLong("id"));
            msg.setDescricao(rs.getString("descricao"));
            msg.setTipo(rs.getString("tipo"));

            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setId(rs.getLong("ocorrencia_fk"));
            msg.setOcorrencia(ocorrencia);
            lista.add(msg);
        }
        rs.close();
        ps.close();
        return lista;
    }

}
