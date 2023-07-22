/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinealajuela;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Estudiante
 */
public class Cine {
    private static asiento[][][] asientos= new asiento[3][10][8];
    private static int sala;
    private final double ADULTO=2800, ADULTOMAYOR=2300, NINNO=2000;
    private static int adultoN, adultoMayorN, ninnoN;
    Pelicula miPelicula=new Pelicula();
    private static int pelicula;
    private static String espacio;
    private static String[] espacioSplit;
    private String fechaString, horaString;   
    public Cine() {
        
    }
    
    public int getPelicula(){
        return pelicula;
    }

    public void setPelicula(int pelicula) {
        this.pelicula = pelicula;
    }
    
    
    public void setAdultoN(int adultoN) {
        int adulto=0;
        switch(adultoN){
            case 1:
                adulto=0;
                break;
            case 2:
                adulto=1;
                break;
            case 3:
                adulto=2;
                break;
            case 4:
                adulto=3;
                break;    
            case 5:
                adulto=4;
                break;      
                
        }
        this.adultoN = adulto;
    }

    public void setAdultoMayorN(int adultoMayorN) {
        int adulto=0;
        switch(adultoMayorN){
            case 1:
                adulto=0;
                break;
            case 2:
                adulto=1;
                break;
            case 3:
                adulto=2;
                break;
            case 4:
                adulto=3;
                break;    
            case 5:
                adulto=4;
                break;   
                
        }
        this.adultoMayorN = adulto;
    }

    public static int getAdultoN() {
        return adultoN;
    }

    public static int getAdultoMayorN() {
        return adultoMayorN;
    }

    public static int getNinnoN() {
        return ninnoN;
    }
    
    public void setNinnoN(int ninnoN) {
        int adulto=0;
        switch(ninnoN){
            case 1:
                adulto=0;
                break;
            case 2:
                adulto=1;
                break;
            case 3:
                adulto=2;
                break;
            case 4:
                adulto=3;
                break;    
            case 5:
                adulto=4;
                break;   
                
        }
        this.ninnoN = adulto;
    }
    public int cantidadPersonas(){
        int cantidad=adultoN+adultoMayorN+ninnoN;
        return cantidad;
    }
    public double cobroxPersona(){
        double cobro=adultoN*ADULTO+adultoMayorN*ADULTOMAYOR+ninnoN*NINNO;
        return cobro;
    }
     public boolean verificarAdulto(){
        boolean verificar=false;
        if(adultoN>0||adultoMayorN>0){
            verificar=true;
        }
        return verificar;
    }
   
    public String tiquetes() {
        String tiquete=Integer.toString(this.adultoN)+" regular, "+Integer.toString(this.adultoMayorN)+" adulto mayor, "+Integer.toString(this.ninnoN)+" niños";
        return tiquete;
    }
    
