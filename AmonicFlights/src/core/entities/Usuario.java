package core.entities;

import java.util.Date;

public class Usuario extends BaseEntity {

    private int idRoleFK;
    private String email;
    private String password;
    private String lastName;
    private int idOficinaFK;
    private Date fechaNacimiento;
    private int active;

    public Usuario() {
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(int id, int idRoleFK, String email, String password,
            String firstName, String lastName, int idOficinaFK,
            Date fechaNacimiento, int active) {
        super(id, firstName);
        this.idRoleFK = idRoleFK;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.idOficinaFK = idOficinaFK;
        this.fechaNacimiento = fechaNacimiento;
        this.active = active;
    }

    public int getIdRoleFK() {
        return idRoleFK;
    }

    public void setIdRoleFK(int idRoleFK) {
        this.idRoleFK = idRoleFK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdOficinaFK() {
        return idOficinaFK;
    }

    public void setIdOficinaFK(int idOficinaFK) {
        this.idOficinaFK = idOficinaFK;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
