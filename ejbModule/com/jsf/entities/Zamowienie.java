package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zamowienie database table.
 * 
 */
@Entity
@NamedQuery(name="Zamowienie.findAll", query="SELECT z FROM Zamowienie z")
public class Zamowienie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zamowienia")
	private int idZamowienia;

	@Column(name="czas_stworzenia")
	private String czasStworzenia;

	private String ilosc;

	//bi-directional many-to-one association to ZamProd
	@OneToMany(mappedBy="zamowienie")
	private List<ZamProd> zamProds;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	@JoinColumn(name="id_uzytkownik")
	private Uzytkownik uzytkownik;

	public Zamowienie() {
	}

	public int getIdZamowienia() {
		return this.idZamowienia;
	}

	public void setIdZamowienia(int idZamowienia) {
		this.idZamowienia = idZamowienia;
	}

	public String getCzasStworzenia() {
		return this.czasStworzenia;
	}

	public void setCzasStworzenia(String czasStworzenia) {
		this.czasStworzenia = czasStworzenia;
	}

	public String getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(String ilosc) {
		this.ilosc = ilosc;
	}

	public List<ZamProd> getZamProds() {
		return this.zamProds;
	}

	public void setZamProds(List<ZamProd> zamProds) {
		this.zamProds = zamProds;
	}

	public ZamProd addZamProd(ZamProd zamProd) {
		getZamProds().add(zamProd);
		zamProd.setZamowienie(this);

		return zamProd;
	}

	public ZamProd removeZamProd(ZamProd zamProd) {
		getZamProds().remove(zamProd);
		zamProd.setZamowienie(null);

		return zamProd;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

}