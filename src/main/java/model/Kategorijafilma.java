package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kategorijafilma database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorijafilma.findAll", query="SELECT k FROM Kategorijafilma k")
public class Kategorijafilma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorijaFilma;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	public Kategorijafilma() {
	}

	public int getIdKategorijaFilma() {
		return this.idKategorijaFilma;
	}

	public void setIdKategorijaFilma(int idKategorijaFilma) {
		this.idKategorijaFilma = idKategorijaFilma;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

}