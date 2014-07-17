/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import BD.ColasProcesos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JProgressBar;
import vista.VistadeProcesos;

/**
 *
 * @author Ing Diego
 */
public class Proceso extends Thread {

    int segundoActual = 0;
    VistadeProcesos ventanaProcesos;
    private Thread a = null;
 ColasProcesos ListasPocesos;
    @Override
    public synchronized void start() {
        super.start();
    }

    public Proceso(VistadeProcesos vistadeProcesos) {
        ventanaProcesos = vistadeProcesos;
        a = new Thread(this);
       ListasPocesos= new ColasProcesos();
    }
    

    public Proceso() {
    }
    ColasProcesos procesos = new ColasProcesos();
    Dato pNuevo = null;
    String nombProcesoActual;
    public static ArrayList<Dato> Listos = new ArrayList<Dato>();
    private static HashMap<String, HiloInterface> ListaHilos = new HashMap<>();
    public static ArrayList<Dato> controlarInsidencias = new ArrayList<Dato>();
    boolean bandera = true;
    int cont = 0;
    int cont2 = 0;
    int contador = 0;
    JProgressBar baraprogreso = null;
    JProgressBar baraprogresEntadaSalida = null;
    Hebra hiloj;
    DiagramaGam h;

    @Override
    public void run() {

        for (int i = 1; i <= 50; i++) {
            try {
                Thread.sleep(1000);
                h = new DiagramaGam(ventanaProcesos);
                h.asiganarValor(i);
                pNuevo = procesos.procesoQLlega(i);

                if (pNuevo != null) {
                    if (procesos.getAvisame() && !controlarInsidencias.contains(pNuevo)) {
                        controlarInsidencias.add(pNuevo);
                        contador = contador + 1;

                        switch (contador) {
                            case 1:
                                ventanaProcesos.getPg1().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg1();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es1();
                                ventanaProcesos.getLbl1().setText(pNuevo.getNombreProceso());
                                break;
                            case 2:
                                ventanaProcesos.getPg2().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg2();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es2();
                                ventanaProcesos.getLbl2().setText(pNuevo.getNombreProceso());
                                break;
                            case 3:
                                ventanaProcesos.getPg3().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg3();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es3();
                                ventanaProcesos.getLbl3().setText(pNuevo.getNombreProceso());
                                break;
                            case 4:
                                ventanaProcesos.getPg4().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg4();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es4();
                                ventanaProcesos.getLbl4().setText(pNuevo.getNombreProceso());
                                break;

                            case 5:
                                ventanaProcesos.getPg5().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg5();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es5();
                                ventanaProcesos.getLbl5().setText(pNuevo.getNombreProceso());
                                break;

                            case 6:
                                ventanaProcesos.getPg6().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg6();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es6();
                                ventanaProcesos.getLbl6().setText(pNuevo.getNombreProceso());
                                break;

                            case 7:
                                ventanaProcesos.getPg7().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg7();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es7();
                                ventanaProcesos.getLbl7().setText(pNuevo.getNombreProceso());
                                break;

                            case 8:
                                ventanaProcesos.getPg8().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg8();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es8();
                                ventanaProcesos.getLbl8().setText(pNuevo.getNombreProceso());
                                break;

                            case 9:
                                ventanaProcesos.getPg9().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg9();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es9();
                                ventanaProcesos.getLbl9().setText(pNuevo.getNombreProceso());
                                break;
                            case 10:
                                ventanaProcesos.getPg10().setVisible(true);
                                baraprogreso = ventanaProcesos.getPg10();
                                baraprogresEntadaSalida = ventanaProcesos.getJp_es10();
                                ventanaProcesos.getLbl10().setText(pNuevo.getNombreProceso());
                                break;
                        }

                        if (Listos.size() == 0 ) {
                            hiloj = new Hebra(this,pNuevo, baraprogreso, baraprogresEntadaSalida);
                            this.crearNuevoProceso(hiloj, pNuevo);
                        } 
                        
//                        if(ListasPocesos.isHayEjecucion() == false){
//                        hiloj = new Hebra(this,pNuevo, baraprogreso, baraprogresEntadaSalida);
//                            this.crearNuevoProceso(hiloj, pNuevo);
//                            
//                       }
                      if (ListasPocesos.isHayEjecucion()) {
                    Dato dato=this.obtenerProcesoEjecucion(ListasPocesos.getNombProceso());
                          if (this.verificarPrioridadNuevo(dato, pNuevo)) {
                             pararHilo(dato.getNombreProceso());
                         hiloj = new Hebra(this, pNuevo, baraprogreso, baraprogresEntadaSalida);
                         this.crearNuevoProceso(hiloj, pNuevo);
                            }
                        }
                    }
                }


            } catch (InterruptedException ex) {
            }
        }



    }

    private void agregarHilo(String s, HiloInterface t) {
        ListaHilos.put(s, t);
    }

    public void crearNuevoProceso(Hebra h, Dato pNuev) {
        agregarHilo(pNuev.getNombreProceso(), h);
        h.start();
        h.cmd(1);
       Listos.add(pNuev);
    }

        public Dato obtenerProcesoEjecucion(String inf) {
        Dato datoresultado = null;
        for (Dato d : Listos) {
            if (d.getNombreProceso().equalsIgnoreCase(inf)) {
               return d;
            }
        }
        return datoresultado;
        
    }
    public Iterator<String> getNombreHilos() {
        Iterator it = ListaHilos.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        return it;
    }

    public String estaActivo() {
        Iterator it = ListaHilos.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
        return null;
    }

    public void pararHilo(String s) {
        ListaHilos.get(s).parar(true);
    }
    
      public void empezarrHilo(String s) {
        ListaHilos.get(s).empezar(true);
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

    public Boolean verificarPrioridadNuevo(Dato prosesoACtual, Dato prosesoNuevo) {
             if (Integer.valueOf(prosesoNuevo.getPrioridad()) < Integer.valueOf(prosesoACtual.getPrioridad())) {
                 return true;
            
        } else {
            return false;
        }

    }
    
       public String buscarprocesoMenorPrioridad() {
          Dato menor=null;
          String menorPriorida="";
        if (!Listos.isEmpty()) {
             menor = Listos.get(0);
        menorPriorida = "";
        for (Dato procesoListos : Listos) {
            if (Integer.valueOf(procesoListos.getPrioridad()) < Integer.valueOf(menor.getPrioridad())) {
                menor = procesoListos;
                menorPriorida = menor.getNombreProceso();
            }
        } 
        }
      
        return menorPriorida;
    }
    
    public Boolean sonIguales(Dato prosesoACtual, Dato prosesoNuevo){
     if (Integer.valueOf(prosesoNuevo.getPrioridad()) == Integer.valueOf(prosesoACtual.getPrioridad())) {
            return true;
        } else {
            return false;
        }
    }
}
