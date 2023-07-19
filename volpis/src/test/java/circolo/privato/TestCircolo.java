package circolo.privato;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircolo {

    @Test
    public void testAggiungiSocio() {
        CircoloPrivato circolo = new CircoloPrivato();
        Socio socio = new Socio("Mario", "Rossi", 30, 'M');

        circolo.aggiungiSocio(socio);
        assertEquals(1, circolo.getSoci().size());
    }

    @Test
    public void testModificaSocio() {
        CircoloPrivato circolo = new CircoloPrivato();
        Socio socio = new Socio("Mario", "Rossi", 30, 'M');
        circolo.aggiungiSocio(socio);

        Socio socioModificato = new Socio("Marco", "Bianchi", 35, 'M');
        circolo.modificaSocio(0, socioModificato);

        assertEquals("Marco", circolo.getSoci().get(0).getNome());
        assertEquals("Bianchi", circolo.getSoci().get(0).getCognome());
        assertEquals(35, circolo.getSoci().get(0).getEta());
    }

    @Test
    public void testRimuoviSocio() {
        CircoloPrivato circolo = new CircoloPrivato();
        Socio socio1 = new Socio("Mario", "Rossi", 30, 'M');
        Socio socio2 = new Socio("Marco", "Bianchi", 35, 'M');
        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        circolo.rimuoviSocio(0);

        assertEquals(1, circolo.getSoci().size());
        assertEquals("Marco", circolo.getSoci().get(0).getNome());
    }

    @Test
    public void testIncrementaEtaSoci() {
        CircoloPrivato circolo = new CircoloPrivato();
        Socio socio1 = new Socio("Mario", "Rossi", 30, 'M');
        Socio socio2 = new Socio("Marco", "Bianchi", 35, 'M');
        circolo.aggiungiSocio(socio1);
        circolo.aggiungiSocio(socio2);

        circolo.incrementaEtaSoci();

        assertEquals(31, circolo.getSoci().get(0).getEta());
        assertEquals(36, circolo.getSoci().get(1).getEta());
    }

    @Test
    public void testCalcolaEtaMedia() {
        CircoloPrivato circolo = new CircoloPrivato();
        circolo.aggiungiSocio(new Socio("Mario", "Rossi", 30, 'M'));
        circolo.aggiungiSocio(new Socio("Marco", "Bianchi", 35, 'M'));
        circolo.aggiungiSocio(new Socio("Laura", "Verdi", 28, 'F'));

        double etaMedia = circolo.calcolaEtaMedia();

        assertEquals(31.0, etaMedia);
    }

    // Unit Test per il calcolo dell'età media dei soci di sesso maschile
    @Test
    public void testCalcolaEtaMediaMaschi() {
        CircoloPrivato circolo = new CircoloPrivato();
        circolo.aggiungiSocio(new Socio("Mario", "Rossi", 30, 'M'));
        circolo.aggiungiSocio(new Socio("Marco", "Bianchi", 35, 'M'));
        circolo.aggiungiSocio(new Socio("Laura", "Verdi", 28, 'F'));

        double etaMediaMaschi = circolo.calcolaEtaMediaMaschi();

        assertEquals(32.5, etaMediaMaschi);
    }

    // Unit Test per il calcolo dell'età media dei soci di sesso femminile
    @Test
    public void testCalcolaEtaMediaFemmine() {
        CircoloPrivato circolo = new CircoloPrivato();
        circolo.aggiungiSocio(new Socio("Mario", "Rossi", 30, 'M'));
        circolo.aggiungiSocio(new Socio("Marco", "Bianchi", 35, 'M'));
        circolo.aggiungiSocio(new Socio("Laura", "Verdi", 28, 'F'));

        double etaMediaFemmine = circolo.calcolaEtaMediaFemmine();

        assertEquals(28.0, etaMediaFemmine);
    }

    // Unit Test per il calcolo della distribuzione percentuale dei soci in base al sesso
    @Test
    public void testCalcolaPercentualeSesso() {
        CircoloPrivato circolo = new CircoloPrivato();
        circolo.aggiungiSocio(new Socio("Mario", "Rossi", 30, 'M'));
        circolo.aggiungiSocio(new Socio("Marco", "Bianchi", 35, 'M'));
        circolo.aggiungiSocio(new Socio("Laura", "Verdi", 28, 'F'));

        double percentualeMaschi = circolo.calcolaPercentualeSesso('M');
        double percentualeFemmine = circolo.calcolaPercentualeSesso('F');

        assertEquals(66.66666666666666, percentualeMaschi);
        assertEquals(33.33333333333333, percentualeFemmine);
    }

}
