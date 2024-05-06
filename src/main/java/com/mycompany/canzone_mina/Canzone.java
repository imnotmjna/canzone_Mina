/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import java.io.*;
import java.time.*;

/**
 *
 * @author Mina
 */
public class Canzone implements Serializable
{
    private String titolo;
    private String cantante;
    private int durata;
    private long idCanzone;
    private LocalDate dataUscita;
    
    /**
     * Costruttore per creare una nuova canzone.
     * 
     * @param titolo Il titolo della canzone
     * @param durata La durata della canzone in secondi
     * @param idCanzone L'identificatore univoco della canzone
     * @param dataUscita La data di uscita della canzone
     */
    public Canzone(String titolo, int durata, long idCanzone, LocalDate dataUscita) 
    {
        this.titolo = titolo;
        this.durata = durata;
        this.idCanzone = idCanzone;
        this.dataUscita = dataUscita;
    }
    
    /**
     * Costruttore di copia per creare una copia di una canzone esistente.
     * 
     * @param canzone La canzone da copiare
     */
    public Canzone (Canzone canzone)
    {
        this.titolo=canzone.getTitolo();
        this.durata=canzone.getDurata();
        this.idCanzone=canzone.getIdCanzone();
        this.dataUscita=canzone.getDataUscita();
    }
    
     /**
     * Restituisce il titolo della canzone.
     * 
     * @return Il titolo della canzone
     */
    public String getTitolo() 

    {
        return titolo;
    }
    
    /**
     * Imposta il titolo della canzone.
     * 
     * @param titolo Il titolo della canzone da impostare
     */
    public void setTitolo(String titolo) 
    {
        this.titolo = titolo;
    }
    
    /**
    * Restituisce la durata della canzone in secondi.
    * 
    * @return La durata della canzone in secondi
    */
    public int getDurata() 
    {
        return durata;
    }
    
    /**
     * Imposta la durata della canzone in secondi.
     * 
     * @param durata La durata della canzone in secondi da impostare
     */
    public void setDurata(int durata) 
    {
        this.durata = durata;
    }
    
    /**
     * Restituisce l'identificatore univoco della canzone.
     * 
     * @return L'identificatore univoco della canzone
     */
    public long getIdCanzone() 
    {
        return idCanzone;
    }

    /**
     * Imposta l'identificatore univoco della canzone.
     * 
     * @param idCanzone L'identificatore univoco della canzone da impostare
     */
    public void setIdCanzone(long idCanzone) 
    {
        this.idCanzone = idCanzone;
    }
    
    /**
     * Restituisce la data di uscita della canzone.
     * 
     * @return La data di uscita della canzone
     */
    public LocalDate getDataUscita() 
    {
        return dataUscita;
    }

    /**
     * Imposta la data di uscita della canzone.
     * 
     * @param dataUscita La data di uscita della canzone da impostare
     */
    public void setDataUscita(LocalDate dataUscita) 
    {
        this.dataUscita = dataUscita;
    }
    
    /**
     * Restituisce il cantante della canzone.
     * 
     * @return Il cantante della canzone
     */
    public String getCantante() 
    {
        return cantante;
    }
    /**
     * Imposta il cantante della canzone.
     * 
     * @param cantante Il cantante della canzone da impostare
     */
    public void setCantante(String cantante) 
    {
        this.cantante = cantante;
    }
    /**
     * Restituisce una stringa che rappresenta la canzone.
     * 
     * @return Una stringa che rappresenta la canzone
     */
    
    public String toString() 
    {
        String s;
        s="Canzone{" + "titolo=" + titolo + ", cantante=" + cantante + ", durata=" + durata + ", idCanzone=" + idCanzone + ", dataUscita=" + dataUscita + '}';
        return s;
    }

}