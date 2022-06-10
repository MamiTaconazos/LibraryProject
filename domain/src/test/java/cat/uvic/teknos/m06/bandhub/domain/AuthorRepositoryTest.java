package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.Author;
import cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC.AuthorRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;


public class AuthorRepositoryTest {
    @Test
     void insert() throws SQLException {
        Author a1=new Author();
        a1.setCod_author(1);
        a1.setName("Rick");
        a1.setSurname("riordan");
        a1.setBirth(new java.sql.Date((new Date()).getTime()));
        a1.setCod_country(1);
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        AuthorRepository AuthorRepository=new AuthorRepository(connection);

        AuthorRepository.insert(a1);


        }

    }

