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

public class SearchResultDeserializer extends JsonDeserializer<List<AbstractTypedSearchResult>> {

    @Override
    public List<AbstractTypedSearchResult> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = JsonUtils.DefaultObjectMapperHolder.mapper.readTree(p);
        ArrayList<AbstractTypedSearchResult> searchResults = new ArrayList<>();
        for (int i = 0; i < treeNode.size(); i++) {
            TreeNode maybeObjectTree = treeNode.get(i);
            if (maybeObjectTree.isObject()) {
                searchResults.add(parseTypedResult((ObjectNode) maybeObjectTree));
            }
        }

        return searchResults;
    }

    private AbstractTypedSearchResult parseTypedResult(ObjectNode objectNode) throws IOException {
        return switch (objectNode.get("type").asText()) {
            case "master" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), MasterSearchResult.class);
            case "release" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), ReleaseSearchResult.class);
            case "artist" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), ArtistSearchResult.class);
            case "label" -> JsonUtils.DefaultObjectMapperHolder.mapper.readValue(objectNode.traverse(), LabelSearchResult.class);
            default -> new UndefinedObjectSearchResultWrapper(objectNode);
        };
    }
}
