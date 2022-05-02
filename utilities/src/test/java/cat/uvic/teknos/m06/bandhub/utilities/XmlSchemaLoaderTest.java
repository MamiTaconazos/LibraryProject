package cat.uvic.teknos.m06.bandhub.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlSchemaLoaderTest {

    @Test
    void load() {
        var schemaLoader = new XmlSchemaLoader("src/test/resources/schema.xml");

        assertDoesNotThrow(() -> {
            schemaLoader.load();
        });
    }
}