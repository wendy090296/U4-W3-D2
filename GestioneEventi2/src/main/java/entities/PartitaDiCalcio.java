package entities;

import java.time.LocalDate;

public class PartitaDiCalcio extends Evento{
    //ATTRIBUTI
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int NumGolSquadraDiCasa;
    private int NumGolSquadraOspite;

    //COSTRUTTORE

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMaxPartecipanti, String squadra_di_casa, String ospite, String squadra_vincente, int numGolSquadraDiCasa, int numGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, eventType, numeroMaxPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.NumGolSquadraDiCasa = numGolSquadraDiCasa;
        this.NumGolSquadraOspite = numGolSquadraOspite;
    }

    //GETTERS AND SETTERS

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumGolSquadraDiCasa() {
        return NumGolSquadraDiCasa;
    }

    public void setNumGolSquadraDiCasa(int numGolSquadraDiCasa) {
        NumGolSquadraDiCasa = numGolSquadraDiCasa;
    }

    public int getNumGolSquadraOspite() {
        return NumGolSquadraOspite;
    }

    public void setNumGolSquadraOspite(int numGolSquadraOspite) {
        NumGolSquadraOspite = numGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadra_di_casa='" + squadraDiCasa + '\'' +
                ", ospite='" +  squadraOspite  + '\'' +
                ", squadra_vincente='" + squadraVincente + '\'' +
                ", NumGolSquadraDiCasa=" + NumGolSquadraDiCasa +
                ", NumGolSquadraOspite=" + NumGolSquadraOspite +
                '}';
    }
}
