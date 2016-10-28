package my.food.tomas.healthyfood.data.remote;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import my.food.tomas.healthyfood.FoodApplication;
import my.food.tomas.healthyfood.data.AppDataStore;
import my.food.tomas.healthyfood.data.local.AppLocalDataStore;
import my.food.tomas.healthyfood.data.local.models.Recipe;
import my.food.tomas.healthyfood.data.local.models.RecipeGet;
import my.food.tomas.healthyfood.data.local.models.RecipeSearchParams;
import my.food.tomas.healthyfood.data.local.models.RecipesList;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static my.food.tomas.healthyfood.FoodApplication.API_KEY;

/**
 * Created by Tomas on 25/10/2016.
 */

public class AppRemoteDataStore implements AppDataStore {

    @Inject
    Retrofit retrofit;

//    @Inject
//    AppLocalDataStore appLocalDataStore;


    public AppRemoteDataStore() {
        FoodApplication.getAppComponent().inject(this);
    }

    @Override
    public Observable<RecipesList> getRecipesList(String query) {
        Log.d("REMOTE", "Loaded from remote");
        Observable<RecipesList> call = null;
        if (retrofit != null) {
            Food2ForkApi apiService = retrofit.create(Food2ForkApi.class);
            call = apiService.getRecipesList(
                    FoodApplication.API_KEY,
                        query,
                        "r",
                        1
            );
        }
        return call;
    }

//    @Override
//    public Observable<List<RecipesList>> getRecipesList(String query) {
//        return retrofit.create(Food2ForkApi.class)
//                .getRecipesList(
//                        FoodApplication.API_KEY,
//                        "pizza",
//                        "r",
//                        1
//
//                )
//                .subscribeOn(Schedulers.io());
//    }


    public interface Food2ForkApi {
        @GET("/api/search")
        Observable<RecipesList> getRecipesList(@Query("key") String key, @Query("q") String q,
                                                                      @Query("sort") String sort, @Query("page") int page);

        @GET("/api/get")
        Observable<RecipeGet> getRecipeGet(@Query("key") String key, @Query("rId") String rId);
    }
}