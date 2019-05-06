package hr.veleri.projekt.model;


import java.util.Date;

public class Korisnik {

    private String ime;

    private String prezime;

    private String oib;

    private Date rodjendan;

    private String e_mail;

    private String spol;

    private String adresa;
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public Date getRodjendan() {
        return rodjendan;
    }

    public void setRodjendan(Date rodjendan) {
        this.rodjendan = rodjendan;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getSpol() {
        return spol;
    }

    public void setSpol(String spol) {
        this.spol = spol;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    public String toString(){
        return ime+" "+prezime+" "+oib+" "+rodjendan+" "+spol;
    }
}
