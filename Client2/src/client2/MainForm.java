package client2;

import javax.swing.*;
import client2.panel.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainForm extends javax.swing.JFrame {

    public static Client2 client;
    
    private final JPanel screen_connect;
    private final JPanel screen_join;
    private JPanel screen_game;
    private final JPanel screen_win;
    
    private JPanel panel_current;
    
    public enum Screen {CONNECT, JOIN, GAME, WIN};
    
    public MainForm() {
        initComponents(); 
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setLocation(d.width / 2 - 255, d.height / 2 - 255);
        client  = new Client2();
        screen_connect  = new Connect_panel(this);
        screen_join = new Join_panel(this);
        screen_win = new Win_panel(this);
        setScreen(Screen.CONNECT);
    }
    
    public void setScreen(Screen screen) {
        if (panel_current!=null)
            mainPanel.remove(panel_current);
        switch(screen) {
            case CONNECT: 
                mainPanel.add(screen_connect);
                panel_current = screen_connect;
                break;
            case JOIN: 
                mainPanel.add(screen_join);
                panel_current = screen_join;
                break;
            case GAME: 
                screen_game  = new Game_panel(this);
                mainPanel.add(screen_game);
                panel_current = screen_game;
                break;
            case WIN:
                mainPanel.add(screen_win);
                panel_current = screen_win;
                break;
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setBounds(new java.awt.Rectangle(0, 23, 140, 280));
        setMinimumSize(new java.awt.Dimension(440, 380));
        getContentPane().setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(mainPanel, "");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
