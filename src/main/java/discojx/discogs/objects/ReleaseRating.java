package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ReleaseRating {

    private String username;
    @JsonProperty("release_id")
    private long releaseId;
    private double rating;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ReleaseRating{" +
                "username='" + username + '\'' +
                ", releaseId=" + releaseId +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseRating that = (ReleaseRating) o;
        return releaseId == that.releaseId && Double.compare(that.rating, rating) == 0 && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, releaseId, rating);
    }
}
