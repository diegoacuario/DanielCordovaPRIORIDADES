/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import vista.VistadeProcesos;

/**
 *
* @author Ing Diego
 */
public class hiloOperacionEntradaSalida extends Thread {

    
    
     int segundoActual=0;
   VistadeProcesos ventanaProcesos;
 
   private Thread a = null;   
 
    
    private int order;
    private int prog ;
    Dato proceso;
    Boolean bandera= true;
    Hebra h;
    Proceso pro;
   javax.swing.JProgressBar progBarEnSalida ;

    public hiloOperacionEntradaSalida(Proceso pro, Dato p, Hebra hiloActual, JProgressBar es) {
         a = new Thread(this);
          a.start();
        this.pro=pro;
        this.proceso = p;
        this.prog=0;
        h=hiloActual;
        progBarEnSalida=es;
         progBarEnSalida.setVisible(true);
      
    }
    public void cmd(int in) { // Setter
        this.order = in;
    }

    public void run() {
        while(bandera){
            try {
        this.prog++;
                this.progBarEnSalida.setMaximum(Integer.valueOf(proceso.getDuracion()));
                this.progBarEnSalida.setValue(prog);
                this.progBarEnSalida.setStringPainted(true);
                this.progBarEnSalida.setString(prog+ "min");
        if(prog==Integer.valueOf(proceso.getDuracion())){
        bandera=false;
                try{
            this.h.start(); // llama a run()
        }catch(Exception e){ System.out.println("- Warning: allready running.."); }
        try{
            this.h.cmd(1);            
        }catch(Exception e){ e.printStackTrace(); System.err.println("\nStarting progressBar work: problem detected...\n"); }
         
        break;
        }    
        
        }catch (Exception e) {
                e.printStackTrace(); System.out.println("Thread->Sleep problem:");
        }
            try {
                this.sleep(1250);
            } catch (InterruptedException ex) {
                Logger.getLogger(hiloOperacionEntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
     
        pro.Listos.add(proceso);
        if (!pro.ListasPocesos.isHayEjecucion()) {
            pro.empezarrHilo(proceso.getNombreProceso());
        }
        }
        
    
}
