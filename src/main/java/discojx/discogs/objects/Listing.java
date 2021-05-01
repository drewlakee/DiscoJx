package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

public class Listing {

    public static class Price {
        private int value;
        private MarketplaceCurrency currency;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
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
    private MarketplaceInventoryRelease release;

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

    public MarketplaceInventoryRelease getRelease() {
        return release;
    }

    public void setRelease(MarketplaceInventoryRelease release) {
        this.release = release;
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
                ", release=" + release +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listing listing = (Listing) o;
        return id == listing.id && allowOffers == listing.allowOffers && audio == listing.audio && Objects.equals(resourceUrl, listing.resourceUrl) && Objects.equals(uri, listing.uri) && Objects.equals(status, listing.status) && Objects.equals(condition, listing.condition) && Objects.equals(sleeveCondition, listing.sleeveCondition) && Objects.equals(comments, listing.comments) && Objects.equals(shipsFrom, listing.shipsFrom) && Objects.equals(posted, listing.posted) && Objects.equals(price, listing.price) && Objects.equals(originalPrice, listing.originalPrice) && Objects.equals(seller, listing.seller) && Objects.equals(release, listing.release);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceUrl, uri, status, condition, sleeveCondition, comments, shipsFrom, posted, allowOffers, audio, price, originalPrice, seller, release);
    }
}
