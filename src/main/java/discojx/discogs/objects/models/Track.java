package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Track {

    private String position;
    @JsonProperty("type_")
    private String type;
    private String title;
    private String duration;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "position='" + position + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(position, track.position) && Objects.equals(type, track.type) && Objects.equals(title, track.title) && Objects.equals(duration, track.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, type, title, duration);
    }
}
