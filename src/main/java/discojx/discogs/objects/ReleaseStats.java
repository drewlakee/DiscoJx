package discojx.discogs.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ReleaseStats {

    @JsonProperty("num_have")
    private int numHave;
    @JsonProperty("num_want")
    private int numWant;
    @JsonProperty("is_offensive")
    private boolean isOffensive;

    public int getNumHave() {
        return numHave;
    }

    public void setNumHave(int numHave) {
        this.numHave = numHave;
    }

    public int getNumWant() {
        return numWant;
    }

    public void setNumWant(int numWant) {
        this.numWant = numWant;
    }

    public boolean isOffensive() {
        return isOffensive;
    }

    public void setOffensive(boolean offensive) {
        isOffensive = offensive;
    }

    @Override
    public String toString() {
        return "ReleaseStats{" +
                "numHave=" + numHave +
                ", numWant=" + numWant +
                ", isOffensive=" + isOffensive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReleaseStats that = (ReleaseStats) o;
        return numHave == that.numHave && numWant == that.numWant && isOffensive == that.isOffensive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numHave, numWant, isOffensive);
    }
}
