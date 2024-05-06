/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import eccezioni.*;
import java.io.*;
import java.time.LocalDate;
import utilita.*;

/**
 *
 * @author Mina
 */
public class App 
{
    public static void main(String[] args) 
    {
        
        String[] vociMenu;
        int numeroVoci=7;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta=0;
        Playlist p1=new Playlist(); //creo la playlist vuota
        int esito=0;
        ConsoleInput tastiera=new ConsoleInput();
        String titolo=null;
        String cantante=null;
        int durata=0;
        Canzone canz = null;
        int posizione=0;
        String[] elencoTitoliCantante=null;
        Canzone[] canzoniPresenti;
        
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
                    try
                    {
                        System.out.println("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.println("Cantante --> ");
                        cantante=tastiera.readString();
                        do
                        {
                            try
                            {
                                System.out.println("Durata --> ");
                                durata=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true); 
                      
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..49) --> ");
                                posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            } 
                            catch (IOException ex) 
                            {
                                System.out.println("Impossibile leggere da file");
                            }  
                        }while(true); 
                        
                        p1.setCanzone(new Canzone(titolo, durata, posizione, LocalDate.MIN),posizione);
                        System.out.println("Canzone aggiunto correttamente");
                    }
                    catch (NumberFormatException ex) 
                    {
                        System.out.println("Errore");
                    } 
                    catch (IOException ex) 
                    {
                        
                    }
                    break;

                case 3:
                     try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..49) --> ");
                                posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
                        canz=p1.getCanzone(posizione);
                        System.out.println("Canzone carcata: "+canz.toString());
                    } 
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera!");
                    }
                    break;
                case 4:
                    try 
                    {
                        do
                        {
                            try
                            {
                                    System.out.println("Posizione (0..49) --> ");
                                    posizione=tastiera.readInt();
                                break; //se input ok, esci dal ciclo
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Errore! Devi inserire un numero!");
                            }  
                        }while(true);  
                        p1.rimuoviCanzone(posizione);
                        System.out.println("Canzone rimossa correttamente");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessuna canzone è stata rimossa.");
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile acquisire da tastiera");
                    }                 
                    break;
                case 5:
                    try
                    {
                        System.out.println("Cantante --> ");
                        cantante=tastiera.readString();
                      
                        elencoTitoliCantante=p1.elencoTitoliCantante(cantante);
                        if(elencoTitoliCantante==null)
                            System.out.println("Nessuna canzone presente");
                        else
                        {
                            for(int i=0;i<elencoTitoliCantante.length;i++)
                            {
                                System.out.println(elencoTitoliCantante[i]);
                            }
                        }   
                    }
                    catch (IOException e)
                    {
                        System.out.println("Impossibile leggere da tastiera");
                    }
                    break;
                    
                case 6:
                    canzoniPresenti=p1.elencoCanzoniPresenti();
                    canzoniPresenti=Ordinatore.selectionSortCrescenteCanzoni(canzoniPresenti);
                    for(int i=0;i<canzoniPresenti.length;i++)
                    {
                        System.out.println(canzoniPresenti[i].toString());
                    }
                    break;
            }  
        }while(voceScelta!=0);
    }
}