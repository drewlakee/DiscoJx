package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserIdentity {

    private long id;
    private String username;
    @JsonProperty("resource_url")
    private String resourceUrl;
    @JsonProperty("consumer_name")
    private String consumerName;

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

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "UserIdentity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", consumerName='" + consumerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdentity that = (UserIdentity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(consumerName, that.consumerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, resourceUrl, consumerName);
    }
}
