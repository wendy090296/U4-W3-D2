package entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity // classe che avrà tabella corrispondente nel DB
//@Table(name="events") // nome della tabella nel mio DB
public class Evento {

    // ATTRIBUTI
    @Id // PK
    @GeneratedValue // id gestiti in automatico dal DB
    private int id;
    private String titolo;
    private Date dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
    private int numeroMaxPartecipanti;


 // COSTRUTTORI


    public Evento() { // un'entità deve sempre avere costruttore vuoto x farci
        //restituire dati dal DB come oggetti

    }

    public Evento(String titolo, Date dataEvento, String descrizione, EventType eventType, int numeroMaxPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.eventType = eventType;
        this.numeroMaxPartecipanti = numeroMaxPartecipanti;
    }


    // GETTERS

    public int getId() {
        return id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getTitolo() {
        return titolo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getNumeroMaxPartecipanti() {
        return numeroMaxPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", eventType=" + eventType +
                ", numeroMaxPartecipanti=" + numeroMaxPartecipanti +
                '}';
    }
}
