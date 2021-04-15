package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Profile {

    private long id;
    private String resourceUrl;
    private String uri;
    private String username;
    private String name;
    private String homePage;
    private String location;
    private String profile;
    private Date registered;
    private int rank;
    private int numPending;
    private int numForSale;
    private int numLists;
    private int releasesContributed;
    private int releasesRated;
    private int ratingAvg;
    private String inventoryUrl;
    private String collectionFoldersUrl;
    private String collectionFieldsUrl;
    private String wantlistUrl;
    private String avatarUrl;
    private String currAbbr;
    private boolean activated;
    private boolean marketplaceSuspended;
    private String bannerUrl;
    private int buyerRating;
    private int buyerRatingStars;
    private int buyerNumRatings;
    private int sellerRating;
    private int sellerRatingStars;
    private int sellerNumRatings;
    private boolean isStaff;
    private int numCollection;
    private int numWantlist;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("resource_url")
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

    @JsonProperty("num_pending")
    public int getNumPending() {
        return numPending;
    }

    public void setNumPending(int numPending) {
        this.numPending = numPending;
    }

    @JsonProperty("num_for_sale")
    public int getNumForSale() {
        return numForSale;
    }

    public void setNumForSale(int numForSale) {
        this.numForSale = numForSale;
    }

    @JsonProperty("num_lists")
    public int getNumLists() {
        return numLists;
    }

    public void setNumLists(int numLists) {
        this.numLists = numLists;
    }

    @JsonProperty("releases_contributed")
    public int getReleasesContributed() {
        return releasesContributed;
    }

    public void setReleasesContributed(int releasesContributed) {
        this.releasesContributed = releasesContributed;
    }

    @JsonProperty("releases_rated")
    public int getReleasesRated() {
        return releasesRated;
    }

    public void setReleasesRated(int releasesRated) {
        this.releasesRated = releasesRated;
    }

    @JsonProperty("rating_avg")
    public int getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(int ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    @JsonProperty("inventory_url")
    public String getInventoryUrl() {
        return inventoryUrl;
    }

    public void setInventoryUrl(String inventoryUrl) {
        this.inventoryUrl = inventoryUrl;
    }

    @JsonProperty("collection_folders_url")
    public String getCollectionFoldersUrl() {
        return collectionFoldersUrl;
    }

    public void setCollectionFoldersUrl(String collectionFoldersUrl) {
        this.collectionFoldersUrl = collectionFoldersUrl;
    }

    @JsonProperty("collection_fields_url")
    public String getCollectionFieldsUrl() {
        return collectionFieldsUrl;
    }

    public void setCollectionFieldsUrl(String collectionFieldsUrl) {
        this.collectionFieldsUrl = collectionFieldsUrl;
    }

    @JsonProperty("wantlist_url")
    public String getWantlistUrl() {
        return wantlistUrl;
    }

    public void setWantlistUrl(String wantlistUrl) {
        this.wantlistUrl = wantlistUrl;
    }

    @JsonProperty("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("curr_abbr")
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

    @JsonProperty("marketplace_suspended")
    public boolean isMarketplaceSuspended() {
        return marketplaceSuspended;
    }

    public void setMarketplaceSuspended(boolean marketplaceSuspended) {
        this.marketplaceSuspended = marketplaceSuspended;
    }

    @JsonProperty("banner_url")
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @JsonProperty("buyer_rating")
    public int getBuyerRating() {
        return buyerRating;
    }

    public void setBuyerRating(int buyerRating) {
        this.buyerRating = buyerRating;
    }

    @JsonProperty("buyer_rating_stars")
    public int getBuyerRatingStars() {
        return buyerRatingStars;
    }

    public void setBuyerRatingStars(int buyerRatingStars) {
        this.buyerRatingStars = buyerRatingStars;
    }

    @JsonProperty("buyer_num_ratings")
    public int getBuyerNumRatings() {
        return buyerNumRatings;
    }

    public void setBuyerNumRatings(int buyerNumRatings) {
        this.buyerNumRatings = buyerNumRatings;
    }

    @JsonProperty("seller_rating")
    public int getSellerRating() {
        return sellerRating;
    }

    public void setSellerRating(int sellerRating) {
        this.sellerRating = sellerRating;
    }

    @JsonProperty("seller_rating_stars")
    public int getSellerRatingStars() {
        return sellerRatingStars;
    }

    public void setSellerRatingStars(int sellerRatingStars) {
        this.sellerRatingStars = sellerRatingStars;
    }

    @JsonProperty("seller_num_ratings")
    public int getSellerNumRatings() {
        return sellerNumRatings;
    }

    public void setSellerNumRatings(int sellerNumRatings) {
        this.sellerNumRatings = sellerNumRatings;
    }

    @JsonProperty("is_staff")
    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    @JsonProperty("num_collection")
    public int getNumCollection() {
        return numCollection;
    }

    public void setNumCollection(int numCollection) {
        this.numCollection = numCollection;
    }

    @JsonProperty("num_wantlist")
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
