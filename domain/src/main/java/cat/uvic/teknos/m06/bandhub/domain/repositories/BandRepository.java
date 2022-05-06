package cat.uvic.teknos.m06.bandhub.domain.repositories;

import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
import cat.uvic.teknos.m06.bandhub.domain.models.Band;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BandRepository {
    private final Connection connection;

    public BandRepository(Connection connection) {
        this.connection = connection;
    }
    public void save(Band band) {}
    public void delete(Band band) {}
    public Band GetById(int id) {
        try (var preparedStatement = connection.prepareStatement("select * from band where id = ?")) {
            Band band = null;
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                band = new Band();

                band.setId(resultSet.getInt("id"));
                band.setName(resultSet.getString("name"));
                band.setFoundedOn(resultSet.getDate("foundedOn"));
                band.setActive(resultSet.getBoolean("active"));
            }

            return band;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public List<Band> getAll() {return null;}
}
