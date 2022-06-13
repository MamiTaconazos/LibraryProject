package cat.uvic.teknos.m06.bandhub.domain.JPA;

import cat.uvic.teknos.m06.bandhub.domain.models.Author;
import cat.uvic.teknos.m06.bandhub.domain.repositories.jpa.JPAAuthorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JPAAuthorRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    @BeforeAll
    static void setUp(){
        entityManagerFactory=Persistence.createEntityManagerFactory("library");

    }
    @Test
    void saveInsert() {
        var AuthorRepository=new JPAAuthorRepository(entityManagerFactory);
        var author=new Author();
        author.setName("nick");
        author.setSurname("minaj");
        author.setBirth(new java.sql.Date((new Date()).getTime()));
        author.setCod_country(1);
        assertDoesNotThrow(() ->{
            AuthorRepository.save(author);
        });
        assertTrue((author.getCod_country()!=0));

    }
    @Test
    void saveUpdate(){
        var authorRepository=new JPAAuthorRepository(entityManagerFactory);
        var author=new Author();
        author.setCod_author(2);
        author.setName("rick");
        author.setSurname("riordan");
        author.setBirth(new java.sql.Date((new Date()).getTime()));
        author.setCod_country(2);
        assertDoesNotThrow(()-> {
            authorRepository.save(author);
        });
        var entityManager=entityManagerFactory.createEntityManager();
        var modifiedAuthor=entityManager.find(Author.class,2);
        assertEquals("rick", modifiedAuthor.getName());
        entityManager.close();

        
    }

    @Test
    void delete() {
        var authorRepository=new JPAAuthorRepository(entityManagerFactory);
        var entityManager=entityManagerFactory.createEntityManager();
        var entityManager1=entityManagerFactory.createEntityManager();
        var rom=entityManager.find(Author.class, 1);

        assertNotNull(rom);

        assertDoesNotThrow(() -> {authorRepository.delete(1);
        });

        rom=entityManager1.find(Author.class,1);

        assertNull(rom);
    }


    @Test
    void getById() {
        var countryRepository=new JPAAuthorRepository(entityManagerFactory);
        var country= countryRepository.GetById(1);
        assertNotNull(country);
    }

    @Test
    void getAll() {
        var countryRepository=new JPAAuthorRepository(entityManagerFactory);
        var country= countryRepository.GetAll();
        assertNotNull(country);
        assertTrue(country.size() > 0);

    }
}

