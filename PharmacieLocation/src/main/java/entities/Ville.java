package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String photo;
    @OneToMany(mappedBy = "ville")
    private List<Zone> zone ;
	public Ville(int id, String nom, String photo, List<Zone> zone) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
		this.zone = zone;
	}
	public Ville() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Zone> getZone() {
		return zone;
	}
	public void setZone(List<Zone> zone) {
		this.zone = zone;
	}
    
    
    
}
