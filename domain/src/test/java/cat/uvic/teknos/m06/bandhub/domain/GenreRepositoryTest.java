package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.genre;
import cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC.genreRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GenreRepositoryTest {
    @Test
     void insert() throws SQLException {
        genre g=new genre();
        g.setCod_genre(1);
        g.setDescription("xd");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        genreRepository genreRepository=new genreRepository(connection);

        genreRepository.insert(g);


        }

    }

