/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistadeProcesos.java
 *
 * Created on 16-jul-2014, 23:00:08
 * @author Ing Diego
 */
package vista;

import BD.ColasProcesos;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Proceso;
import modelo.Dato;

public class VistadeProcesos extends javax.swing.JFrame {

    DefaultTableModel tmProcesos;
    ListSelectionModel lsmProcesos;
    static List<Dato> procesos = BD.ColasProcesos.procesos;
    Dato p = null;
    Proceso pr = null;
    int x;

    public VistadeProcesos() {
        initComponents();
        x = 1;
        tmProcesos = new DefaultTableModel(null, new String[]{"Proceso", "Prioridad", "Rafaga", "TmpLLegada", "O E/S", "Duracion"});
        tbProcesos.setModel(tmProcesos);
        pr = new Proceso(this);
        this.ocultarBarasProgreso();
        setLocationRelativeTo(null);
    }

    private void tbClientesLineaSeleccionada(JTable tb) {
        if (tb.getSelectedRow() != -1) {
            txtNombreProceso.setText(procesos.get(tb.getSelectedRow()).getNombreProceso());
            txtPrioridad.setText(procesos.get(tb.getSelectedRow()).getPrioridad());
            txtRafaga.setText(procesos.get(tb.getSelectedRow()).getRafaga());
            txtTiempoLLegada.setText(procesos.get(tb.getSelectedRow()).getTiempoLLegada());
            txtOEntradaSalida.setText(procesos.get(tb.getSelectedRow()).getOentradaSalidad());
            txtDuracion.setText(procesos.get(tb.getSelectedRow()).getDuracion());
        }

    }

    public void cargarDatosVista(List<Dato> personas) {
        while (tmProcesos.getRowCount() > 0) {
            tmProcesos.removeRow(0);
        }
        if (personas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La Lista esta Vacia");
        } else {
            String campos[] = new String[]{null, null, null, null, null, null};
            for (int i = 0; i < personas.size(); i++) {
                tmProcesos.addRow(campos);
                tmProcesos.setValueAt(personas.get(i).getNombreProceso(), i, 0);
                tmProcesos.setValueAt(personas.get(i).getPrioridad(), i, 1);
                tmProcesos.setValueAt(personas.get(i).getRafaga(), i, 2);
                tmProcesos.setValueAt(personas.get(i).getTiempoLLegada(), i, 3);
                tmProcesos.setValueAt(personas.get(i).getOentradaSalidad(), i, 4);
                tmProcesos.setValueAt(personas.get(i).getDuracion(), i, 5);
            }
        }

    }

    private void agregar(String nombreproceso, String prioridad, String rafaga, String tiempoLegada, String operacionES, String duracion) {
        if (nombreproceso.equals("") || prioridad.equals("") || rafaga.equals("") || tiempoLegada.equals("")) {
            JOptionPane.showMessageDialog(null, "Hay Campos Vacios antes de Guardar");
        } else {
            if (ColasProcesos.procesos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este es el Primer Proceso");
            }
            if (operacionES.equals("") || duracion.equals("")) {
                BD.ColasProcesos.procesos.add(new Dato(nombreproceso, prioridad, rafaga, tiempoLegada, "0", "0"));
            } else {
                BD.ColasProcesos.procesos.add(new Dato(nombreproceso, prioridad, rafaga, tiempoLegada, operacionES, duracion));
            }

            this.cargarDatosVista(BD.ColasProcesos.procesos);
            tmProcesos.fireTableDataChanged();
            this.limpiar();
        }
    }

