package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MarketplaceOrder {

    public static class Item {

        public static class Release {
            private long id;
            private String description;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            @Override
            public String toString() {
                return "Release{" +
                        "id=" + id +
                        ", description='" + description + '\'' +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Release release = (Release) o;
                return id == release.id && Objects.equals(description, release.description);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, description);
            }
        }

        public static class Price {
            private String currency;
            private double value;

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
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
                return "Price{" +
                        "currency=" + currency +
                        ", value=" + value +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Price price = (Price) o;
                return Double.compare(price.value, value) == 0 && currency.equals(price.currency);
            }

            @Override
            public int hashCode() {
                return Objects.hash(currency, value);
            }
        }

        private long id;
        @JsonProperty("media_condition")
        private String mediaCondition;
        @JsonProperty("sleeve_condition")
        private String sleeveCondition;
        private Release release;
        private Price price;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMediaCondition() {
            return mediaCondition;
        }

        public void setMediaCondition(String mediaCondition) {
            this.mediaCondition = mediaCondition;
        }

        public String getSleeveCondition() {
            return sleeveCondition;
        }

        public void setSleeveCondition(String sleeveCondition) {
            this.sleeveCondition = sleeveCondition;
        }

        public Release getRelease() {
            return release;
        }

        public void setRelease(Release release) {
            this.release = release;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", mediaCondition='" + mediaCondition + '\'' +
                    ", sleeveCondition='" + sleeveCondition + '\'' +
                    ", release=" + release +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return id == item.id && Objects.equals(mediaCondition, item.mediaCondition) && Objects.equals(sleeveCondition, item.sleeveCondition) && Objects.equals(release, item.release) && Objects.equals(price, item.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, mediaCondition, sleeveCondition, release, price);
        }
    }

    public static class Shipping {
        private String currency;
        private String method;
        private double value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Shipping{" +
                    "currency=" + currency +
                    ", method='" + method + '\'' +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shipping shipping = (Shipping) o;
            return Double.compare(shipping.value, value) == 0 && currency.equals(shipping.currency) && Objects.equals(method, shipping.method);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currency, method, value);
        }
    }

    private static class Seller {
        private long id;
        private String username;
        @JsonProperty("resource_url")
        private URL resourceUrl;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public URL getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(URL resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "Seller{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seller seller = (Seller) o;
            return id == seller.id && Objects.equals(username, seller.username) && Objects.equals(resourceUrl, seller.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, resourceUrl);
        }
    }

    public static class Buyer {
        private long id;
        private String username;
        @JsonProperty("resource_url")
        private URL resourceUrl;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public URL getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(URL resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "Buyer{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Buyer buyer = (Buyer) o;
            return id == buyer.id && Objects.equals(username, buyer.username) && Objects.equals(resourceUrl, buyer.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, resourceUrl);
        }
    }

    public static class Total {
        private String currency;
        private double value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
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
            return "Total{" +
                    "currency=" + currency +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Total total = (Total) o;
            return Double.compare(total.value, value) == 0 && currency.equals(total.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currency, value);
        }
    }

    private String id;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    @JsonProperty("messages_url")
    private URL messagesUrl;
    private URI uri;
    private String status;
    @JsonProperty("next_status")
    private List<String> nextStatuses;
    private Fee fee;
    private Date created;
    private List<Item> items;
    private Shipping shipping;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("additional_instructions")
    private String additionalInstructions;
    private boolean archived;
    private Seller seller;
    @JsonProperty("last_activity")
    private Date lastActivity;
    private Buyer buyer;
    private Total total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public URL getMessagesUrl() {
        return messagesUrl;
    }

    public void setMessagesUrl(URL messagesUrl) {
        this.messagesUrl = messagesUrl;
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

    public List<String> getNextStatuses() {
        return nextStatuses;
    }

    public void setNextStatuses(List<String> nextStatuses) {
        this.nextStatuses = nextStatuses;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getAdditionalInstructions() {
        return additionalInstructions;
    }

    public void setAdditionalInstructions(String additionalInstructions) {
        this.additionalInstructions = additionalInstructions;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MarketplaceOrder{" +
                "id='" + id + '\'' +
                ", resourceUrl=" + resourceUrl +
                ", messagesUrl=" + messagesUrl +
                ", uri=" + uri +
                ", status='" + status + '\'' +
                ", nextStatuses=" + nextStatuses +
                ", fee=" + fee +
                ", created=" + created +
                ", items=" + items +
                ", shipping=" + shipping +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", additionalInstructions='" + additionalInstructions + '\'' +
                ", archived=" + archived +
                ", seller=" + seller +
                ", lastActivity=" + lastActivity +
                ", buyer=" + buyer +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplaceOrder that = (MarketplaceOrder) o;
        return archived == that.archived && Objects.equals(id, that.id) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(messagesUrl, that.messagesUrl) && Objects.equals(uri, that.uri) && Objects.equals(status, that.status) && Objects.equals(nextStatuses, that.nextStatuses) && Objects.equals(fee, that.fee) && Objects.equals(created, that.created) && Objects.equals(items, that.items) && Objects.equals(shipping, that.shipping) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(additionalInstructions, that.additionalInstructions) && Objects.equals(seller, that.seller) && Objects.equals(lastActivity, that.lastActivity) && Objects.equals(buyer, that.buyer) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceUrl, messagesUrl, uri, status, nextStatuses, fee, created, items, shipping, shippingAddress, additionalInstructions, archived, seller, lastActivity, buyer, total);
    }
}
