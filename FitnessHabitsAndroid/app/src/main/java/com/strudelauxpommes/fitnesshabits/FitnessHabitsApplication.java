package com.strudelauxpommes.fitnesshabits;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.MainThread;

import com.strudelauxpommes.fitnesshabits.data.AppDatabase;
import com.strudelauxpommes.fitnesshabits.data.repository.AlcoolRepository;
import com.strudelauxpommes.fitnesshabits.data.repository.PhysicalRepository;

/**
 * Created by thomas on 2017-11-25.
 */

public class FitnessHabitsApplication extends Application {
    public static Application application;
    private AppDatabase database;
    private PhysicalRepository physicalRepository;
    private AlcoolRepository alcoolRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        FitnessHabitsApplication.application = this;
    }

    @MainThread
    public AppDatabase getDatabase() {
        if (database==null){
            database = Room.databaseBuilder(this, AppDatabase.class,"FitnessHabits-database").fallbackToDestructiveMigration().build(); //TODO: remove fallback destroy
        }
        return database;
    }

    //TODO, repository access HERE
    @MainThread
    public PhysicalRepository getPhysicalRepository() {
        if (physicalRepository == null) {
            physicalRepository = new PhysicalRepository(getDatabase().physicalDataDAO());
        }
        return physicalRepository;
    }

    @MainThread
    public AlcoolRepository getAlcoolRepository() {
        if (alcoolRepository == null) {
            alcoolRepository = new AlcoolRepository(getDatabase().drinkDataDAO());
        }
        return alcoolRepository;
    }
}
