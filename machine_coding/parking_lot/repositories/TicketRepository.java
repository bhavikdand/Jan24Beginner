package machine_coding.parking_lot.repositories;

import machine_coding.parking_lot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Integer, Ticket> map;

    public TicketRepository(Map<Integer, Ticket> map) {
        this.map = map;
    }

    public TicketRepository() {
        this.map = new HashMap<>();
    }

    private static int id = 1;

    public Ticket insertTicket(Ticket ticket){
        ticket.setId(id);
        map.put(id++, ticket);
        return ticket;
    }

    public Ticket getTicketById(int ticketId){
        return map.get(ticketId);
    }
}
