package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Submitter {

    private String username;
    @JsonProperty("resource_url")
    private String resourceUrl;

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
        return "Submitter{" +
                "username='" + username + '\'' +
                ", resourceUrl=" + resourceUrl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submitter submitter = (Submitter) o;
        return Objects.equals(username, submitter.username) && Objects.equals(resourceUrl, submitter.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, resourceUrl);
    }
}
