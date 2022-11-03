package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the iznajmljuje database table.
 * 
 */
@Entity
@NamedQuery(name="Iznajmljuje.findAll", query="SELECT i FROM Iznajmljuje i")
public class Iznajmljuje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIznajmljuje;

	private double cena;

	@Temporal(TemporalType.DATE)
	private Date datumZaduzenja;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	public Iznajmljuje() {
	}

	public int getIdIznajmljuje() {
		return this.idIznajmljuje;
	}

	public void setIdIznajmljuje(int idIznajmljuje) {
		this.idIznajmljuje = idIznajmljuje;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Date getDatumZaduzenja() {
		return this.datumZaduzenja;
	}

	public void setDatumZaduzenja(Date datumZaduzenja) {
		this.datumZaduzenja = datumZaduzenja;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

}