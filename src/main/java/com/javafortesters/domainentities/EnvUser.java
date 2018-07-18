package com.javafortesters.domainentities;

import com.javafortesters.domainobject.TestAppEnv;

public class EnvUser extends User {

    public String getUrl() {
        return TestAppEnv.getUrl();
    }

}
