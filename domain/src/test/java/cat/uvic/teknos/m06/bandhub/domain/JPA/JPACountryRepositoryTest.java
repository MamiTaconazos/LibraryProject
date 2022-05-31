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
        country.setCod_country(5);
        country.setName("Rumania");
        assertDoesNotThrow(() ->{
            countryRepository.insert(country);
        });
        assertTrue((country.getCod_country()!=0));

    }
    @Test
    void saveUpdate(){
        
    }

    @Test
    void delete() {
    }

    @Test
    void getById() {
    }

    @Test
    void getAll() {
    }
}

