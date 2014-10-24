package labs.anton.icenet;

import java.util.HashMap;

/**
 * Created by anton on 10/17/14.
 */
public final class Header {
    private final HashMap<String, String> headers;

    public Header(Builder builder) {
        this.headers = builder.headers;
    }

    HashMap<String, String> getHeaders() {
        return headers;
    }

    public static class Builder {
        private String key;
        private String value;
        private HashMap<String, String> headers = new HashMap<String, String>();

        public Builder add(String key, String value) {
            headers.put(key, value);
            return this;
        }

        public Header build() {
            return new Header(this);
        }
    }

}
