package discojx.discogs.objects.models;

import java.util.Objects;

public class SellerStats {

    private String rating;
    public int stars;
    public int total;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SellerStats{" +
                "rating='" + rating + '\'' +
                ", stars=" + stars +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerStats that = (SellerStats) o;
        return stars == that.stars && total == that.total && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, stars, total);
    }
}
