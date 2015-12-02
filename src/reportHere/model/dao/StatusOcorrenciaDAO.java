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
import reportHere.model.pojo.Ocorrencia;
import reportHere.model.pojo.Status;
import reportHere.model.pojo.StatusOcorrencia;

public class StatusOcorrenciaDAO{

    public static final String CRITERION_OCORRENCIA_EQ = "1";

    public void create(StatusOcorrencia e, Connection conn) throws Exception {

        String sql = "INSERT INTO status_ocorrencia(status_fk,ocorrencia_fk,data) VALUES(?,?,now())";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getStatus().getId());
        ps.setLong(++i, e.getOcorrencia().getId());
        ps.execute();
        ps.close();  
    }

    public List<StatusOcorrencia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "SELECT status.id as status_id,status.status as status_status,status_fk,ocorrencia_fk,data FROM status_ocorrencia LEFT JOIN status ON status_ocorrencia.status_fk = status.id WHERE 1=1 ";
        List<StatusOcorrencia> statusOcorrencia = new ArrayList<StatusOcorrencia>();

        Long criterioOcorrenciaEq = (Long) criteria.get(CRITERION_OCORRENCIA_EQ);
        if(criterioOcorrenciaEq != null && criterioOcorrenciaEq>0){
            sql +=" AND ocorrencia_fk ="+criterioOcorrenciaEq +" order by status_fk desc";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Status status = new Status();
            status.setId(rs.getLong("status_id"));
            status.setStatus(rs.getString("status_status"));

            Ocorrencia ocorrencia = new Ocorrencia();
            ocorrencia.setId(rs.getLong("ocorrencia_fk"));

            StatusOcorrencia so = new StatusOcorrencia();
            so.setStatus(status);
            so.setOcorrencia(ocorrencia);
            so.setData(rs.getDate("data"));
            statusOcorrencia.add(so);
        }

        return statusOcorrencia;
    }

}
