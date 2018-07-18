package com.javafortesters.chap014junitexplored;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserWithOverriddenEqualsMethod;
import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JUnitExploredTest {

    User usr0 = new User();
    User usr1 = new User();
    UserWithOverriddenEqualsMethod usrOver0 = new UserWithOverriddenEqualsMethod();
    UserWithOverriddenEqualsMethod usrOver1 = new UserWithOverriddenEqualsMethod();

    @Ignore("Ignored because intended to be FAILED: assertEquals() works as User.equals() works by comparing values of reference variables (address) with == operator")
    @Test
    public void assertSameComparesLinksToTwoObjects1() {
        assertEquals(usr0, usr1);
    }


    @Test /*PASSED: UserWithOverriddenEqualsMethod.equals() is overridden the way to compare values of class fields (private username, private password)*/
    public void assertSameComparesLinksToTwoObjects2() {
        assertEquals(usrOver0, usrOver1);
    }

    @Ignore("Ignored because intended to be FAILED: equals() overridden the way that objects of different types are always not equal")
    @Test
    public void assertSameComparesLinksToTwoObjects3() {
        assertEquals(usrOver0, usr0);
    }

    @Ignore("Ignored because intended to be FAILED:: assertSame() works as == operator does - by comparing links (== operator can not be overridden")
    @Test
    public void assertSameComparesValuesOfVariables() {
        assertSame(usrOver0, usrOver1);
    }

    @Test
    public void permisionIsCorrect() {
        assertEquals("Standart", usrOver0.getPermission());
        assertEquals("Normal", usr0.getPermission());
    }

    @Test
    public void getClassReturnsClassName() {
        System.out.println(usr0.getClass());
        System.out.println(usrOver0.getClass());
    }

    @Test
    public void superToCallSuperclassMethod() {
        assertEquals(usr0.getPermission(), usrOver0.getSuperclassPermission());
    }

    @Ignore("Ignored because intended to be FAILED: assertThat ~ assertEquals() works as User.equals() works by comparing values of reference variables (address) with == operator")
    @Test
    public void hamcrestIs() {
        assertThat(usr0, is(usr1));
    }

}
