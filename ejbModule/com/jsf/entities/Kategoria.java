package com.jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategoria database table.
 * 
 */
@Entity
@NamedQuery(name="Kategoria.findAll", query="SELECT k FROM Kategoria k")
public class Kategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kategoria")
	private int idKategoria;

	private String nazwa;

	//bi-directional many-to-one association to Produkt
	@OneToMany(mappedBy="kategoria")
	private List<Produkt> produkts;

	public Kategoria() {
	}

	public int getIdKategoria() {
		return this.idKategoria;
	}

	public void setIdKategoria(int idKategoria) {
		this.idKategoria = idKategoria;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Produkt> getProdukts() {
		return this.produkts;
	}

	public void setProdukts(List<Produkt> produkts) {
		this.produkts = produkts;
	}

	public Produkt addProdukt(Produkt produkt) {
		getProdukts().add(produkt);
		produkt.setKategoria(this);

		return produkt;
	}

	public Produkt removeProdukt(Produkt produkt) {
		getProdukts().remove(produkt);
		produkt.setKategoria(null);

		return produkt;
	}

}