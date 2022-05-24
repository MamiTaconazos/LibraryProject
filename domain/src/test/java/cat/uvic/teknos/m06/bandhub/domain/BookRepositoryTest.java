package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.book;
import cat.uvic.teknos.m06.bandhub.domain.repositories.BookRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BookRepositoryTest {
    @Test
     void insert() throws SQLException {
        book b1=new book();
        b1.setCod_book(1);
        b1.setTitle("El ladron del rayo");
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        BookRepository BookRepository=new BookRepository(connection);

        BookRepository.insert(b1);


        }

    }

