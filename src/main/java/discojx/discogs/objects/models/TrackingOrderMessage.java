package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TrackingOrderMessage extends AbstractOrderMessage {

    public static class Actor {
        private long id;
        private String username;
        @JsonProperty("resource_url")
        private String resourceUrl;
        @JsonProperty("is_admin")
        private boolean isAdmin;

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

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }

        @Override
        public String toString() {
            return "Actor{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", resourceUrl='" + resourceUrl + '\'' +
                    ", isAdmin=" + isAdmin +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Actor actor = (Actor) o;
            return id == actor.id && isAdmin == actor.isAdmin && Objects.equals(username, actor.username) && Objects.equals(resourceUrl, actor.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, resourceUrl, isAdmin);
        }
    }

    private Actor actor;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "TrackingOrderMessage{" +
                "order=" + order +
                ", timestamp=" + timestamp +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", actor=" + actor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackingOrderMessage that = (TrackingOrderMessage) o;
        return Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor);
    }
}
