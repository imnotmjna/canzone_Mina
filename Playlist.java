/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import com.mycompany.canzone_mina.Canzone;
import utility.Ordinatore;

/**
 *
 * @author Studente
 */
public class Playlist 
{
    private final int N_MAX_CANZONE=50;
    private int nCanzoniPresenti;
    private Canzone[] elencoCanzoni;
   

    public Playlist() 
    {
        this.nCanzoniPresenti = 0;
        this.elencoCanzoni = new Canzone[N_MAX_CANZONE];
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

    public void rimuoviCanzone(Canzone canzone) 
    {
        for (int i = 0; i < nCanzoniPresenti; i++) 
        {
            if (elencoCanzoni[i].equals(canzone)) 
            {
                for (int j = i; j < nCanzoniPresenti - 1; j++) 
                {
                    elencoCanzoni[j] = elencoCanzoni[j + 1];
                }
                elencoCanzoni[nCanzoniPresenti - 1] = null;
                nCanzoniPresenti--;
                break;
            }
        }
    }

    public int getNumeroCanzoniPresenti() 
    {
        return nCanzoniPresenti;
    }
}