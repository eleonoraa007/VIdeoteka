package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the videotekauloga database table.
 * 
 */
@Entity
@NamedQuery(name="Videotekauloga.findAll", query="SELECT v FROM Videotekauloga v")
public class Videotekauloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVideotekaUloga;

	private String naziv;

	//bi-directional many-to-many association to Videotekakorisnik
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="videotekakorisnik_has_videotekauloga"
		, joinColumns={
			@JoinColumn(name="VideotekaUloga_idVideotekaUloga")
			}
		, inverseJoinColumns={
			@JoinColumn(name="VideotekaKorisnik_idVideotekaKorisnik")
			}
		)
	private Set<Videotekakorisnik> videotekakorisniks;

	public Videotekauloga() {
	}

	public int getIdVideotekaUloga() {
		return this.idVideotekaUloga;
	}

	public void setIdVideotekaUloga(int idVideotekaUloga) {
		this.idVideotekaUloga = idVideotekaUloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<Videotekakorisnik> getVideotekakorisniks() {
		return this.videotekakorisniks;
	}

	public void setVideotekakorisniks(Set<Videotekakorisnik> videotekakorisniks) {
		this.videotekakorisniks = videotekakorisniks;
	}

	public void addKorisnik(Videotekakorisnik k) {
		this.videotekakorisniks.add(k);
	}
	
}