package question.ExpenseSharing.repo;

import question.ExpenseSharing.model.Group;
import question.ExpenseSharing.model.User;

import java.util.HashMap;
import java.util.Map;

public class GroupRepo {

    private Map<String, Group> groupDb;

    public GroupRepo() {
        this.groupDb=new HashMap<>();
    }

    public Group getGroupById(String groupId){
        return groupDb.getOrDefault(groupId,null);
    }

    public Group addGroup(Group group){
        if(groupDb.containsKey(group.getId())){
            throw new RuntimeException("This Group Id :"+group.getId()+" is already present");
        }
//        System.out.println("Group has been Created "+group);
        groupDb.put(group.getId(),group);
        return group;
    }

    public void addMember(String id, User user){
        if(groupDb.containsKey(id)){
            this.groupDb.get(id).addMembers(user);
        }
        throw  new RuntimeException("Group Doesn't Exist");
    }
}
