package discojx.discogs.objects.models;

import java.util.Objects;

public class PriceSuggestion {

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
        return "PriceSuggestion{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceSuggestion that = (PriceSuggestion) o;
        return Double.compare(that.value, value) == 0 && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, value);
    }
}
