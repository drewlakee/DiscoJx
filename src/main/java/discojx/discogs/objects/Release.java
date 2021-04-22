package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Release {

    public static class ArtistRelease {

        public static class Stats {

            public static class Community {
                @JsonProperty("in_wantlist")
                private int inWantList;
                @JsonProperty("in_collection")
                private int inCollection;

                public int getInWantList() {
                    return inWantList;
                }

                public void setInWantList(int inWantList) {
                    this.inWantList = inWantList;
                }

                public int getInCollection() {
                    return inCollection;
                }

                public void setInCollection(int inCollection) {
                    this.inCollection = inCollection;
                }

                @Override
                public String toString() {
                    return "Community{" +
                            "inWantList=" + inWantList +
                            ", inCollection=" + inCollection +
                            '}';
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    Community community = (Community) o;
                    return inWantList == community.inWantList && inCollection == community.inCollection;
                }

                @Override
                public int hashCode() {
                    return Objects.hash(inWantList, inCollection);
                }
            }

            private Community community;

            public Community getCommunity() {
                return community;
            }

            public void setCommunity(Community community) {
                this.community = community;
            }

            @Override
            public String toString() {
                return "Stats{" +
                        "community=" + community +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Stats stats = (Stats) o;
                return Objects.equals(community, stats.community);
            }

            @Override
            public int hashCode() {
                return Objects.hash(community);
            }
        }

        private long id;
        private String status;
        private String type;
        private String format;
        private String label;
        private String title;
        @JsonProperty("resource_url")
        private URL resourceUrl;
        private String role;
        private String artist;
        private int year;
        private URL thumb;
        private Stats stats;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public URL getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(URL resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public URL getThumb() {
            return thumb;
        }

        public void setThumb(URL thumb) {
            this.thumb = thumb;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }

        @Override
        public String toString() {
            return "ArtistRelease{" +
                    "id=" + id +
                    ", status='" + status + '\'' +
                    ", type='" + type + '\'' +
                    ", format='" + format + '\'' +
                    ", label='" + label + '\'' +
                    ", title='" + title + '\'' +
                    ", resourceUrl=" + resourceUrl +
                    ", role='" + role + '\'' +
                    ", artist='" + artist + '\'' +
                    ", year=" + year +
                    ", thumb=" + thumb +
                    ", stats=" + stats +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ArtistRelease that = (ArtistRelease) o;
            return id == that.id && year == that.year && Objects.equals(status, that.status) && Objects.equals(type, that.type) && Objects.equals(format, that.format) && Objects.equals(label, that.label) && Objects.equals(title, that.title) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(role, that.role) && Objects.equals(artist, that.artist) && Objects.equals(thumb, that.thumb) && Objects.equals(stats, that.stats);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, status, type, format, label, title, resourceUrl, role, artist, year, thumb, stats);
        }
    }

    private long id;
    private String status;
    private int year;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
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
    private URL masterUrl;
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
    private String release;
    @JsonProperty("extraartists")
    private List<Artist.Short> extraArtists;
    @JsonProperty("tracklist")
    private List<Track> trackList;

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

    public URL getMasterUrl() {
        return masterUrl;
    }

    public void setMasterUrl(URL masterUrl) {
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

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public List<Artist.Short> getExtraArtists() {
        return extraArtists;
    }

    public void setExtraArtists(List<Artist.Short> extraArtists) {
        this.extraArtists = extraArtists;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
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
                ", release='" + release + '\'' +
                ", extraArtists=" + extraArtists +
                ", trackList=" + trackList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release1 = (Release) o;
        return id == release1.id && year == release1.year && formatQuantity == release1.formatQuantity && numForSale == release1.numForSale && Double.compare(release1.lowestPrice, lowestPrice) == 0 && masterId == release1.masterId && estimatedWeight == release1.estimatedWeight && Objects.equals(status, release1.status) && Objects.equals(resourceUrl, release1.resourceUrl) && Objects.equals(uri, release1.uri) && Objects.equals(artists, release1.artists) && Objects.equals(artistsSort, release1.artistsSort) && Objects.equals(labels, release1.labels) && Objects.equals(identifiers, release1.identifiers) && Objects.equals(companies, release1.companies) && Objects.equals(formats, release1.formats) && Objects.equals(dataQuality, release1.dataQuality) && Objects.equals(community, release1.community) && Objects.equals(dateAdded, release1.dateAdded) && Objects.equals(dateChanged, release1.dateChanged) && Objects.equals(masterUrl, release1.masterUrl) && Objects.equals(title, release1.title) && Objects.equals(country, release1.country) && Objects.equals(released, release1.released) && Objects.equals(releasedFormatted, release1.releasedFormatted) && Objects.equals(videos, release1.videos) && Objects.equals(genres, release1.genres) && Objects.equals(styles, release1.styles) && Objects.equals(images, release1.images) && Objects.equals(thumb, release1.thumb) && Objects.equals(notes, release1.notes) && Objects.equals(series, release1.series) && Objects.equals(release, release1.release) && Objects.equals(extraArtists, release1.extraArtists) && Objects.equals(trackList, release1.trackList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, year, resourceUrl, uri, artists, artistsSort, labels, identifiers, companies, formats, dataQuality, community, formatQuantity, dateAdded, dateChanged, numForSale, lowestPrice, masterId, masterUrl, title, country, released, releasedFormatted, videos, genres, styles, images, thumb, estimatedWeight, notes, series, release, extraArtists, trackList);
    }
}
