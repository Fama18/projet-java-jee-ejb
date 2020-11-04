package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.User;

@Local
public interface IUser {
	
	public int add(User user);
	public List<User> list();
	public User getUserByEmail(String email, String password);

}
