package BenchManagementTool.BMT.serde;

import BenchManagementTool.BMT.lib.Utils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BaseLocationDeserializer extends JsonDeserializer<Utils.Location> {

    @Override
    public Utils.Location deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getText();
        return Utils.Location.fromString(value);
    }
}
