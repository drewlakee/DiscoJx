package discojx.discogs.objects;

import java.util.Objects;

public class ReleaseDefaultStats {

    private ReleaseCommunity community;

    public ReleaseCommunity getCommunity() {
        return community;
    }

    public void setCommunity(ReleaseCommunity community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "ReleaseDefaultStats{" +
                "community=" + community +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseDefaultStats that = (ReleaseDefaultStats) o;
        return Objects.equals(community, that.community);
    }

    @Override
    public int hashCode() {
        return Objects.hash(community);
    }
}
