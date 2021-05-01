package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ReleaseCommunity {

    @JsonProperty("in_wantlist")
    private int inWantList;
    @JsonProperty("in_collection")
    private int inCollection;

    public int getInWantList() {
        return inWantList;
    }

    public void setInWantList(int inWantList) {
        this.inWantList = inWantList;
    }

    public int getInCollection() {
        return inCollection;
    }

    public void setInCollection(int inCollection) {
        this.inCollection = inCollection;
    }

    @Override
    public String toString() {
        return "ReleaseCommunity{" +
                "inWantList=" + inWantList +
                ", inCollection=" + inCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseCommunity that = (ReleaseCommunity) o;
        return inWantList == that.inWantList && inCollection == that.inCollection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inWantList, inCollection);
    }
}
