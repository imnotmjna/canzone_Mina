/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.canzone_mina;

import com.mycompany.canzone_mina.Canzone;
import eccezioni.*;
import java.io.*;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.*;

/**
 * La classe Playlist rappresenta una collezione di canzoni.
 * Ogni playlist ha una capacità massima predefinita di 50 canzoni.
 * Le canzoni possono essere aggiunte, rimosse e gestite all'interno della playlist.
 *
 * @author Mina
 */
public class Playlist implements Serializable
{
    private final int N_MAX_CANZONE=50;
    private int nCanzoniPresenti;
    private Canzone[] canzoni;
   
    /**
     * Costruttore
     * Inizializza una playlist vuota con capacità massima di 50 canzoni.
     */
    public Playlist() 
    {
        nCanzoniPresenti = 0;
        canzoni = new Canzone[N_MAX_CANZONE];
    }
    
    /**
     * Costruttore di copia
     * Crea una nuova playlist copiando le canzoni.
     * 
     * @param playlist L'istanza di Playlist da cui copiare le canzoni.
     */
     public Playlist(Playlist playlist)
    {
        canzoni = new Canzone[N_MAX_CANZONE];
        Canzone c;
        for(int i=0;i<playlist.getN_MAX_CANZONI();i++)
        {
            c=playlist.cercaCanzone(i);
            if(c!=null)
                canzoni[i]=new Canzone(c);
        }
    }
     
     /**
     * Restituisce il numero massimo di canzoni che la playlist può contenere.
     * 
     * @return Il numero massimo di canzoni consentite nella playlist.
     */
    public int getN_MAX_CANZONI()
    {
        return N_MAX_CANZONE;
    }
    
    /**
     * Cerca una canzone nella playlist in base al suo ID.
     * 
     * @param codiceDaCercare L'ID della canzone da cercare.
     * @return La canzone corrispondente all'ID specificato se presente; 
     *         altrimenti, null.
     */
     public Canzone cercaCanzone(int codiceDaCercare)
    {
        for(int i=0;i<N_MAX_CANZONE;i++)
        {
            if(canzoni[i].getIdCanzone()==codiceDaCercare)
                return new Canzone(canzoni[i]);
        }
        return null;
    }
     
    /**
     * Restituisce la canzone in una determinata posizione della playlist.
     * 
     * @param posizione La posizione della canzone nella playlist.
     * @return La canzone nella posizione specificata se presente; 
     *         altrimenti, null.
     */
     public Canzone getCanzone(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        try
        {
            return new Canzone(canzoni[posizione]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        }
        catch(NullPointerException e)
        {
            throw new EccezionePosizioneVuota();         
        }
    }
     
    /**
     * Imposta una canzone in una determinata posizione della playlist.
     * 
     * @param canzone La canzone da impostare.
     * @param posizione La posizione in cui impostare la canzone.
     * @return 0 se la canzone viene impostata correttamente; 
     *         -1 se la posizione non è valida; 
     *          -2 se la posizione è già occupata.
     */
   public void setCanzone(Canzone canzone, int posizione) throws EccezionePosizioneOccupata, EccezionePosizioneNonValida
    {
        try
        {
            if (canzoni[posizione]!=null)
                throw new EccezionePosizioneOccupata();
            canzoni[posizione]=new Canzone(canzone);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new eccezioni.EccezionePosizioneNonValida();
        }
        
    }
 
    /**
     * Rimuove una canzone dalla playlist in una determinata posizione.
     * 
     * @param posizione La posizione della canzone da rimuovere.
     * @return La posizione della canzone rimossa se riuscita; 
        *       -1 se la posizione non è valida 
        *          -2 se la posizione è vuota.
     * @throws EccezionePosizioneNonValida Se la posizione specificata non è valida.
     * @throws EccezionePosizioneVuota Se la posizione specificata è vuota.
     */ 
    public void rimuoviCanzone(int posizione) throws EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        try
        {
            if (canzoni[posizione] == null)
                throw new EccezionePosizioneVuota();
            canzoni[posizione]=null;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            throw new EccezionePosizioneNonValida();
        }
       
    }
    
   
    
