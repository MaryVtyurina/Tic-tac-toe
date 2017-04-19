package client2.panel;

import client2.MainForm;
import static client2.MainForm.client;
import java.awt.Color;
import java.io.IOException;

public class ScreenConnect extends javax.swing.JPanel {

    private final MainForm parent;
    
    public ScreenConnect(MainForm parent) {
        initComponents();
        this.parent = parent;
        client.addListener((String message) -> {
            String[] string = message.split("#");
            switch (string[0]) {
                case "CLIENT":
                    switch (string[1]) {
                        case "CONNECTED":
                            parent.setScreen(MainForm.Screen.JOIN);
                            break;
                        case "DISCONNECTED":
                            label_error.setText("Не удалось подключиться к серверу.");
                    }
                    break;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_address = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        text_port = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        button_join = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        label_error = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(640, 480));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jPanel7.setMinimumSize(new java.awt.Dimension(222, 180));
        jPanel7.setLayout(new java.awt.CardLayout());

        jPanel9.setBackground(new Color(0,0,0,0));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel4.setBackground(new java.awt.Color(51, 255, 51));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GameNET");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Привет!");
        jPanel9.add(jLabel5);

        jPanel7.add(jPanel9, "card3");

        add(jPanel7);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 11, 11));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2000000000));
        jPanel1.setMinimumSize(new java.awt.Dimension(88, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(228, 300));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new Color(0,0,0,0));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new Color(0,0,0,0));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Адрес");
        jPanel3.add(jLabel1);

        text_address.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        text_address.setText("127.0.0.1");
        text_address.setBorder(null);
        text_address.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel3.add(text_address);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 11));
        jPanel3.add(jSeparator2);

        jPanel2.add(jPanel3);

        jPanel8.setBackground(new Color(0,0,0,0));
        jPanel8.setMaximumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8);

        jPanel4.setBackground(new Color(0,0,0,0));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Порт");
        jPanel4.add(jLabel2);

        text_port.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        text_port.setText("8080");
        text_port.setBorder(null);
        text_port.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        jPanel4.add(text_port);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 11));
        jPanel4.add(jSeparator1);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2);

        jPanel6.setBackground(new Color(0,0,0,0));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jPanel6);

        jPanel11.setBackground(new Color(0,0,0,0));
        jPanel11.setMaximumSize(new java.awt.Dimension(10, 30));
        jPanel11.setMinimumSize(new java.awt.Dimension(10, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        button_join.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        button_join.setText("Подключиться");
        button_join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_joinActionPerformed(evt);
            }
        });
        jPanel12.add(button_join);

        jPanel1.add(jPanel12);

        jPanel13.setBackground(new Color(0,0,0,0));
        jPanel13.setMaximumSize(new java.awt.Dimension(10, 30));
        jPanel13.setMinimumSize(new java.awt.Dimension(10, 30));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13);

        jPanel5.setBackground(new Color(0,0,0,0));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        label_error.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        label_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel5.add(label_error);

        jPanel1.add(jPanel5);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void button_joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_joinActionPerformed
        try {
            if (client.config(text_address.getText(), Integer.valueOf(text_port.getText())))
                client.start();
        } catch (Exception ex) {}
    }//GEN-LAST:event_button_joinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_join;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_error;
    private javax.swing.JTextField text_address;
    private javax.swing.JTextField text_port;
    // End of variables declaration//GEN-END:variables
}
