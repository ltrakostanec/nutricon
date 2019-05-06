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
public class NamirnicaNaObroku {
    
    private Namirnica namirnica;
    
    private double kolicina;
    
    private double iznosEnergije;
    
    private double iznosSecera;
    
    private double iznosMasti;
    
    private double iznosBjelancevina;

    public Namirnica getNamirnica() {
        return namirnica;
    }

    public void setNamirnica(Namirnica namirnica) {
        this.namirnica = namirnica;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznosEnergije() {
        return iznosEnergije;
    }

    public double getIznosSecera() {
        return iznosSecera;
    }

    public double getIznosMasti() {
        return iznosMasti;
    }


    public double getIznosBjelancevina() {
        return iznosBjelancevina;
    }

    public void setIznosEnergije(double iznosEnergije) {
        this.iznosEnergije = iznosEnergije;
    }

    public void setIznosSecera(double iznosSecera) {
        this.iznosSecera = iznosSecera;
    }

    public void setIznosMasti(double iznosMasti) {
        this.iznosMasti = iznosMasti;
    }

    public void setIznosBjelancevina(double iznosBjelancevina) {
        this.iznosBjelancevina = iznosBjelancevina;
    }


    public void izracunObroka() {
        iznosEnergije = kolicina*(1-namirnica.getOdbitak())*namirnica.getEnergija();
        iznosSecera = kolicina*(1-namirnica.getOdbitak())*namirnica.getSeceri();
        iznosMasti = kolicina*(1-namirnica.getOdbitak())*namirnica.getMasti();
        iznosBjelancevina = kolicina*(1-namirnica.getOdbitak())*namirnica.getBjelancevine();
    }
       
    public String toString(){
        return "ID: "+namirnica.getId()+" Naziv: "+namirnica.getNaziv()+" Energija: "+iznosEnergije+" kcal Seceri: "+iznosSecera
                +" g Masti: "+iznosMasti+" g Bjelancevine: "+iznosBjelancevina+" g Kolicina: "+kolicina+" g";
    }
}
