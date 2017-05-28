package ro.ubischallenge;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "ticket") 

public class Ticket implements Serializable {  
	private static final long serialVersionUID = 1L;

	private int ticketId;
	private int eventId;
	private int price;
	private String buyer;

	public Ticket(){} 


	public Ticket(int ticketId, int eventId, int price, String buyer){
		this.ticketId = ticketId;
		this.eventId = eventId;
		this.price = price;
		this.buyer = buyer;
	}

	public int getTicketId() {
		return ticketId; 
	}

	@XmlElement 
	public void setTicketId(int ticketId) { 
		this.ticketId = ticketId; 
	}

	public int getEventId() {
		return eventId;
	}

	@XmlElement 
	public void setEventId(int eventId) { 
		this.eventId = eventId; 
	}

	public int getPrice() { 
		return price; 
	}

	@XmlElement 
	public void setPrice(int price) { 
		this.price = price; 
	}

	public String getBuyer() { 
		return buyer; 
	}

	@XmlElement 
	public void setBuyer(String buyer) { 
		this.buyer = buyer; 
	}
	
	public String toString() {
		return "Ticket ID: " + ticketId +
				"\tEvent ID: " + eventId +
				"\tPrice: " + price +
				"\tBuyer: " + buyer;
	}
} 