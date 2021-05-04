package discojx.discogs.api;

public enum DiscogsApiEndpoints {

    ROOT                                        ("https://api.discogs.com"),

    USER_PROFILE                                (ROOT.endpoint + "/users/{username}"),
    USER_PROFILE_EDIT                           (ROOT.endpoint + "/users/{username}"),
    USER_IDENTITY                               (ROOT.endpoint + "/oauth/identity"),
    USER_SUBMISSIONS                            (ROOT.endpoint + "/users/{username}/submissions"),
    USER_CONTRIBUTIONS                          (ROOT.endpoint + "/users/{username}/contributions"),
    USER_LISTS                                  (ROOT.endpoint + "/users/{username}/lists"),
    USER_LIST                                   (ROOT.endpoint + "/lists/{list_id}"),
    USER_WANT_LIST                              (ROOT.endpoint + "/users/{username}/wants"),
    USER_ADD_WANT_LIST                          (ROOT.endpoint + "/users/{username}/wants/{release_id}"),
    USER_EDIT_WANT_LIST                         (ROOT.endpoint + "/users/{username}/wants/{release_id}"),
    USER_DELETE_WANT_LIST                       (ROOT.endpoint + "/users/{username}/wants/{release_id}"),
    USER_COLLECTION_FOLDERS                     (ROOT.endpoint + "/users/{username}/collection/folders"),
    USER_COLLECTION_CREATE_FOLDER               (ROOT.endpoint + "/users/{username}/collection/folders"),
    USER_COLLECTION_FOLDER                      (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}"),
    USER_COLLECTION_EDIT_FOLDER                 (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}"),
    USER_COLLECTION_DELETE_FOLDER               (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}"),
    USER_COLLECTION_RELEASE_ITEMS_BY_RELEASE    (ROOT.endpoint + "/users/{username}/collection/releases/{release_id}"),
    USER_COLLECTION_RELEASE_ITEMS_BY_FOLDER     (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}/releases"),
    USER_COLLECTION_ADD_RELEASE_ITEM_TO_FOLDER  (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}/releases/{release_id}"),
    USER_COLLECTION_CHANGE_RATING_OF_RELEASE    (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}"),
    USER_COLLECTION_DELETE_INSTANCE_FROM_FOLDER (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}"),
    USER_COLLECTION_LIST_CUSTOM_FIELDS          (ROOT.endpoint + "/users/{username}/collection/fields"),
    USER_COLLECTION_EDIT_FIELDS_INSTANCE        (ROOT.endpoint + "/users/{username}/collection/folders/{folder_id}/releases/{release_id}/instances/{instance_id}/fields/{field_id}"),
    USER_COLLECTION_VALUE                       (ROOT.endpoint + "/users/{username}/collection/value"),

    INVENTORY_UPLOAD_ADD                        (ROOT.endpoint + "/inventory/upload/add"),
    INVENTORY_UPLOAD_CHANGE                     (ROOT.endpoint + "/inventory/upload/change"),
    INVENTORY_UPLOAD_DELETE                     (ROOT.endpoint + "/inventory/upload/delete"),
    INVENTORY_UPLOAD_GET_RECENT_UPLOADS         (ROOT.endpoint + "/inventory/upload"),
    INVENTORY_UPLOAD_GET_UPLOAD                 (ROOT.endpoint + "/inventory/upload/{id}"),
    INVENTORY_EXPORT_GET_YOUR_INVENTORY         (ROOT.endpoint + "/inventory/export"),
    INVENTORY_EXPORT_GET_RECENT_EXPORTS         (ROOT.endpoint + "/inventory/export"),
    INVENTORY_EXPORT_GET_EXPORT                 (ROOT.endpoint + "/inventory/export/{id}"),
    INVENTORY_EXPORT_DOWNLOAD_EXPORT            (ROOT.endpoint + "/inventory/export/{id}/download"),

    MARKETPLACE_INVENTORY                       (ROOT.endpoint + "/users/{username}/inventory"),
    MARKETPLACE_GET_LISTING                     (ROOT.endpoint + "/marketplace/listings/{listing_id}"),
    MARKETPLACE_EDIT_LISTING                    (ROOT.endpoint + "/marketplace/listings/{listing_id}"),
    MARKETPLACE_DELETE_LISTING                  (ROOT.endpoint + "/marketplace/listings/{listing_id}"),
    MARKETPLACE_NEW_LISTING                     (ROOT.endpoint + "/marketplace/listings"),
    MARKETPLACE_GET_ORDER                       (ROOT.endpoint + "/marketplace/orders/{order_id}"),
    MARKETPLACE_EDIT_ORDER                      (ROOT.endpoint + "/marketplace/orders/{order_id}"),
    MARKETPLACE_LIST_ORDERS                     (ROOT.endpoint + "/marketplace/purchases"),
    MARKETPLACE_LIST_ORDER_MESSAGES             (ROOT.endpoint + "/marketplace/orders/{order_id}/messages"),
    MARKETPLACE_ADD_NEW_ORDER_MESSAGE           (ROOT.endpoint + "/marketplace/orders/{order_id}/messages"),

    DATABASE_RELEASE                            (ROOT.endpoint + "/releases/{release_id}"),
    DATABASE_RELEASE_RATING_BY_USER             (ROOT.endpoint + "/releases/{release_id}/rating/{username}"),
    DATABASE_COMMUNITY_RELEASE_RATING           (ROOT.endpoint + "/releases/{release_id}/rating"),
    DATABASE_RELEASE_STATS                      (ROOT.endpoint + "/releases/{release_id}/stats"),
    DATABASE_MASTER_RELEASE                     (ROOT.endpoint + "/masters/{master_id}"),
    DATABASE_MASTER_RELEASE_VERSIONS            (ROOT.endpoint + "/masters/{master_id}/versions"),
    DATABASE_ARTIST                             (ROOT.endpoint + "/artists/{artist_id}"),
    DATABASE_ARTIST_RELEASES                    (ROOT.endpoint + "/artists/{artist_id}/releases"),
    DATABASE_LABEL                              (ROOT.endpoint + "/labels/{label_id}"),
    DATABASE_LABEL_RELEASES                     (ROOT.endpoint + "/labels/{label_id}/releases"),
    DATABASE_SEARCH                             (ROOT.endpoint + "/database/search");

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
