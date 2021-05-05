package discojx.discogs.api.endpoints.user.collection.requests.release.rating;

import discojx.discogs.api.requests.RequestBuilder;

public interface ChangeReleaseRatingRequestBuilder extends RequestBuilder<ChangeReleaseRatingRequest> {

    ChangeReleaseRatingRequestBuilder username(String username);
    ChangeReleaseRatingRequestBuilder folderId(long folderId);
    ChangeReleaseRatingRequestBuilder folderIdToReplace(long folderIdToReplace);
    ChangeReleaseRatingRequestBuilder releaseId(long releaseId);
    ChangeReleaseRatingRequestBuilder instanceId(long instanceId);
    ChangeReleaseRatingRequestBuilder rating(int rating);
}
