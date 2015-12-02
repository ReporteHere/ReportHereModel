/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Perfil;
import reportHere.model.pojo.TipoOcorrencia;

public class OcorrenciaDAO {

    public static final String CRITERION_TIPO_EQ = "1";
    public static final String CRITERION_USUARIO_EQ = "1";

    public void create(Ocorrencia e, Connection conn) throws Exception {

        String sql = "INSERT INTO ocorrencia(assunto,descricao,nome,email,anonimo,finalizado,protocolo,senha,perfil_fk,tipo_ocorrencia_fk) VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        //String senha = (System.currentTimeMillis()/8);

        int i = 0;
        ps.setString(++i, e.getAssunto());
        ps.setString(++i, e.getDescricao());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getEmail());
        ps.setBoolean(++i,e.getAnonimo());
        ps.setBoolean(++i, false);
        ps.setLong(++i, e.getProtocolo());
        ps.setString(++i, e.getSenha());
        ps.setLong(++i, e.getPerfil().getId());
        ps.setLong(++i, e.getTipoOcorrencia().getId());
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Ocorrencia readById(Long id, Connection conn) throws Exception {

        String sql = "select ocorrencia.id as ocorrencia_id, ocorrencia.email as ocorrencia_email, ocorrencia.nome as ocorrencia_nome, ocorrencia.assunto as ocorrencia_assunto,ocorrencia.descricao as ocorrencia_descricao,ocorrencia.protocolo as ocorrencia_protocolo,tipo_ocorrencia.nome as tipo_ocorrencia_nome,perfil.nome as perfil_nome from ocorrencia left join departamento_ocorrencia on ocorrencia.id = departamento_ocorrencia.ocorrencia_fk left join perfil on perfil.id = ocorrencia.perfil_fk left join tipo_ocorrencia on tipo_ocorrencia.id = ocorrencia.tipo_ocorrencia_fk left join usuario on usuario.id = departamento_ocorrencia.usuario_fk WHERE ocorrencia.id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        Ocorrencia ocorrencia = new Ocorrencia();
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            ocorrencia.setId(rs.getLong("ocorrencia_id"));
            ocorrencia.setNome(rs.getString("ocorrencia_nome"));
            ocorrencia.setAssunto(rs.getString("ocorrencia_assunto"));
            ocorrencia.setDescricao(rs.getString("ocorrencia_descricao"));
            ocorrencia.setProtocolo(rs.getLong("ocorrencia_protocolo"));
            ocorrencia.setEmail(rs.getString("ocorrencia_email"));

            Perfil perfil = new Perfil();
            perfil.setNome(rs.getString("perfil_nome"));
            ocorrencia.setPerfil(perfil);

            TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
            tipoOcorrencia.setNome(rs.getString("tipo_ocorrencia_nome"));
            ocorrencia.setTipoOcorrencia(tipoOcorrencia);
        }
        rs.close();
        ps.close();

