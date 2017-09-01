package jp.co.recruit_lifestyle.sample;

/**
 * Created by 201502042 on 2017/9/1.
 */

public class TestPresenter {
    TestView mView;

    public TestPresenter(TestView mView) {
        this.mView = mView;
    }

    public void inflateUser(User user) {
        mView.updateUserInfo(user);
    }
}
