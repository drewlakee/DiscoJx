package discojx.discogs.api.database.requests.search;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import discojx.clients.AbstractHttpClient;
import discojx.discogs.api.DiscogsEndpoints;
import discojx.discogs.objects.SearchResult;
import discojx.utils.requests.RequestParametersConstructor;
import discojx.utils.requests.StringBuilderSequentialRequestParametersConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class DefaultAsyncSearchRequest implements AsyncSearchRequest {

    protected final AbstractHttpClient<HttpEntity> client;

    protected static final ObjectMapper jsonMapper = new JsonMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final String queryUrl;

    public DefaultAsyncSearchRequest(Builder builder) {
        this.client = builder.client;
        this.queryUrl = builder.queryUrl;
    }

    public static class Builder implements AsyncSearchRequestBuilder {

        private final AbstractHttpClient<HttpEntity> client;

        private int page;
        private int perPage;
        private String query;
        private String type;
        private String title;
        private String releaseTitle;
        private String credit;
        private String artist;
        private String anv;
        private String label;
        private String genre;
        private String style;
        private String country;
        private int year;
        private String format;
        private String catno;
        private String barcode;
        private String track;
        private String submitter;
        private String contributor;

        private String queryUrl;

        public Builder(AbstractHttpClient<HttpEntity> client) {
            this.client = client;
        }

        @Override
        public AsyncSearchRequestBuilder query(String query) {
            this.query = query;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder releaseTitle(String releaseTitle) {
            this.releaseTitle = releaseTitle;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder credit(String credit) {
            this.credit = credit;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder artist(String artist) {
            this.artist = artist;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder anv(String anv) {
            this.anv = anv;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder label(String label) {
            this.label = label;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder style(String style) {
            this.style = style;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder country(String country) {
            this.country = country;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder year(int year) {
            this.year = year;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder format(String format) {
            this.format = format;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder catno(String catno) {
            this.catno = catno;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder barcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder track(String track) {
            this.track = track;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder submitter(String submitter) {
            this.submitter = submitter;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder contributor(String contributor) {
            this.contributor = contributor;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder page(int page) {
            this.page = page;
            return this;
        }

        @Override
        public AsyncSearchRequestBuilder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        @Override
        public AsyncSearchRequest build() {
            this.queryUrl = DiscogsEndpoints.DATABASE_SEARCH.getEndpointWith(constructParameters().toParametersString());
            return new DefaultAsyncSearchRequest(this);
        }

        @Override
        public RequestParametersConstructor constructParameters() {
            StringBuilderSequentialRequestParametersConstructor parameters =
                    new StringBuilderSequentialRequestParametersConstructor();

            if (page > 0) parameters.append("page", page);
            if (perPage > 0) parameters.append("per_page", perPage);
            if (query != null) parameters.append("query", query);
            if (type != null) parameters.append("type", type);
            if (title != null) parameters.append("title", title);
            if (releaseTitle != null) parameters.append("release_title", releaseTitle);
            if (credit != null) parameters.append("credit", credit);
            if (artist != null) parameters.append("artist", artist);
            if (anv != null) parameters.append("anv", anv);
            if (label != null) parameters.append("label", label);
            if (genre != null) parameters.append("genre", genre);
            if (style != null) parameters.append("style", style);
            if (country != null) parameters.append("country", country);
            if (year > 0) parameters.append("year", year);
            if (format != null) parameters.append("format", format);
            if (catno != null) parameters.append("catno", catno);
            if (barcode != null) parameters.append("barcode", barcode);
            if (track != null) parameters.append("track", track);
            if (submitter != null) parameters.append("submitter", submitter);
            if (contributor != null) parameters.append("contributor", contributor);

            return parameters;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "client=" + client +
                    ", page=" + page +
                    ", perPage=" + perPage +
                    ", query='" + query + '\'' +
                    ", type='" + type + '\'' +
                    ", title='" + title + '\'' +
                    ", releaseTitle='" + releaseTitle + '\'' +
                    ", credit='" + credit + '\'' +
                    ", artist='" + artist + '\'' +
                    ", anv='" + anv + '\'' +
                    ", label='" + label + '\'' +
                    ", genre='" + genre + '\'' +
                    ", style='" + style + '\'' +
                    ", country='" + country + '\'' +
                    ", year=" + year +
                    ", format='" + format + '\'' +
                    ", catno='" + catno + '\'' +
                    ", barcode='" + barcode + '\'' +
                    ", track='" + track + '\'' +
                    ", submitter='" + submitter + '\'' +
                    ", contributor='" + contributor + '\'' +
                    ", queryUrl='" + queryUrl + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return page == builder.page && perPage == builder.perPage && year == builder.year && Objects.equals(client, builder.client) && Objects.equals(query, builder.query) && Objects.equals(type, builder.type) && Objects.equals(title, builder.title) && Objects.equals(releaseTitle, builder.releaseTitle) && Objects.equals(credit, builder.credit) && Objects.equals(artist, builder.artist) && Objects.equals(anv, builder.anv) && Objects.equals(label, builder.label) && Objects.equals(genre, builder.genre) && Objects.equals(style, builder.style) && Objects.equals(country, builder.country) && Objects.equals(format, builder.format) && Objects.equals(catno, builder.catno) && Objects.equals(barcode, builder.barcode) && Objects.equals(track, builder.track) && Objects.equals(submitter, builder.submitter) && Objects.equals(contributor, builder.contributor) && Objects.equals(queryUrl, builder.queryUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(client, page, perPage, query, type, title, releaseTitle, credit, artist, anv, label, genre, style, country, year, format, catno, barcode, track, submitter, contributor, queryUrl);
        }
    }

    @Override
    public CompletableFuture<SearchResult> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Optional<HttpEntity> execute = client.execute(new HttpGet(queryUrl));
            HttpEntity httpEntity = execute.orElseThrow(() -> new CompletionException(new NullPointerException("HttpEntity expected.")));

            SearchResult searchResult;
            try {
                searchResult = jsonMapper.readValue(httpEntity.getContent(), SearchResult.class);
            } catch (IOException e) {
                throw new CompletionException(e);
            }

            return searchResult;
        });
    }

    @Override
    public String toString() {
        return "DefaultAsyncSearchRequest{" +
                "client=" + client +
                ", queryUrl='" + queryUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAsyncSearchRequest that = (DefaultAsyncSearchRequest) o;
        return Objects.equals(client, that.client) && Objects.equals(queryUrl, that.queryUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, queryUrl);
    }
}
