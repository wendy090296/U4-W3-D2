package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String città;
    @OneToMany(mappedBy = "location")
    private List<Evento> evento;




    public Location( String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

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

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
