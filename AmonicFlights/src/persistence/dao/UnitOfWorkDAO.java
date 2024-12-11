package persistence.dao;

import java.sql.Connection;
import persistence.database.Conexion;
import core.interfaces.IOficina;
import core.interfaces.IPais;
import core.interfaces.IRol;
import core.interfaces.IUnitOfWorkDAO;
import core.interfaces.IUsuario;
import core.entities.Rol;

public class UnitOfWorkDAO implements IUnitOfWorkDAO {

    private Connection conexion;
    private IRol _roles;
    private IPais _paises;
    private IOficina _oficinas;
    private IUsuario _usuarios;

    public UnitOfWorkDAO(Conexion conn) {
        this.conexion = Conexion.getConexion();
        this._roles = new RolDAO(conexion);
        this._paises = new PaisDAO(conexion);
        this._oficinas = new OficinaDAO(conexion);
        this._usuarios = new UsuarioDAO(conexion);
    }

    @Override
    public IRol getRoles() {
        return _roles;
    }

    @Override
    public IPais getPaises() {
        return _paises;
    }

    @Override
    public IOficina getOficinas() {
        return _oficinas;
    }

    @Override
    public IUsuario getUsuarios() {
        return _usuarios;
    }

}
