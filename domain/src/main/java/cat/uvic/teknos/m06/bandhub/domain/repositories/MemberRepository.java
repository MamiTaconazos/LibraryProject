package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberRepository {
    private final Connection connection;

    public MemberRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(member member ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO member VALUES (?,?,?,?,?,?,?,?)")) {
            prepareStatement.setInt(1, member.getCod_member());
            prepareStatement.setString(2, member.getName());
            prepareStatement.setString(3, member.getSurname());
            prepareStatement.setString(4, member.getAddress());
            prepareStatement.setString(5, member.getCod_postal());
            prepareStatement.setString(6, member.getPoblation());
            prepareStatement.setInt(7, member.getPhone_num());
            prepareStatement.setDate(8, (Date) member.getData_birth());

            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(member member, String id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE member set cod_member=?, name=?, surname=?,address=?,cod_postal=?,poblation=?,phone_num=?,data_birth=? where cod_member=?")) {
            prepareStatement.setInt(1, member.getCod_member());
            prepareStatement.setString(2, member.getName());
            prepareStatement.setString(3, member.getSurname());
            prepareStatement.setString(4, member.getAddress());
            prepareStatement.setString(5, member.getCod_postal());
            prepareStatement.setString(6, member.getPoblation());
            prepareStatement.setInt(7, member.getPhone_num());
            prepareStatement.setDate(8, (Date) member.getData_birth());

            prepareStatement.executeUpdate();

            prepareStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete (String cod){
            try (var prepareStatement = connection.prepareStatement("delete from member where cod_member= ?")) {
                prepareStatement.setString(1, cod);
                prepareStatement.executeUpdate();

                prepareStatement.close();

            } catch (SQLException e) {
                throw new RepositoryException("Exception while executing getAll", e);
            }
        }



    public member GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from member where cod_member = ?")) {
            member member = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                member = new member();

                member.setCod_member(resultSet.getInt("cod_member"));
                member.setName(resultSet.getString("name"));
                member.setSurname(resultSet.getString("surname"));
                member.setAddress(resultSet.getString("address"));
                member.setCod_postal(resultSet.getString("address"));
                member.setPoblation(resultSet.getString("address"));
                member.setPhone_num(resultSet.getInt("address"));
                member.setData_birth(resultSet.getDate("cod_country"));


            }

            return member;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<member> getAll() {
        var members = new ArrayList<member>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from member");
            while (resultSet.next()) {
                var member = new member();
                member.setCod_member(resultSet.getInt("cod_member"));
                member.setName(resultSet.getString("name"));
                member.setSurname(resultSet.getString("surname"));
                member.setAddress(resultSet.getString("address"));
                member.setCod_postal(resultSet.getString("address"));
                member.setPoblation(resultSet.getString("address"));
                member.setPhone_num(resultSet.getInt("address"));
                member.setData_birth(resultSet.getDate("cod_country"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return members;
    }
}
