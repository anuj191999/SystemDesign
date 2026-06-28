package ExpenseSharing.repo;


import ExpenseSharing.model.Group;
import ExpenseSharing.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private Map<String, User>  userDb;

    public UserRepo() {
        this.userDb = new HashMap<>();
    }

    public User getUserById(String userId){
        return userDb.getOrDefault(userId,null);
    }
    public User addUser(User user){
        if(userDb.containsKey(user.getId())){
            throw new RuntimeException("User Already Exist into DB ID "+user.getId());
        }
        userDb.put(user.getId(),user);
        return user;
    }

    public boolean addGroup(User user, Group group){
        user.addMembers(group);
        return true;
    }

}
