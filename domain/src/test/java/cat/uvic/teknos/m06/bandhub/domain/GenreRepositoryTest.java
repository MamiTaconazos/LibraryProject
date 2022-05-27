package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.genre;

import cat.uvic.teknos.m06.bandhub.domain.repositories.genreRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class GenreRepositoryTest {
    @Test
    void insert() throws SQLException {
        genre g = new genre();
        g.setCod_genre(1);
        g.setDescription("xd");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        genreRepository genreRepository = new genreRepository(connection);

        genreRepository.insert(g);


    }

    @Test
    void GetById() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        genreRepository genreRepository = new genreRepository(connection);

        assertTrue(genreRepository.GetById(1) != null);


    }


    @Test
    void getAll() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
        Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
        genreRepository genreRepository = new genreRepository(connection);
        assertTrue(genreRepository.getAll() != null);

    }
}

