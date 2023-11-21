package org.java.gestore_eventi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ProgrammEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> eventiInData(Date data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    public int numeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    public String elencoEventiPerData() {
        Collections.sort(eventi, (evento1, evento2) -> evento1.getData().compareTo(evento2.getData()));

        StringBuilder result = new StringBuilder();
        for (Evento evento : eventi) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormattata = dateFormat.format(evento.getData());
            result.append(dataFormattata).append(" - ").append(evento.getTitolo()).append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Programma Eventi: " + titolo;
    }

}