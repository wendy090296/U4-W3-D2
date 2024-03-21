package dao;

import entities.Concerto;
import entities.Evento;
import entities.PartitaDiCalcio;
import enumerations.Genere;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class EventoDAO {
    // QUI DEFINIAMO LE FUNZIONALITÀ PER INERAGIRE COL DB

 private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

 public void save(Evento ev) {
     try {

         EntityTransaction transaction = em.getTransaction();// 1) richiedo all' em una nuova transaction
         transaction.begin(); // 2) inizio transaction
         em.persist(ev); //3) aggiungo al persistence context l'oggetto evento
         transaction.commit();// 4) step finale per salvare l'oggetto
         System.out.println("L'evento " + ev.getTitolo() + " é stato salvato con successo!");
     }catch(Exception ex){
         System.out.println(ex.getMessage());

     }
 }

 public Evento getById(long eventoId){
      return em.find(Evento.class,eventoId);



 }

 public void findByIdAndDelete(long eventoId){
        try{

     EntityTransaction transaction = em.getTransaction();
     Evento eventoDaEliminare = this.getById(eventoId);
            Evento found = em.find(Evento.class, eventoId);
            if (found != null) {
                transaction.begin();
                em.remove(found);
                transaction.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");
 }catch(Exception ex){
            System.out.println(ex.getMessage());

        }
        }

        public List<Concerto> getConcertiInStreaming(){
            TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true ", Concerto.class);
            return query.getResultList();
        }

        public List<Concerto> getConcertiPerGenere(Genere genere){
        TypedQuery<Concerto> query= em.createQuery("SELECT C FROM Concerto c WHERE c.genere= :genere", Concerto.class);
        query.setParameter("genere",genere);
        return query.getResultList();
        }

        public  int partiteVinteInCasa(String squadra){
            TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partiteVinteInCasa", PartitaDiCalcio.class);
            query.setParameter("squadra", squadra);
            List<PartitaDiCalcio> partiteVinte = query.getResultList();
            return partiteVinte.size();

        }
    public int partiteVinteInTrasferta(String squadra){
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partiteVinteInTrasferta", PartitaDiCalcio.class);
        query.setParameter("squadra", squadra);
        List<PartitaDiCalcio> partiteVinte = query.getResultList();
        return partiteVinte.size();

    }




}

