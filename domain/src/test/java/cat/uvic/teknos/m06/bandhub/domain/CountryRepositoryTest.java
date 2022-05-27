package cat.uvic.teknos.m06.bandhub.domain;
import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.repositories.CountryRepository;
import cat.uvic.teknos.m06.bandhub.domain.models.country;
import org.junit.jupiter.api.Test;
import java.util.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class CountryRepositoryTest {
    @Test
    void insert() throws SQLException {
        country espanya = new country();
        espanya.setCod_country(2);
        espanya.setName("andorra");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        CountryRepository CountryRepository = new CountryRepository(connection);

        CountryRepository.insert(espanya.getCod_country(), espanya.getName());


    }

    @Test
    void update() throws SQLException {
        country espanya = new country();
        espanya.setCod_country(3);
        espanya.setName("andorra");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        CountryRepository CountryRepository = new CountryRepository(connection);

        CountryRepository.update(espanya.getCod_country(), espanya.getName(),2);

    }
    @Test
    void delete() throws SQLException {
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        CountryRepository CountryRepository = new CountryRepository(connection);

        CountryRepository.delete(3);

    }
}

