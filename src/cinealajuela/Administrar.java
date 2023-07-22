/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinealajuela;

/**
 *
 * @author danii
 */
public class Administrar {
    
    private String contrasenna;
    private final int LONGITUD=4;
    Cine miCine= new Cine();
    
    public Administrar(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    public Administrar(){
    }
    public boolean longitud(){
        boolean permiso=false;
        if(contrasenna.length()<5){
            permiso=true;
        }
        else{
            permiso=false;
        }
        return permiso;
    }
    public boolean validarContrasenna(){
        int contrasennaInt=0;
        boolean validar=false;
        int anterior=0, cuenta=0;
        if(longitud()){
            for(int i=1; i<LONGITUD; i++){
            anterior=Integer.parseInt(Character.toString(contrasenna.charAt(cuenta)));
            contrasennaInt=Integer.parseInt(Character.toString(contrasenna.charAt(i)));
            if(contrasennaInt==2*anterior){
                validar=true;
            }
            else{
                validar=false;
            }
            cuenta++;
            }
        }
        else{
            validar=false;
        }
        
        return validar;
    }
    public String ingresosSala(){
        String hilera="";
        hilera="\nEl numero de asientos comprados en total: "+miCine.comprados();
        return hilera;
    }
    
    public String compraxSala(){
        String hilera=miCine.compraxSala();
        return hilera;
    }
    public String reportexSala(){
        String hilera=miCine.reportexSala();
        return hilera;
    }
  
}
