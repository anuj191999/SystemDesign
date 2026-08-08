package question.ExpenseSharing.service;

import question.ExpenseSharing.model.Group;
import question.ExpenseSharing.model.User;
import question.ExpenseSharing.repo.UserRepo;

public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(String userId,String name){
        try{
            return userRepo.addUser(new User(userId,name));
        } catch (Exception e) {
            System.out.println("UserService.createUser() :: Exception "+e.getMessage());
        }
        return null;
    }

    public boolean acceptMemberShip(User user ,Group group){
        return userRepo.addGroup(user,group);
    }
    public User getUserById(String id){
        return userRepo.getUserById(id);
    }

}
