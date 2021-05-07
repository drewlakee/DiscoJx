package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class OrderMessage extends CommonOrderMessage {

    public static class From {
        private long id;
        private String username;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("resource_url")
        private String resourceUrl;

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

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "From{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    ", resourceUrl='" + resourceUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            From from = (From) o;
            return id == from.id && Objects.equals(username, from.username) && Objects.equals(avatarUrl, from.avatarUrl) && Objects.equals(resourceUrl, from.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, avatarUrl, resourceUrl);
        }
    }

    private From from;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "order=" + order +
                ", timestamp=" + timestamp +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", from=" + from +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderMessage that = (OrderMessage) o;
        return Objects.equals(from, that.from);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), from);
    }
}
