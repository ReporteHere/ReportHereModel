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
import reportHere.model.pojo.Usuario;

public class UsuarioDAO implements BaseDAO<Usuario>{

    public static final String CRITERION_NOME_I_LIKE = "criterioNomeILike";
    public static final String CRITERION_TIPO_I_LIKE = "criterioTipoILike";

    public static final String CRITERION_LOGIN_EQ = "1";
    public static final String CRITERION_SENHA_EQ = "2";


    public void create(Usuario e, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario(login,senha,nome,tipo_usuario_fk) VALUES (?,?,?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getLogin());
        ps.setString(++i, e.getSenha());
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getTipoUsuario().getId());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Usuario readById(Long id, Connection conn) throws Exception {

        String sql = "SELECT usuario.id as usuario_id, usuario.login as usuario_login, usuario.senha as usuario_senha, usuario.nome as usuario_nome, tipo_usuario.id as tipo_usuario_id, tipo_usuario.nome as tipo_usuario_nome FROM usuario LEFT JOIN tipo_usuario ON usuario.tipo_usuario_fk = tipo_usuario.id WHERE usuario.id = ?";
        Usuario usuario = new Usuario();
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getLong("tipo_usuario_id"));
            tipoUsuario.setNome(rs.getString("tipo_usuario_nome"));
            usuario.setTipoUsuario(tipoUsuario);
        }
        return usuario;
    }

    public List<Usuario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "Select usuario.id as usuario_id, usuario.login as usuario_login, usuario.nome as usuario_nome, usuario.senha as usuario_senha, tipo_usuario.id as tipo_usuario_id, tipo_usuario.nome as tipo_usuario_nome FROM usuario LEFT JOIN tipo_usuario ON usuario.tipo_usuario_fk = tipo_usuario.id WHERE 1=1";
        List<Usuario> lista = new ArrayList<Usuario>();

        
        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);
        if(criterioNomeILike!= null && !criterioNomeILike.trim().isEmpty()){
            sql+= " AND usuario.nome ILIKE '%"+criterioNomeILike+"%'";
        }

        String criterioTipoILike = (String)criteria.get(CRITERION_TIPO_I_LIKE);
        if(criterioTipoILike!= null && !criterioTipoILike.trim().isEmpty()){
            sql+= " AND tipo_usuario_nome = %'"+criterioTipoILike+"%'";
        }

        String criterionUsuarioEq = (String) criteria.get(CRITERION_LOGIN_EQ);
        if (criterionUsuarioEq != null && !criterionUsuarioEq.trim().isEmpty()) {
            sql += " AND usuario.login = '" +criterionUsuarioEq+"'";
        }

        String criterionSenhaEq = (String) criteria.get(CRITERION_SENHA_EQ);
        if (criterionSenhaEq != null && !criterionSenhaEq.trim().isEmpty()) {
            sql += " AND usuario.senha = '" +criterionSenhaEq+"'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getLong("tipo_usuario_id"));
            tipoUsuario.setNome(rs.getString("tipo_usuario_nome"));
            usuario.setTipoUsuario(tipoUsuario);
            lista.add(usuario);
        }
        return lista;
    }

    public void update(Usuario e, Connection conn) throws Exception {
        
        String sql = "UPDATE usuario SET login=?, senha=?, nome=?, tipo_usuario_fk=? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getLogin());
        ps.setString(++i, e.getSenha());
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getTipoUsuario().getId());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }


    public void delete(Long id, Connection conn) throws Exception {

        String sql = "DELETE FROM usuario WHERE id= ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
    }

    public List<Usuario> filtrarUsuario(Long id, Connection conn)throws Exception{

        String sql = "select usuario.id as usuario_id, usuario.login as usuario_login, usuario.nome as usuario_nome, usuario.senha as usuario_senha, tipo_usuario.id as tipo_usuario_id, tipo_usuario.nome as tipo_usuario_nome from usuario "
                + "left join tipo_usuario on tipo_usuario.id = usuario.tipo_usuario_fk "
                + "where usuario.id not in(select usuario_fk from departamento_ocorrencia left join ocorrencia on departamento_ocorrencia.ocorrencia_fk = ocorrencia.id where ocorrencia.id = ?) and usuario.id != 1";
        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getLong("tipo_usuario_id"));
            tipoUsuario.setNome(rs.getString("tipo_usuario_nome"));
            usuario.setTipoUsuario(tipoUsuario);
            lista.add(usuario);
        }
        return lista;
    }
public List<Usuario> mostrarUsuarios(Long id,Connection conn)throws Exception{

    String sql = "select usuario.id as usuario_id, usuario.login as usuario_login, usuario.nome as usuario_nome, usuario.senha as usuario_senha, tipo_usuario.id as tipo_usuario_id, tipo_usuario.nome as tipo_usuario_nome "
        + "from usuario left join departamento_ocorrencia on usuario.id = departamento_ocorrencia.usuario_fk "
        + "left join tipo_usuario on usuario.tipo_usuario_fk = tipo_usuario.id where ocorrencia_fk = ?";
        List<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));

            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setId(rs.getLong("tipo_usuario_id"));
            tipoUsuario.setNome(rs.getString("tipo_usuario_nome"));
            usuario.setTipoUsuario(tipoUsuario);
            lista.add(usuario);
        }
        return lista;
    }
}
