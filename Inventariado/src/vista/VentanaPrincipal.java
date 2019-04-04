/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.ControlPrincipal;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Factura;
import modelo.ReporteGeneral;

/**
 *
 * @author ~Antares~
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private ControlPrincipal mainControl;
    //**********
    private Factura factura;
    private ReporteGeneral reporteGeneral;
    private VentanaReporteTabla ventanaReporteTabla;
    //**********

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        jlbRefOtraFactura.setEnabled(false);
        jtfRerOtraFactura.setEnabled(false);

        mainControl = new ControlPrincipal();
        jtfNumFactura.setText("" + mainControl.getNumFactura());
        jtfFecha.setText(getFecha());

    }

    private void guaradarMovimiento() {
        factura = new Factura();
        factura.setNumFactura(Integer.parseInt(jtfNumFactura.getText()));
        factura.setFeha(jtfFecha.getText());
        factura.setTipoMovimiento(jcbTipoMovimiento.getSelectedItem().toString());
        factura.setCantidadUnidades(Integer.parseInt(jtfCantidad.getText()));
        factura.setCosotUnitario(Double.parseDouble(jtfPrecioUnidad.getText()));
        if (jtfRerOtraFactura.getText().equals("")) {
            factura.setRefOtraFactura(0);
        } else {
            factura.setRefOtraFactura(Integer.parseInt(jtfRerOtraFactura.getText()));
        }

        if (mainControl.hacerTransaccionPrincipal(factura)) {
            jtfNumFactura.setText("" + mainControl.getNumFactura());
            settearCampos();
            JOptionPane.showMessageDialog(null, "Transaccion ralizada con exito, datos registrados satisfactoriamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "error en la transaccion, no se registro ningun dato",
                    "Información", JOptionPane.ERROR_MESSAGE);
        }

    }

    private boolean validarCamposDouble(JLabel jlbLabelX, JTextField jtfcampoX) {
        try {
            Double.parseDouble(jtfcampoX.getText());
            jlbLabelX.setForeground(Color.black);
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            jlbLabelX.setForeground(Color.red);
            jtfcampoX.setText("");
            jtfTotal.setText("");
            return false;
        }
        return true;
    }

    private boolean validarCamposInteger(JLabel jlbLabelX, JTextField jtfcampoX) {
        try {
            Integer.parseInt(jtfcampoX.getText());
            jlbLabelX.setForeground(Color.black);
        } catch (NumberFormatException e) {
            Toolkit.getDefaultToolkit().beep();
            jlbLabelX.setForeground(Color.red);
            jtfcampoX.setText("");
            jtfTotal.setText("");
            return false;
        }
        return true;
    }

    private String getFecha() {
        String fecha;
        String dia;
        String mes;
        String annio;
        int mesX;
        int diaX;

        Calendar calendario = Calendar.getInstance();

        dia = Integer.toString(calendario.get(Calendar.DATE));

        mesX = calendario.get(Calendar.MONTH);
        if (mesX < 10) {
            mes = "0" + Integer.toString(mesX);
        } else {
            mes = Integer.toString(mesX);
        }

        diaX = calendario.get(Calendar.DATE);
        if (diaX < 10) {
            dia = "0" + Integer.toString(diaX);
        } else {
            dia = Integer.toString(diaX);
        }

        annio = Integer.toString(calendario.get(Calendar.YEAR));

        fecha = dia + "/" + mes + "/" + annio;
        return fecha;
    }

    private void totalizar() {
        try {
            Double precio = Double.parseDouble(jtfPrecioUnidad.getText());
            try {
                int cantidad = Integer.parseInt(jtfCantidad.getText());
                jtfTotal.setText("" + precio * cantidad);
            } catch (NumberFormatException e) {

            }
        } catch (NumberFormatException e) {

        }
    }

    private void settearCampos() {
        jtfRerOtraFactura.setText("");
        jtfPrecioUnidad.setText("");
        jtfCantidad.setText("");
        jtfTotal.setText("");

        jlbRefOtraFactura.setForeground(Color.black);
        jlbPresioUnidad.setForeground(Color.black);
        jlbCantidad.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPestanas = new javax.swing.JTabbedPane();
        jPanelTransacciones = new javax.swing.JPanel();
        jPanelFechaYFactura = new javax.swing.JPanel();
        jlbNumFactura = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JTextField();
        jtfNumFactura = new javax.swing.JTextField();
        jPanelTransaccion = new javax.swing.JPanel();
        jlbTipoMovimiento = new javax.swing.JLabel();
        jcbTipoMovimiento = new javax.swing.JComboBox<>();
        jlbRefOtraFactura = new javax.swing.JLabel();
        jtfRerOtraFactura = new javax.swing.JTextField();
        jlbCantidad = new javax.swing.JLabel();
        jtfCantidad = new javax.swing.JTextField();
        jlbTotal = new javax.swing.JLabel();
        jtfTotal = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlbPresioUnidad = new javax.swing.JLabel();
        jtfPrecioUnidad = new javax.swing.JTextField();
        jPanelImagen = new javax.swing.JPanel();
        jlbImagen = new javax.swing.JLabel();
        jPanelTitulo3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelReportes = new javax.swing.JPanel();
        jPanelTitulo1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnReporteGeneral = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnReporteEntradas = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnReporteSalidas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setResizable(false);

        jTabbedPestanas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPestanas.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanelTransacciones.setBorder(null);
        jPanelTransacciones.setFocusable(false);

        jPanelFechaYFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelFechaYFactura.setFocusable(false);

        jlbNumFactura.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbNumFactura.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbNumFactura.setText("Nº Factura");
        jlbNumFactura.setFocusable(false);

        jlbFecha.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbFecha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbFecha.setText("Fecha");
        jlbFecha.setFocusable(false);

        jtfFecha.setEditable(false);
        jtfFecha.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfFecha.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfFecha.setFocusable(false);

        jtfNumFactura.setEditable(false);
        jtfNumFactura.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfNumFactura.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfNumFactura.setFocusable(false);

        javax.swing.GroupLayout jPanelFechaYFacturaLayout = new javax.swing.GroupLayout(jPanelFechaYFactura);
        jPanelFechaYFactura.setLayout(jPanelFechaYFacturaLayout);
        jPanelFechaYFacturaLayout.setHorizontalGroup(
            jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechaYFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNumFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jtfNumFactura))
                .addContainerGap())
        );
        jPanelFechaYFacturaLayout.setVerticalGroup(
            jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFechaYFacturaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelFechaYFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbNumFactura)
                    .addComponent(jtfNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanelTransaccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTransaccion.setFocusable(false);

        jlbTipoMovimiento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbTipoMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbTipoMovimiento.setText("Tipo de Transaccion");
        jlbTipoMovimiento.setFocusable(false);

        jcbTipoMovimiento.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jcbTipoMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "compra", "venta", "devolucion Compra", "devolucion Venta" }));
        jcbTipoMovimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTipoMovimientoItemStateChanged(evt);
            }
        });

        jlbRefOtraFactura.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbRefOtraFactura.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbRefOtraFactura.setText("Nº Factura devolucion");
        jlbRefOtraFactura.setFocusable(false);

        jtfRerOtraFactura.setEditable(false);
        jtfRerOtraFactura.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfRerOtraFactura.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfRerOtraFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfRerOtraFacturaFocusLost(evt);
            }
        });
        jtfRerOtraFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfRerOtraFacturaActionPerformed(evt);
            }
        });
        jtfRerOtraFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfRerOtraFacturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfRerOtraFacturaKeyTyped(evt);
            }
        });

        jlbCantidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbCantidad.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbCantidad.setText("Cantidad");
        jlbCantidad.setBorder(null);
        jlbCantidad.setFocusable(false);

        jtfCantidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfCantidad.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCantidadFocusLost(evt);
            }
        });
        jtfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCantidadActionPerformed(evt);
            }
        });
        jtfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCantidadKeyReleased(evt);
            }
        });

        jlbTotal.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbTotal.setText("Total");
        jlbTotal.setBorder(null);
        jlbTotal.setFocusable(false);

        jtfTotal.setEditable(false);
        jtfTotal.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfTotalFocusGained(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(176, 179, 50));
        btnRegistrar.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar Transaccion");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jlbPresioUnidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jlbPresioUnidad.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbPresioUnidad.setText("Precio Unidad");
        jlbPresioUnidad.setBorder(null);
        jlbPresioUnidad.setFocusable(false);

        jtfPrecioUnidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtfPrecioUnidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfPrecioUnidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPrecioUnidadFocusLost(evt);
            }
        });
        jtfPrecioUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioUnidadActionPerformed(evt);
            }
        });
        jtfPrecioUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPrecioUnidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelTransaccionLayout = new javax.swing.GroupLayout(jPanelTransaccion);
        jPanelTransaccion.setLayout(jPanelTransaccionLayout);
        jPanelTransaccionLayout.setHorizontalGroup(
            jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransaccionLayout.createSequentialGroup()
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTransaccionLayout.createSequentialGroup()
                        .addComponent(jlbPresioUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelTransaccionLayout.createSequentialGroup()
                        .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransaccionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelTransaccionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransaccionLayout.createSequentialGroup()
                                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbRefOtraFactura)
                                    .addComponent(jlbTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfRerOtraFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelTransaccionLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanelTransaccionLayout.setVerticalGroup(
            jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransaccionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTipoMovimiento)
                    .addComponent(jcbTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbRefOtraFactura)
                    .addComponent(jtfRerOtraFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCantidad)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecioUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPresioUnidad))
                .addGap(12, 12, 12)
                .addGroup(jPanelTransaccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTotal)
                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanelImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelImagen.setToolTipText("");
        jPanelImagen.setFocusable(false);

        jlbImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/índiceNuevo.png"))); // NOI18N
        jlbImagen.setFocusable(false);

        javax.swing.GroupLayout jPanelImagenLayout = new javax.swing.GroupLayout(jPanelImagen);
        jPanelImagen.setLayout(jPanelImagenLayout);
        jPanelImagenLayout.setHorizontalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanelImagenLayout.setVerticalGroup(
            jPanelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 212, Short.MAX_VALUE)
        );

        jPanelTitulo3.setBackground(java.awt.SystemColor.activeCaption);
        jPanelTitulo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("REGISTRO DE ENTRADAS Y SALIDAS EN KARDEX");
        jLabel4.setFocusable(false);

        javax.swing.GroupLayout jPanelTitulo3Layout = new javax.swing.GroupLayout(jPanelTitulo3);
        jPanelTitulo3.setLayout(jPanelTitulo3Layout);
        jPanelTitulo3Layout.setHorizontalGroup(
            jPanelTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanelTitulo3Layout.setVerticalGroup(
            jPanelTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTransaccionesLayout = new javax.swing.GroupLayout(jPanelTransacciones);
        jPanelTransacciones.setLayout(jPanelTransaccionesLayout);
        jPanelTransaccionesLayout.setHorizontalGroup(
            jPanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelTransaccionesLayout.createSequentialGroup()
                        .addComponent(jPanelTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelFechaYFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelTransaccionesLayout.setVerticalGroup(
            jPanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelTransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelTransaccionesLayout.createSequentialGroup()
                        .addComponent(jPanelFechaYFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelTransaccion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPestanas.addTab("Transacciones", jPanelTransacciones);

        jPanelTitulo1.setBackground(java.awt.SystemColor.activeCaption);
        jPanelTitulo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GESTION DE REPORTES DE INVENTARIO");

        javax.swing.GroupLayout jPanelTitulo1Layout = new javax.swing.GroupLayout(jPanelTitulo1);
        jPanelTitulo1.setLayout(jPanelTitulo1Layout);
        jPanelTitulo1Layout.setHorizontalGroup(
            jPanelTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanelTitulo1Layout.setVerticalGroup(
            jPanelTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitulo1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reporte General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(4, 99));

        btnReporteGeneral.setBackground(new java.awt.Color(176, 179, 50));
        btnReporteGeneral.setText("Generar reporte");
        btnReporteGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel12.setText("Este reporte muestra toda la actividad de Entradas y ");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel13.setText("Salidas en relacion con las Facturas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnReporteGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reporte Entradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(589, 99));

        btnReporteEntradas.setBackground(new java.awt.Color(176, 179, 50));
        btnReporteEntradas.setText("Generar reporte");
        btnReporteEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteEntradasActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel10.setText("con las Entradas realizadas");

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel11.setText("Este reporte muestra las facturas y saldos en relacion ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporteEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnReporteEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Reporte Salidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 14))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(4, 99));

        btnReporteSalidas.setBackground(new java.awt.Color(176, 176, 50));
        btnReporteSalidas.setText("Generar reporte");
        btnReporteSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSalidasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("Este reporte muestra las facturas y saldos en relacion ");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setText("con las Salidas realizadas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnReporteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelReportesLayout = new javax.swing.GroupLayout(jPanelReportes);
        jPanelReportes.setLayout(jPanelReportesLayout);
        jPanelReportesLayout.setHorizontalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelReportesLayout.setVerticalGroup(
            jPanelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPestanas.addTab("Reportes", jPanelReportes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPestanas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Eventos **********
    private void jcbTipoMovimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTipoMovimientoItemStateChanged
        if (evt.getItem().equals("devolucion Compra") || evt.getItem().equals("devolucion Venta")) {
            jlbRefOtraFactura.setEnabled(true);
            jtfRerOtraFactura.setEnabled(true);
            jtfRerOtraFactura.setEditable(true);
            jtfPrecioUnidad.setEditable(false);
            jtfPrecioUnidad.setFocusable(false);
            jtfCantidad.setEditable(false);
            jtfCantidad.setFocusable(false);
        } else {
            jlbRefOtraFactura.setEnabled(false);
            jtfRerOtraFactura.setEnabled(false);
            jtfRerOtraFactura.setEditable(false);
            jtfPrecioUnidad.setEditable(true);
            jtfPrecioUnidad.setFocusable(true);
            jtfCantidad.setEditable(true);
            jtfCantidad.setFocusable(true);
        }
        settearCampos();
    }//GEN-LAST:event_jcbTipoMovimientoItemStateChanged

    private void jtfRerOtraFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfRerOtraFacturaActionPerformed
        validarCamposInteger(jlbRefOtraFactura, jtfRerOtraFactura);
    }//GEN-LAST:event_jtfRerOtraFacturaActionPerformed
    private void jtfRerOtraFacturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfRerOtraFacturaFocusLost
        boolean esValido = validarCamposInteger(jlbRefOtraFactura, jtfRerOtraFactura);
        if (esValido) {
            System.out.println("inserto factura a buscar...");
            Double res = mainControl.getPrecioUnidad(Integer.parseInt(jtfRerOtraFactura.getText()), jcbTipoMovimiento.getSelectedItem().toString());
            if (res == 0) {
                jtfPrecioUnidad.setText("");

            } else {
                jtfPrecioUnidad.setText("" + res);
                jtfCantidad.setEditable(true);
                jtfCantidad.setFocusable(true);
            }
        }
    }//GEN-LAST:event_jtfRerOtraFacturaFocusLost
    private void jtfRerOtraFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfRerOtraFacturaKeyReleased
        validarCamposInteger(jlbRefOtraFactura, jtfRerOtraFactura);
    }//GEN-LAST:event_jtfRerOtraFacturaKeyReleased
    private void jtfRerOtraFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfRerOtraFacturaKeyTyped
        if (jtfRerOtraFactura.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfRerOtraFacturaKeyTyped

    private void jtfPrecioUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioUnidadActionPerformed
        validarCamposDouble(jlbPresioUnidad, jtfPrecioUnidad);
    }//GEN-LAST:event_jtfPrecioUnidadActionPerformed
    private void jtfPrecioUnidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPrecioUnidadFocusLost
        validarCamposDouble(jlbPresioUnidad, jtfPrecioUnidad);
        totalizar();

    }//GEN-LAST:event_jtfPrecioUnidadFocusLost
    private void jtfPrecioUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecioUnidadKeyReleased
        validarCamposDouble(jlbPresioUnidad, jtfPrecioUnidad);
    }//GEN-LAST:event_jtfPrecioUnidadKeyReleased

    private void jtfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCantidadActionPerformed
        validarCamposInteger(jlbCantidad, jtfCantidad);
    }//GEN-LAST:event_jtfCantidadActionPerformed
    private void jtfCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCantidadFocusLost
        validarCamposInteger(jlbCantidad, jtfCantidad);
        totalizar();
    }//GEN-LAST:event_jtfCantidadFocusLost
    private void jtfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCantidadKeyReleased
        validarCamposInteger(jlbCantidad, jtfCantidad);
    }//GEN-LAST:event_jtfCantidadKeyReleased

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!"".equals(jtfCantidad.getText()) && !"".equals(jtfPrecioUnidad.getText()) && !"".equals(jtfTotal.getText())) {
            guaradarMovimiento();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor diligencie todas las casillas primero",
                    "Información", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jtfTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTotalFocusGained
        totalizar();
    }//GEN-LAST:event_jtfTotalFocusGained

    private void btnReporteGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralActionPerformed
        ventanaReporteTabla = new VentanaReporteTabla(mainControl.imprimirReporteGeneral(), "general");
        ventanaReporteTabla.setVisible(true);
    }//GEN-LAST:event_btnReporteGeneralActionPerformed

    private void btnReporteEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteEntradasActionPerformed
        ventanaReporteTabla = new VentanaReporteTabla(mainControl.imprimirReporteGeneral(), "entrada");
        ventanaReporteTabla.setVisible(true);
    }//GEN-LAST:event_btnReporteEntradasActionPerformed

    private void btnReporteSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSalidasActionPerformed
        ventanaReporteTabla = new VentanaReporteTabla(mainControl.imprimirReporteGeneral(), "salida");
        ventanaReporteTabla.setVisible(true);
    }//GEN-LAST:event_btnReporteSalidasActionPerformed

    //****************
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporteEntradas;
    private javax.swing.JButton btnReporteGeneral;
    private javax.swing.JButton btnReporteSalidas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelFechaYFactura;
    private javax.swing.JPanel jPanelImagen;
    private javax.swing.JPanel jPanelReportes;
    private javax.swing.JPanel jPanelTitulo1;
    private javax.swing.JPanel jPanelTitulo3;
    private javax.swing.JPanel jPanelTransaccion;
    private javax.swing.JPanel jPanelTransacciones;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPestanas;
    private javax.swing.JComboBox<String> jcbTipoMovimiento;
    private javax.swing.JLabel jlbCantidad;
    private javax.swing.JLabel jlbFecha;
    private javax.swing.JLabel jlbImagen;
    private javax.swing.JLabel jlbNumFactura;
    private javax.swing.JLabel jlbPresioUnidad;
    private javax.swing.JLabel jlbRefOtraFactura;
    private javax.swing.JLabel jlbTipoMovimiento;
    private javax.swing.JLabel jlbTotal;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfFecha;
    private javax.swing.JTextField jtfNumFactura;
    private javax.swing.JTextField jtfPrecioUnidad;
    private javax.swing.JTextField jtfRerOtraFactura;
    private javax.swing.JTextField jtfTotal;
    // End of variables declaration//GEN-END:variables
}
