package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserList {

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

    public static class Item {

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

        private String type;
        private long id;
        private String comment;
        private String uri;
        @JsonProperty("resource_url")
        private String resourceUrl;
        @JsonProperty("image_url")
        private String imageUrl;
        @JsonProperty("display_title")
        private String displayTitle;
        private Stats stats;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getDisplayTitle() {
            return displayTitle;
        }

        public void setDisplayTitle(String displayTitle) {
            this.displayTitle = displayTitle;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "type='" + type + '\'' +
                    ", id=" + id +
                    ", comment='" + comment + '\'' +
                    ", uri=" + uri +
                    ", resourceUrl=" + resourceUrl +
                    ", imageUrl=" + imageUrl +
                    ", displayTitle='" + displayTitle + '\'' +
                    ", stats=" + stats +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return id == item.id && Objects.equals(type, item.type) && Objects.equals(comment, item.comment) && Objects.equals(uri, item.uri) && Objects.equals(resourceUrl, item.resourceUrl) && Objects.equals(imageUrl, item.imageUrl) && Objects.equals(displayTitle, item.displayTitle) && Objects.equals(stats, item.stats);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, id, comment, uri, resourceUrl, imageUrl, displayTitle, stats);
        }
    }

    private long id;
    private User user;
    private String name;
    private String description;
    @JsonProperty("public")
    private boolean isPublic;
    @JsonProperty("date_added")
    private Date dateAdded;
    @JsonProperty("date_changed")
    private Date dateChanged;
    private String uri;
    @JsonProperty("resource_url")
    private String resourceUrl;
    @JsonProperty("image_url")
    private String imageUrl;
    private List<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isPublic=" + isPublic +
                ", dateAdded=" + dateAdded +
                ", dateChanged=" + dateChanged +
                ", uri=" + uri +
                ", resourceUrl=" + resourceUrl +
                ", imageUrl=" + imageUrl +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserList userList = (UserList) o;
        return id == userList.id && isPublic == userList.isPublic && Objects.equals(user, userList.user) && Objects.equals(name, userList.name) && Objects.equals(description, userList.description) && Objects.equals(dateAdded, userList.dateAdded) && Objects.equals(dateChanged, userList.dateChanged) && Objects.equals(uri, userList.uri) && Objects.equals(resourceUrl, userList.resourceUrl) && Objects.equals(imageUrl, userList.imageUrl) && Objects.equals(items, userList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, name, description, isPublic, dateAdded, dateChanged, uri, resourceUrl, imageUrl, items);
    }
}
