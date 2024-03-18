package machine_coding.parking_lot.services;

import machine_coding.parking_lot.exceptions.InvalidGateException;
import machine_coding.parking_lot.exceptions.InvalidTicketException;
import machine_coding.parking_lot.models.Invoice;

public interface InvoiceService {

    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidGateException;
}
