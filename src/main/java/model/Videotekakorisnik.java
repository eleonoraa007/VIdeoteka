package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the videotekakorisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Videotekakorisnik.findAll", query="SELECT v FROM Videotekakorisnik v")
public class Videotekakorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVideotekaKorisnik;

	private String ime;

	private String korisnickoIme;

	private String prezime;

	private String sifra;

	//bi-directional many-to-many association to Videotekauloga
	@ManyToMany(mappedBy="videotekakorisniks", fetch=FetchType.EAGER)
	private Set<Videotekauloga> videotekaulogas;

	public Videotekakorisnik() {
	}

	public int getIdVideotekaKorisnik() {
		return this.idVideotekaKorisnik;
	}

	public void setIdVideotekaKorisnik(int idVideotekaKorisnik) {
		this.idVideotekaKorisnik = idVideotekaKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Set<Videotekauloga> getVideotekaulogas() {
		return this.videotekaulogas;
	}

	public void setVideotekaulogas(Set<Videotekauloga> videotekaulogas) {
		this.videotekaulogas = videotekaulogas;
	}

	public void setRoles(Set<Videotekauloga> uloge) {
		this.videotekaulogas = uloge;
	}
	public void addRole(Videotekauloga r) {
		this.videotekaulogas.add(r);
	}
}