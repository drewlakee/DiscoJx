package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Artist {

    private String name;
    private String anv;
    private String join;
    private String role;
    private String tracks;
    private long id;
    @JsonProperty("resource_url")
    private URL resourceUrl;
    @JsonProperty("realname")
    private String realName;
    private String profile;
    private List<URL> urls;
    @JsonProperty("data_quality")
    private String dataQuality;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
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
                ", anv='" + anv + '\'' +
                ", join='" + join + '\'' +
                ", role='" + role + '\'' +
                ", tracks='" + tracks + '\'' +
                ", id=" + id +
                ", resourceUrl=" + resourceUrl +
                ", realName='" + realName + '\'' +
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
        return id == artist.id && Objects.equals(name, artist.name) && Objects.equals(anv, artist.anv) && Objects.equals(join, artist.join) && Objects.equals(role, artist.role) && Objects.equals(tracks, artist.tracks) && Objects.equals(resourceUrl, artist.resourceUrl) && Objects.equals(realName, artist.realName) && Objects.equals(profile, artist.profile) && Objects.equals(urls, artist.urls) && Objects.equals(dataQuality, artist.dataQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, anv, join, role, tracks, id, resourceUrl, realName, profile, urls, dataQuality);
    }
}
