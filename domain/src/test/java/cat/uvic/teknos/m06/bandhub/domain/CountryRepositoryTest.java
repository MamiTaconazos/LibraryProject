package cat.uvic.teknos.m06.bandhub.domain;
import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC.CountryRepository;
import cat.uvic.teknos.m06.bandhub.domain.models.Country;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class CountryRepositoryTest {
    @Test
     void insert() throws SQLException {
        Country espanya=new Country();
        espanya.setCod_country(2);
        espanya.setName("andorra");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        CountryRepository CountryRepository=new CountryRepository(connection);

        CountryRepository.insert(espanya.getCod_country(),espanya.getName());


        }

    }

