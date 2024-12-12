package core.interfaces;

import core.entities.Usuario;
import java.util.List;

public interface IUsuario {

    // Métodos CRUD Basic: Read - Create - Update - Delete
    List<Usuario> listaUsuarios();

    boolean createNewUser(Usuario usuario);

    boolean updateUserExists(Usuario usuario);

    boolean deleteUserExists(Usuario usuario);

    // Métodos CRUD Read: UserById - IdUserByEmail
    String userById(Usuario usuario);

    int idUserByEmail(Usuario usuario);
    
    int autenticarUsuario(Usuario usuario);
}
