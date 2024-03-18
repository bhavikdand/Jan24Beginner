package machine_coding.parking_lot.services;

import machine_coding.parking_lot.models.Ticket;

public interface TicketService {

    public Ticket generateTicket(int gateId, String vehicleNumber, String vehicleType) throws Exception;

    public Ticket getTicketById(int ticketId);
}
