package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.author;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorRepository {
    private final Connection connection;

    public AuthorRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(author author ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO author VALUES (?, ?,?,?,?)")) {
            prepareStatement.setString(1, author.getCod_author());
            prepareStatement.setString(2, author.getName());
            prepareStatement.setString(3, author.getSurname());
            prepareStatement.setDate(4, (Date) author.getBirth());
            prepareStatement.setInt(5, author.getCod_country());

            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(author author, String id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE author set cod_author=?, name=?, surname=?,birth=?,cod_country=? where cod_country=?")) {
            prepareStatement.setString(1, author.getCod_author());
            prepareStatement.setString(2, author.getName());
            prepareStatement.setString(3, author.getSurname());
            prepareStatement.setDate(4, (Date) author.getBirth());
            prepareStatement.setInt(5, author.getCod_country());
            prepareStatement.setString(6, id);

            prepareStatement.executeUpdate();

            prepareStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete (String cod){
            try (var prepareStatement = connection.prepareStatement("delete from author where cod_author= ?")) {
                prepareStatement.setString(1, cod);
                prepareStatement.executeUpdate();

                prepareStatement.close();

            } catch (SQLException e) {
                throw new RepositoryException("Exception while executing getAll", e);
            }
        }



    public author GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from author where cod_author = ?")) {
            author author = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author = new author();

                author.setCod_author(resultSet.getString("cod_author"));
                author.setName(resultSet.getString("name"));
                author.setSurname(resultSet.getString("surname"));
                author.setBirth(resultSet.getDate("birth"));
                author.setCod_country(resultSet.getInt("cod_country"));


            }

            return author;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<author> getAll() {
        var authors = new ArrayList<author>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from author");
            while (resultSet.next()) {
                var author = new author();
                author.setCod_author(resultSet.getString("cod_author"));
                author.setName(resultSet.getString("name"));
                author.setSurname(resultSet.getString("surname"));
                author.setBirth(resultSet.getDate("birth"));
                author.setCod_country(resultSet.getInt("cod_country"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return authors;
    }
}
