package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import core.entities.Rol;
import core.interfaces.IRol;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements IRol {

    private Connection conn;
    private Rol rol;
    
    public RolDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Rol> listaRoles() {
        List<Rol> roles = new ArrayList<>();
        
        String sql = "select * from roles";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                this.rol = new Rol();
                rol.setId(rs.getInt("ID"));
                rol.setNombre(rs.getString("Title"));
                roles.add(rol);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron roles en la tabla, más detalles: " + e.getMessage());
        }
        
        return roles;
    }

    @Override
    public boolean createNewRole(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateRoleExists(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteRoleExists(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String roleById(Rol rol) {
        
        String sql = "select Title from roles where ID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, rol.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("Title");
            }
            
        } catch (Exception e) {
        }
        
        return null;
    }

    @Override
    public int idRoleByNombre(Rol rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
