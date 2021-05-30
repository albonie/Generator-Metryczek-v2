package GUI;

import javax.swing.*;
import java.awt.*;

public class Data extends JDialog {
    JTextField data1 = new JTextField();
    JTextField data2 = new JTextField();
    JButton generuj = new JButton("Generuj");
    JButton wroc = new JButton("Wróć");
    JLabel opis = new JLabel("Podaj datę na 2 dni zawodów");
    JLabel d1 = new JLabel("Dzień pierwszy");
    JLabel d2 = new JLabel("Dzień drugi");

    public static String dataDzienPierwszy;
    public static String dataDzienDrugi;

    Data() {
        init();
    }

    private void init() {
        this.setResizable(false);
        int szer = 300;
        int wys = 200;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Container kontener = this.getContentPane();
        kontener.setLayout(null);

        data1.setSize(80, 20);
        data1.setLocation(50, 50);

        data2.setSize(80, 20);
        data2.setLocation(150, 50);

        opis.setSize(opis.getPreferredSize());
        opis.setLocation(50, 5);

        d1.setSize(d1.getPreferredSize());
        d1.setLocation(50, 30);

        d2.setSize(d2.getPreferredSize());
        d2.setLocation(150, 30);

        wroc.setSize(generuj.getPreferredSize());
        wroc.setLocation(100, 130);
        wroc.addActionListener(e -> {
            new index();
            dispose();
        });

        generuj.setSize(generuj.getPreferredSize());
        generuj.setLocation(100, 100);
        generuj.addActionListener(e -> {
            if (!data1.getText().isEmpty() && !data2.getText().isEmpty()) {
                try {
                    dataDzienPierwszy = data1.getText();
                    dataDzienDrugi = data2.getText();
                    new Generator();
                } catch (FileNotSelectedException | NullPointerException ex) {
                    new PlikNieWybrany("Plik nie został wybrany", "Plik nie został wybrany");
                }
            } else {
                index.gdzie = "data";
                new PlikNieWybrany("Została podana zła data", "Zła data");
            }
            dispose();
        });

        kontener.add(data1);
        kontener.add(data2);
        kontener.add(generuj);
        kontener.add(wroc);
        kontener.add(d1);
        kontener.add(d2);
        kontener.add(opis);

        this.setTitle("Podaj datę");
        this.setVisible(true);
    }

}
