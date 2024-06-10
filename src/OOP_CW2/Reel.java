package OOP_CW2;

import java.util.*;
import javax.swing.*;

public class Reel {

    //erstellt eine ArrayList von Symbol Objekten
    private final ArrayList<Symbol> symbol = new ArrayList<>();

    //Lädt alle Symbole in den Reel Constructor, so dass jede Reel all diese Symbole enthalten kann
    public Reel()
    {
            Symbol bell = new Symbol();
            bell.setImage(new ImageIcon("src/OOP_CW2/bell.png", "Bell"));
            bell.setValue(6);
            symbol.add(bell);

            Symbol cherry = new Symbol();
            cherry.setImage(new ImageIcon("src/OOP_CW2/cherry.png", "Cherry"));
            cherry.setValue(2);
            symbol.add(cherry);

            Symbol lemon = new Symbol();
            lemon.setImage(new ImageIcon("src/OOP_CW2/lemon.png", "Lemon"));
            lemon.setValue(3);
            symbol.add(lemon);

            Symbol plum = new Symbol();
            plum.setImage(new ImageIcon("src/OOP_CW2/plum.png", "Plum"));
            plum.setValue(4);
            symbol.add(plum);

            Symbol redSeven = new Symbol();
            redSeven.setImage(new ImageIcon("src/OOP_CW2/redSeven.png", "Seven"));
            redSeven.setValue(7);
            symbol.add(redSeven);

            Symbol watermelon = new Symbol();
            watermelon.setImage(new ImageIcon("src/OOP_CW2/watermelon.png", "Watermelon"));
            watermelon.setValue(5);
            symbol.add(watermelon);

            //sorgt dafür, dass die Reihenfolge der Symbole auf den Reels jedes Mal neu gemischt wird, wenn eine Reel erstellt wird.
            Collections.shuffle(symbol);
        }

    public void setSymbol(Symbol symbol) {
        if(symbol != null) {
            this.symbol.add(symbol);
        }
    }

    //wenn die Spin-Methode aufgerufen wird, wird die gesamte Instanz eines Symbols ArrayList zurückgegeben
    public ArrayList<Symbol> spin() {
        return symbol;
    }

}
