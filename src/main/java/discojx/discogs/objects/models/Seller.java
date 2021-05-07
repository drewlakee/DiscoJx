package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Seller {

    private long id;
    private String username;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private SellerStats stats;
    @JsonProperty("min_order_total")
    private int minOrderTotal;
    @JsonProperty("html_url")
    private String htmlUrl;
    private long uid;
    private String url;
    private String payment;
    private String shipping;
    @JsonProperty("resource_url")
    private String resourceUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public SellerStats getStats() {
        return stats;
    }

    public void setStats(SellerStats stats) {
        this.stats = stats;
    }

    public int getMinOrderTotal() {
        return minOrderTotal;
    }

    public void setMinOrderTotal(int minOrderTotal) {
        this.minOrderTotal = minOrderTotal;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatarUrl=" + avatarUrl +
                ", stats=" + stats +
                ", minOrderTotal=" + minOrderTotal +
                ", htmlUrl=" + htmlUrl +
                ", uid=" + uid +
                ", url=" + url +
                ", payment='" + payment + '\'' +
                ", shipping='" + shipping + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return id == seller.id && minOrderTotal == seller.minOrderTotal && uid == seller.uid && Objects.equals(username, seller.username) && Objects.equals(avatarUrl, seller.avatarUrl) && Objects.equals(stats, seller.stats) && Objects.equals(htmlUrl, seller.htmlUrl) && Objects.equals(url, seller.url) && Objects.equals(payment, seller.payment) && Objects.equals(shipping, seller.shipping) && Objects.equals(resourceUrl, seller.resourceUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, avatarUrl, stats, minOrderTotal, htmlUrl, uid, url, payment, shipping, resourceUrl);
    }
}
