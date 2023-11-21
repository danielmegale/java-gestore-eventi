package org.java.gestore_eventi;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProgrammEventi programmaEventi = new ProgrammEventi("Programma Eventi");

        boolean inserireNuovoEvento = true;

        while (inserireNuovoEvento) {
            try {
                System.out.println("Inserisci i dettagli per creare un nuovo concerto:");
                System.out.print("Titolo: ");
                String titolo = scanner.nextLine();

                System.out.print("Data (formato dd/MM/yyyy): ");
                String dataString = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date data = dateFormat.parse(dataString);

                System.out.print("Numero di posti totali: ");
                int numeroPostiTotale = scanner.nextInt();

                System.out.print("Ora (formato HH:mm): ");
                String oraString = scanner.next();
                LocalTime ora = LocalTime.parse(oraString);

                System.out.print("Prezzo del biglietto: ");
                BigDecimal prezzoBiglietto = scanner.nextBigDecimal();

                Concerto concerto = new Concerto(titolo, data, numeroPostiTotale, ora, prezzoBiglietto);
                programmaEventi.aggiungiEvento(concerto);

                // Richiedere e gestire prenotazioni
                System.out.println("Vuoi effettuare delle prenotazioni? (Si/No)");
                scanner.nextLine();
                String risposta = scanner.nextLine().toLowerCase();

                if (risposta.equalsIgnoreCase("Si")) {
                    System.out.print("Quanti posti vuoi prenotare? ");
                    int numeroPrenotazioni = scanner.nextInt();

                    for (int i = 0; i < numeroPrenotazioni; i++) {
                        try {
                            concerto.prenota();
                            System.out.println("Prenotazione effettuata con successo.");
                        } catch (Exception e) {
                            System.out.println("Impossibile effettuare la prenotazione: " + e.getMessage());
                        }
                    }
                }

                // Stampa il numero di posti prenotati e disponibili
                System.out.println("Numero di posti prenotati: " + concerto.getNumeroPostiPrenotati());
                System.out.println("Numero di posti disponibili: " + (concerto.getNumeroPostiTotale() - concerto.getNumeroPostiPrenotati()));

                // Richiedere e gestire disdette
                System.out.println("Vuoi disdire dei posti? (Si/No)");
                scanner.nextLine();
                risposta = scanner.nextLine();

                if (risposta.equalsIgnoreCase("Si")) {
                    System.out.print("Quanti posti vuoi disdire? ");
                    int numeroDisdette = scanner.nextInt();

                    for (int i = 0; i < numeroDisdette; i++) {
                        try {
                            concerto.disdici();
                            System.out.println("Disdetta effettuata con successo.");
                        } catch (Exception e) {
                            System.out.println("Impossibile effettuare la disdetta: " + e.getMessage());
                        }
                    }
                }

                // Stampa il numero di posti prenotati e disponibili dopo le disdette
                System.out.println("Numero di posti prenotati: " + concerto.getNumeroPostiPrenotati());
                System.out.println("Numero di posti disponibili: " + (concerto.getNumeroPostiTotale() - concerto.getNumeroPostiPrenotati()));
                System.out.println(concerto.toString());
                System.out.println("Elenco eventi nel programma:");
                System.out.println(programmaEventi.elencoEventiPerData());
                System.out.println("Vuoi inserire un nuovo evento? (Si/No)");
                risposta = scanner.next();
                inserireNuovoEvento = risposta.equalsIgnoreCase("Si");

            } catch (Exception e) {
                System.out.println("Errore durante la creazione del concerto: " + e.getMessage());
            } finally {
                scanner.nextLine(); // Consuma la nuova riga rimasta nel buffer
            }
        }
        System.out.println("Grazie per utilizzare il gestore eventi. Arrivederci!");

        scanner.close();
    }
}
