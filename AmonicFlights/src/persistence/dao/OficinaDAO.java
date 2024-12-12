package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import core.entities.Oficina;
import core.interfaces.IOficina;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO implements IOficina {

    private Connection conn;
    private Oficina oficina;
    
    public OficinaDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Oficina> listaOficinas() {
        List<Oficina> oficinas = new ArrayList<>();
        
        String sql = "select * from offices";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.oficina = new Oficina();
                oficina.setId(rs.getInt("ID"));
                oficina.setIdPaisFK(rs.getInt("CountryID"));
                oficina.setNombre(rs.getString("Title"));
                oficina.setPhone(rs.getString("Phone"));
                oficina.setContact(rs.getString("Contact"));
                oficinas.add(oficina);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron oficinas en la tabla, más detalles: " + e.getMessage());
        }
        
        return oficinas;
    }

    @Override
    public boolean createNewOffice(Oficina oficina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateOfficeExists(Oficina oficina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteOfficeExists(Oficina oficina) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String officeById(Oficina oficina) {
        
        String sql = "select Title from offices where ID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, oficina.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("Title");
            }
            
        } catch (Exception e) {
            System.out.println("No se encontró ninguna coincidencia: " + e.getMessage());
        }
        
        return null;
    }

    @Override
    public int idOfficeByNombre(Oficina oficina) {
        
        String sql = "select ID from offices where Title = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, oficina.getNombre());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID");
            }
            
        } catch (Exception e) {
            System.out.println("No se encontró ninguna coincidencia: " + e.getMessage());
        }
        
        return 0;
    }
    
}
