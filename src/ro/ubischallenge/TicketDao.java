package ro.ubischallenge;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;  

public class TicketDao { 
	@SuppressWarnings("unchecked")
	public List<Ticket> getAllTickets(){
		List<Ticket> ticketList = null; 
		try { 
			File file = new File("Tickets.dat"); 
			if (!file.exists()) { 
				ticketList = MockRepo.getInstance().ticketMockList(); 
				saveList(ticketList, "Tickets.dat"); 
			} 
			else{ 
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				ticketList = (List<Ticket>) ois.readObject(); 
				ois.close(); 
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}   
		return ticketList; 
	}

	public List<Ticket> getFilteredTickets(String filter) {
		List<Ticket> ticketList = getAllTickets();
		List<Ticket> filteredTicketList = new ArrayList<Ticket>();


		if(filter.matches("[0-9]+")) {
			/*
			 * searching tickets by id
			 */
			int ticketId = Integer.parseInt(filter);
			for(Ticket ticket : ticketList)
				if(ticket.getTicketId() == ticketId) {
					filteredTicketList.add(ticket);
					break;
				}
		} else {
			/*
			 * searching tickets by buyer name
			 */
			for(Ticket ticket : ticketList)
				if(ticket.getBuyer().equals(filter))
					filteredTicketList.add(ticket);
		}

		return filteredTicketList;
	}
	
	public void cancelTicket(String ticketId) {
		if(ticketId.matches("[0-9]+")) {
			int id = Integer.parseInt(ticketId);
			List<Ticket> ticketList = getAllTickets();
			for(int i = 0; i < ticketList.size(); i++)
				if(ticketList.get(i).getTicketId() == id)
					ticketList.remove(i);
			saveList(ticketList, "Tickets.dat");
		}
	}

	public void buyTicket(Ticket ticket) {
		List<Ticket> ticketList = getAllTickets(); 
		ticketList.add(ticket);
		saveList(ticketList, "Tickets.dat"); 
	}

	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents(){
		List<Event> eventList = null; 
		try { 
			File file = new File("Events.dat"); 
			if (!file.exists()) { 
				eventList = MockRepo.getInstance().eventMockList(); 
				saveList(eventList, "Events.dat"); 
			} 
			else{ 
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis); 
				eventList = (List<Event>) ois.readObject(); 
				ois.close(); 
			} 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		}   
		return eventList; 
	}

	private void saveList(List<?> listToSave, String fileName){ 
		try { 
			File file = new File(fileName); 
			FileOutputStream fos;  
			fos = new FileOutputStream(file); 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(listToSave); 
			oos.close(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	}

}
