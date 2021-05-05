package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class ExportItem {

    private long id;
    private String status;
    private String filename;
    @JsonProperty("download_url")
    private String downloadUrl;
    private String url;
    @JsonProperty("created_ts")
    private Date createdTs;
    @JsonProperty("finished_ts")
    private Date finishedTs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public Date getFinishedTs() {
        return finishedTs;
    }

    public void setFinishedTs(Date finishedTs) {
        this.finishedTs = finishedTs;
    }

    @Override
    public String toString() {
        return "ExportItem{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", filename='" + filename + '\'' +
                ", downloadUrl=" + downloadUrl +
                ", url=" + url +
                ", createdTs=" + createdTs +
                ", finishedTs=" + finishedTs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExportItem that = (ExportItem) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(filename, that.filename) && Objects.equals(downloadUrl, that.downloadUrl) && Objects.equals(url, that.url) && Objects.equals(createdTs, that.createdTs) && Objects.equals(finishedTs, that.finishedTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, filename, downloadUrl, url, createdTs, finishedTs);
    }
}
