package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CommunityReleaseRating {

    private Rating rating;
    @JsonProperty("release_id")
    private long releaseId;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    @Override
    public String toString() {
        return "CommunityReleaseRating{" +
                "rating=" + rating +
                ", releaseId=" + releaseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityReleaseRating that = (CommunityReleaseRating) o;
        return releaseId == that.releaseId && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, releaseId);
    }
}
