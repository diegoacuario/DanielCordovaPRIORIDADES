/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoprioridades;

import vista.VistadeProcesos;
import vista.VistadeProcesos;

/**
 *
 * @author Ing Diego
 */
public class AlgoritmoPrioridades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistadeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistadeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistadeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistadeProcesos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
// TODO code application logic here
        new VistadeProcesos().setVisible(true);
    }
}
