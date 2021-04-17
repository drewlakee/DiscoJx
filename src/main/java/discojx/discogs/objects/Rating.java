package discojx.discogs.objects;

import java.util.Objects;

public class Rating {

    private int count;
    private int average;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "count=" + count +
                ", average=" + average +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return count == rating.count && average == rating.average;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, average);
    }
}
