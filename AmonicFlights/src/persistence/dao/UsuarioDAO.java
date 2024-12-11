package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import core.entities.Usuario;
import core.interfaces.IUsuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuario {

    private Connection conn;
    private Usuario usuario;
    
    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from users";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setIdRoleFK(rs.getInt("RoleID"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setNombre(rs.getString("FirstName"));
                usuario.setLastName(rs.getString("LastName"));
                usuario.setIdOficinaFK(rs.getInt("OfficeID"));
                usuario.setFechaNacimiento(rs.getDate("Birthdate"));
                usuario.setActive(rs.getInt("Active"));
                usuarios.add(usuario);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron usuarios en la tabla, más detalles: " + e.getMessage());
        }
        
        return usuarios;
    }

    @Override
    public boolean createNewUser(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateUserExists(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteUserExists(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String userById(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int idUserByEmail(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
