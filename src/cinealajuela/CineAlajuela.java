/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinealajuela;

//DANIELA MENDEZ PORRAS 
public class CineAlajuela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        jFrmCarteleras ventana= new jFrmCarteleras();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        Cine miCine= new Cine();
        miCine.generarAsientos();
    }
    
}
