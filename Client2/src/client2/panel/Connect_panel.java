package client2.panel;
import client2.MainForm;
import static client2.MainForm.client;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Connect_panel extends javax.swing.JPanel {

    private final MainForm parent;
    
    public Connect_panel(MainForm p) {
        initComponents();        
        this.parent = p;
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setLocation(d.width / 2 - 255, d.height / 2 - 255);
        Connect_button.setVisible(true);
        System.out.println("connect panel on");
        client.addListener((String message) -> {
            String[] string = message.split("#");
            switch (string[0]) {
                case "CLIENT":
                    switch (string[1]) {
                        case "CONNECTED":
                            parent.setScreen(MainForm.Screen.JOIN);
                            break;
                        case "DISCONNECTED":
                            error.setText("Не удалось подключиться к серверу.");
                    }
                    break;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        error = new javax.swing.JLabel();
        Connect_button = new javax.swing.JButton();
        InfoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 153, 255));

        Connect_button.setBackground(new java.awt.Color(102, 0, 204));
        Connect_button.setForeground(new java.awt.Color(51, 0, 102));
        Connect_button.setText("Connect");
        Connect_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connect_buttonActionPerformed(evt);
            }
        });

        InfoLabel.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(error))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(InfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(Connect_button)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(InfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Connect_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(error)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Connect_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connect_buttonActionPerformed
        if (client.config("127.0.0.1", 8080))
                client.start();
    }//GEN-LAST:event_Connect_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connect_button;
    private javax.swing.JLabel InfoLabel;
    private javax.swing.JLabel error;
    // End of variables declaration//GEN-END:variables
}
