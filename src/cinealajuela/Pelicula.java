/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinealajuela;

import java.util.Calendar;

/**
 *
 * @author Estudiante
 */
public class Pelicula {
    private static int nombrePelicula;
    private static int hora, fecha, mes;
    private static double precio;
    private static int peliculaNum;
    Calendar calendario = Calendar.getInstance();
    private static String pelicula="Italia 90", pelicula1="Rio 2", pelicula2="X-Men";
    
    public Pelicula(int nombrePelicula, int hora, int fecha, double precio) {
        this.nombrePelicula = nombrePelicula;
        this.hora = hora;
        this.fecha = fecha;
        this.precio = precio;
        
    }
    public Pelicula() {
    }
    public static int getNombrePelicula() {
        return nombrePelicula;
    }

    public static void setNombrePelicula(int nombrePelicula) {
        Pelicula.nombrePelicula = nombrePelicula;
    }

    public static void setHora(int hora) {
        Pelicula.hora = hora;
    }

    public static void setFecha(int fecha) {
        Pelicula.fecha = fecha;
    }

    public static void setPrecio(double precio) {
        Pelicula.precio = precio;
    }

    public int getHora() {
        return hora;
    }

    public int getFecha() {
        return fecha;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPeliculaCambio(String pelicula){
        this.pelicula=pelicula;
    }
    public void setPeliculaCambio1(String pelicula1){
        this.pelicula1=pelicula1;
    }
    public void setPeliculaCambio2(String pelicula2){
        this.pelicula2=pelicula2;
    }

    public static String getPelicula() {
        return pelicula;
    }

    public static String getPelicula1() {
        return pelicula1;
    }

    public static String getPelicula2() {
        return pelicula2;
    }
    

    public void dia(int fecha){
        switch(fecha){
            case 0:
                this.fecha=0;
                break;
            case 1:
                this.fecha=25;
                this.mes=11;
                break;
            case 2:
                this.mes=12;
                this.fecha=9;
                break;
            case 3:
                this.mes=12;
                this.fecha=10;
                break;
        }
    }
     
     public int horaNum(int horaS){
        switch(horaS){
            case 0:
                this.hora =0;
                break;
            case 1:            
                this.hora =10;
                break;
            case 2:
                this.hora =18;
                break;
            case 3:
                this.hora =21;
                break;
                
        }
        return this.hora;
    }
    
     public boolean tiempo(){
         
         int horaActual=calendario.get(Calendar.HOUR_OF_DAY);
         if(horaActual>=this.hora){
             return true;
         }
         return false;
     }
      public boolean fecha(){
         boolean validez=false;
         int diaMes= calendario.get(Calendar.DAY_OF_MONTH);
         int mesA = calendario.get(Calendar.MONTH) +1;
         if(mesA==mes){
            if(diaMes>=fecha){
                validez=true;
            }
            
         }
         return validez;
     }
     public String pelicula(){
        int peliculaNum=4;
        String peliculaString="";
        switch(this.nombrePelicula){
            case 0:
                peliculaString="";
                peliculaNum=4;
                break;
            case 1:            
                peliculaString=getPelicula();//
                peliculaNum=0;
                break;
            case 2:
                peliculaString=getPelicula1();//
                peliculaNum=1;
                break;
            case 3:
                peliculaString=getPelicula2();//
                peliculaNum=2;
                break;
                
        }
        return peliculaString;
    }
     public int nombrePelicula(){
        return this.peliculaNum;
    }
    
    public String toString(){
        StringBuilder h = new StringBuilder("");
        h.append("\n Horario: ");
        h.append(this.hora+":00");
         h.append("\n Fecha: ");
        h.append(this.fecha+"/"+this.mes+"/"+"2022");
        h.append("\n");
        h.append("\n ¡Que disfruten su película!");
        return h.toString();
    }
    
}
