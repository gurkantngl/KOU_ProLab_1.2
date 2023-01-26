package mainPackage;

import javax.swing.JLabel;

public class UstaMakas extends Makas{
    private int hiz=2;
    private double etki;

    public int getHiz() {
        return hiz;
    }

    public UstaMakas() {
        keskinlik= super.keskinlik;
        dayaniklilik= super.dayaniklilik;
        seviyePuani= super.seviyePuani;
    }

    public UstaMakas(int dayaniklilik, int seviyePuani) {
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
            etki= (this.getKeskinlik() * this.getHiz()) / (0.8 * tas.getKatilik());
        }else if(nesne.getClass().getSimpleName().equals("AgirTas")){
            AgirTas agirtas= (AgirTas)nesne;
            etki= (this.getKeskinlik() * this.getHiz()) / (0.8 * agirtas.getKatilik() * agirtas.getSicaklik());
        }else if(nesne.getClass().getSimpleName().equals("Kagit")){
            Kagit kagit= (Kagit)nesne;
            etki= (this.getKeskinlik() * this.getHiz()) / (0.2 * kagit.getNufuz());
        }else if(nesne.getClass().getSimpleName().equals("OzelKagit")){
            OzelKagit ozelkagit= (OzelKagit)nesne;
            etki= (this.getKeskinlik() * this.getHiz()) / (0.2 * ozelkagit.getNufuz() * ozelkagit.getKalinlik());
        }else if(nesne.getClass().getSimpleName().equals("Makas")){
            Makas makas= (Makas)nesne;
            etki= (this.getKeskinlik() * this.getHiz()) / (0.2 * makas.getKeskinlik());
        }else if(nesne.getClass().getSimpleName().equals("UstaMakas")){
            UstaMakas ustamakas= (UstaMakas)nesne;
            etki= (this.getKeskinlik() * this.getHiz()) / ustamakas.getKeskinlik() * ustamakas.getHiz();
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }
    @Override
    public String getNesneIsım(){
        return "Usta Makas";
    }
}
