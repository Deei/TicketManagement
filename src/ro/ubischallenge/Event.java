package ro.ubischallenge;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "event") 

public class Event implements Serializable {  
	private static final long serialVersionUID = 1L;

	private int eventId;
	private String name;
	private String location;
	private String date;

	public Event(){} 


	public Event(int eventId, String name, String location, String date){
		this.eventId = eventId;
		this.name = name;
		this.location = location;
		this.date = date;
	}

	public int getEventId() {
		return eventId; 
	}

	@XmlElement 
	public void setEventId(int eventId) { 
		this.eventId = eventId; 
	}
	
	public String getName() { 
		return name; 
	}

	@XmlElement 
	public void setName(String name) { 
		this.location = name; 
	}

	public String getLocation() { 
		return location; 
	}

	@XmlElement 
	public void setLocation(String location) { 
		this.location = location; 
	}
	
	public String getDate() { 
		return date; 
	}

	@XmlElement 
	public void setDate(String date) { 
		this.date = date; 
	}
	
	
	public String toString() {
		return	"Event ID: " + eventId +
				"\tLocation: " + location +
				"\tDate: " + date;
	}
} 