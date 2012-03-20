package com.test.modele;

public class Adresse {
	private String voie;
	private int codePostal;
	private String pays;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(String voie, int codePostal, String pays) {
		super();
		this.voie = voie;
		this.codePostal = codePostal;
		this.pays = pays;
	}
	
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	public String toString() {
		return "Adresse [voie=" + voie + ", codePostal=" + codePostal
				+ ", pays=" + pays + "]";
	}
}
