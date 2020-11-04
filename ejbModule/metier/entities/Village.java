package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import metier.entities.Client;
import metier.entities.User;

/**
 * Entity implementation class for Entity: Village
 *
 */
@Entity

public class Village implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomVillage;
	@OneToMany(mappedBy = "village", fetch = FetchType.LAZY)
    private List<Client> clients = new ArrayList<Client>();
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();
	private static final long serialVersionUID = 1L;

	public Village() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNomVillage() {
		return this.nomVillage;
	}

	public void setNomVillage(String nomVillage) {
		this.nomVillage = nomVillage;
	}
	public Village(int id, String nomVillage) {
		super();
		this.id = id;
		this.nomVillage = nomVillage;
	}
	
	
	@Override
	public String toString() {
		return "Village [id=" + id + ", nomVillage=" + nomVillage + "]";
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
   
}
