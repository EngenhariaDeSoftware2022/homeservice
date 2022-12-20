package es.homeservices.DTO;

import es.homeservices.models.User;

import java.util.Date;

// Passes all the user information but NOT the password
public class UserDetailsDTO {

    private String name;
    private String cpf;
    private Date birthDate;
    private String email;
    private String cel;
    private String city;
    private String neighborhood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public UserDetailsDTO(String name, String cpf, Date birthDate, String email, String cel, String city, String neighborhood) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
        this.cel = cel;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public UserDetailsDTO(User user) {
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
        this.cel = user.getCel();
        this.city = user.getLocation().getCity();
        this.neighborhood = user.getLocation().getNeighborhood();
    }
}