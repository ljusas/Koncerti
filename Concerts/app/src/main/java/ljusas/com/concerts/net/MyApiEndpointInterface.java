package ljusas.com.concerts.net;

/**
 * Created by milossimic on 11/10/16.
 */

import java.util.List;
import java.util.Map;

import ljusas.com.concerts.net.model.Event;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


/**
 * Klasa koja opisuje koji tj mapira putanju servisa
 * opisuje koji metod koristimo ali i sta ocekujemo kao rezultat
 *
 * */
public interface MyApiEndpointInterface {

    @GET("artists/{artist}/events")
    Call<List<Event>> getArtistByName(@Path("artist") String artist, @QueryMap Map<String, String> options);
}
