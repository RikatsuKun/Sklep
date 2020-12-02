package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zam_prod database table.
 * 
 */
@Entity
@Table(name="zam_prod")
@NamedQuery(name="ZamProd.findAll", query="SELECT z FROM ZamProd z")
public class ZamProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_zam_prod")
	private int idZamProd;

	private int ilosc;

	//bi-directional many-to-one association to Produkt
	@ManyToOne
	@JoinColumn(name="id_produkt")
	private Produkt produkt;

	//bi-directional many-to-one association to Zamowienie
	@ManyToOne
	@JoinColumn(name="id_zamowienia")
	private Zamowienie zamowienie;

	public ZamProd() {
	}

	public int getIdZamProd() {
		return this.idZamProd;
	}

	public void setIdZamProd(int idZamProd) {
		this.idZamProd = idZamProd;
	}

	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public Produkt getProdukt() {
		return this.produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public Zamowienie getZamowienie() {
		return this.zamowienie;
	}

	public void setZamowienie(Zamowienie zamowienie) {
		this.zamowienie = zamowienie;
	}

}