package es.homeservices.DTO;

import es.homeservices.models.enumeration.Tag;

public class JobRequestDTO {
    private String title;
    private String description;
    private Tag tag;
    private String cel;
    private String city;
    private String neighborhood;
    private double value;

    public JobRequestDTO(String title, String description, String tag, String cel, String city, String neighborhood, double value) {
        this.title = title;
        this.description = description;
        this.tag = Tag.valueOf(tag);
        this.cel = cel;
        this.city = city;
        this.neighborhood = neighborhood;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
