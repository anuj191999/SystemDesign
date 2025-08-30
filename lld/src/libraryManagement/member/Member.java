package libraryManagement.member;

import libraryManagement.book.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Member {
    private String name;;
    private Map<String,Book> booksHeld;
    private MemberStatus status;
    private String memberId;
    private MemberRole role;

    public Member(String name,MemberStatus status,MemberRole role) {
        this.name = name;
        booksHeld = new HashMap<>();
        this.status = status;
        this.role=role;
        this.memberId= UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }
    public Map<String,Book> getBooksHeld() {
        return booksHeld;
    }
    public void setBooksHeld(String barCode,Book book) {
        booksHeld.put(barCode,book);
    }
    public boolean removeBookHeld(String barCode) {
        return booksHeld.remove(barCode)!=null;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }
    public String getMemberId() {
        return memberId;
    }
    public MemberRole getRole(){
        return role;
    }
}
