package GUI;

import javax.swing.*;
import java.awt.*;

public class Koniec extends JFrame {
    public Koniec() {
        super("Błąd");
        init();
    }

    JLabel label = new JLabel("Coś poszło nie tak, spróbuj jeszcze raz");
    JPanel panel = new JPanel();
    JButton powrot = new JButton("Wróć");
    void init() {
        this.setResizable(false);
        int szer = 300;
        int wys = 100;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(panel);
        panel.add(label, BorderLayout.NORTH);
        panel.add(powrot, BorderLayout.SOUTH);
        powrot.addActionListener(e -> {
            new index();
            dispose();
        });

        this.setVisible(true);
    }
}
