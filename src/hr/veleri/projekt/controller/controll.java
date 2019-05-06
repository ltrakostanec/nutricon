/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.veleri.projekt.controller;

import hr.veleri.projekt.model.Korisnik;
import hr.veleri.projekt.model.Mjerenje;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Leon
 */
public class controll {
    
    public static double izracunajItm(Mjerenje mjerenje) {
        double visina = (mjerenje.getVisina()/100);
        mjerenje.setItm(mjerenje.getTezina()/(visina*visina));
        return mjerenje.getItm();    
    }

    public static String ispisiBmi(Mjerenje mjere) {
        String ispis = "";
        if(mjere.getItm()<18.5){
            ispis+="Pothranjeni ste!";
        }
        else if(mjere.getItm()>=18.5 && mjere.getItm()<=24.9){
            ispis+="Uravnotežena tjelesna masa!";
        }
        else if(mjere.getItm()>=25 && mjere.getItm()<=29.9){
            ispis+="Prekomjerna tjelesna masa!";
        }
        else if(mjere.getItm()>=30 && mjere.getItm()<=34.9){
            ispis+="Gojaznost (oblik 1)!";
        }
        else if(mjere.getItm()>=35 && mjere.getItm()<=39.9){
            ispis+="Gojaznost (oblik 2)!";
        }
        else if(mjere.getItm()>=40){
            ispis+="Gojaznost (oblik 3)!";
        }
        return ispis;
    }

    public static void izracunajIdealnuTjelesnuMasu(Mjerenje mjere, Korisnik korisnik) {
        Date date = new Date();

        int dob = date.getYear()-korisnik.getRodjendan().getYear();
        
        if(korisnik.getSpol().equalsIgnoreCase("muskarac")){
            mjere.setIdelnaTjelesnaMasa((mjere.getVisina()-100)-(mjere.getVisina()-150)/4+(dob-20)/4);

        }else if(korisnik.getSpol().equalsIgnoreCase("zena")){
            mjere.setIdelnaTjelesnaMasa((mjere.getVisina()-100)-(mjere.getVisina()-150)/2.5+(dob-20)/4);
        }
    }

    public double izracunajBmi(Mjerenje mjerenje) {
        mjerenje.setItm(mjerenje.getTezina()/mjerenje.getVisina()*mjerenje.getVisina());
        return mjerenje.getItm();
    }


    public static void izracunajWhr(Mjerenje mjerenje) {
        double whr = mjerenje.getOpsegStruka()/mjerenje.getOpsegBokova();
        mjerenje.setWhr(whr);
    }

    public static void izracunajCjelodnevnuEnergetskuPotrebu(Mjerenje mjere, Korisnik korisnik) {
        Date date = new Date();

        int dob = date.getYear()-korisnik.getRodjendan().getYear();
        double pa = 0;
        double eer;
        double visinaM = mjere.getVisina()/100;
        
        if(korisnik.getSpol().equalsIgnoreCase("muskarac")) {
            if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Umjerena tjelesna aktivnost")){
                pa=1.0;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Normalna tjelesna aktivnost")){
                pa=1.11;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Povećana tjelesna aktivnost")){
                pa=1.25;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Velika tjelesna aktivnost")){
                pa=1.48;
            }
            
            eer = 661.8-(9.53*dob)+pa*(15.91*mjere.getTezina()+539.6*visinaM);
            mjere.setEer(eer);

        }else if(korisnik.getSpol().equalsIgnoreCase("zena")) {
            if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Umjerena tjelesna aktivnost")){
                pa=1.0;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Normalna tjelesna aktivnost")){
                pa=1.12;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Povećana tjelesna aktivnost")){
                pa=1.27;
            }
            else if(mjere.getDnevnaAktivnost().equalsIgnoreCase("Velika tjelesna aktivnost")){
                pa=1.45;
            }
            
            eer = 354.1-(6.91*dob)+pa*(9.36*mjere.getTezina()+726*visinaM);
            mjere.setEer(eer);
        }
    }
}
