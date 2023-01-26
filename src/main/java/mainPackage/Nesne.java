package mainPackage;

import javax.swing.JLabel;

public abstract class Nesne {
    protected double dayaniklilik=20;
    protected int seviyePuani=0;

    public Nesne() {
    }
    
    public Nesne(int dayaniklilik, int seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
    }

    public abstract String getNesneIsım();
    public double getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik (double dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public int getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }
    
    public abstract void nesnePuaniGoster(JLabel lbl1, JLabel lbl2);
    
    public abstract void etkiHesapla(Nesne nesne);
    
    public abstract void durumGuncelle(Nesne nesne);
}
