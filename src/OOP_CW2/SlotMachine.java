package OOP_CW2;

import java.util.*;

public class SlotMachine {

    private int remCredit = 10;
    private int currentBet = 0;

    //Ein Reel Array, welches 3 Reels enthalten würde
    private Reel[] reel = new Reel[3];

    //Stellt sicher, dass beim Laden des Konstruktors 3 neue Reels
    public SlotMachine() {
        for(int x = 0 ; x < 3 ; x++) {
            reel[x] = new Reel();
        }
    }

    public int getRemCredit() {
        return remCredit;
    }

    public void setRemCredit(int remCredit) {
        this.remCredit = remCredit;
    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    //Wirft die entsprechende Reel entsprechend ihrer Nummer zurück und dreht sie
    public ArrayList<Symbol> getReel(int reelNo) {
        return reel[reelNo].spin();
    }

    public void addCoin(){
        remCredit+=1;
    }

    public void betOne(){
        if(remCredit>0){
            currentBet+=1;
            remCredit-=1;
        }else{
            throw new RuntimeException("Nicht genug Coins");
        }
    }

    public void betMax(){
        if(remCredit>2){
           currentBet+=3;
            remCredit-=3;
        }else{
            throw new RuntimeException("Nicht genug Coins");
        }
    }


}

