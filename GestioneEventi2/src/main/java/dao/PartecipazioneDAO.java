package dao;

import entities.Location;
import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    // QUI DEFINIAMO LE FUNZIONALITÀ PER INERAGIRE COL DB

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        try {
            EntityTransaction transaction = em.getTransaction();// 1) richiedo all' em una nuova transaction
            transaction.begin(); // 2) inizio transaction
            em.persist(partecipazione); //3) aggiungo al persistence context l'oggetto evento
            transaction.commit();// 4) step finale per salvare l'oggetto
            System.out.println("Partecipazione all'evento " + partecipazione.getEvento() + " per " + partecipazione.getPersona().getCognome() + ",é stata  creata con successo!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    public Partecipazione findById(long partecipazioneId){
        return em.find(Partecipazione.class,partecipazioneId);
    }

    public void findByIdAndDelete(long partecipazioneId) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Partecipazione found = em.find(Partecipazione.class, partecipazioneId);
            if (found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Partecipazione cancellata");
            } else System.out.println("Partecipazione non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}






