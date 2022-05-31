package cat.uvic.teknos.m06.bandhub.domain.repositories.JDBC;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class genreRepository {
    private final Connection connection;

    public genreRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(genre genre ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO genre VALUES (?, ?)")) {
            prepareStatement.setInt(1, genre.getCod_genre());
            prepareStatement.setString(2, genre.getDescription());
            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(genre genre, int id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE genre set cod_genre=?, description=? where cod_genre=?")) {
            prepareStatement.setInt(1, genre.getCod_genre());
            prepareStatement.setString(2, genre.getDescription());
            prepareStatement.setInt(3, id);

            prepareStatement.executeUpdate();

            prepareStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete (String cod){
            try (var prepareStatement = connection.prepareStatement("delete from genre where cod_genre= ?")) {
                prepareStatement.setString(1, cod);
                prepareStatement.executeUpdate();

                prepareStatement.close();

            } catch (SQLException e) {
                throw new RepositoryException("Exception while executing getAll", e);
            }
        }



    public genre GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from genre where cod_genre = ?")) {
            genre genre = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                genre = new genre();

                genre.setDescription(resultSet.getString("description"));

                genre.setCod_genre(resultSet.getInt("cod_genre"));


            }

            return genre;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<genre> getAll() {
        var genres = new ArrayList<genre>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from genre");
            while (resultSet.next()) {
                var genre = new genre();
                genre.setDescription(resultSet.getString("description"));
                genre.setCod_genre(resultSet.getInt("cod_genre"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return genres;
    }
}
