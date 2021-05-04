package discojx.utils.json.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import discojx.discogs.objects.MarketplacePriceSuggestions;
import discojx.discogs.objects.PriceSuggestion;
import discojx.utils.json.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class PriceSuggestionsDeserializer extends JsonDeserializer<MarketplacePriceSuggestions> {

    @Override
    public MarketplacePriceSuggestions deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        HashMap<String, PriceSuggestion> priceSuggestions = new HashMap<>();
        TreeNode treeNode = JsonUtils.DefaultObjectMapperHolder.mapper.readTree(p);

        Iterator<String> fieldsIterator = treeNode.fieldNames();
        while (fieldsIterator.hasNext()) {
            String fieldName = fieldsIterator.next();
            priceSuggestions.put(fieldName, JsonUtils.DefaultObjectMapperHolder.mapper.readValue(treeNode.get(fieldName).traverse(), PriceSuggestion.class));
        }

        MarketplacePriceSuggestions marketplacePriceSuggestions = new MarketplacePriceSuggestions();
        marketplacePriceSuggestions.setSuggestions(priceSuggestions);

        return marketplacePriceSuggestions;
    }
}
