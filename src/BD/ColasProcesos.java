/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.util.ArrayList;
import java.util.List;
import modelo.Dato;

/**
 *
 * @author Diego
 */
///Clase que simula un contenedor de procesos
public class ColasProcesos {

    public static List<Dato> procesos = new ArrayList<>();
   
    private static boolean hayEjecucion = false;
    private static String NombProceso = "";
    Dato proceso = null;
    Boolean avisame = false;

    public Dato procesoQLlega(int segundoActual) {
        for (Dato p : procesos) {
            if (p.getTiempoLLegada().equals(String.valueOf(segundoActual))) {
                avisame = true;
                proceso = p;
                break;
            }
        }

        return proceso;

    }
    public Boolean getAvisame() {
        return avisame;
    }

    public void setAvisame(Boolean avisame) {
        this.avisame = avisame;
    }

    public static List<Dato> getProcesos() {
        return procesos;
    }

    public static void setProcesos(List<Dato> procesos) {
        ColasProcesos.procesos = procesos;
    }

    public static boolean isHayEjecucion() {
        return hayEjecucion;
    }

    public static void setHayEjecucion(boolean hayEjecucion) {
        ColasProcesos.hayEjecucion = hayEjecucion;
    }

    public static String getNombProceso() {
        return NombProceso;
    }

    public static void setNombProceso(String NombProceso) {
        ColasProcesos.NombProceso = NombProceso;
    }

}