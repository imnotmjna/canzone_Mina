/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.canzone_mina;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mina
 */
public class PlaylistTest {
    
    /*@Test
    public void costruttorePlaylistTest() throws EccezionePosizioneOccupata, EccezionePosizioneNonValida, EccezionePosizioneVuota 
    {
        Playlist playlist=new Playlist();
        Canzone c1=new Canzone("snty", "jk", 5, 0, LocalDate.of(2024, Month.APRIL, 07));
        playlist.setCanzone(c1, 0);
        assertEquals(c1,playlist.getCanzone(0));
          
    }
    */
    
    /*
    @Test
    public void costruttoreCopiaPlaylistTest() 
    {
        Canzone c2=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        Canzone c3=new Canzone(c2);
        int posizione=0;
        Canzone attuale=c2;
        assertEquals(c3, attuale);
    }
    */
    
    /**
     * Test of cercaCanzone method, of class Playlist.
     */
    @Test
    public void testCercaCanzone() 
    {
        
    }

    /**
     * Test of getNumeroCanzoniPresenti method, of class Playlist.
     */
    @Test
    public void testGetNumeroCanzoniPresenti() 
    {
        
    }

    /**
     * Test of getCanzone method, of class Playlist.
     */
    @Test
    public void testGetCanzone() {
    }

    /**
     * Test of setCanzone method, of class Playlist.
     */
    @Test
    public void testSetCanzone() {
    }

    /**
     * Test of aggiungiCanzone method, of class Playlist.
     */
    @Test
    public void testAggiungiCanzone() {
    }

    /**
     * Test of rimuoviCanzone method, of class Playlist.
     */
    @Test
    public void testRimuoviCanzone() throws Exception {
    }

    /**
     * Test of elencoTitoliCantante method, of class Playlist.
     */
    @Test
    public void testElencoTitoliCantante() {
    }

    /**
     * Test of elencoCanzoniPresenti method, of class Playlist.
     */
    @Test
    public void testElencoCanzoniPresenti() {
    }

    /**
     * Test of esportaCSV method, of class Playlist.
     */
    @Test
    public void testEsportaCSV() throws Exception {
    }

    /**
     * Test of importaCSV method, of class Playlist.
     */
    @Test
    public void testImportaCSV() throws Exception {
    }

    /**
     * Test of salvaPlaylist method, of class Playlist.
     */
    @Test
    public void testSalvaPlaylist() throws Exception {
    }

    /**
     * Test of caricaPlaylist method, of class Playlist.
     */
    @Test
    public void testCaricaPlaylist() throws Exception {
    }
        /**
     * Test of toString method, of class Playlist.
     */
    @Test
    public void testToString() throws EccezionePosizioneNonValida, EccezionePosizioneOccupata 
    {
        Playlist playlist=new Playlist();
        Canzone c1=new Canzone("snty", "jk", 5, 0, LocalDate.of(2024, Month.APRIL, 07));
        playlist.setCanzone(c1, 4);
        Canzone c2=new Canzone("snty", "jk", 4, 0, LocalDate.of(2023, Month.APRIL, 07));
        playlist.setCanzone(c2, 3);
        String s=playlist.toString();
        assertEquals(s, playlist.toString());
    }
}
