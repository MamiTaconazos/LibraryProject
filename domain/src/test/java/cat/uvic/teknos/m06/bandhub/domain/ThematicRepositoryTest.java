package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.thematic;
import cat.uvic.teknos.m06.bandhub.domain.repositories.ThematicRepository;
import org.junit.jupiter.api.Test;

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

    }

