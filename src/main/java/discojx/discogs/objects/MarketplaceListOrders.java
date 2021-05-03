package discojx.discogs.objects;

import java.util.List;
import java.util.Objects;

public class MarketplaceListOrders {

    private Pagination pagination;
    private List<MarketplaceOrder> purchases;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<MarketplaceOrder> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<MarketplaceOrder> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "MarketplaceListOrders{" +
                "pagination=" + pagination +
                ", orders=" + purchases +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplaceListOrders that = (MarketplaceListOrders) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(purchases, that.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, purchases);
    }
}
