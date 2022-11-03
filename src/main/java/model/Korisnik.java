package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String email;

	private String ime;

	private String korisnickoIme;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Iznajmljuje
	@OneToMany(mappedBy="korisnik")
	private List<Iznajmljuje> iznajmljujes;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Iznajmljuje> getIznajmljujes() {
		return this.iznajmljujes;
	}

	public void setIznajmljujes(List<Iznajmljuje> iznajmljujes) {
		this.iznajmljujes = iznajmljujes;
	}

	public Iznajmljuje addIznajmljuje(Iznajmljuje iznajmljuje) {
		getIznajmljujes().add(iznajmljuje);
		iznajmljuje.setKorisnik(this);

		return iznajmljuje;
	}

	public Iznajmljuje removeIznajmljuje(Iznajmljuje iznajmljuje) {
		getIznajmljujes().remove(iznajmljuje);
		iznajmljuje.setKorisnik(null);

		return iznajmljuje;
	}

}