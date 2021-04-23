package discojx.utils.requests;

import java.util.Objects;

public class StringBuilderSequentialRequestParametersConstructor implements SequentialRequestParametersConstructor {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public SequentialRequestParametersConstructor append(String key, Object value) {
        if (builder.length() == 0) builder.append("?");
        builder.append(key).append("=").append(value).append("&");
        return this;
    }

    @Override
    public String toParametersString() {
        if (builder.length() == 0) return builder.toString();

        removeTailRedundancy();
        replaceWhitespaces();

        return builder.toString();
    }

    private void removeTailRedundancy() {
        char lastCharacterInSequence = builder.charAt(builder.length() - 1);
        if (lastCharacterInSequence == '&' || lastCharacterInSequence == '?') {
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private void replaceWhitespaces() {
        for (int charIndex = 0; charIndex < builder.length(); charIndex++) {
            if (builder.charAt(charIndex) == ' ') {
                builder.replace(charIndex, charIndex + 1, "%20");
            }
        }
    }

    @Override
    public String toString() {
        return "StringBuilderSequentialRequestParametersConstructor{" +
                "builder=" + builder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringBuilderSequentialRequestParametersConstructor that = (StringBuilderSequentialRequestParametersConstructor) o;
        return Objects.equals(builder, that.builder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(builder);
    }
}
