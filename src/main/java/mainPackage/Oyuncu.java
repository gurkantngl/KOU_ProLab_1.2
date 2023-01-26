package mainPackage;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public abstract class Oyuncu {
    Random rand = new Random();
    private int oyuncuID;
    private String oyuncuAdi;
    private double skor;

    public Oyuncu(){
        oyuncuID = rand.nextInt();
    }

    public Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public double getSkor() {
        return skor;
    }

    public void setSkor(double skor) {
        this.skor = skor;
    }
    
    ArrayList <Nesne> nesneList = new ArrayList<>(); 
    
    public void skorGoster(JLabel lbl1, JLabel lbl2){
        lbl2.setText(lbl1.getText() +" Skor: " + this.getSkor());
    }
    
    public abstract Nesne nesneSec(int index);

}
