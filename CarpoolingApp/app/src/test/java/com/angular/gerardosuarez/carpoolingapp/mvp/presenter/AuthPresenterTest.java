package com.angular.gerardosuarez.carpoolingapp.mvp.presenter;

import android.content.Intent;

import com.angular.gerardosuarez.carpoolingapp.R;
import com.angular.gerardosuarez.carpoolingapp.activity.AuthActivity;
import com.angular.gerardosuarez.carpoolingapp.mvp.event.OnLoginClickedEvent;
import com.angular.gerardosuarez.carpoolingapp.mvp.event.OnLoginEvent;
import com.angular.gerardosuarez.carpoolingapp.mvp.view.AuthView;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by gerardosuarez on 2/03/17.
 */

public class AuthPresenterTest {

    AuthPresenter presenter;

    @Mock AuthView view;
    @Mock AuthActivity activity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.doNothing().when(model).authUser("user", "password");
        Mockito.when(view.getActivity()).thenReturn(activity);
        presenter = new AuthPresenter(model, view);
    }

    @Ignore
    public void mustShowUserCannotBeNullOrEmpty() throws Exception {
        String username = "";
        String password = "qrqwe";
        OnLoginClickedEvent event = new OnLoginClickedEvent(username, password);
        presenter.onLoginClicked(event);
        Mockito.verify(view).showErrorMessage(R.string.error_username_empry);
    }

    @Ignore
    public void mustShowPasswordCannotBeNullOrEmpry() throws Exception {
        String username = "12412";
        String password = "";
        OnLoginClickedEvent event = new OnLoginClickedEvent(username, password);
        presenter.onLoginClicked(event);
        Mockito.verify(view).showErrorMessage(R.string.error_password_empry);
    }

    @Ignore
    public void mustShowMainActivityIsStarted() throws Exception {
        presenter.showMain();
        Mockito.verify(view).getActivity();
        Mockito.verify(activity).startActivity(Mockito.any(Intent.class));
    }

    @Ignore
    public void mustShowMainActivityIsStartedWhenLoginIsCorrect() throws Exception {
        OnLoginEvent event = new OnLoginEvent(true);
        presenter.onLoginEvent(event);
        Mockito.verify(activity).startActivity(Mockito.any(Intent.class));
    }

}
