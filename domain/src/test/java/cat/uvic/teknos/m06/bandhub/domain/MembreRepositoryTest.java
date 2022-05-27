package cat.uvic.teknos.m06.bandhub.domain;

import cat.uvic.teknos.m06.bandhub.domain.connection.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.domain.models.member;
import cat.uvic.teknos.m06.bandhub.domain.repositories.MemberRepository;
import cat.uvic.teknos.m06.bandhub.domain.repositories.genreRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;


public class MembreRepositoryTest {
    @Test
     void insert() throws SQLException {
        member m=new member();
        m.setCod_member(2);
        m.setName("ferran");
        m.setSurname("vencells");
        m.setAddress("ferrer");
        m.setCod_postal("casca");
        m.setPoblation("esquirol");
        m.setPhone_num(635030302);
        m.setData_birth(new java.sql.Date((new Date()).getTime()));
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        Connection connection= DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        MemberRepository MemberRepository=new MemberRepository(connection);

        MemberRepository.insert(m);


        }

   @Test
   void GetById() throws SQLException {

      var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
      Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
      MemberRepository MemberRepository = new MemberRepository(connection);

      assertTrue(MemberRepository.GetById(2) != null);


   }


   @Test
   void getAll() throws SQLException {

      var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library", "root", null);
      Connection connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
      MemberRepository MemberRepository = new MemberRepository(connection);
      assertTrue(MemberRepository.getAll() != null);

   }
}


