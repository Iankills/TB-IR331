package gestConges.service;

import gestConges.data.model.Conge;
import gestConges.data.model.Salarie;

import javax.ejb.Remote;

import java.util.List;

@Remote
public interface IGestionSalarie {
	
	public static final String JNDI_NAME= "java:global/gestConges_EAR/gestConges_EJB/GestionSalarie!gestConges.service.IGestionSalarie";
	
	public List<Salarie> listeSalaries();
	public Salarie getSalarie(int id);
	public void miseAJour(Salarie s);
	public List<Salarie> listeDesSalariesPourUnManager(int id);
	

}
