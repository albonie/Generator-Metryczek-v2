package GUI;

import javax.swing.*;
import java.awt.*;

public class PlikNieWybrany extends JDialog {
    PlikNieWybrany(String opis, String tytul) {
        this.setTitle(tytul);
        init(opis);
    }

    JPanel panel = new JPanel();
    JLabel info = new JLabel();
    JButton ok = new JButton("Wróć");

    void init(String opis) {
        this.setResizable(false);
        int szer = 700;
        int wys = 100;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(panel);
        info.setText(opis);
        panel.add(info);
        panel.add(ok);
        ok.addActionListener(e -> {
            if (index.gdzie.equals("data")) new Data();
            else new index();
            dispose();
        });
        this.setVisible(true);
    }
}
