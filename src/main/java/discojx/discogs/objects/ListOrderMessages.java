package discojx.discogs.objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import discojx.utils.json.deserializers.OrderMessagesDeserializer;

import java.util.List;
import java.util.Objects;

public class ListOrderMessages {

    private Pagination pagination;
    @JsonDeserialize(using = OrderMessagesDeserializer.class)
    private List<AbstractTypedObject> messages;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<AbstractTypedObject> getMessages() {
        return messages;
    }

    public void setMessages(List<AbstractTypedObject> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ListOrderMessages{" +
                "pagination=" + pagination +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOrderMessages that = (ListOrderMessages) o;
        return Objects.equals(pagination, that.pagination) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagination, messages);
    }
}
