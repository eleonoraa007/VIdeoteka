package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zanrfilma database table.
 * 
 */
@Entity
@NamedQuery(name="Zanrfilma.findAll", query="SELECT z FROM Zanrfilma z")
public class Zanrfilma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idZanrFilma;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	private Zanr zanr;

	public Zanrfilma() {
	}

	public int getIdZanrFilma() {
		return this.idZanrFilma;
	}

	public void setIdZanrFilma(int idZanrFilma) {
		this.idZanrFilma = idZanrFilma;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

}