    private void limpiar() {
        txtNombreProceso.setText("pc" + x);
        txtPrioridad.setText("1");
        txtOEntradaSalida.setText("1");
        txtTiempoLLegada.setText("1");
        txtRafaga.setText("1");
        txtDuracion.setText("1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProcesos = new javax.swing.JTable();
        bttLimpiar = new javax.swing.JButton();
        bttSalir = new javax.swing.JButton();
        bttEliminar = new javax.swing.JButton();
        bttEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        bttEjecutarProcesos = new javax.swing.JButton();
        bttGuardar2 = new javax.swing.JButton();
        pg1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreProceso = new javax.swing.JTextField();
        txtOEntradaSalida = new javax.swing.JTextField();
        txtRafaga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JTextField();
        txtTiempoLLegada = new javax.swing.JTextField();
        txtPrioridad = new javax.swing.JTextField();
        pg2 = new javax.swing.JProgressBar();
        pg3 = new javax.swing.JProgressBar();
        pg4 = new javax.swing.JProgressBar();
        pg5 = new javax.swing.JProgressBar();
        pg6 = new javax.swing.JProgressBar();
        pg7 = new javax.swing.JProgressBar();
        pg8 = new javax.swing.JProgressBar();
        pg10 = new javax.swing.JProgressBar();
        pg9 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jp_es1 = new javax.swing.JProgressBar();
        jp_es2 = new javax.swing.JProgressBar();
        jp_es3 = new javax.swing.JProgressBar();
        jp_es4 = new javax.swing.JProgressBar();
        jp_es5 = new javax.swing.JProgressBar();
        jp_es6 = new javax.swing.JProgressBar();
        jp_es7 = new javax.swing.JProgressBar();
        jp_es8 = new javax.swing.JProgressBar();
        jp_es9 = new javax.swing.JProgressBar();
        jp_es10 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ALGORITMO CON PRIORIDADES");

        tbProcesos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tbProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbProcesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmProcesos = tbProcesos.getSelectionModel();
        lsmProcesos.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e){
                if(! e.getValueIsAdjusting()){
                    tbClientesLineaSeleccionada(tbProcesos);
                }
            }
        });
        jScrollPane1.setViewportView(tbProcesos);

        bttLimpiar.setText("Limpiar");
        bttLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLimpiarActionPerformed(evt);
            }
        });

        bttSalir.setText("Reiniciar");
        bttSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSalirActionPerformed(evt);
            }
        });

        bttEliminar.setText("Eliminar");
        bttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEliminarActionPerformed(evt);
            }
        });

        bttEditar.setText("Editar");
        bttEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEditarActionPerformed(evt);
            }
        });

        jLabel4.setText("LISTA DE PROCESOS");

        bttEjecutarProcesos.setText("Ejecutar Procesos");
        bttEjecutarProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEjecutarProcesosActionPerformed(evt);
            }
        });

        bttGuardar2.setText("Agregar Proceso");
        bttGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardar2ActionPerformed(evt);
            }
        });

        pg1.setMaximum(0);

        jLabel1.setText("Nombre del Proceso:");

        jLabel3.setText("Rafaga:");

        jLabel6.setText("O E/S:");

        txtNombreProceso.setText("pc1");
        txtNombreProceso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProcesoKeyTyped(evt);
            }
        });

        txtOEntradaSalida.setText("1");
        txtOEntradaSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOEntradaSalidaKeyTyped(evt);
            }
        });

        txtRafaga.setText("1");
        txtRafaga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRafagaKeyTyped(evt);
            }
        });

        jLabel2.setText("Prioridad:");

        jLabel5.setText("Tiempo Llegada:");

        jLabel7.setText("Duracion:");

        txtDuracion.setText("1");
        txtDuracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDuracionKeyTyped(evt);
            }
        });

        txtTiempoLLegada.setText("1");
        txtTiempoLLegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoLLegadaKeyTyped(evt);
            }
        });

        txtPrioridad.setText("1");
        txtPrioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrioridadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtRafaga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(txtOEntradaSalida, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreProceso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTiempoLLegada, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRafaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtTiempoLLegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOEntradaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("DIAGRAMA DE GAM");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("Cola O E/S");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Procesos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 547, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(172, 172, 172))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jp_es1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl1)
                                    .addComponent(lbl3)
                                    .addComponent(lbl2)
                                    .addComponent(lbl4)
                                    .addComponent(lbl5)
                                    .addComponent(lbl6)
                                    .addComponent(lbl7)
                                    .addComponent(lbl8)
                                    .addComponent(lbl9)
                                    .addComponent(lbl10)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pg9, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(pg8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pg10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttEjecutarProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bttEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bttSalir))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttGuardar2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttEjecutarProcesos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttEditar)
                    .addComponent(bttEliminar)
                    .addComponent(bttLimpiar)
                    .addComponent(bttSalir))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl9)
                            .addComponent(jp_es9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl1)
                            .addComponent(jp_es1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pg2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jp_es2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pg3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl3)
                                    .addComponent(jp_es3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl4)
                            .addComponent(jp_es4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl5)
                            .addComponent(jp_es5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl6)
                            .addComponent(jp_es6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl7)
                            .addComponent(jp_es7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pg8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jp_es8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pg10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl10))
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jp_es10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void bttLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLimpiarActionPerformed

    this.limpiar();
}//GEN-LAST:event_bttLimpiarActionPerformed

