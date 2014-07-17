/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.VistadeProcesos;

    
/**
 *
* @author Ing Diego
 */
public class DiagramaGam extends Thread{
    
     int segundoActual=0;
   VistadeProcesos ventanaProcesos;
 
   private Thread a = null;   
 
 public DiagramaGam(VistadeProcesos vistadeProcesos) {
       ventanaProcesos=vistadeProcesos;
         a = new Thread(this);
      a.start();
    }

  
    public void asiganarValor(int a) throws InterruptedException{
      // Thread.sleep(1000);
      ventanaProcesos.getjProgressBar2().setValue(a); 
       ventanaProcesos.getjProgressBar2().setStringPainted(true);
       ventanaProcesos.getjProgressBar2().setString(a + "min");
    }

    public Thread getA() {
        return a;
    }

    public void setA(Thread a) {
        this.a = a;
    }

    public int getSegundoActual() {
        return segundoActual;
    }

    public void setSegundoActual(int segundoActual) {
        this.segundoActual = segundoActual;
    }
}
    
