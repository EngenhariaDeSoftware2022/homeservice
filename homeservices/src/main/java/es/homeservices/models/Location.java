package es.homeservices.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String neighborhood;

    public Location(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public Location() {

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

    public void setNeighborhood(String bairro) {
        this.neighborhood = bairro;
    }

    public boolean isSameCity(Location loc){
        return this.city.equals(loc.getCity());
    }

    public boolean isSameNeighborhood(Location loc){
        return this.neighborhood.equals(loc.getNeighborhood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location that = (Location) o;
        return city.equals(that.city) && neighborhood.equals(that.getNeighborhood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, neighborhood);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}