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
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String nom;
	private String image;
	
	@OneToMany(mappedBy = "zone")
	private List<Pharmacie> pharmacie;
	
    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

	public Zone(int id, String nom, String image, List<Pharmacie> pharmacie, Ville ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.image = image;
		this.pharmacie = pharmacie;
		this.ville = ville;
	}

	public Zone() {
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Pharmacie> getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(List<Pharmacie> pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
    
}
 