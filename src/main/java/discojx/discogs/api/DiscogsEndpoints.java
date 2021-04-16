package discojx.discogs.api;

public enum DiscogsEndpoints {

    ROOT ("https://api.discogs.com"),

    USER_IDENTITY (ROOT.endpoint + "/oauth/identity"),

    PROFILE (ROOT.endpoint + "/users/{username}"),
    PROFILE_EDIT (ROOT.endpoint + "/users/{username}"),

    USER_SUBMISSIONS(ROOT.endpoint + "/users/{username}/submissions");

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
