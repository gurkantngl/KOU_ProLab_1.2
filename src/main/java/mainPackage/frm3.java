package mainPackage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class frm3 {
	public static void main(String[] args) {
			JFrame frm3= new JFrame();
			
			frm3.setTitle("Taş Kağıt Makas");
	    	frm3.setSize(800,600);
	        frm3.setLocation(350,100);	        
	        frm3.getContentPane().setLayout(null);
	    	frm3.getContentPane().setBackground(Color.DARK_GRAY);
	    	frm3.setVisible(true);
	    	
	    	JLabel lblWon = new JLabel("Bilgisayar Kazandı");
	    	lblWon.setFont(new Font("Calibri",Font.BOLD,35));
	    	lblWon.setBounds(250, 260, 300, 80);
	    	lblWon.setForeground(Color.WHITE);
	    	frm3.getContentPane().add(lblWon);
	    	
	    	JLabel lblSkor1 = new JLabel();
	    	lblSkor1.setBounds(250, 350, 147, 50);
	    	lblSkor1.setText("Bilgisayar Skor: ");
	    	lblSkor1.setForeground(Color.WHITE);
	    	lblSkor1.setFont(new Font("Calibri",Font.BOLD,20));
	    	frm3.getContentPane().add(lblSkor1);
	    	
	    	JLabel lblSkor2 = new JLabel();
	    	lblSkor2.setBounds(250, 410, 157, 50);
	    	lblSkor2.setText("Kullanıcı Skor: ");
	    	lblSkor2.setForeground(Color.WHITE);
	    	lblSkor2.setFont(new Font("Calibri",Font.BOLD,20));
	    	frm3.getContentPane().add(lblSkor2);
		}
	}