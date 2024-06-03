package OOP_CW2;

import javax.swing.*;

public class Symbol implements ISymbol {

    private ImageIcon image;
    private int value;

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

}