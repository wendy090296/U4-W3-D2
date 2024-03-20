package entities;

import dao.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("wendy");

    public static void main(String[] args) {
        // em é un oggetto speciale che ci consente l'interazione col DB ed é istanziato a partire da EntityManagerFactory!
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO= new EventoDAO(em);

        //creazione oggetti
        Evento evento1 = new Evento("Rock-em-Ring", LocalDate.of(2024,9,12),"music festival",EventType.PUBBLICO,12000);
        Evento evento2 = new Evento("Voglio tornare negli anni 90", LocalDate.of(2024,6,14),"show",EventType.PUBBLICO,8000);
        Evento evento3 = new Evento("Maurizio Battista", LocalDate.of(2024,4,3),"comic show",EventType.PUBBLICO,500);
        Evento evento4 = new Evento("Geolier", LocalDate.of(2024,7,7),"music festival",EventType.PRIVATO,100);

        //---------------------- SAVE METHOD -----------------------//


        eventoDAO.save(evento1);
        eventoDAO.save(evento2);
        eventoDAO.save(evento3);
        eventoDAO.save(evento4);
//
//        Evento evento3 = eventoDAO.getById(3);
//        System.out.println(evento3);

//        eventoDAO.delete(2);


        em.close();
        emf.close();




    }
}
