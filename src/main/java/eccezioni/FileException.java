/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eccezioni;

/**
 *
 * @author Mina
 */
public class FileException extends Exception
{
    private String motivoEccezione;
    
    public FileException(String motivo)
    {
        motivoEccezione=motivo;
    }
    
    public String toString()
    {
        return motivoEccezione;
    }
    
    
}
