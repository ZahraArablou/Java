package com.spring.capp.service;

import com.spring.capp.domain.User;
import com.spring.capp.exception.UserBlockedException;
import java.util.List;


public interface UserService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;
    
     public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 2;

    /**
     *
     * The method handle the user registration task.
     *
     * @param u the new user detail as User Object.
     */
    public void register(User u);
/**
 * The method handle login operation (authentication) using given credentials,it returns user object when success and null when failed.
 * @param loginName
 * @param password
 * @return
 * @throws UserBlockedException 
 */
    public User login(String loginName, String password) throws UserBlockedException;

    /**
     *
     * Call this method to get list of registered users.
     *
     * @return
     */
    public List<User> getUserList();

    /**
     * This method change the user login status for details passed as argument.
     *
     * @param userId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
    
    /**
     * check the username availability.
     * @param username
     * @return 
     */
    public Boolean isUsernameExist(String username);
    
}
