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
    private final int N_MAX_CANZONE=50;
    private int nCanzoniPresenti;
    private Canzone[] elencoCanzoni;
    private Canzone[] posizioni;
   

    public Playlist() 
    {
        this.nCanzoniPresenti = 0;
        this.elencoCanzoni = new Canzone[N_MAX_CANZONE];
    }

    
     public Canzone getCanzone(int posizione)
    {
        if (posizione<0 || posizione>=N_MAX_CANZONE)
            return null;
        return(posizioni[posizione]);
 }
    public void aggiungiCanzone(Canzone canzone) 
    {
        if (nCanzoniPresenti < N_MAX_CANZONE) 
        {
            elencoCanzoni[nCanzoniPresenti] = canzone;
            nCanzoniPresenti++;
        } else 
        {
            System.out.println("La playlist è piena, impossibile aggiungere altre canzoni.");
        }
    }

    public void rimuoviCanzone(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
    
    /*    if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1; //posizione non valida 
    */
        try
        {
            if (elencoCanzoni[posizione]==null)
               throw new EccezionePosizioneVuota();
            elencoCanzoni[posizione]=null;
            //return posizione; 
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        } 
    }
    public int getNumeroCanzoniPresenti() 
    {
        return nCanzoniPresenti;
    }
}