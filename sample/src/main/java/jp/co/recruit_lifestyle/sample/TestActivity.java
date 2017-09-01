package jp.co.recruit_lifestyle.sample;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import jp.co.recruit.floatingview.R;
import jp.co.recruit.floatingview.databinding.ActivityTestBinding;

/**
 *
 * Created by 201502042 on 2017/9/1.
 */

public class TestActivity extends LifecycleActivity implements TestView{

    private TestPresenter presenter;
    private ActivityTestBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        binding.setUser(new User(2,3,"Init set user"));
        presenter = new TestPresenter(this);
        ViewModelProviders.of(this).get(UserModel.class).getUserLiveData().observe(this, user -> {
            //update UI
            presenter.inflateUser(user);
        });
    }
    @Override
    public void updateUserInfo(User user) {
        if (user!=null){
            binding.setUser(user);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
