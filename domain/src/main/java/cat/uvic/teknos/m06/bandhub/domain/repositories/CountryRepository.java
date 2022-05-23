package cat.uvic.teknos.m06.bandhub.domain.repositories;

        import cat.uvic.teknos.m06.bandhub.domain.exceptions.RepositoryException;
        import cat.uvic.teknos.m06.bandhub.domain.models.country;


        import java.sql.Connection;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;


public class CountryRepository {
    private final Connection connection;

    public CountryRepository(Connection connection) {
        this.connection = connection;
    }
    public void insert(int cod_country,String name ) {
        try (var prepareStatement = connection.prepareStatement("INSERT INTO country VALUES (?, ?)")) {
            country country = null;
            prepareStatement.setInt(1, cod_country);
            prepareStatement.setString(2, name);
            prepareStatement.executeUpdate();

            prepareStatement.close();
        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }


    public void delete(int cod_country) {
        try (var prepareStatement = connection.prepareStatement("delete from country where cod_coutry= ?")){
            country country = null;
            prepareStatement.setInt(1, cod_country);
            prepareStatement.executeUpdate();

            prepareStatement.close();

        }
        catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }


    public country GetById(int id) {
        try (var preparedStatement = connection.prepareStatement("select * from country where cod_coutry = ?")) {
            country country = null;
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                country = new country();

                country.setCod_country(resultSet.getInt("cod_country"));
                country.setName(resultSet.getString("name"));

            }

            return country;
        } catch (SQLException e) {
            throw new RepositoryException("Exception while executing getAll", e);
        }
    }
    public List<country> getAll() {
        var countrys = new ArrayList<country>();
        try (var Statement = connection.createStatement()) {

            var resultSet = Statement.executeQuery("select * from country");
            while (resultSet.next()) {
                var country = new country();
                country.setCod_country(resultSet.getInt("cod_counrty"));
                country.setName(resultSet.getString("name"));
                countrys.add(country);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return countrys;
    }
}
