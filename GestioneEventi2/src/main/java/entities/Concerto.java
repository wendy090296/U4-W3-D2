package entities;

import enumerations.Genere;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento{
    //ATTRIBUTI
    private Genere genere;
    private boolean inStreaming;

    //COSTRUTTORI

    public  Concerto(){}


    public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMaxPartecipanti, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
