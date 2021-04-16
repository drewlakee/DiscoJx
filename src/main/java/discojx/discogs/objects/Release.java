package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Release {

    private long id;
    private String status;
    private int year;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String uri;
    private List<Artist> artists;
    @JsonProperty("artists_sort")
    private String artistsSort;
    private List<Label> labels;
    // TODO series [...]
    // TODO companies [...]
    // TODO formats [...]
    @JsonProperty("data_quality")
    private String dataQuality;
    // TODO community {...}
    private int formatQuantity;
    @JsonProperty("date_added")
    private Date dateAdded;
    @JsonProperty("date_changed")
    private Date dateChanged;
    @JsonProperty("num_for_sale")
    private int numForSale;
    @JsonProperty("lowest_price")
    private int lowestPrice;
    @JsonProperty("master_id")
    private long masterId;
    @JsonProperty("master_url")
    private String masterUrl;
    private String title;
    private String country;
    private Date released;
    @JsonProperty("released_formatted")
    private String releasedFormatted;
    // TODO identifiers [...]
    // TODO videos [...]
    // TODO genres [...]
    // TODO styles [...]
    // TODO images [...]
    private String thumb;
    @JsonProperty("estimated_weight")
    private int estimatedWeight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public String getArtistsSort() {
        return artistsSort;
    }

    public void setArtistsSort(String artistsSort) {
        this.artistsSort = artistsSort;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public int getFormatQuantity() {
        return formatQuantity;
    }

    public void setFormatQuantity(int formatQuantity) {
        this.formatQuantity = formatQuantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public void setNumForSale(int numForSale) {
        this.numForSale = numForSale;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public long getMasterId() {
        return masterId;
    }

    public void setMasterId(long masterId) {
        this.masterId = masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(String masterUrl) {
        this.masterUrl = masterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public String getReleasedFormatted() {
        return releasedFormatted;
    }

    public void setReleasedFormatted(String releasedFormatted) {
        this.releasedFormatted = releasedFormatted;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public int getEstimatedWeight() {
        return estimatedWeight;
    }

    public void setEstimatedWeight(int estimatedWeight) {
        this.estimatedWeight = estimatedWeight;
    }

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", year=" + year +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", uri='" + uri + '\'' +
                ", artists=" + artists +
                ", artistsSort='" + artistsSort + '\'' +
                ", labels=" + labels +
                ", dataQuality='" + dataQuality + '\'' +
                ", formatQuantity=" + formatQuantity +
                ", dateAdded=" + dateAdded +
                ", dateChanged=" + dateChanged +
                ", numForSale=" + numForSale +
                ", lowestPrice=" + lowestPrice +
                ", masterId=" + masterId +
                ", masterUrl='" + masterUrl + '\'' +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", released=" + released +
                ", releasedFormatted='" + releasedFormatted + '\'' +
                ", thumb='" + thumb + '\'' +
                ", estimatedWeight=" + estimatedWeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return id == release.id && year == release.year && formatQuantity == release.formatQuantity && numForSale == release.numForSale && lowestPrice == release.lowestPrice && masterId == release.masterId && estimatedWeight == release.estimatedWeight && Objects.equals(status, release.status) && Objects.equals(resourceUrl, release.resourceUrl) && Objects.equals(uri, release.uri) && Objects.equals(artists, release.artists) && Objects.equals(artistsSort, release.artistsSort) && Objects.equals(labels, release.labels) && Objects.equals(dataQuality, release.dataQuality) && Objects.equals(dateAdded, release.dateAdded) && Objects.equals(dateChanged, release.dateChanged) && Objects.equals(masterUrl, release.masterUrl) && Objects.equals(title, release.title) && Objects.equals(country, release.country) && Objects.equals(released, release.released) && Objects.equals(releasedFormatted, release.releasedFormatted) && Objects.equals(thumb, release.thumb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, year, resourceUrl, uri, artists, artistsSort, labels, dataQuality, formatQuantity, dateAdded, dateChanged, numForSale, lowestPrice, masterId, masterUrl, title, country, released, releasedFormatted, thumb, estimatedWeight);
    }
}
