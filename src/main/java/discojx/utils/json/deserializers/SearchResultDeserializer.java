package discojx.utils.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.discogs.objects.AbstractTypedSearchResult;
import discojx.discogs.objects.ArtistSearchResult;
import discojx.discogs.objects.MasterSearchResult;
import discojx.discogs.objects.ReleaseSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchResultDeserializer extends JsonDeserializer<List<AbstractTypedSearchResult>> {

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public List<AbstractTypedSearchResult> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        TreeNode treeNode = jsonMapper.readTree(p);
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
            case "master" -> jsonMapper.readValue(objectNode.traverse(), MasterSearchResult.class);
            case "release" -> jsonMapper.readValue(objectNode.traverse(), ReleaseSearchResult.class);
            case "artist" -> jsonMapper.readValue(objectNode.traverse(), ArtistSearchResult.class);
            default -> throw new NullPointerException("Typed Json Object expected.");
        };
    }
}
