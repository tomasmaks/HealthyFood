package my.food.tomas.healthyfood.data;

import java.util.List;

import my.food.tomas.healthyfood.data.local.models.Recipe;
import my.food.tomas.healthyfood.data.local.models.RecipeGet;
import my.food.tomas.healthyfood.data.local.models.RecipeSearchParams;
import my.food.tomas.healthyfood.data.local.models.RecipesList;
import rx.Observable;

/**
 * Created by Tomas on 25/10/2016.
 */

public interface AppDataStore {

    Observable<RecipesList> getRecipesList(String query);
    Observable<RecipeGet> getRecipe(String id);

}
