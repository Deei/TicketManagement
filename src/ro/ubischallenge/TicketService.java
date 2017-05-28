package ro.ubischallenge;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;  
@Path("/TicketService") 

public class TicketService {  
   TicketDao ticketDao = new TicketDao();  
   @GET 
   @Path("/list_tickets") 
   @Produces(MediaType.TEXT_XML) 
   public List<Ticket> getTickets(){ 
      return ticketDao.getAllTickets(); 
   }
   
   @GET 
   @Path("/list_events") 
   @Produces(MediaType.TEXT_XML) 
   public List<Event> getEvents(){ 
      return ticketDao.getAllEvents(); 
   }
   
   @GET 
   @Path("/ticket_details/{filter}") 
   @Produces(MediaType.TEXT_PLAIN) 
   public String getTicketDetails(@PathParam("filter") String filter){ 
	   ArrayList<Ticket> filteredTicketList = (ArrayList<Ticket>) ticketDao.getFilteredTickets(filter);
	   ArrayList<Event> eventList = (ArrayList<Event>) ticketDao.getAllEvents();
	      
	   String output = new String();
	   
	   for(Ticket ticket : filteredTicketList) {
		   output += "" + ticket + "\n";
		   for(Event event : eventList)
			   if(ticket.getEventId() == event.getEventId()) {
				   output += "" + event + "\n";
				   break;
			   }
		   output += "\n";
	   }
	   
	   return output;
   }
   
   @GET 
   @Path("/list_tickets/{filter}") 
   @Produces(MediaType.TEXT_XML)
   public List<Ticket> getSpecificTickets(@PathParam("filter") String filter){ 
	   return ticketDao.getFilteredTickets(filter); 
   }
   
   @POST
   @Path("/buy_ticket")
   @Consumes(MediaType.TEXT_XML)
   public Response buyTicket(Ticket ticket) {
	   try {
		   
		   ticketDao.buyTicket(ticket);
	   
	       String output = ticket.toString();
	       
	       return Response.status(Status.OK).
	    		   entity(output).
	    		   build();
	       
	   } catch (Exception e) {
		   
		   e.printStackTrace();
		   return Response.status(Status.INTERNAL_SERVER_ERROR).
				   entity(e.getMessage()).
				   build();
	   }
   }
   
   @POST
   @Path("/cancel_ticket/{ticketId}")
   public Response cancelTicket(@PathParam("ticketId") String ticketId) {
	   try {
		   String output = new String();
		   Ticket ticket = ticketDao.getFilteredTickets(ticketId).get(0);
		   
		   if(ticket != null)
			   output = ticket.toString();
		   
		   ticketDao.cancelTicket(ticketId);
	       
	       return Response.status(Status.OK).
	    		   entity(output).
	    		   build();
	       
	   } catch (Exception e) {
		   
		   e.printStackTrace();
		   return Response.status(Status.INTERNAL_SERVER_ERROR).
				   entity(e.getMessage()).
				   build();
	   }
   }
}
