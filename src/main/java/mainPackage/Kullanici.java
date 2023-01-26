package mainPackage;

import java.util.Random;

public class Kullanici extends Oyuncu{
    Random rand= new Random();
    
    public Kullanici() {
    	
    }

    public Kullanici(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }
    
    @Override
    public  Nesne nesneSec(int index){
        return nesneList.get(index);
    }
}