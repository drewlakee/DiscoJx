package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import discojx.discogs.objects.requests.Pagination;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserLists {

    public static class UserList {

        public static class User {
            private long id;
            @JsonProperty("avatar_url")
            private String avatarUrl;
            private String username;
            @JsonProperty("resource_url")
            private String resourceUrl;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getResourceUrl() {
                return resourceUrl;
            }

            public void setResourceUrl(String resourceUrl) {
                this.resourceUrl = resourceUrl;
            }

            @Override
            public String toString() {
                return "User{" +
                        "id=" + id +
                        ", avatarUrl=" + avatarUrl +
                        ", username='" + username + '\'' +
                        ", resourceUrl=" + resourceUrl +
                        '}';
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return id == user.id && Objects.equals(avatarUrl, user.avatarUrl) && Objects.equals(username, user.username) && Objects.equals(resourceUrl, user.resourceUrl);
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, avatarUrl, username, resourceUrl);
            }
        }

        @JsonProperty("date_added")
        private Date dateAdded;
        @JsonProperty("date_changed")
        private Date dateChanged;
        private String name;
        private long id;
        private String uri;
        @JsonProperty("resource_url")
        private String resourceUrl;
        @JsonProperty("public")
        private boolean isPublic;
        private String description;
        private User user;
        @JsonProperty("image_url")
        private String imageUrl;

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

        public boolean isPublic() {
            return isPublic;
        }

        public void setPublic(boolean aPublic) {
            isPublic = aPublic;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        public String toString() {
            return "UserList{" +
                    "dateAdded=" + dateAdded +
                    ", dateChanged=" + dateChanged +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", uri=" + uri +
                    ", resourceUrl=" + resourceUrl +
                    ", isPublic=" + isPublic +
                    ", description='" + description + '\'' +
                    ", user=" + user +
                    ", imageUrl=" + imageUrl +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserList userList = (UserList) o;
            return id == userList.id && isPublic == userList.isPublic && Objects.equals(dateAdded, userList.dateAdded) && Objects.equals(dateChanged, userList.dateChanged) && Objects.equals(name, userList.name) && Objects.equals(uri, userList.uri) && Objects.equals(resourceUrl, userList.resourceUrl) && Objects.equals(description, userList.description) && Objects.equals(user, userList.user) && Objects.equals(imageUrl, userList.imageUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dateAdded, dateChanged, name, id, uri, resourceUrl, isPublic, description, user, imageUrl);
        }
    }

    private Pagination pagination;
    @JsonProperty("lists")
    private List<UserList> userLists;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<UserList> getUserLists() {
        return userLists;
    }

    public void setUserLists(List<UserList> userLists) {
        this.userLists = userLists;
    }

    @Override
    public String toString() {
        return "UserLists{" +
                "pagination=" + pagination +
                ", userLists=" + userLists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLists userLists1 = (UserLists) o;
        return Objects.equals(pagination, userLists1.pagination) && Objects.equals(userLists, userLists1.userLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, userLists);
    }
}
