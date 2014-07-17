/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
* @author Ing Diego
 */
public class Dato {
    
    private String nombreProceso="0";
    private String prioridad="0";
    private String rafaga="0";
    private String tiempoLLegada="0";
    private String oentradaSalidad="0";
    private String duracion="0";

    public Dato() {
    }

    public Dato(String nombreProceso, String prioridad, String rafaga, String tiempoLLegada, String oentradaSalidad, String duracion) {
        this.nombreProceso = nombreProceso;
        this.prioridad = prioridad;
        this.rafaga = rafaga;
        this.tiempoLLegada = tiempoLLegada;
        this.oentradaSalidad = oentradaSalidad;
        this.duracion = duracion;
    }

 

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    
    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getRafaga() {
        return rafaga;
    }

    public void setRafaga(String rafaga) {
        this.rafaga = rafaga;
    }

    public String getTiempoLLegada() {
        return tiempoLLegada;
    }

    public void setTiempoLLegada(String tiempoLLegada) {
        this.tiempoLLegada = tiempoLLegada;
    }

    public String getOentradaSalidad() {
        return oentradaSalidad;
    }

    public void setOentradaSalidad(String oentradaSalidad) {
        this.oentradaSalidad = oentradaSalidad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Proceso{" + "nombreProceso=" + nombreProceso + '}';
    }
    
    
    
    
}
