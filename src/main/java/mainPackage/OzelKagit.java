package mainPackage;

import javax.swing.JLabel;

public class OzelKagit extends Kagit {
    private int kalinlik=2;
    private static double etki;

    public int getKalinlik() {
        return kalinlik;
    }

    public OzelKagit() {
        dayaniklilik= super.dayaniklilik;
        seviyePuani= super.seviyePuani;
        nufuz= super.nufuz;
    }

    public OzelKagit(int dayaniklilik, int seviyePuani) {
        super(dayaniklilik, seviyePuani);
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
            etki= (this.getKalinlik()*this.getNufuz()) / (0.2 * tas.getKatilik());
        }else if(nesne.getClass().getSimpleName().equals("Kagit")){
            Kagit kagit= (Kagit)nesne;
            etki= (this.getKalinlik()*this.getNufuz()) / (0.2 * kagit.getNufuz());
        }else if(nesne.getClass().getSimpleName().equals("Makas")){
            Makas makas= (Makas)nesne;
            etki= (this.getKalinlik() * this.getNufuz()) / (0.8 * makas.getKeskinlik());
        }else if((nesne.getClass().getSimpleName().equals("AgirTas"))){
            AgirTas agirtas= (AgirTas)nesne;
            etki= (this.getKalinlik() * this.getNufuz()) / (0.2 * agirtas.getKatilik() * agirtas.getSicaklik());
        }else if(nesne.getClass().getSimpleName().equals("OzelKagit")){
            OzelKagit ozelkagit= (OzelKagit)nesne;
            etki= (this.getKalinlik() * this.getNufuz()) / ozelkagit.getKalinlik() * ozelkagit.getNufuz();
        }else if(nesne.getClass().getSimpleName().equals("UstaMakas")){
            UstaMakas ustamakas= (UstaMakas)nesne;
            etki= (this.getKalinlik() * this.getNufuz()) / (0.8 * ustamakas.getKeskinlik() * ustamakas.getHiz());
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }
    @Override
    public String getNesneIsım(){
        return "Özel Kağıt";
    }
}
