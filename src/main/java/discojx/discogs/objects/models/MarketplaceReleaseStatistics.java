package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class MarketplaceReleaseStatistics {

    public static class LowestPrice {
        private String currency;
        private double value;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "LowestPrice{" +
                    "currency='" + currency + '\'' +
                    ", value=" + value +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LowestPrice that = (LowestPrice) o;
            return Double.compare(that.value, value) == 0 && Objects.equals(currency, that.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(currency, value);
        }
    }

    @JsonProperty("lowest_price")
    private LowestPrice lowestPrice;
    @JsonProperty("num_for_sale")
    private int numForSale;
    @JsonProperty("blocked_from_sale")
    private boolean isBlockedFromSale;

    public LowestPrice getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(LowestPrice lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public void setNumForSale(int numForSale) {
        this.numForSale = numForSale;
    }

    public boolean isBlockedFromSale() {
        return isBlockedFromSale;
    }

    public void setBlockedFromSale(boolean blockedFromSale) {
        isBlockedFromSale = blockedFromSale;
    }

    @Override
    public String toString() {
        return "MarketplaceReleaseStatistics{" +
                "lowestPrice=" + lowestPrice +
                ", numForSale=" + numForSale +
                ", isBlockedFromSale=" + isBlockedFromSale +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketplaceReleaseStatistics that = (MarketplaceReleaseStatistics) o;
        return numForSale == that.numForSale && isBlockedFromSale == that.isBlockedFromSale && Objects.equals(lowestPrice, that.lowestPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowestPrice, numForSale, isBlockedFromSale);
    }
}
