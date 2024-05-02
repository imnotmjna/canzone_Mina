/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import com.mycompany.canzone_mina.Canzone;
import eccezioni.*;
import utilita.*;

/**
 *
 * @author Studente
 */
public class Playlist 
{
    private final static int N_MAX_CANZONE=50;
    private int nCanzoniPresenti;
    private Canzone[] canzoni;
    private Canzone[] posizioni;
   

    public Playlist() 
    {
        this.nCanzoniPresenti = 0;
        this.canzoni = new Canzone[N_MAX_CANZONE];
    }

     public Canzone getCanzone(int posizione)
    {
        if (posizione<0 || posizione>=N_MAX_CANZONE)
            return null;
        if (canzoni[posizione]==null)
            return null; //posizione vuota
        else
            return new Canzone(canzoni[posizione]);
    }
     
   public int setCanzone(Canzone canzone, int posizione)
    {
        if (posizione<0 || posizione>=getNumeroCanzoniPresenti())
        return -1; //Posizione non valida
        if (canzoni[posizione]!=null)
        return -2; //posizione già occupata
        else
        {
        canzoni[posizione]=new Canzone(canzone);
        return posizione;
        }
    }
    public void aggiungiCanzone(Canzone canzone) 
    {
        if (nCanzoniPresenti < N_MAX_CANZONE) 
        {
            canzoni[nCanzoniPresenti] = canzone;
            nCanzoniPresenti++;
        } else 
        {
            System.out.println("La playlist è piena, impossibile aggiungere altre canzoni.");
        }
    }

    public int rimuoviCanzone(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
    
        try
        {
            if (canzoni[posizione]==null)
               throw new EccezionePosizioneVuota();
            canzoni[posizione]=null;
            //return posizione; 
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        } 
        return posizione;
    }
    public int getNumeroCanzoniPresenti() 
    {
        return nCanzoniPresenti;
    }
    
    
    
     public String[] elencoTitoliCantante(String cantante)
   {
       Canzone canz;
       String[] elencoTitoliAutore;
       
       int contaCanzoniCantante=0;
       for (int i=0;i<N_MAX_CANZONE;i++)
       {
            canz=this.getCanzone(i);
            if (canz.getCantante().equalsIgnoreCase(cantante))
                {
                    contaCanzoniCantante++;  //sarà la dimensione dell'array
                } 
       }
       //Se non ci sono canzoni del cantante --> return null
       if (contaCanzoniCantante==0)
           return null;
           
       //Istanzio l'array DINAMICAMENTE (Run time, durante l'esecuzione)
       elencoTitoliAutore=new String[contaCanzoniCantante];
       
       //Copio i titoli del cantante nell'array di titoli
       contaCanzoniCantante=0;
       for (int i=0;i<N_MAX_CANZONE;i++)
       {
            canz=this.getCanzone(i);
            if (canz.getCantante().equalsIgnoreCase(cantante))
                   {
                    elencoTitoliAutore[contaCanzoniCantante]=canz.getTitolo();
                    contaCanzoniCantante++;  //sarà la dimensione dell'array
                   }
              
       }   
       return elencoTitoliAutore;
   }
}