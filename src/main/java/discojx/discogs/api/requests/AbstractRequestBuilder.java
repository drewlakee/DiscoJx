package discojx.discogs.api.requests;

import discojx.http.AbstractHttpClient;

import java.util.Objects;

public abstract class AbstractRequestBuilder {

    protected final AbstractHttpClient client;

    protected String queryUrl;

    public AbstractRequestBuilder(AbstractHttpClient client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "AbstractRequestBuilder{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRequestBuilder that = (AbstractRequestBuilder) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