    /**
     * Metodo che crea un elenco con all'interno le canzoni di un determinato cantante
     * @param detCantante
     * @return l'elenco delle canzoni di cantante 
     */
    public String[] elencoDetCantante(String detCantante)
    {
        int numeroDetCanzoni=0;
        Canzone canz;

        for (int i=0;i<N_MAX_CANZONE;i++)
        {
            
            if (canzoni[i]!=null)
            {
                canz=canzoni[i];
                if (canz.getCantante().equalsIgnoreCase(detCantante))
                    numeroDetCanzoni++;
            }
            
        }
        if (numeroDetCanzoni==0)
            return null;
        String[] elencoDetCantante=new String[numeroDetCanzoni];

        int posizioneCantante=0;

        for (int i=0;i<N_MAX_CANZONE;i++)
        {
            if (canzoni[i]!=null)
            {
                canz=canzoni[i];
                if (canz.getCantante().equalsIgnoreCase(detCantante))
                {
                    elencoDetCantante[posizioneCantante]=canz.getCantante();
                    posizioneCantante++;
                }
            }
        }

        return elencoDetCantante;
    }
    
    /**
     * Restituisce un array di stringhe contenente i titoli delle canzoni di un determinato cantante presenti nella playlist.
     * 
     * @param cantante Il nome del cantante di cui cercare le canzoni.
     * @return Un array di stringhe contenente i titoli delle canzoni del cantantese presenti; 
     *         altrimenti, null.
     */
     public String[] elencoTitoliCantante(String cantante)
        {
         Canzone canz;
         String[] elencoTitoliCantante;


         int contaCanzoniCantante = 0;
         for (int i = 0; i < N_MAX_CANZONE; i++) {
             try {
                 canz = this.getCanzone(i);
                 if (canz.getCantante().equalsIgnoreCase(cantante)) {
                     contaCanzoniCantante++;  // Incrementa il conteggio delle canzoni dello stesso cantante
                 }
             } catch (EccezionePosizioneNonValida ex) {
                 // Non fare nulla, continua con la prossima iterazione del ciclo
             } catch (EccezionePosizioneVuota ex) {
                 // Non fare nulla, continua con la prossima iterazione del ciclo
             }
         }

         // Se non ci sono canzoni dell'artista, restituisce un array vuoto
         if (contaCanzoniCantante == 0) {
             return new String[0];
         }

         // Istanzia l'array DINAMICAMENTE (Run time, durante l'esecuzione)
         elencoTitoliCantante = new String[contaCanzoniCantante];

         // Copia i titoli del cantante nell'array di titoli
         int a = 0; // Indice per inserire i titoli nell'array
         for (int i = 0; i < N_MAX_CANZONE; i++) {
             try 
             {
                 canz = this.getCanzone(i);
                 if (canz.getCantante().equalsIgnoreCase(cantante)) 
                 {
                     elencoTitoliCantante[a] = canz.getTitolo();
                     a++; 
                 }
             } 
             catch (EccezionePosizioneNonValida ex) 
             {
                 // Non fare nulla
             } 
             catch (EccezionePosizioneVuota ex) 
             {
                 // Non fare nulla
             }
         }

         return elencoTitoliCantante;
     }
     /**
     * 
     * @return il numero di canzoni presenti nella playlist
     */
    public int nCanzoniPresenti()
    {
        int contatore=0;
        for(int i=0;i<N_MAX_CANZONE;i++)
        {
            if(canzoni[i]!=null)
                contatore++;
        }
        return contatore;
    }
    /**
     * Restituisce un array di stringhe contenente i titoli delle canzoni presenti nella playlist.
     * 
     * @return Un array di stringhe contenente i titoli delle canzoni presenti nella playlist.
     */
    public Canzone[] elencoCanzoniPresenti() 
    {
       Canzone[] elencoCanzoniPresenti=new Canzone[nCanzoniPresenti()];
       Canzone canz;
       int c = 0; //contatore
       for (int i=0;i<N_MAX_CANZONE;i++)
       {
           try 
           {
               canz=getCanzone(i);
               elencoCanzoniPresenti[c]=canz;
               c++;  
           } 
           catch (EccezionePosizioneNonValida ex) 
           {
               //mai
           } 
           catch (EccezionePosizioneVuota ex) 
           {
               //mai
           }
                   
       }
       
       return elencoCanzoniPresenti;
    }
    
