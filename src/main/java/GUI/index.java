package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

public class index extends JFrame {
    JButton generujMetryczki = new JButton("Generuj");
    JButton generujPusteMetryczki = new JButton("Generuj");
    JLabel tekst1 = new JLabel("Generuj metryczki z pliku");
    JLabel tekst2 = new JLabel("Generuj puste metryczki");
    JLabel tekst3 = new JLabel(path);
    JButton plik = new JButton("Wybierz plik");
    JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

    public static String path = "Nie wybrano pliku";
    public static File source;
    public static String error = "error";
    public static String gdzie = "index";

    public index() {
        super("Generator metryczek v2.1");
        initComponents();
    }

    private void initComponents() {


        tekst3.setText(path);
        error = "error";


        Container kontener = this.getContentPane();
        kontener.setLayout(null);

        generujMetryczki.setLocation(150, 300);
        generujMetryczki.setSize(generujMetryczki.getPreferredSize());
        generujMetryczki.addActionListener(e -> {
            gdzie = "index";
            if (!index.error.equals("error")) {
                new Data();
            } else {
                new PlikNieWybrany("Plik nie został wybrany", "Plik nie został wybrany");
            }
            dispose();
        });

        generujPusteMetryczki.setLocation(350, 300);
        generujPusteMetryczki.setSize(generujPusteMetryczki.getPreferredSize());
        generujPusteMetryczki.addActionListener(e -> {
            new Numer();
            dispose();
        });

        tekst1.setLocation(120, 280);
        tekst1.setSize(tekst1.getPreferredSize());

        tekst2.setLocation(320, 280);
        tekst2.setSize(tekst2.getPreferredSize());

        tekst3.setLocation(210, 220);
        tekst3.setSize(300, tekst3.getPreferredSize().height);

        fc.addChoosableFileFilter(new FileNameExtensionFilter("Skoroszyty MS Excel (.xlsx)", "xlsx"));
        fc.setAcceptAllFileFilterUsed(true);

        plik.setLocation(210, 100);
        plik.setSize(150, 100);
        plik.addActionListener(e -> {

            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                source = fc.getSelectedFile();
                tekst3.setText(fc.getName(source));
                error = fc.getSelectedFile().toString();
            }
        });

        kontener.add(generujMetryczki);
        kontener.add(generujPusteMetryczki);
        kontener.add(tekst1);
        kontener.add(tekst2);
        kontener.add(plik);
        kontener.add(tekst3);

        this.setResizable(false);
        int szer = 600;
        int wys = 400;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}


