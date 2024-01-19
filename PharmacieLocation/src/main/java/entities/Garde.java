package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Garde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="pharmacie_id")
	private Pharmacie pharmacie;

	public Garde(int id, String type, Pharmacie pharmacie) {
		super();
		this.id = id;
		this.type = type;
		this.pharmacie = pharmacie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}
	
	
    
	

}
