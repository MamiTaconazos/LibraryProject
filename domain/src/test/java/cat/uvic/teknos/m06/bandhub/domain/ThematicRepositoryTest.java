package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.thematic;
import cat.uvic.teknos.m06.bandhub.domain.repositories.ThematicRepository;
import cat.uvic.teknos.m06.bandhub.domain.repositories.genreRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ThematicRepositoryTest {
    @Test
     void insert() throws SQLException {
        thematic t=new thematic();
        t.setCod_book(1);
        t.setCod_genre(1);
        t.setTitle("dddd");
        t.setDescription("dsdcsa");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        ThematicRepository ThematicRepository=new ThematicRepository(connection);

        ThematicRepository.insert(t);


        }
    @Test
    void GetById() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        ThematicRepository ThematicRepository = new ThematicRepository(connection);

        assertTrue(ThematicRepository.GetById(1) != null);


    }


    @Test
    void getAll() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        ThematicRepository ThematicRepository = new ThematicRepository(connection);
        assertTrue(ThematicRepository.getAll() != null);

    }
}




