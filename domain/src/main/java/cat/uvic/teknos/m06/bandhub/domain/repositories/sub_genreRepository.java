package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.sub_genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class sub_genreRepository {
    private final Connection connection;

    public sub_genreRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(sub_genre genre ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO sub_genre VALUES (?, ?)")) {
            prepareStatement.setInt(1, genre.getCod_genre());
            prepareStatement.setInt(2, genre.getCod_sub_genre());
            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(sub_genre genre, int id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE sub_genre set cod_genre=?, cod_sub_genre=? where cod_genre=?")) {
            prepareStatement.setInt(1, genre.getCod_genre());
            prepareStatement.setInt(2, genre.getCod_sub_genre());
            prepareStatement.setInt(3, id);

            prepareStatement.executeUpdate();

            prepareStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete (String cod){
            try (var prepareStatement = connection.prepareStatement("delete from sub_genre where cod_genre= ?")) {
                prepareStatement.setString(1, cod);
                prepareStatement.executeUpdate();

                prepareStatement.close();

            } catch (SQLException e) {
                throw new RepositoryException("Exception while executing getAll", e);
            }
        }



    public sub_genre GetById(String id) {
        try (var preparedStatement = connection.prepareStatement("select * from sub_genre where cod_genre = ?")) {
            sub_genre genre = null;
            preparedStatement.setString(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                genre = new sub_genre();

                genre.setCod_genre(resultSet.getInt("cod_genre"));

                genre.setCod_genre(resultSet.getInt("cod_genre"));


            }

            return genre;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<sub_genre> getAll() {
        var genres = new ArrayList<sub_genre>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from sub_genre");
            while (resultSet.next()) {
                var genre = new sub_genre();
                genre.setCod_genre(resultSet.getInt("cod_genre"));
                genre.setCod_genre(resultSet.getInt("cod_genre"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return genres;
    }
}
