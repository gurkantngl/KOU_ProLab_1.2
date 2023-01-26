package mainPackage;

import javax.swing.JLabel;

public class Tas extends Nesne {
    protected int katilik = 2;
    private static double etki;

    public Tas() {

    }

    public Tas(int dayaniklilik, int seviyePuani) {
        super(dayaniklilik, seviyePuani);
    }

    @Override
    public String getNesneIsım() {
        return "Taş";
    }

    public int getKatilik() {
        return katilik;
    }

    @Override
    public void nesnePuaniGoster(JLabel lbl1, JLabel lbl2) {
        lbl1.setText("Dayanıklılık: " + this.getDayaniklilik());
        lbl2.setText("Seviye Puanı: " + this.getSeviyePuani());
    }

    @Override
    public void etkiHesapla(Nesne nesne) {
        if (nesne.getClass().getSimpleName().equals("Kagit")) {
            Kagit kagit = (Kagit) nesne;
            etki = this.katilik / (0.8 * kagit.getNufuz());
        } else if (nesne.getClass().getSimpleName().equals("Makas")) {
            Makas makas = (Makas) nesne;
            etki = this.katilik / (0.2 * makas.getKeskinlik());
        } else if (nesne.getClass().getSimpleName().equals("UstaMakas")) {
            UstaMakas ustaMakas = (UstaMakas) nesne;
            etki = this.katilik / (0.2 * ustaMakas.getKeskinlik() * ustaMakas.getHiz());
        } else if (nesne.getClass().getSimpleName().equals("OzelKagit")) {
            OzelKagit ozelKagit = (OzelKagit) nesne;
            etki = this.katilik / (0.8 * ozelKagit.getNufuz() * ozelKagit.getKalinlik());
        } else if (nesne.getClass().getSimpleName().equals("Tas")) {
            Tas tas = (Tas) nesne;
            etki = this.katilik / tas.getKatilik();
        } else if (nesne.getClass().getSimpleName().equals("AgirTas")) {
            AgirTas agirTas = (AgirTas) nesne;
            etki = this.katilik / (0.2 * agirTas.getKatilik() * agirTas.getSicaklik());
        }
    }

    @Override
    public void durumGuncelle(Nesne nesne) {
        nesne.setDayaniklilik(nesne.getDayaniklilik() - etki);
    }
}
