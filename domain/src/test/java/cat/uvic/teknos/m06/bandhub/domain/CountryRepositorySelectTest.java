package cat.uvic.teknos.m06.bandhub.domain;
import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC.CountryRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CountryRepositorySelectTest {
    @Test
    void GetById() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        CountryRepository CountryRepository=new CountryRepository(connection);

        assertTrue (CountryRepository.GetById(1)!=null);


    }


    @Test
    void getAll() throws SQLException {

        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        CountryRepository CountryRepository=new CountryRepository(connection);
        CountryRepository.getAll();





    }

}

