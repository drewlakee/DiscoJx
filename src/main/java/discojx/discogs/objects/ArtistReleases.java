package discojx.discogs.objects;

import java.util.List;
import java.util.Objects;

public class ArtistReleases {

    private Pagination pagination;
    private List<Release.ArtistRelease> releases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Release.ArtistRelease> getReleases() {
        return releases;
    }

    public void setReleases(List<Release.ArtistRelease> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return "ArtistReleases{" +
                "pagination=" + pagination +
                ", releases=" + releases +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistReleases that = (ArtistReleases) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(releases, that.releases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, releases);
    }
}
