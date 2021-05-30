package GUI;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import connection.GeneratorHTML;
import connection.PDFMaker;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Numer extends JFrame {
    Numer() {
        init();
        setTitle("Podaj numer");
    }

    JLabel info = new JLabel("Podaj liczbę metryczek do druku: ");
    JButton ok = new JButton("Wróć");
    JButton druk = new JButton("Generuj");
    JTextArea numer = new JTextArea();

    void init() {
        this.setResizable(false);
        int szer = 340;
        int wys = 120;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        Container kontener = this.getContentPane();

        numer.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                numer.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        kontener.add(info, BorderLayout.LINE_START);
        kontener.add(numer, BorderLayout.CENTER);
        kontener.add(ok, BorderLayout.PAGE_END);
        kontener.add(druk, BorderLayout.LINE_END);

        ok.addActionListener(e -> {
            new index();
            dispose();
        });

        druk.addActionListener(e -> {
            String BASEURI = "";
            String DEST = FileSystemView.getFileSystemView().getHomeDirectory() + "\\PusteMetryczki.pdf";
            try {
                ConverterProperties properties = new ConverterProperties();
                properties.setBaseUri(BASEURI);

                PdfWriter writer = new PdfWriter(DEST);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                for (int i = 1; i <= Integer.parseInt(numer.getText()); i++) {


                        PDFMaker.MakePDF(document, GeneratorHTML.WARIANT_DLUGI, " ", " ", " ",
                                -1, " ",
                                " ", " ", " ",
                                " ", " ", " ",
                                " ", " ", " ",
                                " ", " ", " ",
                                " ", " ", " ");



                        PDFMaker.MakePDF(document, GeneratorHTML.WARIANT_KROTKI, " ", " ", " ",
                                -1, " ",
                                " ", " ", " ",
                                " ", " ", " ",
                                " ", " ", " ");

                        pdf.addNewPage();


                }
                document.close();
                if (Desktop.isDesktopSupported()) {
                    try {
                        Thread.sleep(1000);
                        File f = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "\\PusteMetryczki.pdf");
                        Desktop.getDesktop().open(f);
                    } catch (IOException | InterruptedException exc) {
                        exc.printStackTrace();
                        new Koniec();
                    }
                }
                dispose();

            } catch (IOException ex) {
                index.gdzie = "index";
                new PlikNieWybrany("Plik z metryczkami jest otwarty w innym programie, zamknij go i spróbuj otworzyc ponownie", "Błąd otwierania pliku");
                dispose();
            }

        });


        this.setVisible(true);
    }
}
