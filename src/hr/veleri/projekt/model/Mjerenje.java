package hr.veleri.projekt.model;


import java.util.Date;

public class Mjerenje {

    private Korisnik korisnik;

    private double tezina;

    private double visina;

    private String dnevnaAktivnost;

    private double opsegStruka;

    private double opsegBokova;

    private Date datumMjerenja;
    
    private int id;
    
    private double itm;
    
    private double eer;
    
    private double whr;
    
    private double idelnaTjelesnaMasa;

    public double getItm() {
        return itm;
    }

    public void setItm(double itm) {
        this.itm = itm;
    }

    public double getEer() {
        return eer;
    }

    public void setEer(double eer) {
        this.eer = eer;
    }

    public double getWhr() {
        return whr;
    }

    public void setWhr(double whr) {
        this.whr = whr;
    }

    public double getIdelnaTjelesnaMasa() {
        return idelnaTjelesnaMasa;
    }

    public void setIdelnaTjelesnaMasa(double idelnaTjelesnaMasa) {
        this.idelnaTjelesnaMasa = idelnaTjelesnaMasa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public double getVisina() {
        return visina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public String getDnevnaAktivnost() {
        return dnevnaAktivnost;
    }

    public void setDnevnaAktivnost(String dnevnaAktivnost) {
        this.dnevnaAktivnost = dnevnaAktivnost;
    }

    public double getOpsegStruka() {
        return opsegStruka;
    }

    public void setOpsegStruka(double opsegStruka) {
        this.opsegStruka = opsegStruka;
    }

    public double getOpsegBokova() {
        return opsegBokova;
    }

    public void setOpsegBokova(double opsegBokova) {
        this.opsegBokova = opsegBokova;
    }

    public Date getDatumMjerenja() {
        return datumMjerenja;
    }

    public void setDatumMjerenja(Date datumMjerenja) {
        this.datumMjerenja = datumMjerenja;
    }
    
    public String toString(){
        return id+" \t"+visina+" \t"+tezina+" \t"+opsegStruka+" "+opsegBokova+" "+dnevnaAktivnost+" "+datumMjerenja;
    }
}