private void bttSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSalirActionPerformed
// TODO add your handling code here:
    dispose();
    new VistadeProcesos().setVisible(true);
}//GEN-LAST:event_bttSalirActionPerformed

private void bttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEliminarActionPerformed
// TODO add your handling code here:
    if (ColasProcesos.procesos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay Procesos en la Lista");
    } else if (tbProcesos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(null, "Elija el Proceso a Eliminar");
    } else {
        ColasProcesos.procesos.remove(tbProcesos.getSelectedRow());
        this.cargarDatosVista(BD.ColasProcesos.procesos);
        tmProcesos.fireTableDataChanged();
        this.limpiar();
    }
}//GEN-LAST:event_bttEliminarActionPerformed

private void bttEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEditarActionPerformed
// TODO add your handling code here:
    if (ColasProcesos.procesos.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay Procesos en la Lista");
    } else if (tbProcesos.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(null, "Elija el Proceso a Editar");
    } else {
        if (txtNombreProceso.getText().equals("") || txtPrioridad.getText().equals("") || txtOEntradaSalida.getText().equals("")) {
            JOptionPane.showMessageDialog(null, " No ha Seleccionado el Proceso");
        } else {
            ColasProcesos.procesos.remove(tbProcesos.getSelectedRow());
            ColasProcesos.procesos.add(tbProcesos.getSelectedRow(), new Dato(txtNombreProceso.getText(), txtPrioridad.getText(), txtRafaga.getText(), txtTiempoLLegada.getText(), txtOEntradaSalida.getText(), txtDuracion.getText()));
            this.cargarDatosVista(BD.ColasProcesos.procesos);
            tmProcesos.fireTableDataChanged();
        }
    }

}//GEN-LAST:event_bttEditarActionPerformed
    private void bttEjecutarProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEjecutarProcesosActionPerformed
        pr.start();
    }//GEN-LAST:event_bttEjecutarProcesosActionPerformed

    private void bttGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardar2ActionPerformed
        x++;
        // TODO add your handling code here:
        this.agregar(txtNombreProceso.getText(), txtPrioridad.getText(), txtRafaga.getText(), txtTiempoLLegada.getText(), txtOEntradaSalida.getText(), txtDuracion.getText());
