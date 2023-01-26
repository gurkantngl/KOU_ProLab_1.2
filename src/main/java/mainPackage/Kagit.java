package mainPackage;

import javax.swing.JLabel;

public class Kagit extends Nesne {
    protected int nufuz= 2;
    private double etki;
    public int getNufuz() {
        return nufuz;
    }

    public Kagit() {
    
    }

    public Kagit(int dayaniklilik, int seviyePuani) {
        super(dayaniklilik, seviyePuani);
    }
    
    @Override
    public String getNesneIsım() {
    	return "Kağıt";
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
            etki= this.getNufuz() / (0.2 * tas.getKatilik());
        }else if(nesne.getClass().getSimpleName().equals("Makas")){
            Makas makas= (Makas)nesne;
            etki= this.getNufuz() / (0.8 * makas.getKeskinlik());
        }else if(nesne.getClass().getSimpleName().equals("UstaMakas")){
            UstaMakas ustamakas= (UstaMakas)nesne;
            etki= this.getNufuz() / (0.8 * ustamakas.getKeskinlik() * ustamakas.getHiz());
        }else if(nesne.getClass().getSimpleName().equals("AgirTas")){
            AgirTas agirtas= (AgirTas)nesne;
            etki= this.getNufuz() / (0.2 * agirtas.getKatilik() * agirtas.getSicaklik());
        }else if(nesne.getClass().getSimpleName().equals("Kagit")){
            Kagit kagit= (Kagit)nesne;
            etki= this.getNufuz() / kagit.getNufuz();
        }else if(nesne.getClass().getSimpleName().equals("OzelKagit")){
            OzelKagit ozelKagit= (OzelKagit)nesne;
            etki= this.getNufuz() / (0.2 * ozelKagit.getNufuz() * ozelKagit.getKalinlik());
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }
}
