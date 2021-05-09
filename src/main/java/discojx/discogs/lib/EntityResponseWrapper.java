package discojx.discogs.lib;

import org.apache.http.HttpResponse;

import java.util.Objects;

public class EntityResponseWrapper<E> extends AbstractResponseWrapper {

    protected final E entity;

    public EntityResponseWrapper(HttpResponse httpResponse, E entity) {
        super(httpResponse);
        this.entity = entity;
    }

    public E entity() {
        return entity;
    }

    @Override
    public String toString() {
        return "EntityResponseWrapper{" +
                "entity=" + entity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EntityResponseWrapper<?> that = (EntityResponseWrapper<?>) o;
        return Objects.equals(entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entity);
    }
}