    public void esportaCSV(String fileName) throws IOException, FileException, EccezionePosizioneVuota, EccezionePosizioneNonValida
    {
        TextFile f1 = new TextFile(fileName, 'W');
        Canzone canzone;

        for (int i = 0; i < nCanzoniPresenti; i++)
        {
            canzone = getCanzone(i);
            String datiCanzone = canzone.getIdCanzone() + ";" + canzone.getTitolo() + ";" + canzone.getCantante() + ";" + canzone.getDurata() + ";" + canzone.getDataUscita();
            f1.toFile(datiCanzone);
        }

        f1.close();
    }
   
    public void importaCSV(String fileName) throws IOException
    {
        TextFile f1 = new TextFile(fileName, 'R');
        String rigaLetta;
        Canzone canz;
        int posizione = 0;
        try 
        {
            while (true)
            {
                rigaLetta = f1.fromFile();
                String[] datiCanzone = rigaLetta.split(";");
                
                long idCanzone = Long.parseLong(datiCanzone[0]);
                String titolo = datiCanzone[1];
                String cantante = datiCanzone[2];
                int durata = Integer.parseInt(datiCanzone[3]);
                LocalDate dataUscita = LocalDate.parse(datiCanzone[4]);
                
                
                Canzone canzone = new Canzone(titolo, cantante, durata, idCanzone, dataUscita);
                canzone.setCantante(cantante);
                
                
                try 
                {
                    setCanzone(canzone, posizione);
                } 
                catch (EccezionePosizioneOccupata ex) 
                {
                    //non fa nulla
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non fa nulla
                }
            } 
        } 
        catch (FileException ex) 
        {
            // Fine del file di testo
            f1.close();
        }
    }
  
   /**
     * Serializza la playlist in un file specificato.
     * 
     * @param nomeFile Il percorso del file in cui serializzare la playlist.
     * @throws FileNotFoundException Se il file specificato non può essere trovato.
     * @throws IOException Se si verifica un errore di input/output durante la serializzazione.
     */
    public void salvaPlaylist(String fileName) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName)); 
        
            writer.writeObject(this.canzoni);
            writer.flush();
            writer.close();
        
    }
    /**
     * Deserializza una playlist da un file specificato.
     * 
     * @param nomeFile Il percorso del file da cui deserializzare la playlist.
     * @return L'istanza di Playlist deserializzata.
     * @throws FileNotFoundException Se il file specificato non può essere trovato.
     * @throws IOException Se si verifica un errore di input/output durante la deserializzazione.
     * @throws ClassNotFoundException Se la classe deserializzata non può essere trovata.
     */
    public Playlist caricaPlaylist(String fileName) throws IOException, ClassNotFoundException 
    {
        Playlist p=new Playlist();
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
        p.canzoni = (Canzone[])reader.readObject(); // Carica l'array di Canzone
        reader.close();
        return p;

    }
    
    
    
    public  String toString()
    {
        String s="";
        for(int i=0;i<N_MAX_CANZONE;i++)
        {
            s=s+i+"\t--> ";
            if (canzoni[i]!=null)
                s=s+canzoni[i].toString()+"\n";
            else
                s=s+"\n";
        }
        return s;
    }
}