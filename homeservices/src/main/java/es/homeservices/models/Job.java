package es.homeservices.models;

import javax.persistence.*;

import es.homeservices.models.enumeration.Tag;

@Entity
@Table(name="\"Job\"")
public class Job {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String title;
	
	private String description;
	
	private Tag tag;
	
	private String cel;
	
	@OneToOne
	private Location location;
	
	private double value;
	
	public Job(String title, String description, String cel, Location location, double value) {
		this.title = title;
		this.description = description;
		this.cel = cel;
		this.location = location;
		this.value = value;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Tag getTag() {
		return this.tag;
	}
	
	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	public String getCel() {
		return this.cel;
	}
	
	public void setCel(String cel) {
		this.cel = cel;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
}
