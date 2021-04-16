package discojx.clients.authentication;

import java.util.Objects;

public abstract class AbstractToken {

    private final String token;

    protected AbstractToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractToken that = (AbstractToken) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
