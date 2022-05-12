package cat.uvic.teknos.m06.bandhub.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLineCommandSchemaLoaderTest {

    @Test
    void load() {
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        var schemaLoader = new SingleLineCommandSchemaLoader("C:\\Users\\10030108\\Source\\Repos\\LibraryProject\\utilities\\src\\main\\resources\\schema.sql", connectionProperties);

        assertDoesNotThrow(() -> {
            schemaLoader.load();
        });
    }
}