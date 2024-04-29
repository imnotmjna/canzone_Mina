/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.util.Scanner;

/**
 * 
 * @author Studente
 */
public class Menu 
{
    private String [] elencoVoci;
    private int numeroVoci;
    
    public Menu(String[] elencoVoci)
    {
        //Copio le voci parametro nell'elenco voci attributo
        numeroVoci=elencoVoci.length;
        this.elencoVoci=new String[numeroVoci];
        for(int i=0;i<this.numeroVoci;i++)
            this.elencoVoci[i]=elencoVoci[i];
    }
    
    public void visualizzaMenu()
    {
        System.out.println("MENU:");
        for(int i=0;i<this.numeroVoci;i++)
        {
            System.out.println(i+")\t"+ elencoVoci[i]);
        }
    }
    
    public int sceltaMenu()
    {
        String sceltaStringa;
        boolean sceltaOk=true;
        int scelta=0;
        Scanner tastiera=new Scanner(System.in);
       
        do
        {
            System.out.println("Scegli --> ");
            sceltaOk=true;
            sceltaStringa=tastiera.nextLine();
                if (sceltaStringa.charAt(0)<'0' || sceltaStringa.charAt(0)>'9')
                {
                    System.out.println("Input non corretto. Inserire un numero!");
                    sceltaOk=false;
                }                    
                else  //scelta è un numero
                {  
                     scelta=Integer.parseInt(""+sceltaStringa.charAt(0));
                     if (scelta<0 || scelta>elencoVoci.length)
                     {
                         sceltaOk=false;
                         System.out.println("Scelta non valida.");
                     }        
                }
        }while(!sceltaOk);
        
        return scelta;     
    }
}
