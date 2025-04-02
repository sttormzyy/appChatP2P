/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

/**
 *
 * @author Usuario
 */
public class VentanaError extends javax.swing.JDialog {

    /**
     * Creates new form VentanaError
     */
    public VentanaError(java.awt.Frame parent, boolean modal,String error) {
        super(parent, modal);
        initComponents();
        this.textError.setText(error);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelPrincipal = new javax.swing.JPanel();
        textError = new javax.swing.JLabel();
        panelBotonCerrar = new javax.swing.JPanel();
        botonCerrar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Messenger - Advertencia !");
        setBackground(new java.awt.Color(47, 47, 47));

        panelPrincipal.setSize(380,170);
        panelPrincipal.setBackground(new java.awt.Color(47, 47, 47));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(380, 170));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(380, 170));
        panelPrincipal.setLayout(new java.awt.BorderLayout());

        textError.setBackground(new java.awt.Color(47, 47, 47));
        textError.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        textError.setForeground(new java.awt.Color(255, 255, 255));
        textError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelPrincipal.add(textError, java.awt.BorderLayout.CENTER);

        panelBotonCerrar.setBackground(new java.awt.Color(47, 47, 47));

        botonCerrar.setBackground(Colores.COLOR_BOTON);
        botonCerrar.setBackground(new java.awt.Color(30, 30, 30));
        botonCerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonCerrar.setForeground(new java.awt.Color(255, 255, 255));
        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });
        panelBotonCerrar.add(botonCerrar);

        panelPrincipal.add(panelBotonCerrar, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBotonCerrar;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JLabel textError;
    // End of variables declaration//GEN-END:variables
}
