package discojx.discogs.objects.requests;

import discojx.discogs.objects.models.Contribution;

import java.util.List;
import java.util.Objects;

public class Contributions {

    private Pagination pagination;
    private List<Contribution> contributions;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return "Contributions{" +
                "pagination=" + pagination +
                ", contributions=" + contributions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contributions that = (Contributions) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(contributions, that.contributions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, contributions);
    }
}
