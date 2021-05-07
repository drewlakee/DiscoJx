package discojx.discogs.objects.models;

import java.util.Objects;

public class UserCollectionValue {

    private String maximum;
    private String median;
    private String minimum;

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    public String getMedian() {
        return median;
    }

    public void setMedian(String median) {
        this.median = median;
    }

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @Override
    public String toString() {
        return "UserCollectionValue{" +
                "maximum='" + maximum + '\'' +
                ", median='" + median + '\'' +
                ", minimum='" + minimum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCollectionValue that = (UserCollectionValue) o;
        return Objects.equals(maximum, that.maximum) && Objects.equals(median, that.median) && Objects.equals(minimum, that.minimum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maximum, median, minimum);
    }
}
