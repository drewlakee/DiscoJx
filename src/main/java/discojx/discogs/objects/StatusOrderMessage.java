package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StatusOrderMessage extends AbstractOrderMessage {

    public static class Actor {
        private long id;
        private String username;
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

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "Actor{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", resourceUrl='" + resourceUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Actor actor = (Actor) o;
            return id == actor.id && Objects.equals(username, actor.username) && Objects.equals(resourceUrl, actor.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, username, resourceUrl);
        }
    }

    private Actor actor;
    @JsonProperty("status_id")
    private long statusId;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "StatusOrderMessage{" +
                "order=" + order +
                ", timestamp=" + timestamp +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", actor=" + actor +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusOrderMessage that = (StatusOrderMessage) o;
        return statusId == that.statusId && Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, statusId);
    }
}
