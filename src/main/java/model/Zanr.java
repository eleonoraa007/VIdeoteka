package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zanr database table.
 * 
 */
@Entity
@NamedQuery(name="Zanr.findAll", query="SELECT z FROM Zanr z")
public class Zanr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanr;

	private String naziv;

	//bi-directional many-to-one association to Zanrfilma
	@OneToMany(mappedBy="zanr")
	private List<Zanrfilma> zanrfilmas;

	public Zanr() {
	}

	public int getIdZanr() {
		return this.idZanr;
	}

	public void setIdZanr(int idZanr) {
		this.idZanr = idZanr;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Zanrfilma> getZanrfilmas() {
		return this.zanrfilmas;
	}

	public void setZanrfilmas(List<Zanrfilma> zanrfilmas) {
		this.zanrfilmas = zanrfilmas;
	}

	public Zanrfilma addZanrfilma(Zanrfilma zanrfilma) {
		getZanrfilmas().add(zanrfilma);
		zanrfilma.setZanr(this);

		return zanrfilma;
	}

	public Zanrfilma removeZanrfilma(Zanrfilma zanrfilma) {
		getZanrfilmas().remove(zanrfilma);
		zanrfilma.setZanr(null);

		return zanrfilma;
	}

}