package entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class GaraDiAtletica extends Evento{
    //ATTRIBUTI
    private Persona setAtleti;
    private Persona vincitore;

//COSTRUTTORI
public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMaxPartecipanti, Persona setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    // GETTERS E SETTERS


    public Persona getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Persona setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
