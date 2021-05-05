package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import discojx.discogs.objects.requests.Pagination;

import java.util.List;
import java.util.Objects;

public class MasterReleaseVersions {

    public static class Version {

        public static class Stats {

            public static class Community {
                @JsonProperty("in_wantlist")
                private int inWantlist;
                @JsonProperty("in_collection")
                private int inCollection;

                public int getInWantlist() {
                    return inWantlist;
                }

                public void setInWantlist(int inWantlist) {
                    this.inWantlist = inWantlist;
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
                            "inWantlist=" + inWantlist +
                            ", inCollection=" + inCollection +
                            '}';
                }

                @Override
                public boolean equals(Object o) {
                    if (this == o) return true;
                    if (o == null || getClass() != o.getClass()) return false;
                    Community community = (Community) o;
                    return inWantlist == community.inWantlist && inCollection == community.inCollection;
                }

                @Override
                public int hashCode() {
                    return Objects.hash(inWantlist, inCollection);
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

        private long id;
        private String label;
        private String country;
        private String title;
        @JsonProperty("major_formats")
        private List<String> majorFormats;
        private String format;
        private String catno;
        private String released;
        private String status;
        @JsonProperty("resource_url")
        private String resourceUrl;
        private String thumb;
        private Stats stats;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getMajorFormats() {
            return majorFormats;
        }

        public void setMajorFormats(List<String> majorFormats) {
            this.majorFormats = majorFormats;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getCatno() {
            return catno;
        }

        public void setCatno(String catno) {
            this.catno = catno;
        }

        public String getReleased() {
            return released;
        }

        public void setReleased(String released) {
            this.released = released;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public void setResourceUrl(String resourceUrl) {
            this.resourceUrl = resourceUrl;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Stats getStats() {
            return stats;
        }

        public void setStats(Stats stats) {
            this.stats = stats;
        }

        @Override
        public String toString() {
            return "Version{" +
                    "id=" + id +
                    ", label='" + label + '\'' +
                    ", country='" + country + '\'' +
                    ", title='" + title + '\'' +
                    ", majorFormats=" + majorFormats +
                    ", format='" + format + '\'' +
                    ", catno='" + catno + '\'' +
                    ", released='" + released + '\'' +
                    ", status='" + status + '\'' +
                    ", resourceUrl=" + resourceUrl +
                    ", thumb=" + thumb +
                    ", stats=" + stats +
                    '}';
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Version version = (Version) o;
            return id == version.id && Objects.equals(label, version.label) && Objects.equals(country, version.country) && Objects.equals(title, version.title) && Objects.equals(majorFormats, version.majorFormats) && Objects.equals(format, version.format) && Objects.equals(catno, version.catno) && Objects.equals(released, version.released) && Objects.equals(status, version.status) && Objects.equals(resourceUrl, version.resourceUrl) && Objects.equals(thumb, version.thumb) && Objects.equals(stats, version.stats);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, label, country, title, majorFormats, format, catno, released, status, resourceUrl, thumb, stats);
        }
    }

    private Pagination pagination;
    private List<Version> versions;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "MasterReleaseVersions{" +
                "pagination=" + pagination +
                ", versions=" + versions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterReleaseVersions that = (MasterReleaseVersions) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(versions, that.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, versions);
    }
}
