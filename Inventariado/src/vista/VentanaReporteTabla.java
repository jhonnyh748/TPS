/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Conexion;
import modelo.ReporteGeneral;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ~Antares~
 */
public class VentanaReporteTabla extends javax.swing.JFrame {

    /**
     * Creates new form ReporteTabla
     */
    private ReporteGeneral reporteGeneral;
    private String nombreReporteFilePDF = "";

    private DefaultTableModel modeloTabla;
    private TableColumnModel modeloColumna;
    private ArrayList<ReporteGeneral> reporteGeneralMatriz;

    public VentanaReporteTabla(ArrayList<ReporteGeneral> reporteGeneralX, String tipoReporte) {
        reporteGeneralMatriz = reporteGeneralX;
        initComponents();
        this.setLocationRelativeTo(null);

        switch (tipoReporte) {
            case "general":
                reporteGeneral();
                break;
            case "entrada":
                reporteEntradas();
                jlbInfoPrincipal.setText("Vista de ENTRADAS en inventario en formato KARDEX");
                break;
            case "salida":
                reporteSalidas();
                jlbInfoPrincipal.setText("Vista de SALIDAS en inventario en formato KARDEX");
                break;
        }
    }

    private void reporteGeneral() {
        nombreReporteFilePDF = "reporteGeneral.jasper";
        DecimalFormat df = new DecimalFormat("#.00");

        Object columnasGeneral[] = {"NºFACTURA", "FECHA", "TRANSACCION", "REF. OTRA FACTURA", "CANTIDAD", "COSTO UNIDAD",
            "CANTIDAD ENTRADA", "COSTO UNIDAD ENTRADA", "COSTO TOTAL ENTRADA",
            "CANTIDAD SALIDA", "COSTO UNIDAD SALIDA", "COSTO TOTAL SALIDA",
            "CANTIDAD EXISTENCIAS", "COSTO TOTAL", "COSTO UNITARIO PROMEDIO"};

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(columnasGeneral);

        modeloTabla.setRowCount(reporteGeneralMatriz.size());

        for (int i = 0; i < reporteGeneralMatriz.size(); i++) {
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getNumFactura(), i, 0);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getFeha(), i, 1);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getTipoMovimiento(), i, 2);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getRefOtraFactura(), i, 3);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesFactura(), i, 4);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCostoUnitarioFactura(), i, 5);

            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesEntrada(), i, 6);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoUnitarioEntrada()), i, 7);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoTotalEntrada()), i, 8);

            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesSalida(), i, 9);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoUnitarioSalida()), i, 10);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoTotalSalida()), i, 11);

            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadExistencias(), i, 12);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoTotalSaldo()), i, 13);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoUnitarioPromedio()), i, 14);

        }

        jtbTablaPrincipal.setModel(modeloTabla);

        modeloColumna = jtbTablaPrincipal.getColumnModel();

        modeloColumna.getColumn(0).setPreferredWidth(80);
        modeloColumna.getColumn(1).setPreferredWidth(80);
        modeloColumna.getColumn(2).setPreferredWidth(105);
        modeloColumna.getColumn(3).setPreferredWidth(135);
        modeloColumna.getColumn(4).setPreferredWidth(75);
        modeloColumna.getColumn(5).setPreferredWidth(110);
        modeloColumna.getColumn(6).setPreferredWidth(140);
        modeloColumna.getColumn(7).setPreferredWidth(163);
        modeloColumna.getColumn(8).setPreferredWidth(160);
        modeloColumna.getColumn(9).setPreferredWidth(120);
        modeloColumna.getColumn(10).setPreferredWidth(150);
        modeloColumna.getColumn(11).setPreferredWidth(140);
        modeloColumna.getColumn(12).setPreferredWidth(153);
        modeloColumna.getColumn(13).setPreferredWidth(100);
        modeloColumna.getColumn(14).setPreferredWidth(185);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);

        for (int i = 0; i < 15; i++) {
            jtbTablaPrincipal.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }

        modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEADING);

        jtbTablaPrincipal.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }

    private void reporteEntradas() {
        nombreReporteFilePDF = "reporteEntradas.jasper";
        DecimalFormat df = new DecimalFormat("#.00");

        Object columnasGeneral[] = {"NºFACTURA", "FECHA", "TRANSACCION", "REF. OTRA FACTURA", "CANTIDAD", "COSTO UNIDAD",
            "CANTIDAD ENTRADA", "COSTO UNIDAD ENTRADA", "COSTO TOTAL ENTRADA"};

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(columnasGeneral);

        modeloTabla.setRowCount(reporteGeneralMatriz.size());

        for (int i = 0; i < reporteGeneralMatriz.size(); i++) {
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getNumFactura(), i, 0);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getFeha(), i, 1);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getTipoMovimiento(), i, 2);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getRefOtraFactura(), i, 3);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesFactura(), i, 4);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCostoUnitarioFactura(), i, 5);

            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesEntrada(), i, 6);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoUnitarioEntrada()), i, 7);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoTotalEntrada()), i, 8);

        }

        jtbTablaPrincipal.setModel(modeloTabla);

        modeloColumna = jtbTablaPrincipal.getColumnModel();

        modeloColumna.getColumn(0).setPreferredWidth(80);
        modeloColumna.getColumn(1).setPreferredWidth(80);
        modeloColumna.getColumn(2).setPreferredWidth(105);
        modeloColumna.getColumn(3).setPreferredWidth(135);
        modeloColumna.getColumn(4).setPreferredWidth(75);
        modeloColumna.getColumn(5).setPreferredWidth(110);
        modeloColumna.getColumn(6).setPreferredWidth(140);
        modeloColumna.getColumn(7).setPreferredWidth(163);
        modeloColumna.getColumn(8).setPreferredWidth(160);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);

        for (int i = 0; i < 9; i++) {
            jtbTablaPrincipal.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }

        modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEADING);

        jtbTablaPrincipal.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }

    private void reporteSalidas() {
        nombreReporteFilePDF = "reporteSalidas.jasper";
        DecimalFormat df = new DecimalFormat("#.00");

        Object columnasGeneral[] = {"NºFACTURA", "FECHA", "TRANSACCION", "REF. OTRA FACTURA", "CANTIDAD", "COSTO UNIDAD",
            "CANTIDAD SALIDA", "COSTO UNIDAD SALIDA", "COSTO TOTAL SALIDA"};

        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(columnasGeneral);

        modeloTabla.setRowCount(reporteGeneralMatriz.size());

        for (int i = 0; i < reporteGeneralMatriz.size(); i++) {
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getNumFactura(), i, 0);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getFeha(), i, 1);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getTipoMovimiento(), i, 2);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getRefOtraFactura(), i, 3);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesFactura(), i, 4);
            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCostoUnitarioFactura(), i, 5);

            modeloTabla.setValueAt(reporteGeneralMatriz.get(i).getCantidadUnidadesSalida(), i, 6);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoUnitarioSalida()), i, 7);
            modeloTabla.setValueAt(df.format(reporteGeneralMatriz.get(i).getCostoTotalSalida()), i, 8);

        }

        jtbTablaPrincipal.setModel(modeloTabla);

        modeloColumna = jtbTablaPrincipal.getColumnModel();

        modeloColumna.getColumn(0).setPreferredWidth(80);
        modeloColumna.getColumn(1).setPreferredWidth(80);
        modeloColumna.getColumn(2).setPreferredWidth(105);
        modeloColumna.getColumn(3).setPreferredWidth(135);
        modeloColumna.getColumn(4).setPreferredWidth(75);
        modeloColumna.getColumn(5).setPreferredWidth(110);
        modeloColumna.getColumn(6).setPreferredWidth(120);
        modeloColumna.getColumn(7).setPreferredWidth(150);
        modeloColumna.getColumn(8).setPreferredWidth(140);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.RIGHT);

        for (int i = 0; i < 9; i++) {
            jtbTablaPrincipal.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }

        modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.LEADING);

        jtbTablaPrincipal.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPrincipal = new javax.swing.JScrollPane();
        jtbTablaPrincipal = new javax.swing.JTable();
        jPanelInfo = new javax.swing.JPanel();
        jlbInfoPrincipal = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("VentanaReportes"); // NOI18N
        setResizable(false);

        jtbTablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbTablaPrincipal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbTablaPrincipal.setColumnSelectionAllowed(true);
        jScrollPrincipal.setViewportView(jtbTablaPrincipal);
        jtbTablaPrincipal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanelInfo.setBackground(java.awt.SystemColor.activeCaption);
        jPanelInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jlbInfoPrincipal.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jlbInfoPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbInfoPrincipal.setText("Vista general de inventario en formato KARDEX");

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlbInfoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlbInfoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnCerrar.setBackground(new java.awt.Color(176, 179, 50));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(176, 179, 50));
        btnPDF.setText("Exportar a PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPrincipal)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexionInicial();

            String ruta = "src\\reportes\\" + nombreReporteFilePDF;
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            JasperPrint jPrint = JasperFillManager.fillReport(reporte, null, con);
            JasperViewer vistaReporte = new JasperViewer(jPrint, false);

            vistaReporte.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            vistaReporte.setVisible(true);
        } catch (Exception e) {
            System.err.println("error en PDF" + e);
        }
        this.dispose();
    }//GEN-LAST:event_btnPDFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnPDF;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JScrollPane jScrollPrincipal;
    private javax.swing.JLabel jlbInfoPrincipal;
    private javax.swing.JTable jtbTablaPrincipal;
    // End of variables declaration//GEN-END:variables
}
