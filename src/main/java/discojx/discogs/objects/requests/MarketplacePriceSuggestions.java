package discojx.discogs.objects.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import discojx.discogs.objects.models.PriceSuggestion;
import discojx.utils.json.deserializers.PriceSuggestionsDeserializer;

import java.util.Map;
import java.util.Objects;

@JsonDeserialize(using = PriceSuggestionsDeserializer.class)
public class MarketplacePriceSuggestions {

    private Map<String, PriceSuggestion> suggestions;

    public Map<String, PriceSuggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(Map<String, PriceSuggestion> suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return "MarketplacePriceSuggestions{" +
                "priceSuggestions=" + suggestions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplacePriceSuggestions that = (MarketplacePriceSuggestions) o;
        return Objects.equals(suggestions, that.suggestions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suggestions);
    }
}
