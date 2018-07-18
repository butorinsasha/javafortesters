package com.javafortesters.domainentities;

import java.util.Objects;

public class UserWithOverriddenEqualsMethod extends User {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWithOverriddenEqualsMethod usrOver = (UserWithOverriddenEqualsMethod) o;
        return  Objects.equals(getUsername(), usrOver.getUsername()) &&
                Objects.equals(getPassword(), usrOver.getPassword());
    }


    @Override
    public String getPermission() {
        return "Standart";
    }

    public String getSuperclassPermission() {
        return super.getPermission();
    }

}
