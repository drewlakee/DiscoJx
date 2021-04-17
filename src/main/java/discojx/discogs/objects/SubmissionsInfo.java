package discojx.discogs.objects;

import java.util.List;
import java.util.Objects;

public class SubmissionsInfo {

    private List<Release> releases;
    private List<Artist> artists;
    private List<Label> labels;

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @Override
    public String toString() {
        return "SubmissionsInfo{" +
                "releases=" + releases +
                ", artists=" + artists +
                ", labels=" + labels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmissionsInfo that = (SubmissionsInfo) o;
        return Objects.equals(releases, that.releases) && Objects.equals(artists, that.artists) && Objects.equals(labels, that.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(releases, artists, labels);
    }
}
