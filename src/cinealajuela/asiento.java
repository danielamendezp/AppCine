/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinealajuela;

/**
 *
 * @author danii
 */
public class asiento {
   private String letra;
    private int numero;
    private boolean estado;
    private int sala;
    private String nombre;
    
    public asiento() {
        
    }

    public asiento(String letra, int numero, int sala) {
        this.letra = letra;
        this.numero = numero;
        this.sala=sala;
        setAsiento();
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setAsiento(){
        nombre=letra + numero;
    }
    public void setNombre(String nombre) {
        this.nombre=nombre;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
        
    }
}