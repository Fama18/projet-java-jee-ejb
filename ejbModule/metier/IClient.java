package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Client;

@Local
public interface IClient {
	
	public int add(Client client);
	public List<Client> list();

}
