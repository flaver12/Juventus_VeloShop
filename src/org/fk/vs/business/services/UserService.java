package org.fk.vs.business.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import org.fk.vs.data.interfaces.User;
import org.fk.vs.data.model.Customer;
import org.fk.vs.data.model.Staff;

public class UserService {
    
    private Collection<User> users = new ArrayList<User>();
    
    public void AddUser(User user) {
        if (this.users.contains(user)) {
            return;
        }
        this.users.add(user);
    }

    public Collection<User> getAllUser() {
        return users;
    }

    public List<User> getAllCustomers() {
        Predicate<User> streamPredicate = item -> item instanceof Customer;
        return this.users.stream().filter(streamPredicate).toList();
    }

    public List<User> getAllStaff() {
        Predicate<User> streamPredicate = item -> item instanceof Staff;
        return this.users.stream().filter(streamPredicate).toList();
    }

    public User findUserById(int id) {
        Predicate<User> streamPredicate = item -> item.getId() == id; 
        List<User> result = this.users.stream().filter(streamPredicate).toList(); 
        return result.get(0);
    }

}
