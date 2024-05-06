/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import java.time.*;

/**
 *
 * @author Mina
 */
public class Canzone 
{
    private String titolo;
    private String cantante;
    private int durata;
    private long idCanzone;
    private LocalDate dataUscita;
    
    public Canzone(String titolo, int durata, long idCanzone, LocalDate dataUscita) 
    {
        this.titolo = titolo;
        this.durata = durata;
        this.idCanzone = idCanzone;
        this.dataUscita = dataUscita;
    }
    
    public Canzone (Canzone canzone)
    {
        this.titolo=canzone.getTitolo();
        this.durata=canzone.getDurata();
        this.idCanzone=canzone.getIdCanzone();
        this.dataUscita=canzone.getDataUscita();
    }
    

    public String getTitolo() 

    {
        return titolo;
    }

    public void setTitolo(String titolo) 
    {
        this.titolo = titolo;
    }

    public int getDurata() 
    {
        return durata;
    }

    public void setDurata(int durata) 
    {
        this.durata = durata;
    }

    public long getIdCanzone() 
    {
        return idCanzone;
    }

    public void setIdCanzone(long idCanzone) 
    {
        this.idCanzone = idCanzone;
    }

    public LocalDate getDataUscita() 
    {
        return dataUscita;
    }

    public void setDataUscita(LocalDate dataUscita) 
    {
        this.dataUscita = dataUscita;
    }
    
    public String getCantante() 
    {
        return cantante;
    }

    public void setCantante(String cantante) 
    {
        this.cantante = cantante;
    }
    
    @Override
    public String toString() 
    {
        return "Canzone{" + "titolo=" + titolo + ", cantante=" + cantante + ", durata=" + durata + ", idCanzone=" + idCanzone + ", dataUscita=" + dataUscita + '}';
    }

}