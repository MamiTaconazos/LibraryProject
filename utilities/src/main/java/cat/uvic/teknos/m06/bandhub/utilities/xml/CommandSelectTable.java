package cat.uvic.teknos.m06.bandhub.utilities.xml;
import cat.uvic.teknos.m06.bandhub.utilities.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.utilities.SchemaLoader;
import cat.uvic.teknos.m06.bandhub.utilities.exceptions.SchemaLoaderException;

import java.io.BufferedReader;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommandSelectTable implements SchemaLoader {
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public CommandSelectTable(String schemaPath, ConnectionProperties connectionProperties) {
        this.schemaPath = schemaPath;
        this.connectionProperties = connectionProperties;

    }

    @Override
    public void load() {
        PreparedStatement p = null;
        ResultSet rs=null;
        try (var connection = DriverManager.getConnection(
                connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
             var statement = connection.createStatement();
             var inputStream = new BufferedReader(new FileReader(schemaPath, StandardCharsets.UTF_8))
        )
        {
            String sql = "select * from country";
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();
            System.out.println("cod_country\t\tname");
            while (rs.next()) {

                int id = rs.getInt("cod_country");
                String name = rs.getString("name");

                System.out.println(id + "\t\t" + name);
            }



        } catch (SQLException e) {
            throw new SchemaLoaderException("Sql Exception!", e);
        } catch (FileNotFoundException e) {
            throw new SchemaLoaderException("The file" + schemaPath + " doesn't exist", e);
        } catch (IOException e) {
            throw new SchemaLoaderException("IO Exception", e);
        }
    }
}


