package discojx.requests;

import discojx.clients.AbstractHttpClient;

import java.util.Objects;

public abstract class AbstractRequest {

    protected final AbstractHttpClient client;

    protected final String queryUrl;

    public AbstractRequest(AbstractRequestBuilder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    @Override
    public String toString() {
        return "AbstractRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRequest that = (AbstractRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
