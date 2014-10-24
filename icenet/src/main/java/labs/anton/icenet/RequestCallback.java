package labs.anton.icenet;

/**
 * Created by anton on 10/15/14.
 */
public interface RequestCallback<T> {
    public void onRequestSuccess(T t);
    public void onRequestError(RequestError error);
}