package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the produkt database table.
 * 
 */
@Entity
@NamedQuery(name="Produkt.findAll", query="SELECT p FROM Produkt p")
public class Produkt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produkt")
	private int idProdukt;

	@Column(name="cena_produktu")
	private double cenaProduktu;

	private String imgsrc;

	@Column(name="nazwa_produktu")
	private String nazwaProduktu;

	@Column(name="opis_produktu")
	private String opisProduktu;

	//bi-directional many-to-one association to Kategoria
	@ManyToOne
	@JoinColumn(name="id_kategoria")
	private Kategoria kategoria;

	//bi-directional many-to-one association to ZamProd
	@OneToMany(mappedBy="produkt")
	private List<ZamProd> zamProds;

	public Produkt() {
	}

	public int getIdProdukt() {
		return this.idProdukt;
	}

	public void setIdProdukt(int idProdukt) {
		this.idProdukt = idProdukt;
	}

	public double getCenaProduktu() {
		return this.cenaProduktu;
	}

	public void setCenaProduktu(double cenaProduktu) {
		this.cenaProduktu = cenaProduktu;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getNazwaProduktu() {
		return this.nazwaProduktu;
	}

	public void setNazwaProduktu(String nazwaProduktu) {
		this.nazwaProduktu = nazwaProduktu;
	}

	public String getOpisProduktu() {
		return this.opisProduktu;
	}

	public void setOpisProduktu(String opisProduktu) {
		this.opisProduktu = opisProduktu;
	}

	public Kategoria getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public List<ZamProd> getZamProds() {
		return this.zamProds;
	}

	public void setZamProds(List<ZamProd> zamProds) {
		this.zamProds = zamProds;
	}

	public ZamProd addZamProd(ZamProd zamProd) {
		getZamProds().add(zamProd);
		zamProd.setProdukt(this);

		return zamProd;
	}

	public ZamProd removeZamProd(ZamProd zamProd) {
		getZamProds().remove(zamProd);
		zamProd.setProdukt(null);

		return zamProd;
	}

}