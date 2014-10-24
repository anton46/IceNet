package labs.anton.icenet;

/**
 * Created by anton on 10/15/14.
 */
public class IceNet {
    static IceNet singleton = null;

    public synchronized static IceNet init(IceNetConfig config) {
        if (singleton == null) {
            singleton = new IceNet(config);
        }
        return singleton;
    }

    public synchronized static IceNet connect() {
        if (singleton == null) {
            throw new IllegalArgumentException("IceNet not instance yet.");
        }
        return singleton;
    }

    private final IceNetConfig config;

    public IceNet(IceNetConfig config) {
        this.config = config;
    }

    public void cancelRequest(String tag) {
        NetworkHelper.getInstance(config.getContext()).cancelPendingRequests(tag);
    }

    public NetworkCreator createRequest() {
        if (config == null) {
            throw new IllegalArgumentException("Config must not be null.");
        }

        return new NetworkCreator(config.getContext(), config.getBaseUrl());
    }
}
