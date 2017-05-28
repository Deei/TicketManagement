package ro.ubischallenge;

import java.util.ArrayList;
import java.util.List;

public class MockRepo {
	private	static MockRepo instance = null;
	
	private MockRepo() {}
	
	public static MockRepo getInstance() {
		if(instance == null) {
			instance = new MockRepo();
		}
		return instance;
	}
	
	public List<Ticket> ticketMockList() {
		
		List<Ticket> ticketList = new ArrayList<Ticket>();
		
		ticketList.add(new Ticket(1, 1, 100, "Stefan"));
		ticketList.add(new Ticket(2, 1, 120, "Vlad"));
		ticketList.add(new Ticket(3, 2, 80, "Mihai"));
		ticketList.add(new Ticket(4, 4, 20, "Elisabeta"));
		ticketList.add(new Ticket(5, 4, 15, "Maria"));
		ticketList.add(new Ticket(6, 4, 25, "Constantin"));
		ticketList.add(new Ticket(7, 5, 280, "Iancu"));
		ticketList.add(new Ticket(8, 6, 300, "Elena"));
		
		return ticketList;
	}
	
	public List<Event> eventMockList() {
		
		List<Event> eventList = new ArrayList<Event>();
		
		eventList.add(new Event(1, "Sunwaves", "Cort Sunwaves, Mamaia", "1.07.2017"));
		eventList.add(new Event(2, "Untold", "Cluj Arena, Cluj-Napoca", "15.08.2017"));
		eventList.add(new Event(3, "Hospitality Romania", "Arenele Romane, Bucuresti", "10.06.2017"));
		eventList.add(new Event(4, "Concert Holograf", "Sala Palatului, Bucuresti", "28.03.2016"));
		
		return eventList;
	}
}
