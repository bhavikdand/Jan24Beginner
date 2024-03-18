package machine_coding.parking_lot.controllers;

import machine_coding.parking_lot.dtos.*;
import machine_coding.parking_lot.exceptions.InvalidRequestException;
import machine_coding.parking_lot.models.Invoice;
import machine_coding.parking_lot.services.InvoiceService;

public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public GenerateInvoiceResponseDto generateInvoice(GenerateInvoiceRequestDto requestDto){
        GenerateInvoiceResponseDto responseDto = new GenerateInvoiceResponseDto();
        try{
            if(requestDto.getTicketId() < 0){
                throw  new InvalidRequestException("Ticket id cannot be negative");
            }
            if(requestDto.getGateId() < 0){
                throw  new InvalidRequestException("Gate id cannot be negative");
            }
        } catch (Exception e){
            Response response = new Response();
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }

        try{
            Invoice invoice = invoiceService.generateInvoice(requestDto.getTicketId(), requestDto.getGateId());
            Response response = new Response();
            response.setStatus(ResponseStatus.SUCCESS);
            responseDto.setInvoice(invoice);
            responseDto.setResponse(response);
            return responseDto;
        } catch (Exception e){
            Response response = new Response();
            response.setStatus(ResponseStatus.FAILED);
            response.setError(e.getMessage());
            responseDto.setResponse(response);
            return responseDto;
        }


    }
}
