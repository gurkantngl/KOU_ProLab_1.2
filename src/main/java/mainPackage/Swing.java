package mainPackage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Swing{
    public static void main(String[] args) {
        JFrame  jf = new JFrame();
        jf.setTitle("Taş Kağıt Makas");
        jf.setSize(983,620);
        jf.setLocation(350,100);
        JTextField text1 = new JTextField(10);
        text1.setBounds(280, 10, 86, 21);
        JButton button1 = new JButton("Kullanıcı-Bilgisayar");
        button1.setBounds(376, 10, 117, 21);
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);
        
        JLabel label1 = new JLabel();
        label1.setBounds(182, 14, 98, 13);
        label1.setText("Buraya isminizi girin: ");
        label1.setForeground(Color.WHITE);

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label1.setText("Merhabalar " + text1.getText() + " programa hoş geldin");
            }
        });
        button1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent arg0){
                button1.setBackground(Color.RED);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent arg0){
                button1.setBackground(Color.DARK_GRAY);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent e){
                button1.setBackground(Color.BLACK);
            }
        });
        
        JButton button2 = new JButton("Bilgisayar-Bilgisayar");
        button2.setBounds(592, 10, 123, 21);
        button2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        button2.setBackground(Color.DARK_GRAY);
        button2.setForeground(Color.WHITE);
        button2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                button2.setBackground(Color.RED);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                button2.setBackground(Color.DARK_GRAY);
            }
        });

        JButton button4 = new JButton("Giriş");
        button4.setBounds(720, 5, 67, 31);
        button4.setBackground(Color.DARK_GRAY);
        button4.setForeground(Color.WHITE);
        button4.setFont(new Font("Calibri",Font.BOLD,18));
        button4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String isim= JOptionPane.showInputDialog(null,"Lütfen isminizi girin:","Giriş",JOptionPane.DEFAULT_OPTION);
                    JOptionPane.showMessageDialog(null,"Hoş geldin " + isim,"Hoş Geldin",JOptionPane.DEFAULT_OPTION);
        }
        });
        jf.getContentPane().setLayout(null);

        jf.getContentPane().add(label1);
        jf.getContentPane().add(text1);
        jf.getContentPane().add(button1);
        
                JButton button3 = new JButton("Oyuna Başla");
                button3.setBounds(498, 10, 89, 21);
                button3.setBackground(Color.DARK_GRAY);
                button3.setForeground(Color.WHITE);
                button3.addActionListener(new ActionListener(){
                    @SuppressWarnings("static-access")
					@Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane panelimiz = new JOptionPane();
                        panelimiz.showMessageDialog(null,"Merhabalar panele hoş geldin..");
                        
                    }
                });
                jf.getContentPane().add(button3);
        jf.getContentPane().add(button2);
        jf.getContentPane().add(button4);

        jf.getContentPane().setBackground(Color.DARK_GRAY);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setVisible(true);
    }
}
