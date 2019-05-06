package hr.veleri.projekt.model;

import java.util.ArrayList;
import java.util.Date;

public class Jelovnik {

    private Korisnik korisnik;
    
    private int id;
    
    private Date datumJelovnika;
    
    private double ukupnaEnergija;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUkupnaEnergija(double ukupnaEnergija) {
        this.ukupnaEnergija = ukupnaEnergija;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Date getDatumJelovnika() {
        return datumJelovnika;
    }

    public void setDatumJelovnika(Date datumJelovnika) {
        this.datumJelovnika = datumJelovnika;
    }

    private ArrayList<NamirnicaNaObroku> listaNamirnicaNaObroku = new ArrayList<NamirnicaNaObroku>();

    public void dodajNamirnicuNaObrok(NamirnicaNaObroku naObroku) {
        listaNamirnicaNaObroku.add(naObroku);
    }

    public void brisiNamirnicuJelovnika(NamirnicaNaObroku naObroku) {
        listaNamirnicaNaObroku.remove(naObroku);
    }
    
    public double getUkupnaEnergija() {
        return ukupnaEnergija;
    }

    public ArrayList<NamirnicaNaObroku> getListaNamirnicaNaObroku() {
        return listaNamirnicaNaObroku;
    }

    public void izracunEnergijeJelovnika() {
        ukupnaEnergija = 0;
        for (NamirnicaNaObroku naObroku : listaNamirnicaNaObroku) {
            ukupnaEnergija += naObroku.getIznosEnergije();
            System.out.println(ukupnaEnergija);
            System.out.println(listaNamirnicaNaObroku);
        }
        
    }
    
     public String toString(){
        return "ID: "+id+" Datum: "+datumJelovnika+" Energija Jelovnika: "+ukupnaEnergija;
    }

}
