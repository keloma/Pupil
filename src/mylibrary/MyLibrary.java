/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary;

import classes.Book;
import classes.Pupil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author cawa4
 */
public class MyLibrary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Book book1 = new Book("Дж. Блох", "Эффектное программирование на Java", "3 недели");
        Book book2 = new Book("Мария Иванова", "Работа и деньги", "4 недели");
        Pupil pupil1 = new Pupil("Александр", "Кропачев", "11а", new ArrayList<Book>());
        pupil1.addBook(book1);
        pupil1.addBook(book2);
        
        System.out.println(pupil1.toString());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PTVR15_LibraryPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
// em.persist(book1); 
        em.persist(pupil1);
        tx.commit();

        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}


    

