package es.homeservices.DTO;

public class UserRequestDTO {
    private String name;
    private String cpf;
    private String birthDate;
    private String email;
    private String cel;
    private String city;
    private String neighborhood;
    private String pswd;

    public String getCity() {
        return city;
    }

    public UserRequestDTO(String name, String cpf, String birthDate, String email, String cel, String city, String neighborhood, String pswd) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
        this.cel = cel;
        this.city = city;
        this.neighborhood = neighborhood;
        this.pswd = pswd;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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
}
