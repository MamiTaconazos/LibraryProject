package cat.uvic.teknos.m06.bandhub.utilities;
import cat.uvic.teknos.m06.bandhub.utilities.xml.MultiLineCommandSchemaLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiLineCommandShemaLoderTest {
    @Test
    void load() {
        var connectionProperties = new ConnectionProperties("jdbc:mysql://localhost:3306/library","root",null);
        var schemaLoader = new MultiLineCommandSchemaLoader("C:\\Users\\10030108\\Source\\Repos\\LibraryProject\\utilities\\src\\main\\resources\\schema.sql", connectionProperties);

        assertDoesNotThrow(() -> {
            schemaLoader.load();
        });
    }
}


