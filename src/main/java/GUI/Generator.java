package GUI;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import connection.GeneratorHTML;
import connection.PDFMaker;
import connection.XLSXConnection;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Generator extends JFrame {
    private final int maxRows = XLSXConnection.getRows();
    static String BASEURI = "C:\\Users\\48531\\Desktop";
    static String DEST = FileSystemView.getFileSystemView().getHomeDirectory() + "\\Zawody.pdf";
    JLabel tekst1 = new JLabel("Przetworzono 0 z " + maxRows + " osób");
    JPanel panel = new JPanel();
    private boolean done = true;
    JProgressBar bar = new JProgressBar(0, maxRows);
    aTask t = new aTask();

    Generator() throws FileNotSelectedException {

        init();

        t.execute();
    }

    void init() {

        this.setResizable(false);
        int szer = 400;
        int wys = 100;
        this.setSize(szer, wys);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - szer) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - wys) / 2);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Generuję...");



        bar.setStringPainted(true);
        panel.add(tekst1, BorderLayout.NORTH);
        panel.add(bar, BorderLayout.SOUTH);
        this.add(panel);

        this.setVisible(true);


    }


    private class aTask extends SwingWorker<Void, String> {

        @Override
        protected Void doInBackground() throws Exception {


            setProgress(0);


            if (!index.error.equals("error")) {

                int licznik = 0, wiersz = 0;
                try {
                    ConverterProperties properties = new ConverterProperties();
                    properties.setBaseUri(BASEURI);

                    PdfWriter writer = new PdfWriter(DEST);
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf);


                    for (int i = 1; i <= maxRows; i++) {

                        if (!XLSXConnection.getKCZNIE(i).equals("Nie") ||
                                !XLSXConnection.getKCONIE(i).equals("Nie") ||
                                !XLSXConnection.getSSNIE(i).equals("Nie") ||
                                !XLSXConnection.getSONIE(i).equals("Nie") ||
                                !XLSXConnection.getOPTYKANIE(i).equals("Nie")) {
                            PDFMaker.MakePDF(document, GeneratorHTML.WARIANT_DLUGI, XLSXConnection.getNazwisko(i), XLSXConnection.getImie(i), XLSXConnection.getKlub(i),
                                    i, Data.dataDzienPierwszy,
                                    XLSXConnection.getKCZ(i), XLSXConnection.kczW, XLSXConnection.kczK,
                                    XLSXConnection.getKCO(i), XLSXConnection.kczoW, XLSXConnection.kczoK,
                                    XLSXConnection.getOPTYKA(i), XLSXConnection.optykaW, XLSXConnection.optykaK,
                                    XLSXConnection.getSS(i), XLSXConnection.ssW, XLSXConnection.ssK,
                                    XLSXConnection.getSO(i), XLSXConnection.soW, XLSXConnection.soK);
                            licznik++;
                        }
                        if (!XLSXConnection.getKSPNIE(i).equals("Nie") ||
                                !XLSXConnection.getPSPNIE(i).equals("Nie") ||
                                !XLSXConnection.getPCZNIE(i).equals("Nie")) {
                            PDFMaker.MakePDF(document, GeneratorHTML.WARIANT_KROTKI, XLSXConnection.getNazwisko(i), XLSXConnection.getImie(i), XLSXConnection.getKlub(i),
                                    i, Data.dataDzienDrugi,
                                    XLSXConnection.getPSP(i), XLSXConnection.pspW, XLSXConnection.pspK,
                                    XLSXConnection.getPCZ(i), XLSXConnection.pczW, XLSXConnection.pczK,
                                    XLSXConnection.getKSP(i), XLSXConnection.kspW, XLSXConnection.kspK);
                            licznik++;
                        }
                        if (licznik % 2 == 0) {
                            pdf.addNewPage();
                        }
                        tekst1.setText("Przetworzono " + i + " z " + maxRows + " osób");
                        bar.setValue(i);
                        wiersz=i;
                    }
                    document.close();

                } catch (IOException e) {
                    index.gdzie = "data";
                    new PlikNieWybrany("Plik z metryczkami jest otwarty w innym programie, zamknij go i spróbuj otworzyc ponownie", "Błąd otwierania pliku");
                    dispose();
                    done = false;
                }
                catch (NullPointerException e) {
                    new PlikNieWybrany("Znaleziono pustą komórkę w wierszu: "+(wiersz+2), "Pusta komórka");
                    dispose();
                    done = false;
                }
            } else throw new FileNotSelectedException();


            return null;
        }

        @Override
        protected void done() {
            if (done) {
                try {
                    get();
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Thread.sleep(1000);
                            File f = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "\\Zawody.pdf");
                            Desktop.getDesktop().open(f);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                            new Koniec();
                        }
                    }
                    dispose();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

