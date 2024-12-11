package core.interfaces;

import core.entities.Pais;
import java.util.List;

public interface IPais {

    // Métodos CRUD Basic: Read - Create - Update - Delete
    List<Pais> listaPaises();

    boolean createNewCountry(Pais pais);

    boolean updateCountryExists(Pais pais);

    boolean deleteCountryExists(Pais pais);

    // Métodos CRUD Read: ContryById - IdCountryByNombre
    String countryById(Pais pais);

    int idCountryByNombre(Pais pais);

}
