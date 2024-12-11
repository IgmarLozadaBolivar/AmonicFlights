package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import core.entities.Pais;
import core.interfaces.IPais;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements IPais {

    private Connection conn;
    private Pais pais;
    
    public PaisDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Pais> listaPaises() {
        List<Pais> paises = new ArrayList<>();
        
        String sql = "select * from countries";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.pais = new Pais();
                pais.setId(rs.getInt("ID"));
                pais.setNombre(rs.getString("Name"));
                paises.add(pais);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron paises en la tabla, más detalles: " + e.getMessage());
        }
        
        return paises;
    }

    @Override
    public boolean createNewCountry(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateCountryExists(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteCountryExists(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String countryById(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int idCountryByNombre(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
