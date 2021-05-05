package discojx.discogs.objects.requests;

import discojx.discogs.objects.models.UserWant;

import java.util.List;
import java.util.Objects;

public class UserWantList {

    private Pagination pagination;
    private List<UserWant> wants;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<UserWant> getWants() {
        return wants;
    }

    public void setWants(List<UserWant> wants) {
        this.wants = wants;
    }

    @Override
    public String toString() {
        return "UserWantList{" +
                "pagination=" + pagination +
                ", wants=" + wants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWantList that = (UserWantList) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(wants, that.wants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, wants);
    }
}
