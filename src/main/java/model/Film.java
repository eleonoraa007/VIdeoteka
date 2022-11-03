package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFilm;

	private double cena;

	private String naziv;

	private int ocena;

	private String opis;

	//bi-directional many-to-one association to Glumi
	@OneToMany(mappedBy="film")
	private List<Glumi> glumis;

	//bi-directional many-to-one association to Iznajmljuje
	@OneToMany(mappedBy="film")
	private List<Iznajmljuje> iznajmljujes;

	//bi-directional many-to-one association to Kategorijafilma
	@OneToMany(mappedBy="film")
	private List<Kategorijafilma> kategorijafilmas;

	//bi-directional many-to-one association to Zanrfilma
	@OneToMany(mappedBy="film")
	private List<Zanrfilma> zanrfilmas;

	public Film() {
	}

	public int getIdFilm() {
		return this.idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Glumi> getGlumis() {
		return this.glumis;
	}

	public void setGlumis(List<Glumi> glumis) {
		this.glumis = glumis;
	}

	public Glumi addGlumi(Glumi glumi) {
		getGlumis().add(glumi);
		glumi.setFilm(this);

		return glumi;
	}

	public Glumi removeGlumi(Glumi glumi) {
		getGlumis().remove(glumi);
		glumi.setFilm(null);

		return glumi;
	}

	public List<Iznajmljuje> getIznajmljujes() {
		return this.iznajmljujes;
	}

	public void setIznajmljujes(List<Iznajmljuje> iznajmljujes) {
		this.iznajmljujes = iznajmljujes;
	}

	public Iznajmljuje addIznajmljuje(Iznajmljuje iznajmljuje) {
		getIznajmljujes().add(iznajmljuje);
		iznajmljuje.setFilm(this);

		return iznajmljuje;
	}

	public Iznajmljuje removeIznajmljuje(Iznajmljuje iznajmljuje) {
		getIznajmljujes().remove(iznajmljuje);
		iznajmljuje.setFilm(null);

		return iznajmljuje;
	}

	public List<Kategorijafilma> getKategorijafilmas() {
		return this.kategorijafilmas;
	}

	public void setKategorijafilmas(List<Kategorijafilma> kategorijafilmas) {
		this.kategorijafilmas = kategorijafilmas;
	}

	public Kategorijafilma addKategorijafilma(Kategorijafilma kategorijafilma) {
		getKategorijafilmas().add(kategorijafilma);
		kategorijafilma.setFilm(this);

		return kategorijafilma;
	}

	public Kategorijafilma removeKategorijafilma(Kategorijafilma kategorijafilma) {
		getKategorijafilmas().remove(kategorijafilma);
		kategorijafilma.setFilm(null);

		return kategorijafilma;
	}

	public List<Zanrfilma> getZanrfilmas() {
		return this.zanrfilmas;
	}

	public void setZanrfilmas(List<Zanrfilma> zanrfilmas) {
		this.zanrfilmas = zanrfilmas;
	}

	public Zanrfilma addZanrfilma(Zanrfilma zanrfilma) {
		getZanrfilmas().add(zanrfilma);
		zanrfilma.setFilm(this);

		return zanrfilma;
	}

	public Zanrfilma removeZanrfilma(Zanrfilma zanrfilma) {
		getZanrfilmas().remove(zanrfilma);
		zanrfilma.setFilm(null);

		return zanrfilma;
	}

}