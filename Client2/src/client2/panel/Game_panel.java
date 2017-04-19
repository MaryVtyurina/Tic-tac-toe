
package client2.panel;

import client2.MainForm;
import static client2.MainForm.client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Game_panel extends javax.swing.JPanel {

    private final MainForm parent;

    public static String winner = "";
    
    private void reset() {
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
    }
    
    public Game_panel(MainForm p) {
        parent = p;
        initComponents();
        reset();
        ActionListener listener = (ActionEvent e) -> {
            JButton button = (JButton)e.getSource();
            client.out.println("GAME#MOVE#"+button.getActionCommand());
        };
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton7.setOpaque(false);
        jButton7.setContentAreaFilled(false);
        jButton8.setOpaque(false);
        jButton8.setContentAreaFilled(false);
        jButton9.setOpaque(false);
        jButton9.setContentAreaFilled(false);

        jButton1.setOpaque(false);
        jButton1.setActionCommand("1#1");
        jButton2.setActionCommand("1#2");
        jButton3.setActionCommand("1#3");
        jButton4.setActionCommand("2#1");
        jButton5.setActionCommand("2#2");
        jButton6.setActionCommand("2#3");
        jButton7.setActionCommand("3#1");
        jButton8.setActionCommand("3#2");
        jButton9.setActionCommand("3#3");
        jButton1.addActionListener(listener);
        jButton2.addActionListener(listener);
        jButton3.addActionListener(listener);
        jButton4.addActionListener(listener);
        jButton5.addActionListener(listener);
        jButton6.addActionListener(listener);
        jButton7.addActionListener(listener);
        jButton8.addActionListener(listener);
        jButton9.addActionListener(listener);
        client.addListener((String message) -> {
            String[] string = message.split("#");
            if (string[0].equals("GAME")) {
                switch(string[1]) {
                    case "MOVE":
                        if (string[3].equals("1") && string[4].equals("1")) jButton1.setText(string[2]);
                        if (string[3].equals("1") && string[4].equals("2")) jButton2.setText(string[2]);
                        if (string[3].equals("1") && string[4].equals("3")) jButton3.setText(string[2]);
                        if (string[3].equals("2") && string[4].equals("1")) jButton4.setText(string[2]);
                        if (string[3].equals("2") && string[4].equals("2")) jButton5.setText(string[2]);
                        if (string[3].equals("2") && string[4].equals("3")) jButton6.setText(string[2]);
                        if (string[3].equals("3") && string[4].equals("1")) jButton7.setText(string[2]);
                        if (string[3].equals("3") && string[4].equals("2")) jButton8.setText(string[2]);
                        if (string[3].equals("3") && string[4].equals("3")) jButton9.setText(string[2]);
                        break;
                    case "VICTORY":
                        parent.setScreen(MainForm.Screen.WIN);
//                        winner = string[2];
//                        System.out.println(string[2]);
                        break;
                    case "START":
                        System.out.println("Start game and reset");
                        reset();
                        break;
                }
                
            }
        });
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        jButton7.setText("jButton7");

        jButton8.setText("jButton8");

        jButton9.setText("jButton9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
