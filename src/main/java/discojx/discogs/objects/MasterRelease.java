package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class MasterRelease {

    private long id;
    @JsonProperty("main_release")
    private long mainRelease;
    @JsonProperty("most_recent_release")
    private long mostRecentRelease;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
    @JsonProperty("versions_url")
    private URL versionsUrl;
    @JsonProperty("main_release_url")
    private URL mainReleaseUrl;
    @JsonProperty("most_recent_release_url")
    private URL mostRecentReleaseUrl;
    @JsonProperty("num_for_sale")
    private int numForSale;
    @JsonProperty("lowest_price")
    private double lowestPrice;
    private List<Image> images;
    private List<String> genres;
    private List<String> styles;
    private int year;
    @JsonProperty("tracklist")
    private List<Track> trackList;
    private List<Artist.Short> artists;
    private String title;
    @JsonProperty("data_quality")
    private String dataQuality;
    private List<Video> videos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMainRelease() {
        return mainRelease;
    }

    public void setMainRelease(long mainRelease) {
        this.mainRelease = mainRelease;
    }

    public long getMostRecentRelease() {
        return mostRecentRelease;
    }

    public void setMostRecentRelease(long mostRecentRelease) {
        this.mostRecentRelease = mostRecentRelease;
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

    public URL getVersionsUrl() {
        return versionsUrl;
    }

    public void setVersionsUrl(URL versionsUrl) {
        this.versionsUrl = versionsUrl;
    }

    public URL getMainReleaseUrl() {
        return mainReleaseUrl;
    }

    public void setMainReleaseUrl(URL mainReleaseUrl) {
        this.mainReleaseUrl = mainReleaseUrl;
    }

    public URL getMostRecentReleaseUrl() {
        return mostRecentReleaseUrl;
    }

    public void setMostRecentReleaseUrl(URL mostRecentReleaseUrl) {
        this.mostRecentReleaseUrl = mostRecentReleaseUrl;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public List<Artist.Short> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist.Short> artists) {
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "MasterRelease{" +
                "id=" + id +
                ", mainRelease=" + mainRelease +
                ", mostRecentRelease=" + mostRecentRelease +
                ", resourceUrl=" + resourceUrl +
                ", uri=" + uri +
                ", versionsUrl=" + versionsUrl +
                ", mainReleaseUrl=" + mainReleaseUrl +
                ", mostRecentReleaseUrl=" + mostRecentReleaseUrl +
                ", numForSale=" + numForSale +
                ", lowestPrice=" + lowestPrice +
                ", images=" + images +
                ", genres=" + genres +
                ", styles=" + styles +
                ", year=" + year +
                ", trackList=" + trackList +
                ", artists=" + artists +
                ", title='" + title + '\'' +
                ", dataQuality='" + dataQuality + '\'' +
                ", videos=" + videos +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterRelease that = (MasterRelease) o;
        return id == that.id && mainRelease == that.mainRelease && mostRecentRelease == that.mostRecentRelease && numForSale == that.numForSale && Double.compare(that.lowestPrice, lowestPrice) == 0 && year == that.year && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(uri, that.uri) && Objects.equals(versionsUrl, that.versionsUrl) && Objects.equals(mainReleaseUrl, that.mainReleaseUrl) && Objects.equals(mostRecentReleaseUrl, that.mostRecentReleaseUrl) && Objects.equals(images, that.images) && Objects.equals(genres, that.genres) && Objects.equals(styles, that.styles) && Objects.equals(trackList, that.trackList) && Objects.equals(artists, that.artists) && Objects.equals(title, that.title) && Objects.equals(dataQuality, that.dataQuality) && Objects.equals(videos, that.videos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mainRelease, mostRecentRelease, resourceUrl, uri, versionsUrl, mainReleaseUrl, mostRecentReleaseUrl, numForSale, lowestPrice, images, genres, styles, year, trackList, artists, title, dataQuality, videos);
    }
}
