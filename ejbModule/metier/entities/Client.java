package metier.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import metier.entities.User;
import metier.entities.Village;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity

public class Client implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomFamille;
	private String adresse;
	private String telephone;
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "village_id")
    private Village village = new Village();
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user = new User();
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNomFamille() {
		return this.nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Client(int id, String nomFamille, String adresse, String telephone) {
		super();
		this.id = id;
		this.nomFamille = nomFamille;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nomFamille=" + nomFamille + ", adresse=" + adresse + ", telephone=" + telephone
				+ "]";
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
   
}
