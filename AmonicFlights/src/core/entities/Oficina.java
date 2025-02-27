package core.entities;

public class Oficina extends BaseEntity {

    private int idPaisFK;
    private String phone;
    private String contact;

    public Oficina() {
    }

    public Oficina(int id, int idPaisFK, String title, String phone, String contacto) {
        super(id, title);
        this.idPaisFK = idPaisFK;
        this.phone = phone;
        this.contact = contact;
    }
    
    public Oficina(int id) {
        super(id);
    }

    public int getIdPaisFK() {
        return idPaisFK;
    }

    public void setIdPaisFK(int idPaisFK) {
        this.idPaisFK = idPaisFK;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
