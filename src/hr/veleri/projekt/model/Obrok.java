/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.veleri.projekt.model;

import java.util.ArrayList;

/**
 *
 * @author Leon
 */
public class Obrok {
    private Namirnica namirnica;

    private double energijaDorucak;
    
    private double energijaRucak;
    
    private double energijaVecera;

    public double getEnergijaDorucak() {
        return energijaDorucak;
    }

    public double getEnergijaRucak() {
        return energijaRucak;
    }

    public double getEnergijaVecera() {
        return energijaVecera;
    }

   private ArrayList<NamirnicaNaObroku> listaDorucak = new ArrayList<NamirnicaNaObroku>();
   private ArrayList<NamirnicaNaObroku> listaRucak = new ArrayList<NamirnicaNaObroku>();
   private ArrayList<NamirnicaNaObroku> listaVecera = new ArrayList<NamirnicaNaObroku>();

    public void dodajListuDorucak(NamirnicaNaObroku naObroku) {
        listaDorucak.add(naObroku);
    }
    
    public void izracunEnergijeDorucak(){
        energijaDorucak = 0;
        for (NamirnicaNaObroku naObroku : listaDorucak) {
            energijaDorucak += naObroku.getIznosEnergije();
        }
    }

    public void dodajListuRucak(NamirnicaNaObroku naObroku) {
        listaRucak.add(naObroku);
    }

    public void dodajListuVecera(NamirnicaNaObroku naObroku) {
        listaVecera.add(naObroku);
    }
    
    public void izracunEnergijeRucak() {
        energijaRucak = 0;
        for (NamirnicaNaObroku naObroku : listaRucak) {
            energijaRucak += naObroku.getIznosEnergije();
        }
    }    

    public void izracunEnergijeVecera() {
        energijaVecera = 0;
        for (NamirnicaNaObroku naObroku : listaVecera) {
            energijaVecera += naObroku.getIznosEnergije();
        }
    }
}
