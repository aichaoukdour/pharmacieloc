package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pharmacie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String photo;
	private double lat;
	private double lon;
	
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "zone_id")
	private Zone zone;
	
	@OneToMany(mappedBy= "pharmacie")
	private List<PharmacieGarde> phagarde;
	
	
	


	

	


	public Pharmacie(int id, String nom, String photo, double lat, double lon, Users user, Zone zone,
			List<PharmacieGarde> phagarde) {
		super();
		this.id = id;
		this.nom = nom;
		this.photo = photo;
		this.lat = lat;
		this.lon = lon;
		this.user = user;
		this.zone = zone;
		this.phagarde = phagarde;
	}


	public Pharmacie() {
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


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLon() {
		return lon;
	}


	public void setLon(double lon) {
		this.lon = lon;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Zone getZone() {
		return zone;
	}


	public void setZone(Zone zone) {
		this.zone = zone;
	}


	public List<PharmacieGarde> getPhagarde() {
		return phagarde;
	}


	  public void setPhagarde(List<PharmacieGarde> phagarde2) {
		// TODO Auto-generated method stub
		
	}


	
	 

}
