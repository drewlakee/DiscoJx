package discojx.discogs.objects;

import java.util.List;

public class SubmissionsInfo {

    private List<Release> releases;

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    @Override
    public String toString() {
        return "SubmissionsInfo{" +
                "releases=" + releases +
                '}';
    }
}
