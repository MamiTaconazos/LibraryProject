package cat.uvic.teknos.m06.bandhub.domain;
import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.repositories.CountryRepository;
import cat.uvic.teknos.m06.bandhub.domain.models.country;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class CountryRepositoryTest {
    @Test
     void insert() throws SQLException {
        country espanya=new country();
        espanya.setCod_country(1);
        espanya.setName("espanya");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        CountryRepository CountryRepository=new CountryRepository(connection);

        CountryRepository.insert(espanya.getCod_country(),espanya.getName());


        }

    }

