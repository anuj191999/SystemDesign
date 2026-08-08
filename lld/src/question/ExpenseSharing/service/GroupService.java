package question.ExpenseSharing.service;

import question.ExpenseSharing.model.Group;
import question.ExpenseSharing.model.User;
import question.ExpenseSharing.repo.GroupRepo;

import java.util.List;

public class GroupService {

    private GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public Group createGroup(String groupId,User createBy, String groupName, List<User> members){
        try {
//            members.add(createBy);
//            String groupId= UUID.randomUUID().toString();
            Group group=new Group(groupId,groupName,members,createBy);
            return groupRepo.addGroup(group);
        } catch (Exception e) {
            System.out.println("GroupService.createGroup Exception Occurred");
        }
        return null;
    }

    public void addMember(String groupId,User user){
        try{
            groupRepo.addMember(groupId,user);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
