package gestConges.front.utils;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServicesLocator
{
	//-----------------------------------------------------------------------------
	private Context initialContext;
	private Map<String, Object> cache;
	// Singleton
	private static final ServicesLocator instance = new ServicesLocator();
	//-----------------------------------------------------------------------------
	private ServicesLocator()
	{
    try
    {
	    initialContext = new InitialContext();
			cache = new HashMap<String, Object>();
    }
    catch (NamingException e)
    {
	    e.printStackTrace();
    }
	}
	//-----------------------------------------------------------------------------
	public static ServicesLocator getInstance()
	{
		return instance;
	}
	//-----------------------------------------------------------------------------
	/**
	 * Renvoie le stub du composant EJB.
	 * 
	 * @param jndiName nom JNDI du composant EJB recherchÃ©
	 * @return le stub du composant EJB correspondant au nom JNDI.
	 * @throws ServiceLocatorException levÃ© en cas de problÃ¨mes liÃ©s Ã  la recherche.
	 */
	public Object getRemoteInterface(String nomEJB) throws ServicesLocatorException
	{
		// Le nom JNDI pour la rÃ©cupÃ©ration du service distant (stub du
		// composant EJB) est de la forme :
		//   java:global/<nom projet EAR>/<nom sous-projet EJB>/<nom bean session EJB>!<nom complet avec package de l'interface remote du bean>
		// Exemple :
		//   java:global/CabinetRecrutement_EAR/CabinetRecrutement_EJB/ServiceEntreprise!eu.telecom_bretagne.cabinet_recrutement.service.IServiceEntreprise
		
		String nomJNDI = null;
		if(nomEJB.equals("GestionConges"))
			nomJNDI = "java:global/gestConges_EAR/gestConges_EJB/GestionConges!gestConges.service.IGestionConges";
		else if(nomEJB.equals("GestionSalarie"))
			nomJNDI = "java:global/gestConges_EAR/gestConges_EJB/GestionSalarie!gestConges.service.IGestionSalarie";
		
		// ATTENTION !!! La recuperation d'un DAO n'existe ici que
		// pour les controles (utilises dans la servlet ControleDAOServlet) :
		// ils ne sont normalement pas appeles par la couche IHM.
		
		else if(nomEJB.equals("CongeDAO"))
			nomJNDI = "java:global/gestConges_EAR/gestConges_EJB/CongeDAO!gestConges.data.dao.CongeDAO";
		else if(nomEJB.equals("SalarieDAO"))
			nomJNDI = "java:global/gestConges_EAR/gestConges_EJB/SalarieDAO!gestConges.data.dao.SalarieDAO";
		else
			throw new ServicesLocatorException("Il n'y a pas d'EJB avec ce nom...");
		
		// La mÃ©thode recherche d'abord le stub dans le cache, s'il est absent,
		// il est rÃ©cupÃ©rÃ© via JNDI.
		Object remoteInterface = cache.get(nomJNDI);
		if (remoteInterface == null)
		{
			try
			{
				remoteInterface = initialContext.lookup(nomJNDI);
				cache.put(nomJNDI, remoteInterface);
			}
			catch (Exception e)
			{
				throw new ServicesLocatorException(e);
			}
		}
		return remoteInterface;
	}
	//-----------------------------------------------------------------------------
}
