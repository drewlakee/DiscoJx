package discojx.discogs.api.requests.impl;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsApiEndpoints;
import discojx.discogs.api.endpoints.marketplace.listing.requests.edit.MarketplaceEditListingRequest;
import discojx.discogs.api.endpoints.marketplace.listing.requests.edit.MarketplaceEditListingRequestBuilder;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequest;
import discojx.discogs.api.requests.AbstractJsonParameterizedRequestBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class DefaultMarketplaceEditListingRequest extends AbstractJsonParameterizedRequest<ObjectNode>
        implements MarketplaceEditListingRequest {

    public DefaultMarketplaceEditListingRequest(AbstractJsonParameterizedRequestBuilder<ObjectNode> builder) {
        super(builder);
    }

    public static class Builder extends AbstractJsonParameterizedRequestBuilder<ObjectNode>
            implements MarketplaceEditListingRequestBuilder {

        private long listingId;
        private long releaseId;
        private String condition;
        private String sleeveCondition;
        private double price;
        private String comments;
        private boolean allowOffers;
        private String status;
        private long externalId;
        private String location;
        private double weight;
        private int formatQuantity;

        public Builder(AbstractHttpClient client) {
            super(client);
        }

        @Override
        public MarketplaceEditListingRequestBuilder listingId(long listingId) {
            this.listingId = listingId;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder releaseId(long releaseId) {
            this.releaseId = releaseId;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder condition(String condition) {
            this.condition = condition;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder sleeveCondition(String sleeveCondition) {
            this.sleeveCondition = sleeveCondition;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder price(double price) {
            this.price = price;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder allowOffers(boolean allowOffers) {
            this.allowOffers = allowOffers;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder status(String status) {
            this.status = status;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder externalId(long externalId) {
            this.externalId = externalId;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder location(String location) {
            this.location = location;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        @Override
        public MarketplaceEditListingRequestBuilder formatQuantity(int formatQuantity) {
            this.formatQuantity = formatQuantity;
            return this;
        }

        @Override
        public MarketplaceEditListingRequest build() {
            this.queryUrl = DiscogsApiEndpoints
                    .MARKETPLACE_EDIT_LISTING
                    .getEndpoint()
                    .replace("{listing_id}", String.valueOf(listingId));
            this.jsonObject = constructJsonParameters();
            return new DefaultMarketplaceEditListingRequest(this);
        }

        @Override
        protected ObjectNode constructJsonParameters() {
            ObjectNode jsonObject = JsonNodeFactory.instance.objectNode();

            if (releaseId > 0) jsonObject.put("release_id", releaseId);
            if (condition != null) jsonObject.put("condition", condition);
            if (sleeveCondition != null) jsonObject.put("sleeve_condition", sleeveCondition);
            if (price > 0) jsonObject.put("price", price);
            if (comments != null) jsonObject.put("comments", comments);
            if (allowOffers) jsonObject.put("allow_offers", true);
            if (status != null) jsonObject.put("status", status);
            if (externalId > 0) jsonObject.put("external_id", externalId);
            if (location != null) jsonObject.put("location", location);
            if (weight > 0) jsonObject.put("weight", weight);
            if (formatQuantity > 0) jsonObject.put("format_quantity", formatQuantity);

            return jsonObject;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "listingId=" + listingId +
                    ", releaseId=" + releaseId +
                    ", condition='" + condition + '\'' +
                    ", sleeveCondition='" + sleeveCondition + '\'' +
                    ", price=" + price +
                    ", comments='" + comments + '\'' +
                    ", allowOffers=" + allowOffers +
                    ", status='" + status + '\'' +
                    ", externalId=" + externalId +
                    ", location='" + location + '\'' +
                    ", weight=" + weight +
                    ", formatQuantity=" + formatQuantity +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Builder builder = (Builder) o;
            return listingId == builder.listingId && releaseId == builder.releaseId && Double.compare(builder.price, price) == 0 && allowOffers == builder.allowOffers && externalId == builder.externalId && Double.compare(builder.weight, weight) == 0 && formatQuantity == builder.formatQuantity && Objects.equals(condition, builder.condition) && Objects.equals(sleeveCondition, builder.sleeveCondition) && Objects.equals(comments, builder.comments) && Objects.equals(status, builder.status) && Objects.equals(location, builder.location);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), listingId, releaseId, condition, sleeveCondition, price, comments, allowOffers, status, externalId, location, weight, formatQuantity);
        }
    }

    @Override
    public CompletableFuture<HttpResponse> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            HttpPost request = new HttpPost(queryUrl);
            request.setHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonObject.toString(), "UTF-8"));
            return client.execute(request);
        });
    }
}
