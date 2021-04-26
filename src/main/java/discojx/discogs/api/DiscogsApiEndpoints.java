package discojx.discogs.api;

public enum DiscogsApiEndpoints {

    ROOT                                    ("https://api.discogs.com"),

    USER_PROFILE                            (ROOT.endpoint + "/users/{username}"),
    USER_PROFILE_EDIT                       (ROOT.endpoint + "/users/{username}"),
    USER_IDENTITY                           (ROOT.endpoint + "/oauth/identity"),
    USER_SUBMISSIONS                        (ROOT.endpoint + "/users/{username}/submissions"),
    USER_CONTRIBUTIONS                      (ROOT.endpoint + "/users/{username}/contributions"),
    USER_LISTS                              (ROOT.endpoint + "/users/{username}/lists"),
    USER_LIST                               (ROOT.endpoint + "/lists/{list_id}"),
    USER_WANT_LIST                          (ROOT.endpoint + "/users/{username}/wants"),
    USER_ADD_WANT_LIST                      (ROOT.endpoint + "/users/{username}/wants/{release_id}"),
    USER_EDIT_WANT_LIST                     (ROOT.endpoint + "/users/{username}/wants/{release_id}"),
    USER_DELETE_WANT_LIST                   (ROOT.endpoint + "/users/{username}/wants/{release_id}"),

    DATABASE_RELEASE                        (ROOT.endpoint + "/releases/{release_id}"),
    DATABASE_RELEASE_RATING_BY_USER         (ROOT.endpoint + "/releases/{release_id}/rating/{username}"),
    DATABASE_COMMUNITY_RELEASE_RATING       (ROOT.endpoint + "/releases/{release_id}/rating"),
    DATABASE_RELEASE_STATS                  (ROOT.endpoint + "/releases/{release_id}/stats"),
    DATABASE_MASTER_RELEASE                 (ROOT.endpoint + "/masters/{master_id}"),
    DATABASE_MASTER_RELEASE_VERSIONS        (ROOT.endpoint + "/masters/{master_id}/versions"),
    DATABASE_ARTIST                         (ROOT.endpoint + "/artists/{artist_id}"),
    DATABASE_ARTIST_RELEASES                (ROOT.endpoint + "/artists/{artist_id}/releases"),
    DATABASE_LABEL                          (ROOT.endpoint + "/labels/{label_id}"),
    DATABASE_LABEL_RELEASES                 (ROOT.endpoint + "/labels/{label_id}/releases"),
    DATABASE_SEARCH                         (ROOT.endpoint + "/database/search");

    private final String endpoint;

    DiscogsApiEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getEndpointWith(String parameters) {
        return endpoint + parameters;
    }

    @Override
    public String toString() {
        return "DiscogsApiEndpoints{" +
                "endpoint='" + endpoint + '\'' +
                '}';
    }
}
