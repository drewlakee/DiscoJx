package discojx.discogs.objects;

import java.util.Objects;

public class Video {

    private String uri;
    private String title;
    private String description;
    private int duration;
    private boolean embed;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isEmbed() {
        return embed;
    }

    public void setEmbed(boolean embed) {
        this.embed = embed;
    }

    @Override
    public String toString() {
        return "Video{" +
                "uri=" + uri +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", embed=" + embed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return duration == video.duration && embed == video.embed && Objects.equals(uri, video.uri) && Objects.equals(title, video.title) && Objects.equals(description, video.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri, title, description, duration, embed);
    }
}
