package OOP_CW2;

import javax.swing.*;
import java.util.*;

public class ThreadController extends Thread{

    public static ArrayList<ArrayList<Symbol>> reelImages;
    private SlotMachine slotMachine;
    private static int index;

    public static int getIndex() {
        return index;
    }

    //Erstellen von 3 Reels mit zufälliger Symbolreihenfolge
    public void threadSpinMethod(){
        this.slotMachine = new SlotMachine();
        reelImages = new ArrayList<ArrayList<Symbol>>();

                for(int x = 0 ; x < 3 ; x++) {
                    reelImages.add(slotMachine.getReel(x));
                }

        ThreadController thread = new ThreadController();
                thread.start();
    }

    //Animieren des Drehvorgangs mit Threads
    public void run(){
        while(GraphicalUserInterface.flag){
            GraphicalUserInterface.reel1.setIcon(reelImages.get(0).get(index).getImage());
            GraphicalUserInterface.reel2.setIcon(reelImages.get(1).get(index).getImage());
            GraphicalUserInterface.reel3.setIcon(reelImages.get(2).get(index).getImage());

            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            index++;
            if(index>5){
                index=0;
            }
        }
    }

}
