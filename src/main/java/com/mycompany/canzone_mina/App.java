/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import eccezioni.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.*;

/**
 *
 * @author Mina
 */
public class App 
{
    public static void main(String[] args) {
        
        String[] vociMenu;
        int numeroVoci=7;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Playlist p1=new Playlist(); //creo la playlist vuota
        int esito;
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,cantante;
        int durata;
        Canzone canz = null;
        int posizione;
        String[] elencoTitoliCantante;
        int canzoniPresenti;
        //Canzone[] canzoniPresenti
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutte le canzoni presenti";
        vociMenu[2]="\t--> Aggiungi canzone";
        vociMenu[3]="\t--> Visualizza canzone (posizione) ";
        vociMenu[4]="\t--> Elimina canzone (ripiano, posizione)";
        vociMenu[5]="\t--> Mostra canzoni di un artista";
        vociMenu[6]="\t--> Mostra le canzoni presenti in ordine alfabetico di titolo";
        
        menu=new Menu(vociMenu);

        //Gestione menu
        do
        {
            System.out.println("Menu:");
            voceScelta=menu.sceltaMenu();
            switch (voceScelta) 
            {
                case 0: //esci
                    System.out.println("Arrivederci!");    
                    break;
                case 1://Visualizza tutti
                    System.out.println(p1.toString());
                    break;
                case 2://aggiungiCanzone
                    System.out.println("Premi invio per continuare...");
                {
                    try 
                    {
                        tastiera.readString();
                        System.out.println("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.println("Cantante --> ");
                        cantante=tastiera.readString();
                        System.out.println("Durata --> ");
                        durata=tastiera.readInt();

                        canzoniPresenti=tastiera.readInt();
                        System.out.println("Posizione (0..49) --> ");
                        posizione=tastiera.readInt();  
                        esito=p1.setCanzone(canz, posizione);
                        if(esito==-1)
                            System.out.println("Posizione inesistente");
                        else if(esito==-2)
                            System.out.println("Posizione già occupata");
                        else
                            System.out.println("Canzone aggiunta correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore");
                    } 
                    catch (NumberFormatException ex) 
                    {
                         System.out.println("Errore");
                    }
                }
                    
                    break;

                case 3:
                    System.out.println("Posizione (0..49) --> ");
                {  
                    try 
                    {
                        posizione=tastiera.readInt();
                        canz=p1.getCanzone(posizione);
                        if (canz==null)
                            System.out.println("Canzone non trovata!");
                        else
                            System.out.println("Canzone cercata: "+canz.toString());
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Errore! Devi inserire un numero!");
                    }
                }
                    break;

                case 4:
                    System.out.println("Posizione (0..49) --> ");
                {
                    try 
                    {
                        posizione=tastiera.readInt();
                        esito=p1.rimuoviCanzone(posizione);
                        if(esito==-1)
                            System.out.println("Posizione inesistente");
                        else if(esito==-2)
                            System.out.println("Posizione già vuota. Nessuna canzone è stato rimosso.");
                        else
                            System.out.println("Canzone rimossa correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Errore! Devi inserire un numero!");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                        System.out.println("Posizione già vuota");
                    }
                }
                    break;

                case 5:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare...");
                {
                    try 
                    {
                        tastiera.readString();
                        System.out.println("Canzone --> ");
                        cantante=tastiera.readString();
                        elencoTitoliCantante=p1.elencoTitoliCantante(cantante);
                        if(elencoTitoliCantante==null)
                            System.out.println("Nessun libro presente");
                        else
                        {
                            for(int i=0;i<elencoTitoliCantante.length;i++)
                            {
                                System.out.println(elencoTitoliCantante[i]);
                            }
                        }
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Errore! Devi inserire un numero!");
                    }
                }
            }  
        }while(voceScelta!=0);
       
    }
}