/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.model.base.service;

import java.sql.Connection;
import java.util.List;
import reportHere.model.base.BaseService;
import reportHere.model.pojo.Usuario;

public interface BaseUsuarioService  extends BaseService<Usuario>{

        public Usuario login(String login, String senha) throws Exception;
        public List<Usuario> filtrarUsuarios(Long id) throws Exception;
        public List<Usuario> mostrarUsuarios(Long id) throws Exception;
        public void updateOuvidor(Usuario e)throws Exception;
                
}
