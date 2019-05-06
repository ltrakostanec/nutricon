/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.veleri.projekt.model;

/**
 *
 * @author Leon
 */
public class Namirnica {
    
    private int id;
    
    private String naziv;
    
    private double energija;
    
    private double seceri;
    
    private double masti;
    
    private double bjelancevine;
    
    private double odbitak;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getEnergija() {
        return energija;
    }

    public void setEnergija(double energija) {
        this.energija = energija;
    }

    public double getSeceri() {
        return seceri;
    }

    public void setSeceri(double seceri) {
        this.seceri = seceri;
    }

    public double getMasti() {
        return masti;
    }

    public void setMasti(double masti) {
        this.masti = masti;
    }

    public double getBjelancevine() {
        return bjelancevine;
    }

    public void setBjelancevine(double bjelancevine) {
        this.bjelancevine = bjelancevine;
    }

    public double getOdbitak() {
        return odbitak;
    }

    public void setOdbitak(double odbitak) {
        this.odbitak = odbitak;
    }
    
}
