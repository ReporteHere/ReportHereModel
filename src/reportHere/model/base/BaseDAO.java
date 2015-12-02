/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.base;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface BaseDAO<E extends BasePOJO>{

    public void create(E e,Connection conn) throws Exception;

    public E readById(Long id,Connection conn) throws Exception;

    public List<E> readByCriteria(Map<String,Object> criteria, Connection conn) throws Exception;

    public void update(E e, Connection conn) throws Exception;

    public void delete(Long id, Connection conn) throws Exception;

}
