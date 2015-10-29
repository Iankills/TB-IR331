package gestConges.demo;

import gestConges.data.model.Conge;
import gestConges.service.IGestionConges;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class AppelGestionConges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test_listeConge();
	}
	
	
	public static IGestionConges getGestionConge(){
		InitialContext ctx;
	

		IGestionConges gestionConge = null;
	
		try{
			ctx = new InitialContext();
			gestionConge = (IGestionConges) ctx.lookup(IGestionConges.JNDI_NAME);
		}
		catch (NamingException e){
			//Unable to retrieve the context or the service
			System.out.println("catch" );
			e.printStackTrace();
			System.exit(-1);
		}
		return gestionConge;
	}
	
	public static void test_listeConge(){
		for (Conge conge : getGestionConge().listeConge()){
			System.out.println("conge id: " + conge.getId() + " status:" + conge.getStatus());
		}
	}
}
