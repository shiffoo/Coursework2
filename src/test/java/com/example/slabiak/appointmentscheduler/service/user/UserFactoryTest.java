package com.example.slabiak.appointmentscheduler.service.user;

import com.example.slabiak.appointmentscheduler.model.UserForm;

public class UserFactoryTest {

    public static UserForm prepareSampleUserForm() {
        UserForm userForm = new UserForm();
        userForm.setEmail("example@example.com");
        userForm.setFirstName("Tomasz");
        userForm.setLastName("Nowak");
        userForm.setMobile("123456");
        userForm.setUserName("sampleUser");
        userForm.setPassword("password");
        return userForm;
    }
}
