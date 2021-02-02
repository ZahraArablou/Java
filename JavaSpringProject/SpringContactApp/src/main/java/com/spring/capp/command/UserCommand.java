
package com.spring.capp.command;

import com.spring.capp.domain.User;


public class UserCommand {
    User user;//it is a good ides to use User instead of definiing the same fields again and again
    
    //TODO: more fields if required

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