        return ocorrencia;
    }

    public List<Ocorrencia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "select ocorrencia.id as ocorrencia_id, ocorrencia.nome as ocorrencia_nome, ocorrencia.email as ocorrencia_email, ocorrencia.assunto as ocorrencia_assunto,ocorrencia.descricao as ocorrencia_descricao,ocorrencia.protocolo as ocorrencia_protocolo,tipo_ocorrencia.nome as tipo_ocorrencia_nome,perfil.nome as perfil_nome from ocorrencia left join perfil on perfil.id = ocorrencia.perfil_fk left join tipo_ocorrencia on tipo_ocorrencia.id = ocorrencia.tipo_ocorrencia_fk WHERE 1=1 ";


        String tipoEquals = (String)criteria.get(CRITERION_TIPO_EQ);
        if(tipoEquals != null && !tipoEquals.trim().isEmpty()){
            sql += " AND ocorrencia.tipo_ocorrencia_fk = "+tipoEquals;
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Ocorrencia> lista = new ArrayList<Ocorrencia>();

        while(rs.next()){
            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setId(rs.getLong("ocorrencia_id"));
            ocorrencia.setNome(rs.getString("ocorrencia_nome"));
            ocorrencia.setAssunto(rs.getString("ocorrencia_assunto"));
            ocorrencia.setDescricao(rs.getString("ocorrencia_descricao"));
            ocorrencia.setProtocolo(rs.getLong("ocorrencia_protocolo"));
            ocorrencia.setEmail(rs.getString("ocorrencia_email"));
            
            Perfil perfil = new Perfil();
            perfil.setNome(rs.getString("perfil_nome"));
            ocorrencia.setPerfil(perfil);

            TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
            tipoOcorrencia.setNome(rs.getString("tipo_ocorrencia_nome"));
            ocorrencia.setTipoOcorrencia(tipoOcorrencia);
            lista.add(ocorrencia);
        }
        rs.close();
        ps.close();
        return lista;

    }

    public List<Ocorrencia> readByCriteriaEncaminhamento(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "select ocorrencia.id as ocorrencia_id, ocorrencia.nome as ocorrencia_nome, ocorrencia.email as ocorrencia_email, ocorrencia.assunto as ocorrencia_assunto,ocorrencia.descricao as ocorrencia_descricao,ocorrencia.protocolo as ocorrencia_protocolo,tipo_ocorrencia.nome as tipo_ocorrencia_nome,perfil.nome as perfil_nome from ocorrencia left join departamento_ocorrencia on ocorrencia.id = departamento_ocorrencia.ocorrencia_fk left join perfil on perfil.id = ocorrencia.perfil_fk left join tipo_ocorrencia on tipo_ocorrencia.id = ocorrencia.tipo_ocorrencia_fk left join usuario on usuario.id = departamento_ocorrencia.usuario_fk WHERE 1=1 ";
        
        Long porDepartamento = (Long) criteria.get(CRITERION_USUARIO_EQ);
        if(porDepartamento != null && porDepartamento > 0){
            sql += " AND departamento_ocorrencia.usuario_fk='"+porDepartamento+"'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Ocorrencia> lista = new ArrayList<Ocorrencia>();

        while(rs.next()){
            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setId(rs.getLong("ocorrencia_id"));
            ocorrencia.setNome(rs.getString("ocorrencia_nome"));
            ocorrencia.setAssunto(rs.getString("ocorrencia_assunto"));
            ocorrencia.setDescricao(rs.getString("ocorrencia_descricao"));
            ocorrencia.setProtocolo(rs.getLong("ocorrencia_protocolo"));
            ocorrencia.setEmail(rs.getString("ocorrencia_email"));

            Perfil perfil = new Perfil();
            perfil.setNome(rs.getString("perfil_nome"));
            ocorrencia.setPerfil(perfil);

            TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
            tipoOcorrencia.setNome(rs.getString("tipo_ocorrencia_nome"));
            ocorrencia.setTipoOcorrencia(tipoOcorrencia);
            lista.add(ocorrencia);
        }
        rs.close();
        ps.close();
        return lista;

    }

    public void update(Ocorrencia e, Connection conn)throws Exception{

        String sql = "UPDATE ocorrencia SET finalizado = TRUE WHERE ocorrencia.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, e.getId());
        ps.execute();
        ps.close();
    }
    public List<Map<String, Object>> readCountOcorrencias(Connection conn) throws Exception {
        String sql = "select tipo_ocorrencia.nome as nome, count(tipo_ocorrencia.nome) as qtde  from ocorrencia "
                + "inner join tipo_ocorrencia on tipo_ocorrencia_fk = tipo_ocorrencia.id "
                + "group by tipo_ocorrencia.nome";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        while(rs.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nome", rs.getString("nome"));
            map.put("qtde", rs.getDouble("qtde"));
            listMap.add(map);
        }
        rs.close();
        ps.close();
        return listMap;
    }
    public List<Map<String, Object>> readCountOcorrenciasPorDepartamento(Connection conn) throws Exception {
        String sql = "select tipo_usuario.nome as nome, count(tipo_usuario.nome) as qtde from departamento_ocorrencia "
                + "inner join usuario on usuario_fk = usuario.id "
                + "inner join tipo_usuario on tipo_usuario_fk = tipo_usuario.id "
                + "group by tipo_usuario.nome";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        while(rs.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nome", rs.getString("nome"));
            map.put("qtde", rs.getDouble("qtde"));
            listMap.add(map);
        }
        rs.close();
        ps.close();
        return listMap;
    }

    public List<Map<String, Object>> readByStatusOcorrencia(Connection conn, Map<String, Object> criteria) throws Exception {
        String sql = "select ocorrencia.id as id_ocorrencia, assunto as assunto, nome as nome,data as data, status as status from ocorrencia "
                + "inner join status_ocorrencia on ocorrencia.id = ocorrencia_fk "
                + "inner join status on status.id = status_fk where protocolo = '"+criteria.get("protocolo")+"' and senha = '"+criteria.get("senha")+"'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        while(rs.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", rs.getLong("id_ocorrencia"));
            map.put("assunto", rs.getString("assunto"));
            map.put("data", formatador.format(rs.getDate("data")));
            map.put("nome", rs.getString("nome"));
            map.put("status", rs.getString("status"));
            listMap.add(map);
        }
        rs.close();
        ps.close();
        return listMap;
    }

}