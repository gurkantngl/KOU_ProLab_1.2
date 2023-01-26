package mainPackage;

import java.util.Random;

public class Bilgisayar extends Oyuncu{
    Random rand= new Random();
    Nesne[] objects= {new Tas(), new Kagit(), new Makas()};
    
    public Bilgisayar() {
        for (int i = 0; i<5; i++) {
            int randomIndex = rand.nextInt(objects.length);
            nesneList.add(objects[randomIndex]);
        }
    }

    public Bilgisayar(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }
    @Override
    public Nesne nesneSec(int index){
        return nesneList.get(index);
    }
    
}
