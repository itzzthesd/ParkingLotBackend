package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long, Ticket> ticketStore;

    public TicketRepository(){
        this.ticketStore = new HashMap<>();
    }
    public void save(Ticket ticket){
        // to implement save
        ticketStore.put(ticket.getId(), ticket);
    }
}
