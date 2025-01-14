package gestConges.data.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the conges database table.
 * 
 */
@Entity
@Table(name="conges")
@NamedQuery(name="Conge.findAll", query="SELECT c FROM Conge c")
public class Conge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONGES_ID_GENERATOR", sequenceName="CONGES_ID_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONGES_ID_GENERATOR")
	private Integer id;

	private String debutconges;

	private String finconges;

	private Integer idemploye;

	private double periode;

	private String status;

	public Conge() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDebutconges() {
		return this.debutconges;
	}

	public void setDebutconges(String debutconges2) {
		this.debutconges = debutconges2;
	}

	public String getFinconges() {
		return this.finconges;
	}

	public void setFinconges(String finconges2) {
		this.finconges = finconges2;
	}

	public Integer getIdemploye() {
		return this.idemploye;
	}

	public void setIdemploye(Integer idemploye) {
		this.idemploye = idemploye;
	}

	public double getPeriode() {
		return this.periode;
	}

	public void setPeriode(double periode) {
		this.periode = periode;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}