/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import eccezioni.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta=0;
        Playlist p1=new Playlist(); //creo la playlist vuota
        int esito;
        ConsoleInput tastiera=new ConsoleInput();
        String titolo;
        String cantante;
        LocalDate dataUscita;
        int durata;
        Canzone canz = null;
        int posizione;
        int idCanzone = 0;
        String[] elencoTitoliCantante = null;
        Canzone[] canzoniPresenti = null;
        String nomeFile="canzoni.csv";
        String nomeFileBinario="playlist.bin";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutte le canzoni presenti";
        vociMenu[2]="\t--> Aggiungi canzone";
        vociMenu[3]="\t--> Visualizza canzone (posizione) ";
        vociMenu[4]="\t--> Elimina canzone (posizione)";
        vociMenu[5]="\t--> Mostra canzoni di un artista";
        vociMenu[6]="\t--> Mostra le canzoni presenti in ordine alfabetico di titolo";
        vociMenu[7]="\t--> Esporta le canzoni su file CSV";
        vociMenu[8]="\t--> Importa le canzoni da file CSV";
        vociMenu[9]="\t--> Salva dati";
        vociMenu[10]="\t--> Carica dati";
        
        
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
                        }while(true); 
                        
                        do {
                                try 
                                {
                                    System.out.println("Inserisci la data di uscita (AAAA-MM-GG): ");
                                    String inputData = tastiera.readString();
                                    dataUscita = LocalDate.parse(inputData); // Utilizza la variabile corretta
                                    break; // Esci dal ciclo se l'input è corretto
                                } 
                                catch (DateTimeParseException e) 
                                { // Gestisci eccezione specifica per il parsing della data
                                    System.out.println("Errore! Formato data non valido. Inserisci la data nel formato corretto (AAAA-MM-GG)");
                                }
                            } while (true);
                        try
                        {
                            try 
                            {
                                p1.setCanzone(new Canzone(titolo, durata, idCanzone, dataUscita),posizione);
                            } 
                            catch (EccezionePosizioneOccupata ex) 
                            {
                                System.out.println("Posizione già occupata");
                            } 
                            catch (EccezionePosizioneNonValida ex) 
                            {
                                 System.out.println("Posizione non valida");
                            }
                            System.out.println("Canzone aggiunta correttamente");
                        }   
                        catch (NumberFormatException ex) 
                        {
                            System.out.println("Errore");
                        } 
                    }
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da tastiera!");
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
                        
                            try 
                            {
                                canz=p1.getCanzone(posizione);
                            } 
                            catch (EccezionePosizioneNonValida ex) 
                            {
                                 System.out.println("Posizione non valida");
                            }
                            catch (EccezionePosizioneVuota ex) 
                            {
                                System.out.println("Posizione vuota");
                            }
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
                      
                try 
                {
                    elencoTitoliCantante=p1.elencoTitoliCantante(cantante);
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                      System.out.println("Posizione inesistente");
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                      System.out.println("Posizione già vuota. Nessuna canzone è stata rimossa.");
                }
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
                {
                    try 
                    {
                        canzoniPresenti=p1.elencoCanzoniPresenti();
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessuna canzone è stata rimossa.");
                    }
                }
                    canzoniPresenti=Ordinatore.selectionSortCrescenteCanzoni(canzoniPresenti);
                    for(int i=0;i<canzoniPresenti.length;i++)
                    {
                        System.out.println(canzoniPresenti[i].toString());
                    }
                    break;

                    
                 case 7: //esporta su file CSV
                    try 
                    {
                        p1.esportaCSV(nomeFile);
                        System.out.println("Esportazione avvenuta con successo!");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore di scrittura, impossibile accedere al file");
                    } 
                    catch (FileException ex) 
                    {
                        System.out.println("Errore file aperto in lettura!");
                    }
                    catch (EccezionePosizioneNonValida ex) 
                    {
                          System.out.println("Posizione inesistente");
                    } 
                    catch (EccezionePosizioneVuota ex) 
                    {
                          System.out.println("Posizione già vuota. Nessuna canzone è stata rimossa.");
                    }
                    break;

                 case 8:              
                    try 
                    {
                        p1.importaCSV(nomeFile);
                        System.out.println("Importazione avvenuta con successo.");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere dal file");
                    } 
                    break;
                case 9:
                    try
                    {
                       
                        p1.salvaPlaylist(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile salvare su file");
                    }
                    break;
                case 10: 
                    try 
                    {
                        //carica playlist
                        p1=p1.caricaPlaylist(nomeFileBinario);
                        System.out.println("Caricamento avvenuto con successo");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile leggere da file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere i dati dello scaffale");
                    }

                    break;
            }  
        }while(voceScelta!=0);
    }
}


        