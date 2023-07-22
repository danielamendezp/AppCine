/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinealajuela;
import java.util.Calendar;

public class Cliente {
    private static String nombreCliente;
    private static String numTarjeta, codigoSeg;
    private int annoVencimiento, tipoTarjeta;
    private int mesVencimiento;
    private static int contadorReserva=1000, cantidadPersonas;//para llevar la cuenta, hacer un metodo constructor sobrecargado unicamente con la variable de contador. y en el main o donde se llame, lo llamo siempre que se ingrese u nuevo cliente
    Calendar calendario= Calendar.getInstance();
    Pelicula miPeli= new Pelicula();
    public Cliente(){
        
    }
    public Cliente(String nombreCliente, int tipoTarjeta, String numTarjeta, String codigoSeg, int annoVencimiento, int mesVencimiento) {
        this.nombreCliente = nombreCliente;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.codigoSeg = codigoSeg;
        this.annoVencimiento = annoVencimiento;
        this.mesVencimiento = mesVencimiento-1;
        contadorReserva++;
    }
    

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }                 //de aumentar el contador para llevar registro en numero de reserva
    
    public void setTipoTarjeta( int tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setAnnoVencimiento(int annoVencimiento) {
        this.annoVencimiento = annoVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public void setCodigoSeg(String codigoSeg) {
        this.codigoSeg = codigoSeg;
    }

    public boolean fechaVencimiento(){//VERIFICACION DE MES
        boolean validez=false;
        int mesActual=calendario.get(Calendar.MONTH)+1;
        int annoActual=calendario.get(Calendar.YEAR);
        int annoV=0;
        switch(this.annoVencimiento){
            case 0 -> annoV=0;
            case 1 -> annoV=2022;
            case 2 -> annoV=2023;
            case 3 -> annoV=2024;
            case 4 -> annoV=2025;
            case 5 -> annoV=2026;
            case 6 -> annoV=2027;
            case 7 -> annoV=2028;
        }
        if(annoActual==annoV){
            validez=mesVencimiento+1>mesActual;
        }
        else{
            validez=annoActual<annoV;
        }
        
        return validez;
    } 
    
    public boolean cantPersonas(){
        boolean validarPersonas=true;//REVISAR***
      //  cantidadPersonas=miCine.cantidadPersonas();
         validarPersonas = cantidadPersonas<=4;
        return validarPersonas;
    }
    public boolean tarjeta(){
        boolean vTarjeta=false;
        switch(tipoTarjeta){
            case 0 -> vTarjeta=false;//No valido
            case 1 -> {
                //Visa
                if(numTarjeta.length()==16){
                    if(Integer.parseInt(Character.toString(numTarjeta.charAt(0)))==4){
                        vTarjeta=true;
                    }
                    else{
                        vTarjeta=false;
                    }
                }
                else{
                    vTarjeta=false;
                }
             }
            case 2 -> {
                //Master Card
                if(numTarjeta.length()==16){
                    if(Integer.parseInt(Character.toString(numTarjeta.charAt(0)))==5&&(Integer.parseInt(Character.toString(numTarjeta.charAt(1)))>=1&&Integer.parseInt(Character.toString(numTarjeta.charAt(1)))<=5)){
                        vTarjeta=true;
                    }
                    else{
                        vTarjeta=false;
                    }
                }
                else{
                        vTarjeta=false;
                    }
             }
        }
        return vTarjeta;
    }
    public boolean vNumTarjeta(){
        int n1=0, n2=0;
        String atras=new StringBuffer(numTarjeta).reverse().toString();
        for(int i=0;i<atras.length();i++){
            int numero=Character.digit(atras.charAt(i), 10);
            if(i%2==0){
                n1+=numero;
            }else{
                n2+=2*numero;
                if(numero>= 5){
                    n2=n2-9;
                }
            }
        }
        return (n1+n2)%10==0;
    }
     public String tarjetaString(){
        String tipoTarjetaS="";
        switch(tipoTarjeta){
            case 1 -> tipoTarjetaS="No valido";
            case 2 -> tipoTarjetaS="Visa";
            case 3 -> tipoTarjetaS="Master Card";
        }
        return tipoTarjetaS;
    }
     
    public boolean validacion(){
        boolean validacion;
        validacion = fechaVencimiento()==true&&tarjeta()==true&&validarCodigoSeg()==true&&vNumTarjeta()==true;
        return validacion;
    }
    public boolean validarCodigoSeg(){
        boolean validar = codigoSeg.length()==3;
        return validar;
    }
    public String numeroTarjeta(){
        numTarjeta.replaceAll("-", "");
        String numero=this.numTarjeta, numeroTarjeta="xxxx-xxxx-xxxx-", sConcatenar="";
        char concatenar=' ';
        for(int i=12; i<this.numTarjeta.length();i++){
            concatenar=numero.charAt(i);
            sConcatenar+=Character.toString(concatenar);
        }
        numeroTarjeta+=sConcatenar;
        return numeroTarjeta;
    }
    
    public String fecha(){
        String fecha="";
        int diaMes= calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) +1;
        int anno= calendario.get(Calendar.YEAR);
        fecha=Integer.toString(diaMes)+"/"+Integer.toString(mes)+"/"+Integer.toString(anno);
        return fecha;
    }
    public String toString(){
        StringBuilder h = new StringBuilder("");
        h.append("\nCine Daniela Méndez");
        h.append("\n");
        h.append("\n");
        h.append("\nNumero de reservacion: ");
        h.append(this.contadorReserva);
        h.append("\nFecha de reservación: ");
        h.append(fecha());
        h.append("\nNombre del cliente: ");
        h.append(this.nombreCliente);
        h.append("\nTarjeta ");
        h.append(tarjetaString());
         h.append(" No.");
        h.append(numeroTarjeta());
        h.append("\n");
        return h.toString();
    }
}