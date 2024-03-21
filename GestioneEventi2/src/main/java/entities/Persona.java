package entities;

import enumerations.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="people")
public class Persona {
    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    @OneToMany(mappedBy = "persona") // relazione CON ENTITÀ PARTECIPAZIONE
    private List<Partecipazione> partecipazione;

 // COSTRUTTORE VUOTO
    public Persona() {
    }

    //ALTRI COSTRUTTORI

    public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, Sesso sesso, List<Partecipazione> partecipazione){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
        this.partecipazione = partecipazione;
    }

    //GETTERS E SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getPartecipazione() {
        return partecipazione;
    }

    public void setPartecipazione(List<Partecipazione> partecipazione) {
        this.partecipazione = partecipazione;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                '}';
    }
}


