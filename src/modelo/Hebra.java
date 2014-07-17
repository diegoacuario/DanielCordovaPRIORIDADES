package modelo;

/**
 *
 * @author Ing Diego
 */
import BD.ColasProcesos;
import javax.swing.JProgressBar;

public class Hebra extends Thread implements HiloInterface {
    // Variables

    private boolean life;
    private int order;
    private int prog;
    Dato proceso;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JProgressBar progBarEnSalida;
    Proceso proc;

    // Constructor
    public Hebra(Proceso proc, Dato p, JProgressBar b, JProgressBar es) {
        super(p.getNombreProceso());
        this.proceso = p;
        proc = proc;
        this.progBar = b;
        progBarEnSalida = es;
        this.life = true;
        this.prog = 0;

    }

    // Methods
    public void kill() {
        this.life = false;
    }

    public void cmd(int in) { // Setter
        this.order = in;
    }

    public void run() {
        while (life) {
            if (order == 1) {
                new ColasProcesos().setHayEjecucion(true);
                new ColasProcesos().setNombProceso(proceso.getNombreProceso());
                System.out.println("Thread running.." + this.prog);
                this.prog++;
                this.progBar.setMaximum(Integer.valueOf(proceso.getRafaga()));
                this.progBar.setValue(prog);
                this.progBar.setStringPainted(true);
                this.progBar.setString(prog + "min");
                if (this.controlarOES()) {
                    if (!proc.Listos.isEmpty()) {
                        proc.empezarrHilo(proc.buscarprocesoMenorPrioridad());;
                    }
                    new hiloOperacionEntradaSalida(proc, proceso, this, this.progBarEnSalida);

                }
                try {
                    Thread.sleep(1090); // 125 millisegundos
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Thread->Sleep problem:");
                }
            }
            if (this.prog == Integer.valueOf(proceso.getRafaga())) {
                life = false;
                System.out.println("Thread ended..");
            }
        }
        proc.Listos.remove(proceso);
         //proc.procesos.setHayEjecucion(false);
        //proc.procesos.setNombProceso("");

        new Proceso().empezarrHilo(proc.buscarprocesoMenorPrioridad());

    }

    public int getProg() {
        return prog;
    }

    public void setProg(int prog) {
        this.prog = prog;
    }

    public Boolean controlarOES() {

        if (Integer.valueOf(proceso.getOentradaSalidad()) == getProg()) {
            this.cmd(0);
            proc.Listos.remove(proceso);
            new ColasProcesos().setHayEjecucion(false);//   EstoyActivo=false;
            new ColasProcesos().setNombProceso("");//   EstoyActivo=false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void parar(boolean b) {
        if (b == true) {
            this.cmd(0);
            new ColasProcesos().setHayEjecucion(false);//  
            new ColasProcesos().setNombProceso("");
        }

    }

    @Override
    public void empezar(boolean c) {
        if (c == true) {
            this.cmd(1);
            new ColasProcesos().setHayEjecucion(true);//   
        }
    }
}
