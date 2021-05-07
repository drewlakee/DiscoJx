package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Community {

    private int have;
    private int want;
    private Rating rating;
    private Submitter submitter;
    private List<Contributor> contributors;
    @JsonProperty("data_quality")
    private String dataQuality;
    private String status;

    public int getHave() {
        return have;
    }

    public void setHave(int have) {
        this.have = have;
    }

    public int getWant() {
        return want;
    }

    public void setWant(int want) {
        this.want = want;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Community{" +
                "have=" + have +
                ", want=" + want +
                ", rating=" + rating +
                ", submitter=" + submitter +
                ", contributors=" + contributors +
                ", dataQuality='" + dataQuality + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return have == community.have && want == community.want && Objects.equals(rating, community.rating) && Objects.equals(submitter, community.submitter) && Objects.equals(contributors, community.contributors) && Objects.equals(dataQuality, community.dataQuality) && Objects.equals(status, community.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(have, want, rating, submitter, contributors, dataQuality, status);
    }
}
