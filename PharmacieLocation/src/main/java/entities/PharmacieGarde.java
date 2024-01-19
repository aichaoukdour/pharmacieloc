package entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PharmacieGarde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date_debut;
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="pharmacie_id")
	private Pharmacie pharmacie;
	
	@ManyToOne
	@JoinColumn(name="garde_id")
	private Garde garde;

	public PharmacieGarde(int id, Date date_debut, Date date_fin, Pharmacie pharmacie, Garde garde) {
		super();
		this.id = id;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.pharmacie = pharmacie;
		this.garde = garde;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}

	public Object getPharmacieGarde() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
