package connection;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.font.FontProvider;

import java.io.IOException;
import java.util.List;

public class PDFMaker {
    public static void MakePDF(Document document, int wariant, String imie, String nazwisko, String klub, int numer, String data, String ...vararg) throws IOException {

        ConverterProperties properties = new ConverterProperties();
        FontProvider provider = new DefaultFontProvider(false, false, false);
        FontProgram fontProgram = FontProgramFactory.createFont("src\\main\\resources\\fonts\\times.ttf");
        provider.addFont(fontProgram, PdfEncodings.IDENTITY_H);
        properties.setFontProvider(provider);

        List<IElement> elements = HtmlConverter.convertToElements(new GeneratorHTML().generateHTMLMetric(wariant, imie, nazwisko, klub, numer, data, vararg), properties);


        for (IElement element : elements) {
            document.add((IBlockElement)element);
        }
    }
}



//try {
//        ConverterProperties properties = new ConverterProperties();
//        properties.setBaseUri(BASEURI);
//
//        PdfWriter writer = new PdfWriter(DEST);
//        PdfDocument pdf = new PdfDocument(writer);
//
//        String data = "20.20.2020";
//        Document document = new Document(pdf);
//
//
//
//        for (int i = 1; i < connection.XLSXConnection.getRows(); i ++) {
//        connection.PDFMaker.MakePDF(document, 1,  connection.XLSXConnection.getImie(i), connection.XLSXConnection.getNazwisko(i), connection.XLSXConnection.getKlub(i),
//        i, data,
//        connection.XLSXConnection.getKCZ(i), connection.XLSXConnection.kczW, connection.XLSXConnection.kczK,
//        connection.XLSXConnection.getKCO(i), connection.XLSXConnection.kczoW, connection.XLSXConnection.kczoK,
//        connection.XLSXConnection.getSS(i), connection.XLSXConnection.ssW, connection.XLSXConnection.ssK,
//        connection.XLSXConnection.getSO(i), connection.XLSXConnection.soW, connection.XLSXConnection.soK,
//        connection.XLSXConnection.getOPTYKA(i), connection.XLSXConnection.optykaW, connection.XLSXConnection.optykaK);
//        connection.PDFMaker.MakePDF(document, 2,  connection.XLSXConnection.getImie(i), connection.XLSXConnection.getNazwisko(i), connection.XLSXConnection.getKlub(i),
//        i, data,
//        connection.XLSXConnection.getKSP(i), connection.XLSXConnection.kspW, connection.XLSXConnection.kspK,
//        connection.XLSXConnection.getPSP(i), connection.XLSXConnection.pspW, connection.XLSXConnection.pspK,
//        connection.XLSXConnection.getPCZ(i), connection.XLSXConnection.pczW, connection.XLSXConnection.pczK);
//        pdf.addNewPage();
//        }
//
//
//        document.close();
//        }
//        catch (IOException e) {
//        e.printStackTrace();
//        }



//    static String BASEURI = "C:\\Users\\48531\\Desktop";
//    static String DEST = "test.pdf";