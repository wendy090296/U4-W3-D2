package dao;

import entities.Partecipazione;
import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PersonaDAO {
    // QUI DEFINIAMO LE FUNZIONALITÀ PER INERAGIRE COL DB

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(persona);
            transaction.commit();
            System.out.println(persona.getNome() + " " + persona.getCognome() + " salvato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Persona findById(long personaId) {
        return em.find(Persona.class, personaId);

    }

    public void findByIdAndDelete(long personaId) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Persona found = em.find(Persona.class, personaId);
            if (found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Persona eliminata");
            } else System.out.println("Persona non trovata");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
