# ticket-manager-rest-api
----------------------

Requirements
----------------------
- Java JDK 1.7 or later

Implementation and testing details
----------------------
- The implementation was done with Java (JAX-RS) using Jersey
- Testing was done using a local Tomcat server instance.
- The storage consists of .dat files placed in the server's root directory.
- A local data set is initialised with testing data if the .dat files are missing.

Available API
----------------------
- GET to http://localhost:8080/TicketManagement/rest/TicketService/list_tickets
Lists all the tickets.

- GET to http://localhost:8080/TicketManagement/rest/TicketService/list_events
Lists all the events.

- GET to http://localhost:8080/TicketManagement/rest/TicketService/list_tickets/{filter}
Lists all the events where:
    * if filter is a number, returns the ticket with the ID number equal to filter;
    * if filter is not a number, returns the ticket(s) belonging to the person with name equal to filter;

- POST to http://localhost:8080/TicketManagement/rest/TicketService/buy_ticket
Adds a new ticket in the ticket list given a TEXT_XML payload body with the form:
```xml
 <ticket>
        <buyer>Buyer</buyer>
        <eventId>Event_ID</eventId>
        <price>Price</price>
        <ticketId>Ticket_ID</ticketId>
</ticket>
```

- POST to http://localhost:8080/TicketManagement/rest/TicketService/cancel_ticket/{ticketId}
Cancels the ticket with the ID number equal to ticketId and returns the details of the deleted ticket.