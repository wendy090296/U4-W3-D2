package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi2");

    public static void main(String[] args) {
        // em é un oggetto speciale che ci consente l'interazione col DB ed é istanziato a partire da emf!
        EntityManager em = emf.createEntityManager();
        System.out.println("Hello World!");
    }
}
