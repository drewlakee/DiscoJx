package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Contribution {

    private long id;
    private String status;
    private int year;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String uri;
    private List<Artist.Short> artists;
    @JsonProperty("artists_sort")
    private String artistsSort;
    private List<Label.Short> labels;
    private List<Identifier> identifiers;
    private List<Company> companies;
    private List<Format> formats;
    @JsonProperty("data_quality")
    private String dataQuality;
    private Community community;
    @JsonProperty("format_quantity")
    private int formatQuantity;
    @JsonProperty("date_added")
    private Date dateAdded;
    @JsonProperty("date_changed")
    private Date dateChanged;
    @JsonProperty("num_for_sale")
    private int numForSale;
    @JsonProperty("lowest_price")
    private double lowestPrice;
    @JsonProperty("master_id")
    private long masterId;
    @JsonProperty("master_url")
    private String masterUrl;
    private String title;
    private String country;
    private Date released;
    @JsonProperty("released_formatted")
    private String releasedFormatted;
    private List<Video> videos;
    private List<String> genres;
    private List<String> styles;
    private List<Image> images;
    private String thumb;
    @JsonProperty("estimated_weight")
    private int estimatedWeight;
    private String notes;
    private List<Series> series;

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

    public List<Artist.Short> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist.Short> artists) {
        this.artists = artists;
    }

    public String getArtistsSort() {
        return artistsSort;
    }

    public void setArtistsSort(String artistsSort) {
        this.artistsSort = artistsSort;
    }

    public List<Label.Short> getLabels() {
        return labels;
    }

    public void setLabels(List<Label.Short> labels) {
        this.labels = labels;
    }

    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
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

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
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

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", year=" + year +
                ", resourceUrl=" + resourceUrl +
                ", uri=" + uri +
                ", artists=" + artists +
                ", artistsSort='" + artistsSort + '\'' +
                ", labels=" + labels +
                ", identifiers=" + identifiers +
                ", companies=" + companies +
                ", formats=" + formats +
                ", dataQuality='" + dataQuality + '\'' +
                ", community=" + community +
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
                ", videos=" + videos +
                ", genres=" + genres +
                ", styles=" + styles +
                ", images=" + images +
                ", thumb=" + thumb +
                ", estimatedWeight=" + estimatedWeight +
                ", notes='" + notes + '\'' +
                ", series=" + series +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribution that = (Contribution) o;
        return id == that.id && year == that.year && formatQuantity == that.formatQuantity && numForSale == that.numForSale && Double.compare(that.lowestPrice, lowestPrice) == 0 && masterId == that.masterId && estimatedWeight == that.estimatedWeight && Objects.equals(status, that.status) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(uri, that.uri) && Objects.equals(artists, that.artists) && Objects.equals(artistsSort, that.artistsSort) && Objects.equals(labels, that.labels) && Objects.equals(identifiers, that.identifiers) && Objects.equals(companies, that.companies) && Objects.equals(formats, that.formats) && Objects.equals(dataQuality, that.dataQuality) && Objects.equals(community, that.community) && Objects.equals(dateAdded, that.dateAdded) && Objects.equals(dateChanged, that.dateChanged) && Objects.equals(masterUrl, that.masterUrl) && Objects.equals(title, that.title) && Objects.equals(country, that.country) && Objects.equals(released, that.released) && Objects.equals(releasedFormatted, that.releasedFormatted) && Objects.equals(videos, that.videos) && Objects.equals(genres, that.genres) && Objects.equals(styles, that.styles) && Objects.equals(images, that.images) && Objects.equals(thumb, that.thumb) && Objects.equals(notes, that.notes) && Objects.equals(series, that.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, year, resourceUrl, uri, artists, artistsSort, labels, identifiers, companies, formats, dataQuality, community, formatQuantity, dateAdded, dateChanged, numForSale, lowestPrice, masterId, masterUrl, title, country, released, releasedFormatted, videos, genres, styles, images, thumb, estimatedWeight, notes, series);
    }
}