//    txtNombreProceso.setEnabled(false);
//    txtPrioridad.setEnabled(false);
//    txtRafaga.setEnabled(false);
//    txtTiempoLLegada.setEnabled(false);
//    txtOPeracionEntradaSalida.setEnabled(false);
//    txtDuracion.setEnabled(false);

    }//GEN-LAST:event_bttGuardar2ActionPerformed

    private void txtNombreProcesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProcesoKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a) || Character.isLetter(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProcesoKeyTyped

    private void txtRafagaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRafagaKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtRafagaKeyTyped

    private void txtOEntradaSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOEntradaSalidaKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtOEntradaSalidaKeyTyped

    private void txtPrioridadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrioridadKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrioridadKeyTyped

    private void txtDuracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDuracionKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtDuracionKeyTyped

    private void txtTiempoLLegadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoLLegadaKeyTyped
        // TODO add your handling code here:
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtTiempoLLegadaKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttEditar;
    private javax.swing.JButton bttEjecutarProcesos;
    private javax.swing.JButton bttEliminar;
    private javax.swing.JButton bttGuardar2;
    private javax.swing.JButton bttLimpiar;
    private javax.swing.JButton bttSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar jp_es1;
    private javax.swing.JProgressBar jp_es10;
    private javax.swing.JProgressBar jp_es2;
    private javax.swing.JProgressBar jp_es3;
    private javax.swing.JProgressBar jp_es4;
    private javax.swing.JProgressBar jp_es5;
    private javax.swing.JProgressBar jp_es6;
    private javax.swing.JProgressBar jp_es7;
    private javax.swing.JProgressBar jp_es8;
    private javax.swing.JProgressBar jp_es9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JProgressBar pg1;
    private javax.swing.JProgressBar pg10;
    private javax.swing.JProgressBar pg2;
    private javax.swing.JProgressBar pg3;
    private javax.swing.JProgressBar pg4;
    private javax.swing.JProgressBar pg5;
    private javax.swing.JProgressBar pg6;
    private javax.swing.JProgressBar pg7;
    private javax.swing.JProgressBar pg8;
    private javax.swing.JProgressBar pg9;
    private javax.swing.JTable tbProcesos;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtNombreProceso;
    private javax.swing.JTextField txtOEntradaSalida;
    private javax.swing.JTextField txtPrioridad;
    private javax.swing.JTextField txtRafaga;
    private javax.swing.JTextField txtTiempoLLegada;
    // End of variables declaration//GEN-END:variables

    public JProgressBar getjProgressBar1() {
        return pg1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.pg1 = jProgressBar1;
    }

    public JProgressBar getjProgressBar2() {
        return jProgressBar2;
    }

    public void setjProgressBar2(JProgressBar jProgressBar2) {
        this.jProgressBar2 = jProgressBar2;
    }

    public void ocultarBarasProgreso() {
        pg1.setVisible(false);
        pg2.setVisible(false);
        pg3.setVisible(false);
        pg4.setVisible(false);
        pg5.setVisible(false);
        pg6.setVisible(false);
        pg7.setVisible(false);
        pg8.setVisible(false);
        pg9.setVisible(false);
        pg10.setVisible(false);

        jp_es1.setVisible(false);
        jp_es2.setVisible(false);
        jp_es3.setVisible(false);
        jp_es4.setVisible(false);
        jp_es5.setVisible(false);
        jp_es6.setVisible(false);
        jp_es7.setVisible(false);
        jp_es8.setVisible(false);
        jp_es9.setVisible(false);
        jp_es10.setVisible(false);
    }

//barraprogreso.setMaximum(1000);
    //barraprogreso.setValue(i);
    //   barraprogreso.setStringPainted(true);
    //  barraprogreso.setString(i + "%");
    public DefaultTableModel getTmProcesos() {
        return tmProcesos;
    }

    public void setTmProcesos(DefaultTableModel tmProcesos) {
        this.tmProcesos = tmProcesos;
    }

    public static List<Dato> getProcesos() {
        return procesos;
    }

    public static void setProcesos(List<Dato> procesos) {
        VistadeProcesos.procesos = procesos;
    }

    public Dato getP() {
        return p;
    }

    public void setP(Dato p) {
        this.p = p;
    }

    public JProgressBar getPg1() {
        return pg1;
    }

    public void setPg1(JProgressBar pg1) {
        this.pg1 = pg1;
    }

    public JProgressBar getPg10() {
        return pg10;
    }

    public void setPg10(JProgressBar pg10) {
        this.pg10 = pg10;
    }

    public JProgressBar getPg2() {
        return pg2;
    }

    public void setPg2(JProgressBar pg2) {
        this.pg2 = pg2;
    }

    public JProgressBar getPg3() {
        return pg3;
    }

    public void setPg3(JProgressBar pg3) {
        this.pg3 = pg3;
    }

    public JProgressBar getPg4() {
        return pg4;
    }

    public void setPg4(JProgressBar pg4) {
        this.pg4 = pg4;
    }

    public JProgressBar getPg5() {
        return pg5;
    }

    public void setPg5(JProgressBar pg5) {
        this.pg5 = pg5;
    }

    public JProgressBar getPg6() {
        return pg6;
    }

    public void setPg6(JProgressBar pg6) {
        this.pg6 = pg6;
    }

    public JProgressBar getPg7() {
        return pg7;
    }

    public void setPg7(JProgressBar pg7) {
        this.pg7 = pg7;
    }

    public JProgressBar getPg8() {
        return pg8;
    }

    public void setPg8(JProgressBar pg8) {
        this.pg8 = pg8;
    }

    public JProgressBar getPg9() {
        return pg9;
    }

    public void setPg9(JProgressBar pg9) {
        this.pg9 = pg9;
    }

    public JTable getTbProcesos() {
        return tbProcesos;
    }

    public void setTbProcesos(JTable tbProcesos) {
        this.tbProcesos = tbProcesos;
    }

    public JTextField getTxtDuracion() {
        return txtDuracion;
    }

    public void setTxtDuracion(JTextField txtDuracion) {
        this.txtDuracion = txtDuracion;
    }

    public JTextField getTxtNombreProceso() {
        return txtNombreProceso;
    }

    public void setTxtNombreProceso(JTextField txtNombreProceso) {
        this.txtNombreProceso = txtNombreProceso;
    }

    public JTextField getTxtOPeracionEntradaSalida() {
        return txtRafaga;
    }

    public void setTxtOPeracionEntradaSalida(JTextField txtOPeracionEntradaSalida) {
        this.txtRafaga = txtOPeracionEntradaSalida;
    }

    public JTextField getTxtPrioridad() {
        return txtPrioridad;
    }

    public void setTxtPrioridad(JTextField txtPrioridad) {
        this.txtPrioridad = txtPrioridad;
    }

    public JTextField getTxtRafaga() {
        return txtOEntradaSalida;
    }

    public void setTxtRafaga(JTextField txtRafaga) {
        this.txtOEntradaSalida = txtRafaga;
    }

    public JTextField getTxtTiempoLLegada() {
        return txtTiempoLLegada;
    }

    public void setTxtTiempoLLegada(JTextField txtTiempoLLegada) {
        this.txtTiempoLLegada = txtTiempoLLegada;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JLabel getLbl1() {
        return lbl1;
    }

    public void setLbl1(JLabel lbl1) {
        this.lbl1 = lbl1;
    }

    public JLabel getLbl10() {
        return lbl10;
    }

    public void setLbl10(JLabel lbl10) {
        this.lbl10 = lbl10;
    }

    public JLabel getLbl2() {
        return lbl2;
    }

    public void setLbl2(JLabel lbl2) {
        this.lbl2 = lbl2;
    }

    public JLabel getLbl3() {
        return lbl3;
    }

    public void setLbl3(JLabel lbl3) {
        this.lbl3 = lbl3;
    }

    public JLabel getLbl4() {
        return lbl4;
    }

    public void setLbl4(JLabel lbl4) {
        this.lbl4 = lbl4;
    }

    public JLabel getLbl5() {
        return lbl5;
    }

    public void setLbl5(JLabel lbl5) {
        this.lbl5 = lbl5;
    }

    public JLabel getLbl6() {
        return lbl6;
    }

    public void setLbl6(JLabel lbl6) {
        this.lbl6 = lbl6;
    }

    public JLabel getLbl7() {
        return lbl7;
    }

    public void setLbl7(JLabel lbl7) {
        this.lbl7 = lbl7;
    }

    public JLabel getLbl8() {
        return lbl8;
    }

    public void setLbl8(JLabel lbl8) {
        this.lbl8 = lbl8;
    }

    public JLabel getLbl9() {
        return lbl9;
    }

    public void setLbl9(JLabel lbl9) {
        this.lbl9 = lbl9;
    }

    public JProgressBar getJp_es1() {
        return jp_es1;
    }

    public void setJp_es1(JProgressBar jp_es1) {
        this.jp_es1 = jp_es1;
    }

    public JProgressBar getJp_es10() {
        return jp_es10;
    }

    public void setJp_es10(JProgressBar jp_es10) {
        this.jp_es10 = jp_es10;
    }

    public JProgressBar getJp_es2() {
        return jp_es2;
    }

    public void setJp_es2(JProgressBar jp_es2) {
        this.jp_es2 = jp_es2;
    }

    public JProgressBar getJp_es3() {
        return jp_es3;
    }

    public void setJp_es3(JProgressBar jp_es3) {
        this.jp_es3 = jp_es3;
    }

    public JProgressBar getJp_es4() {
        return jp_es4;
    }

    public void setJp_es4(JProgressBar jp_es4) {
        this.jp_es4 = jp_es4;
    }

    public JProgressBar getJp_es5() {
        return jp_es5;
    }

    public void setJp_es5(JProgressBar jp_es5) {
        this.jp_es5 = jp_es5;
    }

    public JProgressBar getJp_es6() {
        return jp_es6;
    }

    public void setJp_es6(JProgressBar jp_es6) {
        this.jp_es6 = jp_es6;
    }

    public JProgressBar getJp_es7() {
        return jp_es7;
    }

    public void setJp_es7(JProgressBar jp_es7) {
        this.jp_es7 = jp_es7;
    }

    public JProgressBar getJp_es8() {
        return jp_es8;
    }

    public void setJp_es8(JProgressBar jp_es8) {
        this.jp_es8 = jp_es8;
    }

    public JProgressBar getJp_es9() {
        return jp_es9;
    }

    public void setJp_es9(JProgressBar jp_es9) {
        this.jp_es9 = jp_es9;
    }

}
