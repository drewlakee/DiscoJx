package discojx.utils.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.discogs.objects.*;
import discojx.utils.json.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderMessagesDeserializer extends JsonDeserializer<List<AbstractTypedObject>> {

    @Override
    public List<AbstractTypedObject> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = JsonUtils.DefaultObjectMapperHolder.mapper.readTree(p);
        ArrayList<AbstractTypedObject> messageResults = new ArrayList<>();
        for (int i = 0; i < treeNode.size(); i++) {
            TreeNode maybeObjectTree = treeNode.get(i);
            if (maybeObjectTree.isObject()) {
                messageResults.add(parseTypedResult((ObjectNode) maybeObjectTree));
            }
        }

        return messageResults;
    }

    private AbstractTypedObject parseTypedResult(ObjectNode objectNode) throws IOException {
        return switch (objectNode.get("type").asText()) {
            case "status" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), StatusOrderMessage.class);
            case "message" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), OrderMessage.class);
            case "tracking" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), TrackingOrderMessage.class);
            default -> new UndefinedTypedObjectWrapper(objectNode);
        };
    }
}
