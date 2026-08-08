1. Any Library member be it a customer or librarian should be able to 
search books by their title , author subject category as well by the publication data.
2. Each book will have unique identification number and other details including a rack
number which will help to physically locate the book.
3. there could be more than one copy of a book and library members should be able 
to check-out and reserve any copy. we will call each of a book, a book item.
4. The system should be able to retrieve information like who take a particular book
or what are the books checked out by specific library member.
5. there should be a maximum limit(5) on how many days a member can keep a book.
6. the system should be able to conflict fines for books returned after the due date.
7. the system should be able to collect fines for books returned after the due date.
8. members should be able to reserve books that are not currently available.
9. the system should be able to send notifications whenever the reserved books become available,as well as 
when the book is not returned within the due date.
10. each book and member card will have unique barcode. the system will be able to read 
barcodes from book and member library cards.

`Actor`
 - user/client
 - librarian 
 - Server - for automation

`Services (SRP, clear responsibilities)`

- CatalogService

- Search by title/author/subject/category/publicationDate; facet & pagination.

- InventoryService

- Manage Book ↔ BookItem; track rack numbers; update states.

- CirculationService

- Checkout, return, renew, mark lost/damaged; enforce policy & availability.

- ReservationService

- Create/cancel reservations; manage FIFO queues; promote next member → hold a specific BookItem.

- FineService

- Compute fines (at return & periodically for reporting), collect/waive, track balances; suspend member if thresholds exceeded.

- NotificationService

- Send email/SMS/push; templates for “hold available”, “due soon”, “overdue”, “reservation expired”.

- BarcodeService

- Decode/validate book and card barcodes; idempotency for repeated scans.

- AuthN/AuthZ

- Roles: MEMBER, LIBRARIAN, SYSTEM.

-PolicyService

- Central read of configurable rules (see LibraryPolicy).

- Audit/ReportingService

- Who took a book; books checked out by member; inventory status.