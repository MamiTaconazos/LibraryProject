package cat.uvic.teknos.m06.bandhub.utilities.xml;

import cat.uvic.teknos.m06.bandhub.utilities.ConnectionProperties;
import cat.uvic.teknos.m06.bandhub.utilities.SchemaLoader;
import cat.uvic.teknos.m06.bandhub.utilities.exceptions.SchemaLoaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MultiLineCommandSchemaLoader implements SchemaLoader {
    private final String schemaPath;
    private final ConnectionProperties connectionProperties;

    public MultiLineCommandSchemaLoader(String schemaPath, ConnectionProperties connectionProperties) {
        this.schemaPath = schemaPath;
        this.connectionProperties = connectionProperties;
    }

    @Override
    public void load() {
        try (var connection = DriverManager.getConnection(connectionProperties.getUrl(), connectionProperties.getUsername(), connectionProperties.getPassword());
             var schema = new BufferedReader(new FileReader(schemaPath, StandardCharsets.UTF_8))
        )
        {
            String sql=schema.readLine ();
            String commit="";
            while(sql!=null){
                commit+=sql+" ";

                if (sql.equals("")) {
                    if (commit == "") {
                    }
                    else{
                        connection.createStatement().executeUpdate(commit);
                    }

                    commit="";
                }
                sql=schema.readLine ();
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