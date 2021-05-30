package connection;

public class GeneratorHTML {
    public static final int WARIANT_KROTKI = 2;
    public static final int WARIANT_DLUGI = 1;

    private String konkurencja(String nazwa, String wlasna, String klubowa) {
        return "<tr>\n" +
                "        <td class='konkurencja'>" + nazwa + "</td>\n" +
                "        <td id='bron'>\n" +
                "            <table id='zaznaczanie'>\n" +
                "                <tr>\n" +
                "                    <td id='lewy'>" + wlasna + "</td>\n" +
                "                    <td id='prawy'>" + klubowa + "</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "        <td></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td class='strzaly'></td>\n" +
                "        <td></td>\n" +
                "        <td></td>\n" +
                "    </tr>";
    }

    private String styl(int wariant) {
        String zwrot = """
                                
                <style>
                        @page{
                        margin: 0;
                        margin-top: 40px;
                        }
                        
                            td {
                                border: 1px solid black;
                            }
                            #ramka{
                                height: 128mm;
                                width: 187mm;
                                border: 2px solid black;
                                padding-left: 2mm;
                                box-sizing: border-box;
                                padding-right: 0mm;
                                margin: auto;
                                margin-bottom: 7mm;
                            }
                                                                                 
                            #numer{
                                width: 20mm;
                                height: 14mm;
                                text-align: center;
                                font-size: 20pt;
                            }
                                
                            .strzaly {
                                width: 14mm;
                                height: 6mm;
                                text-align: center;
                                font-size: 11pt;
                                box-sizing: border-box;
                                padding: 0;
                            }
                                
                            #uwagi{
                                width: 26mm;
                                text-align: center;
                            }
                                
                            #odstep1{
                                width: 31.1mm;
                                border: none;
                            }
                                
                            .dane2tab{
                                width: 30mm;
                                height: 7mm;
                                padding-left: 2mm;
                                font-size: 15pt;
                                text-align: left;
                                box-sizing: border-box;
                            }
                            
                            .dane3tab{
                                width: 41mm;
                                height: 7mm;
                                box-sizing: border-box;
                            }
                                
                            .dane1tab{
                                width: 157mm;
                                height: 6mm;
                                padding-left: 3mm;
                                font-size: 15pt;
                                text-align: left;
                                box-sizing: border-box;
                            }
                                
                            .dane0tab{
                                width: 100mm;
                                height: 7mm;
                                padding-left: 3mm;
                                font-size: 15pt;
                                text-align: left;
                                box-sizing: border-box;
                            }
                                
                            #broniammo{
                                width: 17mm;\s
                                text-align: center;
                                padding: 0;
                                box-sizing: border-box;
                            }
                                
                           \s
                            #odstep2{
                                width: 50mm;
                                border: none;
                            }
                                
                            #rodo{
                                width: 3mm;
                                height: 3mm;
                            }
                                
                            .bezramek{
                                border:none;
                                font-size: 9pt;
                                text-align: left;
                            }
                                
                            .margtop{
                                border: none;
                                height: 2mm;
                            }
                                
                            #duzytab{
                                border-collapse: collapse;
                                width: 180mm;
                                height: 40mm;
                                font-size: 12pt;
                                margin-top: """;

        switch (wariant) {
            case 1 -> zwrot += "2mm;";
            case 2 -> zwrot += "11mm;";
        }

        zwrot += """            
                 }
                \s
                 table{
                     margin-top: 1mm;            \s
                 }
                     
                 #wynik{
                     width: 18mm;
                     text-align: center;
                 }
                     
                     
                 h2, .konkurencja{
                     text-align: center;
                 }
                     
                 #bron {
                     width: 18mm;\s
                     text-align: center;
                     padding: 0;
                     box-sizing: border-box;
                 }
                \s
                 #tytul {
                     text-align: center;
                 }
                     
                 #rodoTekst {
                     padding-left: 2mm;
                     box-sizing: border-box;
                     font-size: 7pt;
                 }
                     
                 body{
                     font-size: 10pt;
                 }
                 #brontab {
                     margin-top: 0;
                     border: 0;
                     border-collapse: collapse;
                     height: 8mm;
                     width: 18mm;   \s
                     table-layout: fixed;
                     font-size: 6.5pt;
                 }
                 #gora {
                     height: 4mm;
                     width: 17mm;
                     border-left: none;
                     border-right: none;
                     border-top: none;
                 }
                 #dol1 {
                     border-left: none;
                 }
                 #dol2 {
                     border-right: none;
                 }
                 #dol1, #dol2 {
                     width: 9mm;
                     height: 4mm;
                     border-bottom: none;
                     box-sizing: border-box;
                     padding: 0;
                 }
                 #zaznaczanie {
                     margin: 0;
                     border: 0;
                     border-collapse: collapse;
                     width: 100%;
                     table-layout: fixed;
                 }
                 #lewy, #prawy {
                     width: 9mm;
                     height: 10mm;
                     border-top: none;
                     border-bottom: none;
                     box-sizing: border-box;
                     padding: 0;
                 }
                 #lewy {
                     border-left: none;
                 }
                 #prawy {
                     border-right: none;
                 }
                 
                 #dolPodpisy {
                     margin-top: """;

        switch (wariant) {
            case 1 -> zwrot += "2mm;";
            case 2 -> zwrot += "14mm;";
        }

        zwrot += """
                 }
                 
                \s
                  </style>
                     
                 """;

        return zwrot;
    }

