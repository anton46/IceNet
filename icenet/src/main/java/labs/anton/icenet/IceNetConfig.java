package labs.anton.icenet;

import android.content.Context;

/**
 * Created by anton on 10/15/14.
 */
public class IceNetConfig {
    private final String baseUrl;
    private final Context context;

    IceNetConfig(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.context = builder.context;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Context getContext() {
        return context;
    }

    public static class Builder {
        private String baseUrl;
        private Context context;

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public IceNetConfig build() {
            return new IceNetConfig(this);
        }
    }

}
