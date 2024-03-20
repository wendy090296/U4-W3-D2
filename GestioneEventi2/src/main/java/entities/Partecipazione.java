package entities;

import enumerations.Stato;
import jakarta.persistence.*;

@Entity
//@Table(name="partecipazione")
public class Partecipazione {


    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    private String persona;
//    private String evento;
    private Stato stato_partecipazione;
    @ManyToOne // relazione con l'entità Persona
    @JoinColumn(name="id_persona", nullable=false)
    private Persona persona;
    @JoinColumn(name="id_evento", nullable=false)
    private Evento evento;


// COSTRUTTORE
    public Partecipazione(Persona persona, Evento evento, Stato stato_partecipazione) {
        this.persona = persona;
        this.evento = evento;
        this.stato_partecipazione = stato_partecipazione;
    }


// GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato_partecipazione() {
        return stato_partecipazione;
    }

    public void setStato_partecipazione(Stato stato_partecipazione) {
        this.stato_partecipazione = stato_partecipazione;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona='" + persona + '\'' +
                ", evento='" + evento + '\'' +
                ", stato_partecipazione=" + stato_partecipazione +
                '}';
    }
}
