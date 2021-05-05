package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class CommonOrderMessage extends AbstractTypedObject {

    public static class Order {
        private String id;
        @JsonProperty("resource_url")
        private String resourceUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", resourceUrl='" + resourceUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return id.equals(order.id) && Objects.equals(resourceUrl, order.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, resourceUrl);
        }
    }

    protected Order order;
    protected Date timestamp;
    protected String subject;
    protected String message;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AbstractOrderMessage{" +
                "order=" + order +
                ", timestamp=" + timestamp +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CommonOrderMessage that = (CommonOrderMessage) o;
        return Objects.equals(order, that.order) && Objects.equals(timestamp, that.timestamp) && Objects.equals(subject, that.subject) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), order, timestamp, subject, message);
    }
}
