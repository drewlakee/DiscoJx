package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Release {

    private long id;
    private String status;
    private int year;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
    private List<Artist> artists;
    @JsonProperty("artists_sort")
    private String artistsSort;
    private List<Label> labels;
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
    private URL thumb;
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

    public URL getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(URL resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
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

    public URL getThumb() {
        return thumb;
    }

    public void setThumb(URL thumb) {
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
        return "Release{" +
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
        Release release = (Release) o;
        return id == release.id && year == release.year && formatQuantity == release.formatQuantity && numForSale == release.numForSale && Double.compare(release.lowestPrice, lowestPrice) == 0 && masterId == release.masterId && estimatedWeight == release.estimatedWeight && Objects.equals(status, release.status) && Objects.equals(resourceUrl, release.resourceUrl) && Objects.equals(uri, release.uri) && Objects.equals(artists, release.artists) && Objects.equals(artistsSort, release.artistsSort) && Objects.equals(labels, release.labels) && Objects.equals(identifiers, release.identifiers) && Objects.equals(companies, release.companies) && Objects.equals(formats, release.formats) && Objects.equals(dataQuality, release.dataQuality) && Objects.equals(community, release.community) && Objects.equals(dateAdded, release.dateAdded) && Objects.equals(dateChanged, release.dateChanged) && Objects.equals(masterUrl, release.masterUrl) && Objects.equals(title, release.title) && Objects.equals(country, release.country) && Objects.equals(released, release.released) && Objects.equals(releasedFormatted, release.releasedFormatted) && Objects.equals(videos, release.videos) && Objects.equals(genres, release.genres) && Objects.equals(styles, release.styles) && Objects.equals(images, release.images) && Objects.equals(thumb, release.thumb) && Objects.equals(notes, release.notes) && Objects.equals(series, release.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, year, resourceUrl, uri, artists, artistsSort, labels, identifiers, companies, formats, dataQuality, community, formatQuantity, dateAdded, dateChanged, numForSale, lowestPrice, masterId, masterUrl, title, country, released, releasedFormatted, videos, genres, styles, images, thumb, estimatedWeight, notes, series);
    }
}
