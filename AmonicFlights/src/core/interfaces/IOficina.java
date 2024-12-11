package core.interfaces;

import core.entities.Oficina;
import java.util.List;

public interface IOficina {

    // Métodos CRUD Basic: Read - Create - Update - Delete
    List<Oficina> listaOficinas();

    boolean createNewOffice(Oficina oficina);

    boolean updateOfficeExists(Oficina oficina);

    boolean deleteOfficeExists(Oficina oficina);

    // Métodos CRUD Read: OfficeById - idOfficeByNombre
    String officeById(Oficina oficina);

    int idOfficeByNombre(Oficina oficina);
}
