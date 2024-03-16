package machine_coding.parking_lot.services;

import machine_coding.parking_lot.exceptions.InvalidGateException;
import machine_coding.parking_lot.exceptions.InvalidTicketException;
import machine_coding.parking_lot.factories.CalculateFeesStrategyFactory;
import machine_coding.parking_lot.models.*;
import machine_coding.parking_lot.repositories.InvoiceRepository;
import machine_coding.parking_lot.strategies.pricing_strategy.CalculateFeesStrategy;

import java.util.Arrays;
import java.util.Date;

public class InvoiceServiceImpl implements InvoiceService{

    private TicketService ticketService;
    private GateService gateService;

    private CalculateFeesStrategyFactory factory;

    private InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(TicketService ticketService, GateService gateService, CalculateFeesStrategyFactory factory, InvoiceRepository invoiceRepository) {
        this.ticketService = ticketService;
        this.gateService = gateService;
        this.factory = factory;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice generateInvoice(int ticketId, int gateId) throws InvalidTicketException, InvalidGateException {
        /*
        1. Get ticket from DB, if ticket obj is null, throw Exception
        2. Get gate from DB, if gate obj is null or gate is an entry gate, throw an Exception
        3. Calculate charges via appropriate strategy
        4. Create invoice obj, store in DB and return
         */
        Ticket ticket = this.ticketService.getTicketById(ticketId);
        if(ticket == null){
            throw new InvalidTicketException("Ticket is not present in DB");
        }
        Gate gate = this.gateService.getGateById(gateId);
        if(gate == null){
            throw new InvalidGateException("Gate is not present in DB");
        }
        if(gate.getGateType().equals(GateType.ENTRY)){
            throw new InvalidGateException("Invoice cannot be created at entry gate");
        }

        Date entryDate = ticket.getEntryTime();
        Date exitDate = new Date();
        CalculateFeesStrategy calculateFeesStrategy = factory.getCalculateFeesStrategy(exitDate);
        double totalAmount = calculateFeesStrategy.calculateFees(entryDate, exitDate, ticket.getVehicle().getVehicleType());

        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetail.setName("Parking fees");
        invoiceDetail.setPrice(totalAmount);


        Invoice invoice = new Invoice();
        invoice.setDetails(Arrays.asList(invoiceDetail));
        invoice.setTicket(ticket);
        invoice.setExitTime(exitDate);
        return invoiceRepository.insertInvoice(invoice);
    }
}
