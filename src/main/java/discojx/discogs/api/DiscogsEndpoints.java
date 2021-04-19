package discojx.discogs.api;

public enum DiscogsEndpoints {

    ROOT ("https://api.discogs.com"),

    USER_PROFILE(ROOT.endpoint + "/users/{username}"),
    USER_PROFILE_EDIT(ROOT.endpoint + "/users/{username}"),

    USER_IDENTITY (ROOT.endpoint + "/oauth/identity"),
    USER_SUBMISSIONS (ROOT.endpoint + "/users/{username}/submissions"),
    USER_CONTRIBUTIONS (ROOT.endpoint + "/users/{username}/contributions"),

    DATABASE_RELEASE (ROOT.endpoint + "/releases/{release_id}"),
    DATABASE_RELEASE_RATING_BY_USER (ROOT.endpoint + "/releases/{release_id}/rating/{username}"),
    DATABASE_COMMUNITY_RELEASE_RATING (ROOT.endpoint + "/releases/{release_id}/rating"),
    DATABASE_RELEASE_STATS (ROOT.endpoint + "/releases/{release_id}/stats"),
    DATABASE_MASTER_RELEASE (ROOT.endpoint + "/masters/{master_id}");

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
