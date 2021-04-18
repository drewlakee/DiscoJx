package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Artist {

    public static class Short {
        private String name;
        private String anv;
        private String join;
        private String role;
        private String tracks;
        private long id;
        @JsonProperty("resource_url")
        private URL resourceUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAnv() {
            return anv;
        }

        public void setAnv(String anv) {
            this.anv = anv;
        }

        public String getJoin() {
            return join;
        }

        public void setJoin(String join) {
            this.join = join;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getTracks() {
            return tracks;
        }

        public void setTracks(String tracks) {
            this.tracks = tracks;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public URL getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(URL resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "Short{" +
                    "name='" + name + '\'' +
                    ", anv='" + anv + '\'' +
                    ", join='" + join + '\'' +
                    ", role='" + role + '\'' +
                    ", tracks='" + tracks + '\'' +
                    ", id=" + id +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Short aShort = (Short) o;
            return id == aShort.id && Objects.equals(name, aShort.name) && Objects.equals(anv, aShort.anv) && Objects.equals(join, aShort.join) && Objects.equals(role, aShort.role) && Objects.equals(tracks, aShort.tracks) && Objects.equals(resourceUrl, aShort.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, anv, join, role, tracks, id, resourceUrl);
        }
    }

    private String name;
    private long id;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    private URI uri;
    @JsonProperty("release_url")
    private URL releaseUrl;
    private List<Image> images;
    private String realname;
    private String profile;
    private List<String> urls;
    @JsonProperty("data_quality")
    private String dataQuality;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public URL getReleaseUrl() {
        return releaseUrl;
    }

    public void setReleaseUrl(URL releaseUrl) {
        this.releaseUrl = releaseUrl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", resourceUrl=" + resourceUrl +
                ", uri=" + uri +
                ", releaseUrl=" + releaseUrl +
                ", images=" + images +
                ", realname='" + realname + '\'' +
                ", profile='" + profile + '\'' +
                ", urls=" + urls +
                ", dataQuality='" + dataQuality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id && Objects.equals(name, artist.name) && Objects.equals(resourceUrl, artist.resourceUrl) && Objects.equals(uri, artist.uri) && Objects.equals(releaseUrl, artist.releaseUrl) && Objects.equals(images, artist.images) && Objects.equals(realname, artist.realname) && Objects.equals(profile, artist.profile) && Objects.equals(urls, artist.urls) && Objects.equals(dataQuality, artist.dataQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, resourceUrl, uri, releaseUrl, images, realname, profile, urls, dataQuality);
    }
}
