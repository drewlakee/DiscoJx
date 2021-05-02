package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Objects;

public class CreatedListingInfo {

    private long listingId;
    @JsonProperty("resource_url")
    private URL resourceUrl;

    public long getListingId() {
        return listingId;
    }

    public void setListingId(long listingId) {
        this.listingId = listingId;
    }

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public String toString() {
        return "CreatedListingInfo{" +
                "listingId=" + listingId +
                ", resourceUrl=" + resourceUrl +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatedListingInfo that = (CreatedListingInfo) o;
        return listingId == that.listingId && Objects.equals(resourceUrl, that.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listingId, resourceUrl);
    }
}