    public String generateHTMLMetric(int wariant, String imie, String nazwisko, String klub, int numer, String data, String... vararg) {
        StringBuilder zwrot = new StringBuilder("""
                                
                <!DOCTYPE html>
                <html lang='en'>
                <head>
                    <meta charset='UTF-8'>
                    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
                    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                   \s
                </head>               
                """);
        zwrot.append(styl(wariant));
        zwrot.append("""
                                
                <body>
                   \s
                    <div id='ramka'>
                                
                       \s
                        <table style='overflow: wrap' autosize='0'>
                            <tr>
                                <td id='numer'><strong>""");
        if (numer != -1) {
            zwrot.append(numer);
        }
        zwrot.append(
                """
                            </strong></td>
                            <td id='tytul' class='bezramek' colspan='3'><h2>KSS LOK REGALICA GRYFINO</h2></td>
                        </tr>
                        <tr>
                           \s
                           \s
                            <td class='bezramek'><strong>IMIĘ</strong></td>
                            <td class='dane1tab'>""").append(imie).append("""
                </td>
                </tr>
                    
                <tr>
                   \s
                    <td class='bezramek'><strong>NAZWISKO</strong></td>
                    <td class='dane1tab'>""").append(nazwisko).append("""
                    </td>
                    </tr>
                </table>
                        
                <table>
                    <tr class='margtop'></tr>
                    <tr>
                        <td class='bezramek'><strong>KLUB</strong></td>
                        <td class='dane0tab'>""").append(klub).append("""
                </td>
                <td id='odstep1'></td>
                <td class='bezramek'><strong>Data</strong></td>
                <td class='dane2tab'>""").append(data).append("""
                            </td>
                            </tr>
                            <tr class='margtop'></tr>
                        </table>
                                
                        <table id='duzytab'>
                            <tr>
                                <td>Konkurencja</td>
                               \s
                                <td id='broniammo'>
                                    <table id='brontab'>
                                        <tr>
                                            <td id='gora' colspan='2'>Broń i amunicja</td>
                                        </tr>
                                        <tr>
                                            <td id='dol1'>Własna</td>
                                            <td id='dol2'>Klubowa</td>
                                        </tr>
                                    </table>
                                    </div>
                                
                                </td>
                                <td>Stanowisko</td>
                                <td class='strzaly'>1</td>
                                <td class='strzaly'>2</td>
                                <td class='strzaly'>3</td>
                                <td class='strzaly'>4</td>
                                <td class='strzaly'>5</td>
                                <td class='strzaly'>6</td>
                                <td class='strzaly'>7</td>
                                <td class='strzaly'>8</td>
                                <td class='strzaly'>9</td>
                                <td class='strzaly'>10</td>
                                <td id='wynik'>Wynik</td>
                                <td class='strzaly'>10X</td>
                                <td id='uwagi'>Uwagi</td>
                            </tr>
                                
                """);

        for (int i = 0; i < vararg.length; i += 3) {
            zwrot.append(konkurencja(vararg[i], vararg[i + 1], vararg[i + 2]));
        }
        zwrot.append("""
                                
                </table>
                                
                        <table id="dolPodpisy" class='dolMarg'>
                            <tr class='margtop'></tr>
                            <tr>
                                <td class='bezramek'>Podpis zawodnika</td>
                                <td class='dane3tab'></td>
                                <td id='odstep2'></td>
                                <td class='bezramek'>Podpis sędziego</td>
                                <td class='dane3tab'></td>
                            </tr>
                         \s
                        </table>
                                
                        <table id='dolRodo' class='dolMarg'>
                            <tr>
                                <td class='bezramek'></td>
                                <td class='bezramek' rowspan='3' id='rodoTekst'>Po zapoznaniu się z regulaminem zawodów wyrażam zgodę na przetwarzanie moich danych osobowych podanych przeze mnie zgodnie <br>
                                    z art. 6 ust. 1 lit. a. Rozporządzenia Parlamentu Europejskiego i Rady (UE) 2016/679 z dnia 27 kwietnia 2016 r. w sprawie ochrony osób <br>
                                     fizycznych w związku z przetwarzaniem danych osobowych i w sprawie swobodnego przepływu takich danych w związku z udziałem w zawodach.</td>
                            </tr>
                            <tr>       \s
                                <td id='rodo'>""");
        if (numer != -1) {
            zwrot.append("X");
        }
        zwrot.append("""
                            </td>
                            </tr>
                            <tr>
                                <td class='bezramek'></td>
                            </tr>
                        </table>
                                
                    </div>
                  \s
                </body>
                </html>
                                
                """);


        return zwrot.toString();

    }
}
