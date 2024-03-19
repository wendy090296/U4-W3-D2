package entities.dao;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EventoDAO { // QUI DEFINIAMO LE FUNZIONALITÀ PER INERAGIRE COL DB

 private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

 public void save(Evento ev){
  EntityTransaction transaction= em.getTransaction();// 1) richiedo all' em una nuova transaction
  transaction.begin(); // 2) inizio transaction
  em.persist(ev); //3) aggiungo al persistence context l'oggetto evento
  transaction.commit();// 4) step finale per salvare l'oggetto
     System.out.println("L'evento " + ev.getTitolo() + " é stato correttamente salvato!");


 }

 public Evento getById(long eventoId){
      return em.find(Evento.class,eventoId);



 }

 public void delete(long eventoId){
     Evento eventoDaEliminare = this.getById(eventoId);

     EntityTransaction transaction = em.getTransaction();
     transaction.begin();
     em.remove(eventoDaEliminare);
     transaction.commit();
     System.out.println(eventoDaEliminare + "Questo evento è stato eliminato");
 }



 }

