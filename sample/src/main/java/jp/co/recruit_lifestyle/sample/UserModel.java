package jp.co.recruit_lifestyle.sample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import static android.content.ContentValues.TAG;

/**
 * Created by 201502042 on 2017/9/1.
 */

public class UserModel extends ViewModel {

    private LiveData<User> userLiveData = new LiveData<User>() {
        @Override
        protected void onActive() {
            Log.e(TAG, "onActive: " );
            super.onActive();
            if (getValue()!=null){
                Log.e(TAG, "onActive:  get data not null ");
                return;
            }
            setValue(new User(1, 2, "" + System.currentTimeMillis()));
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                }
                User user = new User(2, 22, "User From Thread");
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                }
                postValue(user);
                user = new User(2, 22, "User From Thread2");
                postValue(user);

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                }

                user = new User(2, 22, "User From Thread3");
                postValue(user);

                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                }
                postValue(user);
            }).start();
        }
        @Override
        protected void onInactive() {
            super.onInactive();
            setValue(new User(1, 2, "Stopped..."));
            Log.e(TAG, "onInactive: " );
        }
    };

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }


}
