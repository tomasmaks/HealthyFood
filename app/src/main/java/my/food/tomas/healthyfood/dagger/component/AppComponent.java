package my.food.tomas.healthyfood.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import my.food.tomas.healthyfood.dagger.module.AppModule;
import my.food.tomas.healthyfood.dagger.module.DataModule;
import my.food.tomas.healthyfood.data.remote.AppRemoteDataStore;
import my.food.tomas.healthyfood.mainScreen.MainActivity;

/**
 * Created by Tomas on 25/10/2016.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(AppRemoteDataStore appRemoteDataStore);
}