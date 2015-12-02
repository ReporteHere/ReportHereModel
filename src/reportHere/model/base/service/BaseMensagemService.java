/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.base.service;

import java.util.List;
import java.util.Map;
import reportHere.model.pojo.Mensagem;


public interface BaseMensagemService{

    public void create(Mensagem e) throws Exception;

    public Mensagem readById(Long id) throws Exception;

    public List<Mensagem> readByCriteria(Map<String, Object> criteria) throws Exception;

}
