package com.example.slabiak.appointmentscheduler.model;

import com.example.slabiak.appointmentscheduler.entity.Work;
import com.example.slabiak.appointmentscheduler.entity.user.User;
import com.example.slabiak.appointmentscheduler.entity.user.customer.CorporateCustomer;
import com.example.slabiak.appointmentscheduler.entity.user.customer.RetailCustomer;
import com.example.slabiak.appointmentscheduler.entity.user.provider.Provider;
import com.example.slabiak.appointmentscheduler.validation.FieldsMatches;
import com.example.slabiak.appointmentscheduler.validation.UniqueUsername;
import com.example.slabiak.appointmentscheduler.validation.groups.*;

import javax.validation.constraints.*;
import java.util.List;

@FieldsMatches(field = "password", matchingField = "matchingPassword", groups = {CreateUser.class})
public class UserForm {

    @NotNull(groups = {UpdateUser.class})
    @Min(value = 1, groups = {UpdateUser.class})
    private int id;

    @UniqueUsername(groups = {CreateUser.class})
    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Username should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String userName;

    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Password should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String password;

    @Size(min = 5, max = 15, groups = {CreateUser.class}, message = "Password should have 5-15 letters")
    @NotBlank(groups = {CreateUser.class})
    private String matchingPassword;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "First name cannot be empty")
    private String firstName;

    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Last name cannot be empty")
    private String lastName;

    @Email(groups = {CreateUser.class, UpdateUser.class}, message = "Email not valid!")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Email cannot be empty")
    private String email;

    @Pattern(groups = {CreateUser.class, UpdateUser.class}, regexp = "[0-9]{9}", message = "Please enter valid mobile phone")
    @NotBlank(groups = {CreateUser.class, UpdateUser.class}, message = "Mobile phone cannot be empty")
    private String mobile;

    /*
     * CorporateCustomer only:
     * */
    @NotBlank(groups = {CreateCorporateCustomer.class, UpdateCorporateCustomer.class}, message = "Company cannot be empty")
    private String companyName;

    /*
     * Provider only:
     * */
    @NotNull(groups = {CreateProvider.class, UpdateProvider.class})
    private List<Work> works;


    public UserForm() {
    }

    public UserForm(User user) {
        this.setId(user.getId());
        this.setUserName(user.getUserName());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getEmail());
        this.setMobile(user.getMobile());
    }

    public UserForm(Provider provider) {
        this((User) provider);
        this.setWorks(provider.getWorks());
    }

    public UserForm(RetailCustomer retailCustomer) {
        this((User) retailCustomer);
    }

    public UserForm(CorporateCustomer corporateCustomer) {
        this((User) corporateCustomer);
        this.setCompanyName(corporateCustomer.getCompanyName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

}