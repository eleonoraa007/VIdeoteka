package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKategorija;

	private String naziv;

	//bi-directional many-to-one association to Kategorijafilma
	@OneToMany(mappedBy="kategorija")
	private List<Kategorijafilma> kategorijafilmas;

	public Kategorija() {
	}

	public int getIdKategorija() {
		return this.idKategorija;
	}

	public void setIdKategorija(int idKategorija) {
		this.idKategorija = idKategorija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Kategorijafilma> getKategorijafilmas() {
		return this.kategorijafilmas;
	}

	public void setKategorijafilmas(List<Kategorijafilma> kategorijafilmas) {
		this.kategorijafilmas = kategorijafilmas;
	}

	public Kategorijafilma addKategorijafilma(Kategorijafilma kategorijafilma) {
		getKategorijafilmas().add(kategorijafilma);
		kategorijafilma.setKategorija(this);

		return kategorijafilma;
	}

	public Kategorijafilma removeKategorijafilma(Kategorijafilma kategorijafilma) {
		getKategorijafilmas().remove(kategorijafilma);
		kategorijafilma.setKategorija(null);

		return kategorijafilma;
	}

}