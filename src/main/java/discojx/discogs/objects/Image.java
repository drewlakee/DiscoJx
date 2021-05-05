package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Image {

    private String type;
    private String uri;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String uri150;
    private int width;
    private int height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getUri150() {
        return uri150;
    }

    public void setUri150(String uri150) {
        this.uri150 = uri150;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type='" + type + '\'' +
                ", uri=" + uri +
                ", resourceUrl=" + resourceUrl +
                ", uri150=" + uri150 +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return width == image.width && height == image.height && Objects.equals(type, image.type) && Objects.equals(uri, image.uri) && Objects.equals(resourceUrl, image.resourceUrl) && Objects.equals(uri150, image.uri150);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, uri, resourceUrl, uri150, width, height);
    }
}
