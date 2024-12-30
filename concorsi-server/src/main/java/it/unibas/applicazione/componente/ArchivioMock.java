package it.unibas.applicazione.componente;

import it.unibas.applicazione.modello.Archivio;
import it.unibas.applicazione.modello.Concorso;
import it.unibas.applicazione.modello.Domanda;
import it.unibas.applicazione.modello.Regioni;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ArchivioMock {

    public Archivio caricaArchivio() {

        Archivio archivio = new Archivio();

        Concorso concorso1 = new Concorso("BI01", "Concorso pubblico per 105 assunzioni alla Banca d'Italia", 105, Regioni.LAZIO, LocalDateTime.of(2024, 12, 1, 13, 20));
        Concorso concorso2 = new Concorso("MIN01", "Concorso pubblico per 50 funzionari al Ministero dell'Interno", 50, Regioni.LOMBARDIA, LocalDateTime.of(2024, 11, 15, 9, 00));
        Concorso concorso3 = new Concorso("INPS01", "Concorso INPS per 120 analisti di processo", 120, Regioni.CAMPANIA, LocalDateTime.of(2024, 10, 30, 14, 30));

        Domanda domanda1 = new Domanda("RSSMRA80A01H501Z", "M", LocalDate.of(2024, 5, 10));
        Domanda domanda2 = new Domanda("VRDLGI90B02F205T", "F", LocalDate.of(2024, 5, 12));
        Domanda domanda3 = new Domanda("BNCMRC85C03L219X", "M", LocalDate.of(2024, 6, 20));
        Domanda domanda4 = new Domanda("PLZRRT70D04H101Y", "M", LocalDate.of(2024, 5, 15));
        Domanda domanda5 = new Domanda("CRSTFN95E05L987W", "F", LocalDate.of(2024, 5, 25));
        Domanda domanda6 = new Domanda("GLLNTN60F06M304Z", "M", LocalDate.of(2024, 6, 5));
        Domanda domanda7 = new Domanda("BLFGRG92G07L601W", "F", LocalDate.of(2024, 7, 15));
        Domanda domanda8 = new Domanda("SNLFNC93H08P101J", "M", LocalDate.of(2024, 7, 18));
        Domanda domanda9 = new Domanda("VRDLST96I09F210X", "F", LocalDate.of(2024, 7, 20));

        concorso1.getListaDomande().add(domanda1);
        concorso1.getListaDomande().add(domanda2);
        concorso1.getListaDomande().add(domanda3);

        concorso2.getListaDomande().add(domanda4);
        concorso2.getListaDomande().add(domanda5);
        concorso2.getListaDomande().add(domanda6);

        concorso3.getListaDomande().add(domanda7);
        concorso3.getListaDomande().add(domanda8);
        concorso3.getListaDomande().add(domanda9);

        archivio.addConcorso(concorso1);
        archivio.addConcorso(concorso2);
        archivio.addConcorso(concorso3);

        archivio.addConcorso(new Concorso("AG01", "Concorso per 80 agenti di Polizia Locale", 80, Regioni.PIEMONTE, LocalDateTime.of(2024, 11, 20, 10, 00)));
        archivio.addConcorso(new Concorso("UN01", "Concorso per 60 ricercatori universitari", 60, Regioni.TOSCANA, LocalDateTime.of(2024, 12, 10, 9, 30)));
        archivio.addConcorso(new Concorso("MIN02", "Concorso Ministero della Giustizia per 200 cancellieri", 200, Regioni.SICILIA, LocalDateTime.of(2024, 11, 5, 11, 00)));
        archivio.addConcorso(new Concorso("ASL01", "Concorso ASL per 150 infermieri", 150, Regioni.VENETO, LocalDateTime.of(2024, 12, 5, 8, 30)));
        archivio.addConcorso(new Concorso("REG01", "Concorso regionale per 90 amministrativi", 90, Regioni.PUGLIA, LocalDateTime.of(2024, 11, 25, 15, 00)));
        archivio.addConcorso(new Concorso("IST01", "Concorso ISTAT per 70 statistici", 70, Regioni.LAZIO, LocalDateTime.of(2024, 12, 15, 10, 30)));
        archivio.addConcorso(new Concorso("MED01", "Concorso pubblico per 30 medici ospedalieri", 30, Regioni.LOMBARDIA, LocalDateTime.of(2025, 1, 10, 9, 00)));
        archivio.addConcorso(new Concorso("ENG01", "Concorso pubblico per 50 ingegneri civili", 50, Regioni.CALABRIA, LocalDateTime.of(2024, 12, 20, 11, 00)));
        archivio.addConcorso(new Concorso("TEC01", "Concorso pubblico per 40 tecnici ambientali", 40, Regioni.EMILIA_ROMAGNA, LocalDateTime.of(2025, 2, 5, 10, 00)));
        archivio.addConcorso(new Concorso("EDU01", "Concorso per 120 insegnanti di scuola primaria", 120, Regioni.MARCHE, LocalDateTime.of(2025, 3, 15, 9, 30)));
        archivio.addConcorso(new Concorso("FOR01", "Concorso Forestale per 75 guardie forestali", 75, Regioni.UMBRIA, LocalDateTime.of(2025, 1, 25, 14, 30)));
        archivio.addConcorso(new Concorso("FIN01", "Concorso per 200 revisori contabili", 200, Regioni.VENETO, LocalDateTime.of(2025, 4, 1, 8, 30)));
        archivio.addConcorso(new Concorso("SAN01", "Concorso per 100 operatori sanitari", 100, Regioni.LAZIO, LocalDateTime.of(2024, 11, 18, 16, 00)));
        archivio.addConcorso(new Concorso("DOC01", "Concorso per 50 docenti universitari", 50, Regioni.SARDEGNA, LocalDateTime.of(2024, 12, 22, 10, 30)));
        archivio.addConcorso(new Concorso("PSI01", "Concorso pubblico per 60 psicologi", 60, Regioni.CAMPANIA, LocalDateTime.of(2024, 12, 8, 12, 00)));
        archivio.addConcorso(new Concorso("DIR01", "Concorso per 30 dirigenti amministrativi", 30, Regioni.TOSCANA, LocalDateTime.of(2025, 2, 28, 9, 00)));
        archivio.addConcorso(new Concorso("LOG01", "Concorso per 45 logopedisti", 45, Regioni.SICILIA, LocalDateTime.of(2025, 1, 15, 14, 00)));
        archivio.addConcorso(new Concorso("SOC01", "Concorso per 35 assistenti sociali", 35, Regioni.ABRUZZO, LocalDateTime.of(2025, 3, 3, 11, 00)));
        archivio.addConcorso(new Concorso("INF01", "Concorso per 150 informatici senior", 150, Regioni.PIEMONTE, LocalDateTime.of(2025, 5, 12, 9, 30)));
        archivio.addConcorso(new Concorso("BIO01", "Concorso pubblico per 80 biologi", 80, Regioni.LOMBARDIA, LocalDateTime.of(2025, 6, 18, 10, 00)));
        archivio.addConcorso(new Concorso("CHM01", "Concorso per 50 chimici nel settore sanitario", 50, Regioni.VENETO, LocalDateTime.of(2025, 4, 25, 13, 00)));

        return archivio;
    }
}
