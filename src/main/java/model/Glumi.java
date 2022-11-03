package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the glumi database table.
 * 
 */
@Entity
@NamedQuery(name="Glumi.findAll", query="SELECT g FROM Glumi g")
public class Glumi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGlumi;

	//bi-directional many-to-one association to Film
	@ManyToOne
	private Film film;

	//bi-directional many-to-one association to Glumac
	@ManyToOne
	private Glumac glumac;

	public Glumi() {
	}

	public int getIdGlumi() {
		return this.idGlumi;
	}

	public void setIdGlumi(int idGlumi) {
		this.idGlumi = idGlumi;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Glumac getGlumac() {
		return this.glumac;
	}

	public void setGlumac(Glumac glumac) {
		this.glumac = glumac;
	}

}