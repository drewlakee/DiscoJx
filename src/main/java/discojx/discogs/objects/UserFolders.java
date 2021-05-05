package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class UserFolders {

    public static class UserFolder {
        private long id;
        private String name;
        private int count;
        @JsonProperty("resource_url")
        private String resourceUrl;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        @Override
        public String toString() {
            return "UserFolder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", count=" + count +
                    ", resourceUrl=" + resourceUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserFolder that = (UserFolder) o;
            return id == that.id && count == that.count && Objects.equals(name, that.name) && Objects.equals(resourceUrl, that.resourceUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, count, resourceUrl);
        }
    }

    private List<UserFolder> folders;

    public List<UserFolder> getFolders() {
        return folders;
    }

    public void setFolders(List<UserFolder> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "UserFolders{" +
                "folders=" + folders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserFolders that = (UserFolders) o;
        return Objects.equals(folders, that.folders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folders);
    }
}
