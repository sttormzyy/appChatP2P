/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;


/**
 *
 * @author Usuario
 */
public class MensajeVista extends javax.swing.JPanel {
    
    private String msj;
    private AutoSizeTextArea txt;  // Usamos AutoSizeTextArea
    private JPanel txtPanel;
    private static final int ANCHO_FIJO = 300; // Ancho fijo para el JTextArea

    public MensajeVista(String mensaje,boolean esMio) {
        msj = mensaje;
        setBackground(new Color(47,52,52 ));
        // Crear un AutoResizeTextArea con el mensaje
        txt = new AutoSizeTextArea(msj, esMio);  // Usamos la clase personalizada

        // Crear un panel para contener el JTextArea
        txtPanel = new JPanel();
        txtPanel.setBackground(new Color(47,52,52 ));
        txtPanel.setLayout(new BoxLayout(txtPanel, BoxLayout.Y_AXIS)); // Usar BoxLayout en el eje Y
        txtPanel.add(txt); // Añadir el JTextArea al panel
        txtPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Márgenes arriba y abajo (10px)

        // Configurar el panel principal con márgenes a la izquierda y esMio
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15)); // Márgenes izquierdo y derecho (15px)

        // Ajustar el tamaño del panel principal según el contenido del JTextArea
        int panelHeight = txt.getPreferredSize().height + 20;  // Margen adicional de 20px
        setPreferredSize(new Dimension(ANCHO_FIJO + 30, panelHeight)); // Ajustar el ancho y alto del panel

        // Crear un contenedor para centrar el mensaje
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBackground(new Color(47,52,52 ));
        panelContenedor.setLayout(new GridBagLayout()); // Usar GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelContenedor.add(txtPanel, gbc);

        // Si "esMio" es true, se debe alinear el mensaje a la esMio
        if (esMio) {
            add(panelContenedor, BorderLayout.EAST); // Alineamos a la esMio
        } else {
            add(panelContenedor, BorderLayout.WEST); // Alineamos a la izquierda
        }

        // Revalidar y repintar el panel para aplicar los cambios
        revalidate();
        repaint();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 102, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setAlignmentX(0.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
