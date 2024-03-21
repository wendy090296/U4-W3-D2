package entities;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import enumerations.Genere;
import enumerations.Sesso;
import enumerations.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("wendy");

    public static void main(String[] args) {
        // em é un oggetto speciale che ci consente l'interazione col DB ed é istanziato a partire da EntityManagerFactory!
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO= new EventoDAO(em);
        PersonaDAO personaDAO= new PersonaDAO(em);
        LocationDAO locationDAO= new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO= new PartecipazioneDAO(em);


        //--------------------------------------------CREAZIONE EVENTI------------------------------------//
        Evento evento1 = new Evento("Rock-em-Ring", LocalDate.of(2024,9,12),"music festival",EventType.PUBBLICO,12000);
        Evento evento2 = new Evento("Voglio tornare negli anni 90", LocalDate.of(2024,6,14),"show",EventType.PUBBLICO,8000);
        Evento evento3 = new Evento("Maurizio Battista", LocalDate.of(2024,4,3),"comic show",EventType.PUBBLICO,500);
        Evento evento4 = new Evento("Geolier", LocalDate.of(2024,7,7),"music festival",EventType.PRIVATO,100);


        //--------------------------------------------CREAZIONE PERSONE------------------------------------//

//        List<Partecipazione> partecipazioni = new ArrayList<>();
//        Partecipazione partecipazione1 = new Partecipazione("Aldo Baglio","Rock-em-Ring",Stato.CONFERMATA);
//        partecipazioni.add(partecipazione1);
//
//        Persona persona1= new Persona("Aldo","Baglio","aldobaglio@gmail.com",LocalDate.of(1980,3,21), Sesso.MASCHIO,partecipazioni);

        //--------------------------------------------CREAZIONE LOCATION------------------------------------//




       //----------------------------------------------------- SAVE METHODS -----------------------------------//


//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);
//        eventoDAO.save(evento4);
//
//        Evento evento3 = eventoDAO.getById(3);
//        System.out.println(evento3);

       // eventoDAO.delete(2);



        List<Concerto> listaConcertiInStreaming = eventoDAO.getConcertiInStreaming();
        System.out.println(listaConcertiInStreaming);

        List<Concerto> listaConcertiPerGenere = eventoDAO.getConcertiPerGenere(Genere.ROCK);
        System.out.println(listaConcertiPerGenere);


        System.out.println(eventoDAO.partiteVinteInCasa("Napoli"));
        System.out.println(eventoDAO.partiteVinteInTrasferta("Juventus"));

        em.close();
        emf.close();




    }
}
