package libraryManagement;

import libraryManagement.book.Book;
import libraryManagement.book.BookItem;
import libraryManagement.book.BookStatus;
import libraryManagement.bookInventory.Inventory;
import libraryManagement.member.Member;
import libraryManagement.member.MemberRole;
import libraryManagement.member.MemberStatus;

public class Main {
    public static void main(String[] args) {

        Book java=new Book("java","Anuj","byAnuj","12@12");
        Book javaScript=new Book("JavaScript","Anuj","byAnuj","12@13");

        BookItem javaItem1=new BookItem("123@@@1",java, BookStatus.AVAILABLE,"R1-JAVA1");
        BookItem javaItem2=new BookItem("123@@@2",java, BookStatus.AVAILABLE,"R1-JAVA2");
        BookItem javaScript1=new BookItem("124@@@1",javaScript, BookStatus.AVAILABLE,"R1-JAVASCRIPT1");
        BookItem javaScript2=new BookItem("124@@@2",javaScript, BookStatus.AVAILABLE,"R1-JAVASCRIPT2");

        Inventory inventory=new Inventory();
        inventory.addCopies(javaItem1);
        inventory.addCopies(javaItem2);
        inventory.addCopies(javaScript1);
        inventory.addCopies(javaScript2);
        LibraryManager libraryManager=new LibraryManager(inventory);

        Member anuj=new Member("Anuj", MemberStatus.ACTIVE, MemberRole.STUDENT);

        BookItem bookItem=libraryManager.borrowBook("123@@@2",anuj);
        System.out.println(bookItem.toString());

    }
}
