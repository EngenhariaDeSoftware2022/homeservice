package es.homeservices.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="\"User\"")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String cpf;
    private Date birthDate;
    private String email;
    private String cel;

    @OneToOne
    private Location location;
    private String pswd;

    public User(String name, String cpf, String email, String pswd, String city, String neighBorhood) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.pswd = pswd;
        this.location = new Location(city, neighBorhood);
    }

    public User(String name, String cpf, String email, String pswd) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.pswd = pswd;
    }

    public User(String name, String cpf, String email, String pswd, String cel, Location location) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.pswd = pswd;
        this.location = location;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

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

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(cpf, user.cpf) && Objects.equals(email, user.email) && Objects.equals(pswd, user.pswd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, email, pswd);
    }
}
