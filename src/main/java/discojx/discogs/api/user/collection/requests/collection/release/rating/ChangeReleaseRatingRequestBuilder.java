package discojx.discogs.api.user.collection.requests.collection.release.rating;

import discojx.requests.RequestBuilder;

public interface ChangeReleaseRatingRequestBuilder extends RequestBuilder<ChangeReleaseRatingRequest> {

    ChangeReleaseRatingRequestBuilder username(String username);
    ChangeReleaseRatingRequestBuilder folderId(long folderId);
    ChangeReleaseRatingRequestBuilder folderIdToReplace(long folderIdToReplace);
    ChangeReleaseRatingRequestBuilder releaseId(long releaseId);
    ChangeReleaseRatingRequestBuilder instanceId(long instanceId);
    ChangeReleaseRatingRequestBuilder rating(int rating);
}
