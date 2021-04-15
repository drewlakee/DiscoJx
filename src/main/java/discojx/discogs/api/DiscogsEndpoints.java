package discojx.discogs.api;

public enum DiscogsEndpoints {

    ROOT ("https://api.discogs.com"),
    USER_IDENTITY (ROOT.getEndpoint() + "/oauth/identity");

    private final String endpoint;

    DiscogsEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public String toString() {
        return "DiscogsApiEndpoints{" +
                "endpoint='" + endpoint + '\'' +
                '}';
    }
}
