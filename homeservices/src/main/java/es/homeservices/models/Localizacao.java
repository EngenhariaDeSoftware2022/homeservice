package es.homeservices.models;


import java.util.Objects;


public class Localizacao {

    private Long id;
    private String cidade;
    private String bairro;

    public Localizacao(String cidade, String bairro) {
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public Localizacao() {

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public boolean ehMesmaCidade(Localizacao loc){
        return this.cidade.equals(loc.getCidade());
    }

    public boolean ehMesmoBairro(Localizacao loc){
        return this.bairro.equals(loc.getCidade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return cidade.equals(that.cidade) && bairro.equals(that.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidade, bairro);
    }
}
