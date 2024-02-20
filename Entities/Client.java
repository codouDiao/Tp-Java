
package Entities;

public class Client {
    private int id;
    private String nomComplet;
    private String telephone;
    private String email;

    public String getNomComplet() {
        return this.nomComplet;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setEmail(String email) {
        this.email = email;

    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;

    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;

    }

}