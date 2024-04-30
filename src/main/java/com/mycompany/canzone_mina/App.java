/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import eccezioni.*;
import java.io.*;
import utilita.*;

/**
 *
 * @author Studente
 */
public class App 
{
    public static void main(String[] args) {
        
        //Canzone c1=new Canzone("Lao", 3, 1, LocalDate.EPOCH);
        //Canzone c2=new Canzone("Ciao",4, 2,LocalDate.EPOCH);
        //Canzone c3=new Canzone("Ao",2, 3,LocalDate.EPOCH):
        
        
        //Playlist playlist=new Playlist();
        
        
        String[] vociMenu;
        int numeroVoci=11;
        vociMenu=new String[numeroVoci];
        Menu menu;
        int voceScelta;
        Playlist p1=new Playlist(); //creo lo scaffale vuoto
        int esito;
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,autore;
        int durata;
        Canzone canz;
        int ripiano, posizione;
        String[] elencoTitoliAutore;
        Canzone[] canzoniiPresenti;
        String nomeFile="volumi.csv";
        String nomeFileBinario="scaffale.bin";
        
        vociMenu[0]="\t--> Esci";
        vociMenu[1]="\t--> Visualizza tutte le canzoni presenti";
        vociMenu[2]="\t--> Aggiungi canzone";
        vociMenu[3]="\t--> Visualizza canzone (posizione) ";
        vociMenu[4]="\t--> Elimina canzone (ripiano, posizione)";
        vociMenu[5]="\t--> Mostra canzoni di un artista";
        vociMenu[6]="\t--> Mostra le canzoni presenti in ordine alfabetico di titolo";
        //vociMenu[7]="\t--> Esporta i volumi su file CSV";
        //vociMenu[8]="\t--> Importa i volumi da file CSV";
        //vociMenu[9]="\t--> Salva dati scaffale";
        //vociMenu[10]="\t--> Carica dati scaffale";
        
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
                case 2://aggiungivolume
                    System.out.println("Premi invio per continuare...");
                    tastiera.readString();
                    System.out.println("Titolo --> ");
                    titolo=tastiera.readString();
                    System.out.println("Autore --> ");
                    autore=tastiera.readString();
                    System.out.println("Numero pagine --> ");
                    nCanzoniPresenti=tastiera.readInt();
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.readInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.readInt();  
                    esito=s1.setCanzone(new Libro(titolo,autore,nCanzoniPresenti), ripiano, posizione);
                    if(esito==-3)
                        System.out.println("Ripiano inesistente");
                    else if(esito==-1)
                        System.out.println("Posizione inesistente");
                    else if(esito==-2)
                        System.out.println("Posizione già occupata");
                    else
                        System.out.println("Volume aggiunto correttamente");
                    break;
                    
                    break;
                case 3:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.readInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.readInt();  
                    canz=p1.getCanzone(posizione);
                    if (canz==null)
                        System.out.println("Libro non trovato!");
                    else
                        System.out.println("Libro cercato: "+lib.toString());
                    break;
                case 4:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.readInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.readInt();
                    //esito=p1.rimuoviCanzone(posizione);
                    if(esito==-3)
                        System.out.println("Ripiano inesistente");
                    else if(esito==-1)
                        System.out.println("Posizione inesistente");
                    else if(esito==-2)
                        System.out.println("Posizione già vuota. Nessun libro è stato rimosso.");
                    else
                        System.out.println("Volume rimosso correttamente");
                    break;
                case 5:
                    //svuoto buffer input
                    System.out.println("Premi invio per continuare...");
                    tastiera.readString();
                    System.out.println("Autore --> ");
                    autore=tastiera.readString();
                    elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                    if(elencoTitoliAutore==null)
                        System.out.println("Nessun libro presente");
                    else
                    {
                        for(int i=0;i<elencoTitoliAutore.length;i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
            }  
        }while(voceScelta!=0);
       
    }
