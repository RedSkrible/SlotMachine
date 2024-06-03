package OOP_CW2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class StatsGUI extends JFrame {

    private JButton saveStats;
    private JTextArea textArea;
    private Container contentPane;
    private String format = "%1$1s %2$20s %3$20s"; 
    private String statsHeader, statsOutput;
    private String fileName;

    //Constructor der StatsGUI Klasse
    public StatsGUI(){
        contentPane = getContentPane();
        contentPane.add(statsPanel(), BorderLayout.CENTER);
    }

    //Die Spielstatistiken des Benutzers werden in einem tabellenartigen Textbereich angezeigt.
    //(Für die Anzeige von Spielstatistiken halte ich eine solche grafische Komponente für die beste Methode)
    private JComponent statsPanel(){
        JPanel statsPanel = new JPanel();

        textArea = new JTextArea();
        statsHeader = String.format(format, "Wins", "Losses", "Average");
        statsOutput = String.format(format, GraphicalUserInterface.getWins(),
                GraphicalUserInterface.getLosses(), new DecimalFormat("##.##").format(GraphicalUserInterface.getAverage()));
        textArea.append(statsHeader + "\n" + statsOutput);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        saveStats = new JButton("Save");
        saveStats.setBackground(Color.ORANGE);

        statsPanel.add(textArea);
        statsPanel.add(saveStats);


        saveStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        return statsPanel;
    }

    //Speichert die Statistikdaten in einer Textdatei
    private void saveToFile(){

        DateFormat df = new SimpleDateFormat("dd-MM-yy   HH-mm-ss");
        Calendar calobj = Calendar.getInstance();
        fileName=(df.format(calobj.getTime()));
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = "Wins: " + GraphicalUserInterface.getWins() +
                    "   Losses: " + GraphicalUserInterface.getLosses() +
                    "   Average: " + new DecimalFormat("##.##").format(GraphicalUserInterface.getAverage());

            fw = new FileWriter("Suwadith - 2015214   " + fileName+".txt");
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
        }

}