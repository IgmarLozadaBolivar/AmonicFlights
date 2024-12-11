package core.interfaces;

import core.entities.Rol;
import java.util.List;

public interface IRol {

    // Métodos CRUD Basic: Read - Create - Update - Delete
    List<Rol> listaRoles();

    boolean createNewRole(Rol rol);

    boolean updateRoleExists(Rol rol);

    boolean deleteRoleExists(Rol rol);

    // Métodos Read: RoleById - IdRoleByNombre
    String roleById(Rol rol);

    int idRoleByNombre(Rol rol);
}
