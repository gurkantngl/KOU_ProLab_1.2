package mainPackage;

import javax.swing.JLabel;

public class Makas extends Nesne{
    protected int keskinlik=2;
    private double etki;
    public int getKeskinlik() {
        return keskinlik;
    }

    public Makas() {
    }

    public Makas(int dayaniklilik, int seviyePuani) {
        super(dayaniklilik, seviyePuani);
    }
    
    @Override
    public String getNesneIsım() {
    	return "Makas";
    }
    
    @Override
    public void nesnePuaniGoster(JLabel lbl1, JLabel lbl2) {
        lbl1.setText("Dayanıklılık: " + this.getDayaniklilik());
        lbl2.setText("Seviye Puanı: " + this.getSeviyePuani());
    }

    @Override
    public void etkiHesapla(Nesne nesne) {
        if(nesne.getClass().getSimpleName().equals("Tas")){
            Tas tas= (Tas)nesne;
            etki= this.keskinlik / (0.8 * tas.getKatilik());
        }else if(nesne.getClass().getSimpleName().equals("Kagit")){
            Kagit kagit= (Kagit)nesne;
            etki= this.keskinlik / (0.2 * kagit.getNufuz());
        }else if(nesne.getClass().getSimpleName().equals("AgirTas")){
            AgirTas agirtas= (AgirTas)nesne;
            etki= this.keskinlik / (0.8 * agirtas.getKatilik() * agirtas.getSicaklik());
        }else if(nesne.getClass().getSimpleName().equals("OzelKagit")){
            OzelKagit ozelkagit = (OzelKagit)nesne;
            etki = this.keskinlik / (0.2 * ozelkagit.getNufuz() * ozelkagit.getKalinlik());
        }else if(nesne.getClass().getSimpleName().equals("Makas")){
            Makas makas= (Makas)nesne;
            etki= this.keskinlik / makas.getKeskinlik();
        }else if(nesne.getClass().getSimpleName().equals("UstaMakas")){
            UstaMakas ustamakas= (UstaMakas)nesne;
            etki= this.keskinlik / (0.2 * ustamakas.getKeskinlik() * ustamakas.getHiz());
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }   
}
