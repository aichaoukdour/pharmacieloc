package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String pwd;
	
	@OneToOne
	@JoinColumn(name = "pharmacie_id")
	private Pharmacie pharmacie;

	public Users(int id, String nom, String prenom, String email, String pwd, Pharmacie pharmacie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.pharmacie = pharmacie;
	}

	public Users() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}
	
	
	
	

}
