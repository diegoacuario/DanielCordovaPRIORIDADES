/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
* @author Ing Diego
 */

public class HiloMadre extends Thread{
    @Override
    public synchronized void start() {
        super.start();
    }
    //HiloInterface : Nos provee los metodos para acceder a un hilo hijo
    
    private HashMap<String, HiloInterface> ListaHilos=new HashMap<String, HiloInterface>();
    @Override
    public void run() {
        System.out.println("Hilo principal coriiendo");
    }
    private void agregarHilo(String s, HiloInterface t) {
        ListaHilos.put(s, t);
    }
    public Iterator<String> getNombreHilos() {
        java.util.Iterator<String> it = ListaHilos.keySet().iterator();
        return  it;
    }
    public void pararHilo(String s) {
        //  System.out.println(ListaHilos);
        ListaHilos.get(s).parar(true);
    }
}
