package discojx.discogs.objects.requests;

import discojx.discogs.objects.models.Listing;

import java.util.List;
import java.util.Objects;

public class MarketplaceInventory {

    private Pagination pagination;
    private List<Listing> listings;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    @Override
    public String toString() {
        return "MarketplaceInventory{" +
                "pagination=" + pagination +
                ", listings=" + listings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplaceInventory that = (MarketplaceInventory) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(listings, that.listings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, listings);
    }
}
