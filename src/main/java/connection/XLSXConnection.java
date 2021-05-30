package connection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLSXConnection {


    public static String kspK = "-", kspW = "-",
            kczK = "-", kczW = "-",
            kczoK = "-", kczoW = "-",
            optykaK = "-", optykaW = "-",
            pspK = "-", pspW = "-",
            pczK = "-", pczW = "-",
            ssK = "-", ssW = "-",
            soK = "-", soW = "-";

    private static int rows;

    private static String ReadCellData(int vRow, int vColumn) {
        rows = 0;
        String value;
        Workbook wb = null;
        try {
            FileInputStream fis = new FileInputStream(GUI.index.source);
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert wb != null;
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        value = cell.getStringCellValue();
        rows = sheet.getLastRowNum();
        return value;
    }

    public static String getNazwisko(int i) {
        return ReadCellData(i, 3);
    }

    public static String getImie(int i) {
        return ReadCellData(i, 4);
    }

    public static String getKlub(int i) {
        return ReadCellData(i, 5);
    }

    public static String getKCZ(int i) {
        kczK = kczW = "-";
        if (!ReadCellData(i, 6).equals("Nie")) {
            if (!ReadCellData(i, 6).equals("Tak, broń i amunicja własna")) {
                kczW = " ";
                kczK = "X";
            } else {
                kczW = "X";
                kczK = " ";
            }
        }
        return "Kcz";
    }

    public static String getKCZNIE(int i) {
        return ReadCellData(i, 6);
    }

    public static String getKCO(int i) {
        kczoK = kczoW = "-";
        if (!ReadCellData(i, 7).equals("Nie")) {
            if (!ReadCellData(i, 7).equals("Tak, broń i amunicja własna")) {
                kczoW = " ";
                kczoK = "X";
            } else {
                kczoW = "X";
                kczoK = " ";
            }
        }
        return "Kcz OPEN";
    }

    public static String getKCONIE(int i) {
        return ReadCellData(i, 7);
    }

    public static String getSS(int i) {
        ssK = ssW = "-";
        if (!ReadCellData(i, 8).equals("Nie")) {
            if (!ReadCellData(i, 8).equals("Tak, broń i amunicja własna")) {
                ssW = " ";
                ssK = "X";
            } else {
                ssW = "X";
                ssK = " ";
            }
        }
        return "Strzelba STANDARD";
    }

    public static String getSSNIE(int i) {
        return ReadCellData(i, 8);
    }

    public static String getSO(int i) {
        soK = soW = "-";
        if (!ReadCellData(i, 9).equals("Nie")) {
            if (!ReadCellData(i, 9).equals("Tak, broń i amunicja własna")) {
                soW = " ";
                soK = "X";
            } else {
                soW = "X";
                soK = " ";
            }
        }
        return "Strzelba OPEN";
    }

    public static String getSONIE(int i) {
        return ReadCellData(i, 9);
    }

    public static String getKSP(int i) {
        kspW = kspK = "-";
        if (!ReadCellData(i, 10).equals("Nie")) {
            if (!ReadCellData(i, 10).equals("Tak, broń i amunicja własna")) {
                kspW = " ";
                kspK = "X";
            } else {
                kspW = "X";
                kspK = " ";
            }
        }
        return "Ksp";
    }

    public static String getKSPNIE(int i) {
        return ReadCellData(i, 10);
    }

    public static String getPSP(int i) {
        pspK = pspW = "-";
        if (!ReadCellData(i, 11).equals("Nie")) {
            if (!ReadCellData(i, 11).equals("Tak, broń i amunicja własna")) {
                pspW = " ";
                pspK = "X";
            } else {
                pspW = "X";
                pspK = " ";
            }
        }
        return "Psp";
    }

    public static String getPSPNIE(int i) {
        return ReadCellData(i, 11);
    }

    public static String getPCZ(int i) {
        pczK = pczW = "-";
        if (!ReadCellData(i, 12).equals("Nie")) {
            if (!ReadCellData(i, 12).equals("Tak, broń i amunicja własna")) {
                pczW = " ";
                pczK = "X";
            } else {
                pczW = "X";
                pczK = " ";
            }
        }
        return "Pcz";
    }

    public static String getPCZNIE(int i) {
        return ReadCellData(i, 12);
    }

    public static String getOPTYKA(int i) {
        optykaK = optykaW = "-";
        if (!ReadCellData(i, 13).equals("Nie")) {
            if (!ReadCellData(i, 13).equals("Tak, broń i amunicja własna")) {
                optykaW = " ";
                optykaK = "X";
            } else {
                optykaW = "X";
                optykaK = " ";
            }
        }
        return "Optyka";
    }

    public static String getOPTYKANIE(int i) {
        return ReadCellData(i, 13);
    }

    public static int getRows() {

        ReadCellData(0, 0);
        return rows;
    }



}
