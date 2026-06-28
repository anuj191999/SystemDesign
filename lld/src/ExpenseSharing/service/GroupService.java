package ExpenseSharing.service;

import ExpenseSharing.model.Group;
import ExpenseSharing.model.User;
import ExpenseSharing.repo.GroupRepo;

import java.util.List;
import java.util.UUID;

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
