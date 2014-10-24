package labs.anton.icenet;

import android.content.Context;
import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by anton on 10/15/14.
 */
public final class NetworkCreator {
    private static final String TAG = NetworkCreator.class.getSimpleName();
    private final String baseUrl;
    private final Context context;

    NetworkCreator(Context context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    /**
     * @param headers Headers request, it can be null
     */
    public NetworkManager.INetworkManagerBuilder get(@NonNull Header headers) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.GET).setHeaders(headers.getHeaders());
    }

    /**
     *
     */
    public NetworkManager.INetworkManagerBuilder get() {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.GET);
    }

    /**
     * @param headers    Headers request, it can be null
     * @param bodyObject Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder post(@NonNull Header headers, @NonNull Object bodyObject) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.POST).setBodyRequest(generateBodyRequest(bodyObject)).setHeaders(headers.getHeaders());
    }


    /**
     * @param headers     Headers request, it can be null
     * @param bodyRequest Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder post(@NonNull Header headers, @NonNull Body bodyRequest) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.POST).setBodyRequest(bodyRequest.getBody()).setHeaders(headers.getHeaders());
    }

    /**
     * @param bodyObject Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder post(@NonNull Object bodyObject) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.POST).setBodyRequest(generateBodyRequest(bodyObject));
    }

    /**
     * @param bodyRequest Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder post(@NonNull Body bodyRequest) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.POST).setBodyRequest(bodyRequest.getBody());
    }

    /**
     * @param headers    Headers request, it can be null
     * @param bodyObject Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder put(@NonNull Header headers, @NonNull Object bodyObject) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.PUT).setBodyRequest(generateBodyRequest(generateBodyRequest(bodyObject))).setHeaders(headers.getHeaders());
    }

    /**
     * @param headers     Headers request, it can be null
     * @param bodyRequest Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder put(@NonNull Header headers, @NonNull Body bodyRequest) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.PUT).setBodyRequest(generateBodyRequest(bodyRequest.getBody())).setHeaders(headers.getHeaders());
    }

    /**
     * @param bodyObject Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder put(@NonNull Object bodyObject) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.PUT).setBodyRequest(generateBodyRequest(bodyObject));
    }

    /**
     * @param bodyRequest Body request, it not null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder put(@NonNull Body bodyRequest) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.PUT).setBodyRequest(bodyRequest.getBody());
    }

    /**
     * @param headers Headers request, it can be null
     * @return
     */
    public NetworkManager.INetworkManagerBuilder delete(@NonNull Header headers) {
        return new NetworkManager.Builder().setBaseUrl(baseUrl).setContext(context).setMethod(Request.Method.DELETE).setHeaders(headers.getHeaders());
    }

    private HashMap<String, Object> generateBodyRequest(Object bodyRequest) {
        String bodyJson = new Gson().toJson(bodyRequest);
        Type type = new TypeToken<HashMap<String, String>>() {
        }.getType();
        HashMap<String, Object> body = new Gson().fromJson(bodyJson, type);
        return body;
    }

}
