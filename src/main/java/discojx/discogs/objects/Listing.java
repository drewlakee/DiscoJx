package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

public class Listing {

    public static class Price {
        private double value;
        private MarketplaceCurrency currency;

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public MarketplaceCurrency getCurrency() {
            return currency;
        }

        public void setCurrency(MarketplaceCurrency currency) {
            this.currency = currency;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "value=" + value +
                    ", currency=" + currency +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Price price = (Price) o;
            return value == price.value && currency == price.currency;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, currency);
        }
    }

    public static class OriginalPrice {
        @JsonProperty("curr_abbr")
        private MarketplaceCurrency currAbbr;
        @JsonProperty("curr_id")
        private long currId;
        private String formatted;
        private int value;

        public MarketplaceCurrency getCurrAbbr() {
            return currAbbr;
        }

        public void setCurrAbbr(MarketplaceCurrency currAbbr) {
            this.currAbbr = currAbbr;
        }

        public long getCurrId() {
            return currId;
        }

        public void setCurrId(long currId) {
            this.currId = currId;
        }

        public String getFormatted() {
            return formatted;
        }

        public void setFormatted(String formatted) {
            this.formatted = formatted;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "OriginalPrice{" +
                    "currAbbr=" + currAbbr +
                    ", currId=" + currId +
                    ", formatted='" + formatted + '\'' +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OriginalPrice that = (OriginalPrice) o;
            return currId == that.currId && value == that.value && currAbbr == that.currAbbr && Objects.equals(formatted, that.formatted);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currAbbr, currId, formatted, value);
        }
    }

    public static class ShippingPrice {
        private MarketplaceCurrency currency;
        private double value;

        public MarketplaceCurrency getCurrency() {
            return currency;
        }

        public void setCurrency(MarketplaceCurrency currency) {
            this.currency = currency;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ShippingPrice{" +
                    "currency=" + currency +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ShippingPrice that = (ShippingPrice) o;
            return Double.compare(that.value, value) == 0 && currency == that.currency;
        }

        @Override
        public int hashCode() {
            return Objects.hash(currency, value);
        }
    }

    public static class OriginalShippingPrice {
        @JsonProperty("curr_abbr")
        private MarketplaceCurrency currAbbr;
        @JsonProperty("curr_id")
        private long currId;
        private String formatted;
        private double value;

        public MarketplaceCurrency getCurrAbbr() {
            return currAbbr;
        }

        public void setCurrAbbr(MarketplaceCurrency currAbbr) {
            this.currAbbr = currAbbr;
        }

        public long getCurrId() {
            return currId;
        }

        public void setCurrId(long currId) {
            this.currId = currId;
        }

        public String getFormatted() {
            return formatted;
        }

        public void setFormatted(String formatted) {
            this.formatted = formatted;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "OriginalShippingPrice{" +
                    "currAbbr=" + currAbbr +
                    ", currId=" + currId +
                    ", formatted='" + formatted + '\'' +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OriginalShippingPrice that = (OriginalShippingPrice) o;
            return currId == that.currId && Double.compare(that.value, value) == 0 && currAbbr == that.currAbbr && Objects.equals(formatted, that.formatted);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currAbbr, currId, formatted, value);
        }
    }

    private long id;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
    private String status;
    private String condition;
    @JsonProperty("sleeve_condition")
    private String sleeveCondition;
    private String comments;
    @JsonProperty("ships_from")
    private String shipsFrom;
    private Date posted;
    @JsonProperty("allow_offers")
    private boolean allowOffers;
    private boolean audio;
    private Price price;
    @JsonProperty("original_price")
    private OriginalPrice originalPrice;
    private Seller seller;
    @JsonProperty("shipping_price")
    private ShippingPrice shippingPrice;
    @JsonProperty("original_shipping_price")
    private OriginalShippingPrice originalShippingPrice;
    private MarketplaceInventoryRelease release;
    @JsonProperty("external_id")
    private long externalId;
    private String location;
    @JsonProperty("format_quantity")
    private String formatQuantity;
    private double weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSleeveCondition() {
        return sleeveCondition;
    }

    public void setSleeveCondition(String sleeveCondition) {
        this.sleeveCondition = sleeveCondition;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getShipsFrom() {
        return shipsFrom;
    }

    public void setShipsFrom(String shipsFrom) {
        this.shipsFrom = shipsFrom;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    public boolean isAllowOffers() {
        return allowOffers;
    }

    public void setAllowOffers(boolean allowOffers) {
        this.allowOffers = allowOffers;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public OriginalPrice getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(OriginalPrice originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ShippingPrice getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(ShippingPrice shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public OriginalShippingPrice getOriginalShippingPrice() {
        return originalShippingPrice;
    }

    public void setOriginalShippingPrice(OriginalShippingPrice originalShippingPrice) {
        this.originalShippingPrice = originalShippingPrice;
    }

    public MarketplaceInventoryRelease getRelease() {
        return release;
    }

    public void setRelease(MarketplaceInventoryRelease release) {
        this.release = release;
    }

    public long getExternalId() {
        return externalId;
    }

    public void setExternalId(long externalId) {
        this.externalId = externalId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFormatQuantity() {
        return formatQuantity;
    }

    public void setFormatQuantity(String formatQuantity) {
        this.formatQuantity = formatQuantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "id=" + id +
                ", resourceUrl=" + resourceUrl +
                ", uri=" + uri +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                ", sleeveCondition='" + sleeveCondition + '\'' +
                ", comments='" + comments + '\'' +
                ", shipsFrom='" + shipsFrom + '\'' +
                ", posted=" + posted +
                ", allowOffers=" + allowOffers +
                ", audio=" + audio +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", seller=" + seller +
                ", shippingPrice=" + shippingPrice +
                ", originalShippingPrice=" + originalShippingPrice +
                ", release=" + release +
                ", externalId=" + externalId +
                ", location='" + location + '\'' +
                ", formatQuantity='" + formatQuantity + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return id == listing.id && allowOffers == listing.allowOffers && audio == listing.audio && externalId == listing.externalId && Double.compare(listing.weight, weight) == 0 && Objects.equals(resourceUrl, listing.resourceUrl) && Objects.equals(uri, listing.uri) && Objects.equals(status, listing.status) && Objects.equals(condition, listing.condition) && Objects.equals(sleeveCondition, listing.sleeveCondition) && Objects.equals(comments, listing.comments) && Objects.equals(shipsFrom, listing.shipsFrom) && Objects.equals(posted, listing.posted) && Objects.equals(price, listing.price) && Objects.equals(originalPrice, listing.originalPrice) && Objects.equals(seller, listing.seller) && Objects.equals(shippingPrice, listing.shippingPrice) && Objects.equals(originalShippingPrice, listing.originalShippingPrice) && Objects.equals(release, listing.release) && Objects.equals(location, listing.location) && Objects.equals(formatQuantity, listing.formatQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceUrl, uri, status, condition, sleeveCondition, comments, shipsFrom, posted, allowOffers, audio, price, originalPrice, seller, shippingPrice, originalShippingPrice, release, externalId, location, formatQuantity, weight);
    }
}