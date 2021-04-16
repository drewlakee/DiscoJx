package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Artist {

    private String name;
    private String anv;
    private String join;
    private String role;
    private String tracks;
    private long id;
    @JsonProperty("resource_url")
    private String resourceUrl;

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

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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
                ", resourceUrl='" + resourceUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id && Objects.equals(name, artist.name) && Objects.equals(anv, artist.anv) && Objects.equals(join, artist.join) && Objects.equals(role, artist.role) && Objects.equals(tracks, artist.tracks) && Objects.equals(resourceUrl, artist.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, anv, join, role, tracks, id, resourceUrl);
    }
}
