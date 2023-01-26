package mainPackage;

import javax.swing.JLabel;

public class AgirTas extends Tas {
    private int sicaklik=2;
    private double etki;

    public int getSicaklik() {
        return sicaklik;
    }

    public AgirTas() {
        dayaniklilik= super.dayaniklilik;
        seviyePuani= super.seviyePuani;
        katilik= super.katilik;
    }

    public AgirTas(int dayaniklilik, int seviyePuani) {
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
            etki= (this.getKatilik()*this.getSicaklik()) / (0.2 * tas.getKatilik());
        }else if(nesne.getClass().getSimpleName().equals("AgirTas")){
            AgirTas agirtas= (AgirTas)nesne;
            etki= (this.getKatilik()*this.getSicaklik()) / agirtas.getKatilik() * agirtas.getSicaklik();
        }else if(nesne.getClass().getSimpleName().equals("Kagit")){
            Kagit kagit= (Kagit)nesne;
            etki= (this.getKatilik()*this.getSicaklik()) / (0.8 * kagit.getNufuz());
        }else if(nesne.getClass().getSimpleName().equals("OzelKagit")){
            OzelKagit ozelkagit= (OzelKagit)nesne;
            etki= (this.getKatilik()*this.getSicaklik() / (0.8 * ozelkagit.getNufuz() * ozelkagit.getKalinlik()));
        }else if(nesne.getClass().getSimpleName().equals("Makas")){
            Makas makas= (Makas)nesne;
            etki= (this.getKatilik()*this.getSicaklik() / (0.2 * makas.getKeskinlik()));
        }else if(nesne.getClass().getSimpleName().equals("UstaMakas")){
            UstaMakas ustamakas= (UstaMakas)nesne;
            etki= (this.getKatilik()*this.getSicaklik() / (0.2 * ustamakas.getKeskinlik() * ustamakas.getHiz()));
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }
    public void setSicaklik(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    @Override
    public String getNesneIsım(){
        return "Ağır Taş";
    }
    
}
