package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Profile {

    private long id;
    @JsonProperty("resource_url")
    private String resourceUrl;
    private String uri;
    private String username;
    private String name;
    private String homePage;
    private String location;
    private String profile;
    private Date registered;
    private int rank;
    @JsonProperty("num_pending")
    private int numPending;
    @JsonProperty("num_for_sale")
    private int numForSale;
    @JsonProperty("num_lists")
    private int numLists;
    @JsonProperty("releases_contributed")
    private int releasesContributed;
    @JsonProperty("releases_rated")
    private int releasesRated;
    @JsonProperty("rating_avg")
    private int ratingAvg;
    @JsonProperty("inventory_url")
    private String inventoryUrl;
    @JsonProperty("collection_folders_url")
    private String collectionFoldersUrl;
    @JsonProperty("collection_fields_url")
    private String collectionFieldsUrl;
    @JsonProperty("wantlist_url")
    private String wantlistUrl;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("curr_abbr")
    private String currAbbr;
    private boolean activated;
    @JsonProperty("marketplace_suspended")
    private boolean marketplaceSuspended;
    @JsonProperty("banner_url")
    private String bannerUrl;
    @JsonProperty("buyer_rating")
    private int buyerRating;
    @JsonProperty("buyer_rating_stars")
    private int buyerRatingStars;
    @JsonProperty("buyer_num_ratings")
    private int buyerNumRatings;
    @JsonProperty("seller_rating")
    private int sellerRating;
    @JsonProperty("seller_rating_stars")
    private int sellerRatingStars;
    @JsonProperty("seller_num_ratings")
    private int sellerNumRatings;
    @JsonProperty("is_staff")
    private boolean isStaff;
    @JsonProperty("num_collection")
    private int numCollection;
    @JsonProperty("num_wantlist")
    private int numWantlist;

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

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getNumPending() {
        return numPending;
    }

    public void setNumPending(int numPending) {
        this.numPending = numPending;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public void setNumForSale(int numForSale) {
        this.numForSale = numForSale;
    }

    public int getNumLists() {
        return numLists;
    }

    public void setNumLists(int numLists) {
        this.numLists = numLists;
    }

    public int getReleasesContributed() {
        return releasesContributed;
    }

    public void setReleasesContributed(int releasesContributed) {
        this.releasesContributed = releasesContributed;
    }

    public int getReleasesRated() {
        return releasesRated;
    }

    public void setReleasesRated(int releasesRated) {
        this.releasesRated = releasesRated;
    }

    public int getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(int ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public String getInventoryUrl() {
        return inventoryUrl;
    }

    public void setInventoryUrl(String inventoryUrl) {
        this.inventoryUrl = inventoryUrl;
    }

    public String getCollectionFoldersUrl() {
        return collectionFoldersUrl;
    }

    public void setCollectionFoldersUrl(String collectionFoldersUrl) {
        this.collectionFoldersUrl = collectionFoldersUrl;
    }

    public String getCollectionFieldsUrl() {
        return collectionFieldsUrl;
    }

    public void setCollectionFieldsUrl(String collectionFieldsUrl) {
        this.collectionFieldsUrl = collectionFieldsUrl;
    }

    public String getWantlistUrl() {
        return wantlistUrl;
    }

    public void setWantlistUrl(String wantlistUrl) {
        this.wantlistUrl = wantlistUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCurrAbbr() {
        return currAbbr;
    }

    public void setCurrAbbr(String currAbbr) {
        this.currAbbr = currAbbr;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isMarketplaceSuspended() {
        return marketplaceSuspended;
    }

    public void setMarketplaceSuspended(boolean marketplaceSuspended) {
        this.marketplaceSuspended = marketplaceSuspended;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public int getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(int buyerRating) {
        this.buyerRating = buyerRating;
    }

    public int getBuyerRatingStars() {
        return buyerRatingStars;
    }

    public void setBuyerRatingStars(int buyerRatingStars) {
        this.buyerRatingStars = buyerRatingStars;
    }

    public int getBuyerNumRatings() {
        return buyerNumRatings;
    }

    public void setBuyerNumRatings(int buyerNumRatings) {
        this.buyerNumRatings = buyerNumRatings;
    }

    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }

    public int getSellerRatingStars() {
        return sellerRatingStars;
    }

    public void setSellerRatingStars(int sellerRatingStars) {
        this.sellerRatingStars = sellerRatingStars;
    }

    public int getSellerNumRatings() {
        return sellerNumRatings;
    }

    public void setSellerNumRatings(int sellerNumRatings) {
        this.sellerNumRatings = sellerNumRatings;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public int getNumCollection() {
        return numCollection;
    }

    public void setNumCollection(int numCollection) {
        this.numCollection = numCollection;
    }

    public int getNumWantlist() {
        return numWantlist;
    }

    public void setNumWantlist(int numWantlist) {
        this.numWantlist = numWantlist;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", uri='" + uri + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", homePage='" + homePage + '\'' +
                ", location='" + location + '\'' +
                ", profile='" + profile + '\'' +
                ", registered=" + registered +
                ", rank=" + rank +
                ", numPending=" + numPending +
                ", numForSale=" + numForSale +
                ", numLists=" + numLists +
                ", releasesContributed=" + releasesContributed +
                ", releasesRated=" + releasesRated +
                ", ratingAvg=" + ratingAvg +
                ", inventoryUrl='" + inventoryUrl + '\'' +
                ", collectionFoldersUrl='" + collectionFoldersUrl + '\'' +
                ", collectionFieldsUrl='" + collectionFieldsUrl + '\'' +
                ", wantlistUrl='" + wantlistUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", currAbbr='" + currAbbr + '\'' +
                ", activated=" + activated +
                ", marketplaceSuspended=" + marketplaceSuspended +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", buyerRating=" + buyerRating +
                ", buyerRatingStars=" + buyerRatingStars +
                ", buyerNumRatings=" + buyerNumRatings +
                ", sellerRating=" + sellerRating +
                ", sellerRatingStars=" + sellerRatingStars +
                ", sellerNumRatings=" + sellerNumRatings +
                ", isStaff=" + isStaff +
                ", numCollection=" + numCollection +
                ", numWantlist=" + numWantlist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile that = (Profile) o;
        return id == that.id && rank == that.rank && numPending == that.numPending && numForSale == that.numForSale && numLists == that.numLists && releasesContributed == that.releasesContributed && releasesRated == that.releasesRated && Double.compare(that.ratingAvg, ratingAvg) == 0 && activated == that.activated && marketplaceSuspended == that.marketplaceSuspended && Double.compare(that.buyerRating, buyerRating) == 0 && buyerRatingStars == that.buyerRatingStars && buyerNumRatings == that.buyerNumRatings && Double.compare(that.sellerRating, sellerRating) == 0 && sellerRatingStars == that.sellerRatingStars && sellerNumRatings == that.sellerNumRatings && isStaff == that.isStaff && numCollection == that.numCollection && numWantlist == that.numWantlist && Objects.equals(resourceUrl, that.resourceUrl) && Objects.equals(uri, that.uri) && Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(homePage, that.homePage) && Objects.equals(location, that.location) && Objects.equals(profile, that.profile) && Objects.equals(registered, that.registered) && Objects.equals(inventoryUrl, that.inventoryUrl) && Objects.equals(collectionFoldersUrl, that.collectionFoldersUrl) && Objects.equals(collectionFieldsUrl, that.collectionFieldsUrl) && Objects.equals(wantlistUrl, that.wantlistUrl) && Objects.equals(avatarUrl, that.avatarUrl) && Objects.equals(currAbbr, that.currAbbr) && Objects.equals(bannerUrl, that.bannerUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceUrl, uri, username, name, homePage, location, profile, registered, rank, numPending, numForSale, numLists, releasesContributed, releasesRated, ratingAvg, inventoryUrl, collectionFoldersUrl, collectionFieldsUrl, wantlistUrl, avatarUrl, currAbbr, activated, marketplaceSuspended, bannerUrl, buyerRating, buyerRatingStars, buyerNumRatings, sellerRating, sellerRatingStars, sellerNumRatings, isStaff, numCollection, numWantlist);
    }
}
