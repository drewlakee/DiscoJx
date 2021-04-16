package discojx.discogs.objects;

import java.util.Objects;

public class Submissions {

    private Pagination pagination;
    private SubmissionsInfo submissions;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public SubmissionsInfo getSubmissions() {
        return submissions;
    }

    public void setSubmissions(SubmissionsInfo submissions) {
        this.submissions = submissions;
    }

    @Override
    public String toString() {
        return "Submissions{" +
                "pagination=" + pagination +
                ", submissions=" + submissions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submissions that = (Submissions) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(submissions, that.submissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, submissions);
    }
}