    public void generarAsientos() {
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) { 
                    asientos[i][j][k] = new asiento(String.valueOf((char) (j + 65)), k + 1, i);//en i estaba sala
            }
        }
      }
    }
    public String imprimirAsientos() {
        String imprimir="";
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 8; k++) { 
                    imprimir+= (String.valueOf((char) (j + 65))+ (k + 1))+" ";
            }
            imprimir += "\n";
        }
        return imprimir;
    }
     

    public  String verAsientos(int escSala) {
      String hilera = "";
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) {
                if(escSala==i){
                    if (asientos[i][j][k].isEstado()) {
                        //asientos[i][j][k].setNombre("X");
                    } 
                    hilera+= asientos[i][j][k].getNombre() + " ";
                }
            
            }
            if(sala==i){
               hilera += "\n";
            }
        }
      }
        return hilera;
        
    }
    
    public  String leerAsientos(int escSala) {//agregue la int escSala
        String str = "";
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) {
                if(escSala==i){
                    str += Boolean.toString(asientos[i][j][k].isEstado()) + " ";
                }
            
            }str += "\n";
        }
      }
        return str;
    }
    public int comprados() {
      int cantidad=0;
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) {
                if (asientos[i][j][k].isEstado()==true) {
                    cantidad++;
                }
            
            }
        }
      }
        return cantidad;
    }
    
    public String compraxSala() {
      int total1=0, total2=0, total3=0;
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) {
                    switch(i){
                        case 0:
                            if (asientos[i][j][k].isEstado()==true) {
                                total1++;
                            }
                            break;
                        case 1:
                            if (asientos[i][j][k].isEstado()==true) {
                                total2++;
                            }
                            break;
                        case 2:
                            if (asientos[i][j][k].isEstado()==true) {
                                total3++;
                            }
                            break;
                     }
            }
        }
      }
        String hilera="\nAsientos comprados por sala:"+ "\n"+
                "\nSala 1: "+total1+
                "\nSala 2: "+total2+
                "\nSala 3: "+total3;
        return hilera;
    }
    public String reportexSala() {
      int total1=0, total2=0, total3=0;
      String estado1="",estado3="",estado2="";
      for (int i = 0; i < asientos.length; i++) {    
        for (int j = 0; j < asientos[i].length; j++) {
            for (int k = 0; k < asientos[i][j].length; k++) {
                    switch(i){
                        case 0:
                            if (asientos[i][j][k].isEstado()==true) {
                                total1++;
                            }
                            if(total1==80){
                                estado1="Sala llena";
                            }
                            else{
                                estado1="La sala no esta llena";
                            }
                            break;
                        case 1:
                            if (asientos[i][j][k].isEstado()==true) {
                                total2++;
                            }
                            if(total2==80){
                                estado2="Sala llena";
                            }
                            else{
                                estado2="La sala no esta llena";
                            }
                            break;
                        case 2:
                            if (asientos[i][j][k].isEstado()==true) {
                                total3++;
                            }
                            if(total3==80){
                                estado3="Sala llena";
                            }
                            else{
                                estado3="La sala no esta llena";
                            }
                            break;
                     }
            }
        }
      }
        String hilera="\nReporte por sala:"+ "\n"+
                "\nSala 1: "+estado1+
                "\nSala 2: "+estado2+
                "\nSala 3: "+estado3;
        return hilera;
    }
    
    public  boolean venderAsiento(String asiento, int escSala) {//agregue la int escSala
      for (int i = 0; i < asientos.length; i++) {    
        for (int f = 0; f < asientos[i].length; f++) {
            for (int c = 0; c < asientos[i][f].length; c++) {
                if(escSala==i){
                    if (asiento.equalsIgnoreCase(asientos[i][f][c].getNombre())) {
                        if (asientos[i][f][c].isEstado()==false) {
                            asientos[i][f][c].setNombre("X");
                            asientos[i][f][c].setEstado(true);
                            return true;
                        } else {
                            
                            return false;
                        }
                    }
                }
            }
        }
      }
        return false;
    }
    public boolean noVendido(int pelicula) {
      String remover=getEspacio();
      String ocupado="X", asiento="";
      String[] eliminarSplit=remover.split("/");
      for (int i = 0; i <eliminarSplit.length; i++) {    
          eliminarSplit[i]=eliminarSplit[i].toUpperCase();
      }
      for (int i = 0; i < asientos.length; i++) {    
        for (int f = 0; f < asientos[i].length; f++) {
            for (int c = 0; c < asientos[i][f].length; c++) {
                    if(pelicula==i){
                        if (ocupado.equalsIgnoreCase(asientos[i][f][c].getNombre())) {
                                asiento=asientos[i][f][c].getLetra()+asientos[i][f][c].getNumero();
                                if(asiento.equalsIgnoreCase(eliminarSplit[c])){
                                    asientos[i][f][c].setNombre(eliminarSplit[c]);
                                    asientos[i][f][c].setEstado(false);
                                    return true;
                                }
                        }
                    }
                }
            
        }
      }
        return false;
    }

    public String getFechaString() {
        return fechaString;
    }

    public String getHoraString() {
        return horaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public void setHoraString(String horaString) {
        this.horaString = horaString;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
    
    public void espacio(String espacio){
        this.espacio=espacio;
    }
    public String getEspacio(){
        return espacio;
    }
    public void setEspacioSplit(String[] espacio){
        this.espacioSplit=espacio;
    }
    public String[] espacioSplit(){
        return espacioSplit;
    }
   
    
    public String toString(){
        StringBuilder h = new StringBuilder("");
         Pelicula miPelicula=new Pelicula();
        h.append("\nSala No.");
        h.append(getSala()+1);
        h.append("\nPelicula: ");
        h.append(miPelicula.pelicula());
        h.append("\nTiquetes comprados: ");
        h.append(tiquetes());
        h.append("\nAsientos seleccionados: ");
        h.append(getEspacio());
        h.append("\nTotal pagado:                          ₡");
        h.append(cobroxPersona());
        return h.toString();
    }
    
    public String toString2(){
        StringBuilder h = new StringBuilder("");
         Pelicula miPelicula=new Pelicula();
        h.append("\n Cine Daniela Méndez");
        h.append("\n");
        h.append("\n");
        h.append("\n Sala No.");
        h.append(getSala()+1);
        h.append("\n Pelicula: ");
        h.append(miPelicula.pelicula());
        h.append("\n Tiquetes comprados: ");
        h.append(tiquetes());
        h.append("\n Asientos seleccionados: ");
        h.append(this.getEspacio());
        h.append("\n Cobro total: ₡");
        h.append(cobroxPersona());
        return h.toString();
    }
}



