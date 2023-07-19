package circolo.privato;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CircoloPrivato {
    private List<Socio> soci;

    // Costruttore
    public CircoloPrivato() {
        this.soci = new ArrayList<>();
    }

    // Metodi per gestire i soci
    public void caricaSociDaFile(String nomeFile) {
        // Implementa il codice per caricare i soci da un file
    }

    public void aggiungiSocio(Socio socio) {
        soci.add(socio);
    }

    public void modificaSocio(int indice, Socio socio) {
        soci.set(indice, socio);
    }

    public void rimuoviSocio(int indice) {
        soci.remove(indice);
    }

    public void incrementaEtaSoci() {
        for (Socio socio : soci) {
            int etaAttuale = socio.getEta();
            socio.setEta(etaAttuale + 1);
        }
    }

    public double calcolaEtaMedia() {
        int totaleSoci = soci.size();
        if (totaleSoci == 0) {
            return 0.0;
        }

        int sommaEta = 0;
        for (Socio socio : soci) {
            sommaEta += socio.getEta();
        }

        return (double) sommaEta / totaleSoci;
    }

    public double calcolaEtaMediaMaschi() {
        int totaleMaschi = 0;
        int sommaEtaMaschi = 0;

        for (Socio socio : soci) {
            if (socio.getSesso() == 'M') {
                totaleMaschi++;
                sommaEtaMaschi += socio.getEta();
            }
        }

        if (totaleMaschi == 0) {
            return 0.0;
        }

        return (double) sommaEtaMaschi / totaleMaschi;
    }

    public double calcolaEtaMediaFemmine() {
        int totaleFemmine = 0;
        int sommaEtaFemmine = 0;

        for (Socio socio : soci) {
            if (socio.getSesso() == 'F') {
                totaleFemmine++;
                sommaEtaFemmine += socio.getEta();
            }
        }

        if (totaleFemmine == 0) {
            return 0.0;
        }

        return (double) sommaEtaFemmine / totaleFemmine;
    }

    public double calcolaPercentualeSesso(char sesso) {
        int totaleSoci = soci.size();
        if (totaleSoci == 0) {
            return 0.0;
        }

        int contatoreSesso = 0;
        for (Socio socio : soci) {
            if (socio.getSesso() == sesso) {
                contatoreSesso++;
            }
        }

        return (double) contatoreSesso / totaleSoci * 100;
    }

    public void esportaSuFile(String nomeFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            for (Socio socio : soci) {
                writer.write(socio.getNome() + "," + socio.getCognome() + "," + socio.getEta() + "," + socio.getSesso());
                writer.newLine();
            }
            System.out.println("Esportazione su file completata.");
        } catch (IOException e) {
            System.err.println("Si è verificato un errore durante l'esportazione su file.");
            e.printStackTrace();
        }
    }

    public List<Socio> getSoci() {
        return soci;
    }

    public void setSoci(List<Socio> soci) {
        this.soci = soci;
    }
}
