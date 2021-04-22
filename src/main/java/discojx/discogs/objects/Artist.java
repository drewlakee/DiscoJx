package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Artist {

    public static class Submissions {

        private String name;
        private long id;
        @JsonProperty("resource_url")
        private URL resourceUrl;
        private URI uri;
        @JsonProperty("releases_url")
        private URL releasesUrl;
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

        public URL getReleasesUrl() {
            return releasesUrl;
        }

        public void setReleasesUrl(URL releasesUrl) {
            this.releasesUrl = releasesUrl;
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
            return "Submissions{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", resourceUrl=" + resourceUrl +
                    ", uri=" + uri +
                    ", releaseUrl=" + releasesUrl +
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
            Submissions that = (Submissions) o;
            return id == that.id && Objects.equals(name, that.name) && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(uri, that.uri) && Objects.equals(releasesUrl, that.releasesUrl) && Objects.equals(images, that.images) && Objects.equals(realname, that.realname) && Objects.equals(profile, that.profile) && Objects.equals(urls, that.urls) && Objects.equals(dataQuality, that.dataQuality);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, resourceUrl, uri, releasesUrl, images, realname, profile, urls, dataQuality);
        }
    }

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
    @JsonProperty("releases_url")
    private URL releasesUrl;
    private List<Image> images;
    private String profile;
    private List<String> urls;
    @JsonProperty("namevariations")
    private List<String> nameVariations;
    private List<Member> members;
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

    public URL getReleasesUrl() {
        return releasesUrl;
    }

    public void setReleasesUrl(URL releasesUrl) {
        this.releasesUrl = releasesUrl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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

    public List<String> getNameVariations() {
        return nameVariations;
    }

    public void setNameVariations(List<String> nameVariations) {
        this.nameVariations = nameVariations;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
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
                ", releasesUrl=" + releasesUrl +
                ", images=" + images +
                ", profile='" + profile + '\'' +
                ", urls=" + urls +
                ", nameVariations=" + nameVariations +
                ", members=" + members +
                ", dataQuality='" + dataQuality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id && Objects.equals(name, artist.name) && Objects.equals(resourceUrl, artist.resourceUrl) && Objects.equals(uri, artist.uri) && Objects.equals(releasesUrl, artist.releasesUrl) && Objects.equals(images, artist.images) && Objects.equals(profile, artist.profile) && Objects.equals(urls, artist.urls) && Objects.equals(nameVariations, artist.nameVariations) && Objects.equals(members, artist.members) && Objects.equals(dataQuality, artist.dataQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, resourceUrl, uri, releasesUrl, images, profile, urls, nameVariations, members, dataQuality);
    }
}
