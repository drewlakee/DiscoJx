package discojx.discogs.objects.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class UploadItem {

    private long id;
    private String status;
    @JsonProperty("created_ts")
    private Date createdTs;
    @JsonProperty("finished_ts")
    private Date finishedTs;
    private String filename;
    private String type;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UploadItem{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", createdTs=" + createdTs +
                ", finishedTs=" + finishedTs +
                ", filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UploadItem that = (UploadItem) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(createdTs, that.createdTs) && Objects.equals(finishedTs, that.finishedTs) && Objects.equals(filename, that.filename) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdTs, finishedTs, filename, type);
    }
}
