package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.sub_genre;
import cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC.sub_genreRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Sub_GenreRepositoryTest {
    @Test
     void insert() throws SQLException {
        sub_genre sg=new sub_genre();
        sg.setCod_genre(1);
        sg.setCod_sub_genre(1);
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        sub_genreRepository sub_genreRepository=new sub_genreRepository(connection);

        sub_genreRepository.insert(sg);


        }

    }

