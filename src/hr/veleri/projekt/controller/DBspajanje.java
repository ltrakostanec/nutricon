/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.veleri.projekt.controller;

import hr.veleri.projekt.model.Jelovnik;
import hr.veleri.projekt.model.Korisnik;
import hr.veleri.projekt.model.Mjerenje;
import hr.veleri.projekt.model.Namirnica;
import hr.veleri.projekt.model.NamirnicaNaObroku;
import hr.veleri.projekt.model.Obrok;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class DBspajanje {
    private static Connection konekcijaNaBazu(){
        Connection conn = null;
    
        try {
            //konekcija na bazu
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://ucka.veleri.hr/ltrakostanec", "ltrakostanec", "11");

        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    
    
    public static void unosKorisnika(Korisnik korisnik) {
  
        try {
            Connection conn =konekcijaNaBazu();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Korisnik "
                    +"(ime,prezime,oib,adresa,e_mail,rodjendan,spol) VALUES"
                    +"(?,?,?,?,?,?,?)");
            stmt.setString(1, korisnik.getIme());
            stmt.setString(2, korisnik.getPrezime());
            stmt.setString(3, korisnik.getOib());
            stmt.setString(4, korisnik.getAdresa());
            stmt.setString(5, korisnik.getE_mail());
            stmt.setDate(6, new java.sql.Date(korisnik.getRodjendan().getTime()));
            stmt.setString(7, korisnik.getSpol());
            stmt.execute();
            conn.close();//zatvaranje konekcije
        } catch (SQLException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    public static ArrayList<Korisnik> ucitajKorisnike() {

        ArrayList<Korisnik> listaKorisnika= new ArrayList<Korisnik>();
        
        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT id_korisnika, ime, prezime, oib, rodjendan, spol, e_mail, adresa FROM `Korisnik` ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Korisnik korisnik = new Korisnik();
                
                korisnik.setId(rs.getInt("id_korisnika"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setOib(rs.getString("oib"));
                korisnik.setRodjendan(rs.getDate("rodjendan"));
                korisnik.setSpol(rs.getString("spol"));
                korisnik.setAdresa(rs.getString("adresa"));
                korisnik.setE_mail(rs.getString("e_mail"));
                        
                listaKorisnika.add(korisnik);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata korisnika "+ex.toString());
            return null;
        } 
        return listaKorisnika;
    }

    
    
    public static boolean izbrisiKorisnika(int id) {
        try {
            Connection conn = konekcijaNaBazu();
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("DELETE FROM Korisnik WHERE id_korisnika="+id);
            conn.close();
            return true;
        } catch (SQLException ex) { 
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
    public static void unosMjerenja(Mjerenje mjerenje, int id) {
        try {
            Connection conn =konekcijaNaBazu();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Mjerenje "
                    +"(id_korisnika,visina,tezina,dnevnaAktivnost,opsegStruka,opsegBokova,datumMjerenja)VALUES "
                    +"(?,?,?,?,?,?,?);");
            
            stmt.setInt(1, id);
            stmt.setDouble(2, mjerenje.getVisina());
            stmt.setDouble(3, mjerenje.getTezina());
            stmt.setString(4, mjerenje.getDnevnaAktivnost());
            stmt.setDouble(5, mjerenje.getOpsegStruka());
            stmt.setDouble(6, mjerenje.getOpsegBokova());
            stmt.setDate(7, new java.sql.Date(mjerenje.getDatumMjerenja().getTime()));
            
            stmt.execute();
            conn.close();//zatvaranje konekcije
        } catch (SQLException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public static boolean izbrisiMjerenje(int id) {
        try {
            Connection conn = konekcijaNaBazu();
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("DELETE FROM Mjerenje WHERE id_mjerenja="+id+";");
            conn.close();
            return true;
        } catch (SQLException ex) { 
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    
    public static ArrayList<Mjerenje> ucitajMjerenjaKorisnika(int id) {
        ArrayList<Mjerenje> listaMjerenja= new ArrayList<Mjerenje>();
        
        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT id_mjerenja,visina,tezina,opsegStruka,opsegBokova,dnevnaAktivnost,datumMjerenja FROM Mjerenje WHERE Mjerenje.id_korisnika="+id+";";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Mjerenje mjerenje = new Mjerenje();
                
                mjerenje.setId(rs.getInt("id_mjerenja"));
                mjerenje.setVisina(rs.getDouble("visina"));
                mjerenje.setTezina(rs.getDouble("tezina"));
                mjerenje.setOpsegStruka(rs.getDouble("opsegStruka"));
                mjerenje.setOpsegBokova(rs.getDouble("opsegBokova"));
                mjerenje.setDnevnaAktivnost(rs.getString("dnevnaAktivnost"));
                mjerenje.setDatumMjerenja(rs.getDate("datumMjerenja"));
      
                listaMjerenja.add(mjerenje);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata mjerenja korisnika "+ex.toString());
            return null;
        } 
        return listaMjerenja;
    }

    
    public static ArrayList<Namirnica> ucitajNamirnice() {
        ArrayList<Namirnica> listaNamirnica= new ArrayList<Namirnica>();
        
        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM namirnice;";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Namirnica namirnica = new Namirnica();
                
                namirnica.setId(rs.getInt("id"));
                namirnica.setNaziv(rs.getString("Naziv_namirnice"));
                namirnica.setEnergija(rs.getDouble("Energija_Kcal"));
                namirnica.setSeceri(rs.getDouble("Seceri_(g)"));
                namirnica.setMasti(rs.getDouble("Masti_(g)"));
                namirnica.setBjelancevine(rs.getDouble("Bjelancevine_(g)"));
                namirnica.setOdbitak(rs.getDouble("Postotak_odbitka"));
      
                listaNamirnica.add(namirnica);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata namirnica "+ex.toString());
            return null;
        } 
        return listaNamirnica;    
    }

    
    
    public static void izbrisiMjerenje(Mjerenje mjerenje) {
        try {
            Connection conn = konekcijaNaBazu();
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("DELETE FROM Mjerenje WHERE id_mjerenja="+mjerenje.getId()+";");
            conn.close();
       //     return true;
        } catch (SQLException ex) { 
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }
       // return false;
    }

    
    
    public static ArrayList<Korisnik> ucitajKorisnikeZaMjerenja() {
        ArrayList<Korisnik> listaKorisnika= new ArrayList<Korisnik>();
        
        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT id_korisnika, ime, prezime, oib, rodjendan, spol FROM `Korisnik` ";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Korisnik korisnik = new Korisnik();
                
                korisnik.setId(rs.getInt("id_korisnika"));
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setOib(rs.getString("oib"));
                korisnik.setRodjendan(rs.getDate("rodjendan"));
                korisnik.setSpol(rs.getString("spol"));
                        
                listaKorisnika.add(korisnik);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata korisnika "+ex.toString());
            return null;
        } 
        return listaKorisnika;    
    }



    public static void promjenaNazivaNamirnice(Namirnica namirnica) {
        try {
            Connection conn = konekcijaNaBazu();
            Statement stmt = conn.createStatement();
            int res = stmt.executeUpdate("UPDATE `ltrakostanec`.`namirnice` SET `Naziv_namirnice` ='"+namirnica.getNaziv() 
                    +"' WHERE `namirnice`.`id` ="+namirnica.getId()+";");
            conn.close();
       //     return true;
        } catch (SQLException ex) { 
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public static boolean spremiJelovnik(Jelovnik jelovnik, Korisnik korisnik, Obrok obrok) throws SQLException {
        Connection conn = null;
        try {
            conn = konekcijaNaBazu();
            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Jelovnik "
                    + "(datumJelovnika,ukupnaEnergija,id_korisnika) VALUES (?,?,?);"
                    ,  Statement.RETURN_GENERATED_KEYS );
            
            stmt.setDate(1, new java.sql.Date(jelovnik.getDatumJelovnika().getTime()));
            stmt.setDouble(2,jelovnik.getUkupnaEnergija());
            stmt.setInt(3,korisnik.getId());
            stmt.execute();
            
           // ResultSet rs = stmt.ggetGeneratedKeys();
            String sql = "SELECT max(id_jelovnika) AS sifra FROM Jelovnik;";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int sifraJelovnika = rs.getInt("sifra");
            //System.out.println("sifra "+sifra);
            
            
            stmt = conn.prepareStatement("INSERT INTO Obrok "
                    + "(id_jelovnika,energijaDorucak,energijaRucak,energijaVecera) VALUES (?,?,?,?);"
                    ,  Statement.RETURN_GENERATED_KEYS );
            
            stmt.setInt(1, sifraJelovnika);
            stmt.setDouble(2,obrok.getEnergijaDorucak());
            stmt.setDouble(3,obrok.getEnergijaRucak());
            stmt.setDouble(4,obrok.getEnergijaVecera());
            stmt.execute();
            
            String sqlUpit = "SELECT max(id_obroka) AS sifraObroka FROM Obrok";
            ResultSet rst = stmt.executeQuery(sqlUpit);
            rst.next();
            int sifraObroka = rst.getInt("sifraObroka");
            
            
            for (NamirnicaNaObroku naObroku: jelovnik.getListaNamirnicaNaObroku()){
                stmt = conn.prepareStatement("INSERT INTO NamirnicaNaObroku (kolicina, "
                        + "iznosEnergije, iznosSecera, iznosMasti, iznosBjelancevina, id_namirnice, id_obroka) VALUES(?, ?, ?, ?, ?, ?, ?);");
                stmt.setDouble(1, naObroku.getKolicina());
                stmt.setDouble(2, naObroku.getIznosEnergije());
                stmt.setDouble(3, naObroku.getIznosSecera());
                stmt.setDouble(4, naObroku.getIznosMasti());
                stmt.setDouble(5, naObroku.getIznosBjelancevina());
                stmt.setInt(6, naObroku.getNamirnica().getId());
                stmt.setInt(7, sifraObroka);
                
                stmt.execute();
            }
            conn.commit();
            conn.setAutoCommit(true);
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBspajanje.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
            conn.setAutoCommit(true);
            conn.close();   
         }

        return false;
    }

    
    
    public static void traziKorisnika(Korisnik korisnik) {
         try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM `Korisnik` WHERE Korisnik.oib="+korisnik.getOib()+";";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                korisnik.setIme(rs.getString("ime"));
                korisnik.setPrezime(rs.getString("prezime"));
                korisnik.setRodjendan(rs.getDate("rodjendan"));
                korisnik.setSpol(rs.getString("spol"));

            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata korisnika "+ex.toString());
        } 
    }
   
    
    
    public static ArrayList<Jelovnik> ucitajJelovnik(String oib) {
        ArrayList<Jelovnik> listaJelovnika= new ArrayList<Jelovnik>();
        
        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT Jelovnik.* FROM Jelovnik "
                    +"LEFT OUTER JOIN Korisnik ON Jelovnik.id_korisnika=Korisnik.id_korisnika "
                    +"WHERE Korisnik.oib="+oib;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Jelovnik jelovnik = new Jelovnik();
                
                jelovnik.setId(rs.getInt("id_jelovnika"));
                jelovnik.setDatumJelovnika(rs.getDate("datumJelovnika"));
                jelovnik.setUkupnaEnergija(rs.getDouble("ukupnaEnergija"));
                
                listaJelovnika.add(jelovnik);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata jelovnika "+ex.toString());
            return null;
        } 
        return listaJelovnika;

    }


    
    public static ArrayList<NamirnicaNaObroku> ucitajJelovnikKorisnika(int jelovnik) {
        ArrayList<NamirnicaNaObroku> listaNamirnica= new ArrayList<NamirnicaNaObroku>();

        try {
            Connection conn = konekcijaNaBazu();
            
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT namirnice.id,namirnice.Naziv_namirnice,NamirnicaNaObroku.kolicina,"
                    +"NamirnicaNaObroku.iznosEnergije,NamirnicaNaObroku.iznosSecera,NamirnicaNaObroku.iznosMasti,"
                    +"NamirnicaNaObroku.iznosBjelancevina "
                    +"FROM namirnice "
                    +"LEFT OUTER JOIN NamirnicaNaObroku "
                    +"ON namirnice.id=NamirnicaNaObroku.id_namirnice "
                    +"LEFT OUTER JOIN Obrok "
                    +"ON NamirnicaNaObroku.id_obroka=Obrok.id_obroka "
                    +"LEFT OUTER JOIN Jelovnik "
                    +"ON Obrok.id_jelovnika=Jelovnik.id_jelovnika "
                    +"WHERE Jelovnik.id_jelovnika="+jelovnik+";";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Namirnica namirnica = new Namirnica();
                
                namirnica.setId(rs.getInt("namirnice.id"));
                namirnica.setNaziv(rs.getString("namirnice.Naziv_namirnice"));
                
                NamirnicaNaObroku naObroku = new NamirnicaNaObroku();
                
                
                naObroku.setIznosEnergije(rs.getDouble("NamirnicaNaObroku.iznosEnergije"));
                naObroku.setIznosSecera(rs.getDouble("NamirnicaNaObroku.iznosSecera"));
                naObroku.setIznosMasti(rs.getDouble("NamirnicaNaObroku.iznosMasti"));
                naObroku.setIznosBjelancevina(rs.getDouble("NamirnicaNaObroku.iznosBjelancevina"));
                naObroku.setKolicina(rs.getDouble("NamirnicaNaObroku.kolicina"));
                
                naObroku.setNamirnica(namirnica);

                listaNamirnica.add(naObroku);
            }
        conn.close();//zatvaranje konekcije
          
        } catch (SQLException ex) {
            System.out.println("Greška kod dohvata namirnica jelovnika! "+ex.toString());
            return null;
        } 
        return listaNamirnica;
    }


}
