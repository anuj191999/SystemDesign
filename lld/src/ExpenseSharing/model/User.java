package ExpenseSharing.model;

import java.util.*;

public class User {
    private String id;
    private String name;
    private Set<Group> members;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.members=new HashSet<>();
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public Set<Group> getMembers() {
        return members;
    }

    public void addMembers(Group member) {
        this.members.add(member);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;

        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", id='" + id + '\'' +
                '}';
    }
}
