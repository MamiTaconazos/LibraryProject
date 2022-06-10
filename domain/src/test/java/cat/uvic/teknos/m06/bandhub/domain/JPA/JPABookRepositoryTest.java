package cat.uvic.teknos.m06.bandhub.domain.JPA;

import cat.uvic.teknos.m06.bandhub.domain.models.Book;
import cat.uvic.teknos.m06.bandhub.domain.repositories.jpa.JPABookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JPABookRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    @BeforeAll
    static void setUp(){
        entityManagerFactory=Persistence.createEntityManagerFactory("library");

    }
    @Test
    void saveInsert() {
        var countryRepository=new JPABookRepository(entityManagerFactory);
        var country=new Book();
        country.setTitle("nooooo");
        assertDoesNotThrow(() ->{
            countryRepository.save(country);
        });
        assertTrue((country.getCod_book()!=0));

    }
    @Test
    void saveUpdate(){
        var countryRepository=new JPABookRepository(entityManagerFactory);
        var book=new Book();
        book.setTitle("Hello");
        assertDoesNotThrow(()-> {
            countryRepository.save(book);
        });
        var entityManager=entityManagerFactory.createEntityManager();
        var modifiedCountry=entityManager.find(Book.class,2);
        assertEquals("Hello", modifiedCountry.getTitle());
        entityManager.close();

        
    }

    @Test
    void delete() {
        var countryRepository=new JPABookRepository(entityManagerFactory);
        var entityManager=entityManagerFactory.createEntityManager();
        var entityManager1=entityManagerFactory.createEntityManager();
        var rom=entityManager.find(Book.class, 1);

        assertNotNull(rom);

        assertDoesNotThrow(() -> {countryRepository.delete(1);
        });

        rom=entityManager1.find(Book.class,1);

        assertNull(rom);
    }


    @Test
    void getById() {
        var countryRepository=new JPABookRepository(entityManagerFactory);
        var book= countryRepository.GetById(1);
        assertNotNull(book);
    }

    @Test
    void getAll() {
        var countryRepository=new JPABookRepository(entityManagerFactory);
        var book= countryRepository.GetAll();
        assertNotNull(book);
        assertTrue(book.size() > 0);

    }
}

