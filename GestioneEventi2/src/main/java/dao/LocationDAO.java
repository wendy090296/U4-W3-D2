package dao;

import entities.Evento;
import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    // QUI DEFINIAMO LE FUNZIONALITÀ PER INERAGIRE COL DB

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();// 1) richiedo all' em una nuova transaction
        transaction.begin(); // 2) inizio transaction
        em.persist(location); //3) aggiungo al persistence context l'oggetto evento
        transaction.commit();// 4) step finale per salvare l'oggetto
        System.out.println("La location " + location.getNome() + "per l'evento  é stata salvata con successo!");


    }


    public Location findById(long id) {
        return em.find(Location.class, id);
    }

    public Location findByIdAndDelete(long locationId) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Location found = em.find(Location.class, locationId);
            if (found != null) {
                em.remove(found);
                transaction.commit();
                System.out.println("Location eliminata");
            } else System.out.println("Location non trovata");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



//        public void delete(long locationId){
//            Location locationDaEliminare = this.findById(locationId);
//
//            EntityTransaction transaction = em.getTransaction();
//            transaction.begin();
//            em.remove(locationDaEliminare);
//            transaction.commit();
//            System.out.println("La location" + locationDaEliminare + " è stata eliminata con successo!");
//        }









