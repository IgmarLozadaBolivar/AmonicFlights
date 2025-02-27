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
        
        String sql = "insert into users(ID, RoleID, Email, Password, FirstName, LastName, OfficeID, Birthdate, Active)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, usuario.getId());
            ps.setInt(2, usuario.getIdRoleFK());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getNombre());
            ps.setString(6, usuario.getLastName());
            ps.setInt(7, usuario.getIdOficinaFK());
            ps.setDate(8, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setInt(9, usuario.getActive());
            ps.execute();
            
            
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
        
        return false;
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

    @Override
    public int autenticarUsuario(Usuario usuario) {
        
        String sql = "select RoleID from users where Email = ? and Password = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("RoleID");
            }
            
        } catch (Exception e) {
            System.out.println("No se encuentran coincidencias, más detalles: " + e.getMessage());
        }
        
        return 0;
    }

    @Override
    public int ultimoUsuarioConID() {
        String sql = "select max(ID) as ID from users";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int idRol = rs.getInt("ID");
                return idRol;
            }
            
        } catch (Exception e) {
            System.out.println("No existen usuarios registrados: " + e.getMessage());
        }
        
        return 0;
    }

    @Override
    public List<Usuario> listaUsuariosPorOficina(Usuario usuario) {
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from users where OfficeID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, usuario.getIdOficinaFK());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setId(rs.getInt("ID"));
                nuevoUsuario.setIdRoleFK(rs.getInt("RoleID"));
                nuevoUsuario.setEmail(rs.getString("Email"));
                nuevoUsuario.setPassword(rs.getString("Password"));
                nuevoUsuario.setNombre(rs.getString("FirstName"));
                nuevoUsuario.setLastName(rs.getString("LastName"));
                nuevoUsuario.setIdOficinaFK(rs.getInt("OfficeID"));
                nuevoUsuario.setFechaNacimiento(rs.getDate("Birthdate"));
                nuevoUsuario.setActive(rs.getInt("Active"));
                usuarios.add(nuevoUsuario);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron usuarios en la tabla, más detalles: " + e.getMessage());
        }
        
        return usuarios;
    }
    
}
