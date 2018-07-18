package com.javafortesters.chap012introducinginheritance.examples;

import com.javafortesters.domainentities.AdminUser;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminUserTest {

    @Test
    public void anAdminUserHasDefaultConstructor() {
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("adminpass", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void anAdminUserHasParameterizedCunstructor() {
        AdminUser adminUser = new AdminUser("admin", "Passw0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Passw0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

}
