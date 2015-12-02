/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import reportHere.model.pojo.DepartamentoOcorrencia;

public class DepartamentoOcorrenciaDAO {

    public void create(DepartamentoOcorrencia e, Connection conn) throws Exception {

        String sql = "INSERT INTO departamento_ocorrencia(ocorrencia_fk,usuario_fk,data) VALUES (?,?,now())";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, e.getOcorrencia().getId());
        ps.setLong(++i, e.getUsuario().getId());
        ps.execute();
        ps.close();

    }

}
