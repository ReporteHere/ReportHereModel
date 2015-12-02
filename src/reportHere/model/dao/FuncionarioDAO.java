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
import reportHere.model.pojo.Funcionario;
import reportHere.model.pojo.Usuario;

public class FuncionarioDAO implements BaseDAO<Funcionario>{

    public static final String CRITERION_NOME_I_LIKE = "criterioNomeILike";
    public static final String CRITERION_USUARIO_EQ = "1";

    public void create(Funcionario e, Connection conn) throws Exception {

        String sql = "INSERT INTO funcionario(nome,usuario_fk) VALUES(?,?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i =0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getUsuario().getId());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    public Funcionario readById(Long id, Connection conn) throws Exception {

        String sql = "SELECT funcionario.id as funcionario_id, funcionario.nome as funcionario_nome, usuario.id as usuario_id,usuario.login as usuario_login, usuario.senha as usuario_senha, usuario.nome as usuario_nome FROM funcionario LEFT JOIN usuario ON usuario.id = funcionario.usuario_fk WHERE funcionario.id = ?";
        Funcionario pojo = new Funcionario();
            
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            pojo.setId(rs.getLong("funcionario_id"));
            pojo.setNome(rs.getString("funcionario_nome"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));


            pojo.setUsuario(usuario);
        }
        return pojo;

    }

    public List<Funcionario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        String sql = "SELECT funcionario.id as funcionario_id, funcionario.nome as funcionario_nome, usuario.id as usuario_id,usuario.login as usuario_login, usuario.senha as usuario_senha, usuario.nome as usuario_nome, usuario.tipousuario_fk as usuario_tipousuario_fk FROM funcionario LEFT JOIN usuario ON usuario.id = funcionario.usuario_fk WHERE 1=1";
        List<Funcionario> lista = new ArrayList<Funcionario>();

        String criterioNomeILike = (String)criteria.get(CRITERION_NOME_I_LIKE);
        if(criterioNomeILike != null && !criterioNomeILike.trim().isEmpty()){
            sql+= " AND funcionario.nome = %"+criterioNomeILike+"%";
        }

        String funcionarioUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if(funcionarioUsuarioEq != null && !funcionarioUsuarioEq.trim().isEmpty()){
            sql+= " AND funcionario.nome = %"+funcionarioUsuarioEq+"%";
        }

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Funcionario pojo = new Funcionario();

            pojo.setId(rs.getLong("funcionario_id"));
            pojo.setNome(rs.getString("funcionario_nome"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setLogin(rs.getString("usuario_login"));
            usuario.setSenha(rs.getString("usuario_senha"));
            usuario.setNome(rs.getString("usuario_nome"));
            pojo.setUsuario(usuario);

            lista.add(pojo);
        }
        return lista;
    }

    public void update(Funcionario e, Connection conn) throws Exception {

        String sql = "UPDATE funcionario SET nome = ?,usuario_fk=? WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setLong(++i, e.getUsuario().getId());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id, Connection conn) throws Exception {

        String sql = "DELETE FROM funcionario WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);
        ps.execute();
        ps.close();
    }

}
