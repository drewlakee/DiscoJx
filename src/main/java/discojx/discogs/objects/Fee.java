package discojx.discogs.objects;

import java.util.Objects;

public class Fee {

    private MarketplaceCurrency currency;
    private double value;

    public MarketplaceCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(MarketplaceCurrency currency) {
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
        return "Fee{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fee fee = (Fee) o;
        return Double.compare(fee.value, value) == 0 && currency == fee.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
}
