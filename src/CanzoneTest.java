/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.canzone_mina;

import java.time.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mina
 */
public class CanzoneTest {
    
    public CanzoneTest() {
    }
    
    
    @Test
    public void costruttoreCanzoneTest() 
    {
        Canzone c1=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        Canzone attuale=c1;
        assertEquals(c1, attuale);
    }

    /**
     * Test of getTitolo method, of class Canzone.
     */
    @Test
    public void testGetTitolo() 
    {
        Canzone c2=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        String attuale=c2.getTitolo();
        assertEquals("Laoo", attuale);
    }

    /**
     * Test of setTitolo method, of class Canzone.
     */
    @Test
    public void testSetTitolo() 
    {
        Canzone c3=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        c3.setTitolo("Ooal");
        String attuale;
        attuale=c3.getTitolo();
        assertEquals("Ooal", attuale);
    }

    /**
     * Test of getDurata method, of class Canzone.
     */
    @Test
    public void testGetDurata() 
    {
        Canzone c4=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        int attuale=c4.getDurata();
        assertEquals(3, attuale);
        
    }

    /**
     * Test of setDurata method, of class Canzone.
     */
    @Test
    public void testSetDurata() 
    {
        Canzone c5=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        c5.setDurata(5);
        int attuale;
        attuale=c5.getDurata();
        assertEquals(5, attuale);
    }

    /**
     * Test of getIdCanzone method, of class Canzone.
     */
    @Test
    public void testGetIdCanzone() 
    {
        Canzone c6=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        long attuale=c6.getIdCanzone();
        assertEquals(0, attuale);
    }

    /**
     * Test of setIdCanzone method, of class Canzone.
     */
    @Test
    public void testSetIdCanzone() 
    {
        Canzone c7=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        c7.setIdCanzone(0);
        long attuale;
        attuale=c7.getIdCanzone();
        assertEquals(0, attuale);
    }

    /**
     * Test of getCantante method, of class Canzone.
     */
    @Test
    public void testGetCantante() 
    {
        Canzone c8=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        String attuale=c8.getCantante();
        assertEquals("Ooal", attuale);
    }

    /**
     * Test of setCantante method, of class Canzone.
     */
    @Test
    public void testSetCantante() 
    {
        Canzone c9=new Canzone("Laoo", "Ooal", 3, 0, LocalDate.of(2023, Month.MARCH, 12));
        int posizione=0;
        c9.setCantante("Pierone");
        String attuale=c9.getCantante();
        assertEquals("Pierone",attuale);
    }

    /**
     * Test of toString method, of class Canzone.
     */
    @Test
    public void testToString() 
    {
        Canzone c10=new Canzone("Sny", "JK", 4, 0, LocalDate.of(20, Month.APRIL, 26));
        int posizione=0;
        String attuale=c10.toString();
        
        assertEquals(c10.toString(),attuale);
    }
    
}
