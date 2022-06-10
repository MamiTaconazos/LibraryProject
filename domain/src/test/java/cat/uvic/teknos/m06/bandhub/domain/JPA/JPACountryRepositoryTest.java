package cat.uvic.teknos.m06.bandhub.domain.JPA;
import cat.uvic.teknos.m06.bandhub.domain.repositories.jpa.JPACountryRepository;
import org.junit.jupiter.api.Test;
import cat.uvic.teknos.m06.bandhub.domain.models.Country;
import org.junit.jupiter.api.BeforeAll;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

public class JPACountryRepositoryTest {
    private static EntityManagerFactory entityManagerFactory;
    @BeforeAll
    static void setUp(){
        entityManagerFactory=Persistence.createEntityManagerFactory("library");

    }
    @Test
    void saveInsert() {
        var countryRepository=new JPACountryRepository(entityManagerFactory);
        var country=new Country();
        country.setName("Rumania");
        assertDoesNotThrow(() ->{
            countryRepository.save(country);
        });
        assertTrue((country.getCod_country()!=0));

    }
    @Test
    void saveUpdate(){
        var countryRepository=new JPACountryRepository(entityManagerFactory);
        var country=new Country();
        country.setName("Hello");
        assertDoesNotThrow(()-> {
            countryRepository.save(country);
        });
        var entityManager=entityManagerFactory.createEntityManager();
        var modifiedCountry=entityManager.find(Country.class,8);
        assertEquals("Hello", modifiedCountry.getName());
        entityManager.close();

        
    }

    @Test
    void delete() {
        var countryRepository=new JPACountryRepository(entityManagerFactory);
        var entityManager=entityManagerFactory.createEntityManager();
        var entityManager1=entityManagerFactory.createEntityManager();
        var rom=entityManager.find(Country.class, 7);

        assertNotNull(rom);

        assertDoesNotThrow(() -> {countryRepository.delete(7);
        });

        rom=entityManager1.find(Country.class,7);

        assertNull(rom);
    }


    @Test
    void getById() {
        var countryRepository=new JPACountryRepository(entityManagerFactory);
        var country= countryRepository.GetById(7);
        assertNotNull(country);
    }

    @Test
    void getAll() {
        var countryRepository=new JPACountryRepository(entityManagerFactory);
        var country= countryRepository.GetAll();
        assertNotNull(country);
        assertTrue(country.size() > 0);

    }
}

