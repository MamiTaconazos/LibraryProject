package cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.autoria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AutoriaRepository {
    private final Connection connection;

    public AutoriaRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(autoria autoria ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO autoria VALUES (?, ?)")) {
            prepareStatement.setInt(1, autoria.getCod_book());
            prepareStatement.setString(2, autoria.getCod_author());
            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(autoria autoria, int id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE autoria set cod_book=?, cod_author=? where cod_book=?")) {
            prepareStatement.setString(2, autoria.getCod_author());
            prepareStatement.setInt(1, autoria.getCod_book());
            prepareStatement.setInt(3, id);

            prepareStatement.executeUpdate();

            prepareStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete (String cod){
            try (var prepareStatement = connection.prepareStatement("delete from autoria where cod_author= ?")) {
                prepareStatement.setString(1, cod);
                prepareStatement.executeUpdate();

                prepareStatement.close();

            } catch (SQLException e) {
                throw new RepositoryException("Exception while executing getAll", e);
            }
        }



    public autoria GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from author where cod_author = ?")) {
            autoria author = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author = new autoria();

                author.setCod_author(resultSet.getString("cod_author"));

                author.setCod_book(resultSet.getInt("cod_book"));


            }

            return author;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<autoria> getAll() {
        var authors = new ArrayList<autoria>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from author");
            while (resultSet.next()) {
                var author = new autoria();
                author.setCod_author(resultSet.getString("cod_author"));
                author.setCod_book(resultSet.getInt("cod_book"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return authors;
    }
}
