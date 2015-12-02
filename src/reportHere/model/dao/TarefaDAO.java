/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import reportHere.model.base.BaseDAO;
import reportHere.model.pojo.Tarefa;

public class TarefaDAO implements BaseDAO<Tarefa>{

    public void create(Tarefa e, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Tarefa readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Tarefa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Tarefa e, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
