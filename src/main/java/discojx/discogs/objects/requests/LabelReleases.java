package discojx.discogs.objects.requests;

import discojx.discogs.objects.models.Release;

import java.util.List;
import java.util.Objects;

public class LabelReleases {

    private Pagination pagination;
    private List<Release.Label> releases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Release.Label> getReleases() {
        return releases;
    }

    public void setReleases(List<Release.Label> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return "LabelReleases{" +
                "pagination=" + pagination +
                ", releases=" + releases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelReleases that = (LabelReleases) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(releases, that.releases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, releases);
    }
}
