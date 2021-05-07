# DiscoJx - An Asynchronous DiscogsAPI Java Client Library

That client library provides simple access to Discogs API on Java with asynchronous processing that build on Completable Futures.

## Quick Start

```java
// create api client
DiscogsApi api = new DefaultDiscogsApi.Builder()
        .setPersonalAccessToken("your_token_may_placed_here")
        .build(); 

// try to make request and identify yourself
UserIdentity identity = api.user().identity().identifyYourself().executeAsync().join().entity();

// query database for some useful data
SearchResults searchResults = api.database().search().query("Tiny Moving Parts").build().executeAsync().join().entity();
searchResults.getResults().forEach(System.out::println);

// ...
```

Watch out releases to see some implemented API versions and features.

## Installation

The artifact is available through
[Maven Central Repository Search](https://search.maven.org/artifact/io.github.drewlakee/discojx) via
[Sonatype](https://s01.oss.sonatype.org/#nexus-search;quick~discojx).

### Maven

```XML
<dependency>
  <groupId>io.github.drewlakee</groupId>
  <artifactId>discojx</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Gradle

```Gradle
implementation 'io.github.drewlakee:discojx:1.0.0'
```
