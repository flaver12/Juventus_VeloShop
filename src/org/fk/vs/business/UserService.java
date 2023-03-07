package org.fk.vs.business;

import java.util.ArrayList;
import java.util.List;

import org.fk.vs.data.User;

public class UserService {
    
    private List<User> users = new ArrayList<User>();
    
    public void AddUser(User user) {
        if (this.users.contains(user)) {
            return;
        }
        this.users.add(user);
    }

    public List<User> getAllCustomers() {
        
    }

}
