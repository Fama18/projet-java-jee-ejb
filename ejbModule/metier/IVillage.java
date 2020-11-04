package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Village;

@Local
public interface IVillage {
	
	public int add(Village village);
	public List<Village> list();
	public Village getVillageById(int id);

}
