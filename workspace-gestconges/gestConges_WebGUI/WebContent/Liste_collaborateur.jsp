<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="gestConges.front.utils.*,
                java.util.*"%>
<%@page import="gestConges.data.model.Conge"%>
<%@page import="gestConges.service.IGestionConges"%>
<%@page import="gestConges.data.model.Salarie"%>
<%@page import="gestConges.service.IGestionSalarie"%>

<%
String idString = request.getParameter("id_salarie");
// Récupération du servicecongés
IGestionConges gestionConges = (IGestionConges) ServicesLocator.getInstance().getRemoteInterface("GestionConges");
IGestionSalarie gestionSalarie = (IGestionSalarie) ServicesLocator.getInstance().getRemoteInterface("GestionSalarie");
//IServiceSecteurActivite secteurActivite = (IServiceSecteurActivite) ServicesLocator.getInstance().getRemoteInterface("ServiceSecteur");
List<Salarie> salaries = gestionSalarie.listeDesSalariesPourUnManager(Integer.parseInt(idString));

%>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    	<title>Logiciel de conges :</title>
    	<link rel="stylesheet" href="styles.css" type="text/css" />
  	</head>

  	<body>
  
		<h2>Liste des conges de mes collaborateurs</h2>
		<table id="affichage" border="1" >
  			<tr BGCOLOR=GRAY style ="color: WHITE; font-size: medium; font-family: Arial">
  			<th>Identifiant du salarie</th>
		    <th>Nom</th>
		    <th>Prenom</th>
		    <th>Conges</th>
		  </tr>
  			<%
  			for (Salarie salarie : salaries){
  				if(salarie.getId()==salarie.getIdmanager()){
  					break;
  				}
  				System.out.printf(" salarie" + salarie.getNom());
  				List<Conge> conges = gestionConges.listeDesOffresPourUnSalarie(salarie.getId());
  			%>
  			
  			 <tr>
  				<td><%= salarie.getId()%></td>
  				<td><%= salarie.getNom()%></td>
  				<td><%= salarie.getPrenom()%></td>
  				<td>
  				 <table>
  				<tr>
  				    <th>Conges</th>
		   			<th>Conges status</th>
		   			<th>Periode</th>
		   			<th>Début conges</th>
		   			<th>Fin Conges</th>
		   			<th>Authoriser le conges</th>
		 		 </tr>
  				<%
  				for (Conge conge : conges){
  					
  					if(conge.getStatus().equals("cree")){
  				
  				%>
  				<tr>
  				    <td><%= conge.getId()%></td>
  					<td><%= conge.getStatus()%></td>
  					 <td><%= conge.getPeriode()%></td>
  					<td><%= conge.getDebutconges()%></td>
  					 <td><%= conge.getFinconges()%></td>
  					 <td>
  							<a href="template.jsp?action=Nok_conge&id_conge=<%=conge.getId()%>" style ="color: RED;"> NON </a>
  							<a> | </a>
  							<a href="template.jsp?action=Ok_conge&id_conge=<%=conge.getId()%>" style ="color: GREEN;">  OUI </a>
  					 </td>
  				</tr>
  				
  				<%
  					}
  				}
  				%>
  				 </table>
  				</td>
  			</tr>
  			<%
  			}
  			%>
		</table>
    	<p><a href="index.jsp">Retour au menu</a></p>
  	</body>
</html>