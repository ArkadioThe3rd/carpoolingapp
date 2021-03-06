package com.angular.gerardosuarez.carpoolingapp.data.preference.role;

import android.content.Context;

import com.angular.gerardosuarez.carpoolingapp.data.preference.BasePreferenceImpl;

public class RolePreferenceImpl extends BasePreferenceImpl implements RolePreference {

    private final static String CURRENT_ROLE = "role";
    public final static String NAME = "role_preference";

    public RolePreferenceImpl(Context context, String name) {
        super(context, name);
    }

    @Override
    public void putCurrentRole(String value) {
        put(CURRENT_ROLE, value);
    }

    @Override
    public String getCurrentRole() {
        return getString(CURRENT_ROLE);
    }
}
