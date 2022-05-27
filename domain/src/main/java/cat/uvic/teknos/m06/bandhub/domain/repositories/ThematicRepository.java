package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.thematic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ThematicRepository {
    private final Connection connection;

    public ThematicRepository(Connection connection) {
        this.connection = connection;
    }
    public void insert(thematic thematic ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO thematic VALUES (?, ?,?,?)")) {
            prepareStatement.setInt(1, thematic.getCod_book());
            prepareStatement.setInt(2, thematic.getCod_genre());
            prepareStatement.setString(3, thematic.getTitle());
            prepareStatement.setString(4, thematic.getDescription());


            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public void update(thematic thematic, int id) {
        try (var prepareStatement = connection.prepareStatement("UPDATE thematic set cod_book=?,cod_genre=?,title=?,description=? where cod_book=?")) {
            prepareStatement.setInt(1, thematic.getCod_book());
            prepareStatement.setInt(2, thematic.getCod_genre());
            prepareStatement.setString(3, thematic.getTitle());
            prepareStatement.setString(4, thematic.getDescription());
            prepareStatement.setInt(5, id);


            prepareStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


        public void delete(int cod) {
        try (var prepareStatement = connection.prepareStatement("delete from thematic where cod_book= ?")){
            prepareStatement.setInt(1, cod);
            prepareStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing delete<", e);
        }
    }


    public thematic GetById(int  id) {
        try (var preparedStatement = connection.prepareStatement("select * from thematic where cod_book = ?")) {
            thematic thematic = null;
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                thematic = new thematic();

                thematic.setCod_book(resultSet.getInt("cod_book"));
                thematic.setCod_book(resultSet.getInt("cod_genre"));
                thematic.setTitle(resultSet.getString("titel"));
                thematic.setTitle(resultSet.getString("description"));



            }

            return thematic;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing GetById", e);
        }
    }
    public List<thematic> getAll() {
        var thematics = new ArrayList<thematic>();//ficar dins try i el return tambe haveure si funciona
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from thematic");
            while (resultSet.next()) {
                var thematic = new thematic();
                thematic.setCod_book(resultSet.getInt("cod_book"));
                thematic.setCod_book(resultSet.getInt("cod_genre"));
                thematic.setTitle(resultSet.getString("titel"));
                thematic.setTitle(resultSet.getString("description"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return thematics;
    }
}
