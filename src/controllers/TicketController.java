package controllers;

import DTO.GenerateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import DTO.ResponseStatus;
import exceptions.NoParkingSpotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto){
        // do not pass the DTO directly
        try {
            Ticket ticket = ticketService.generateTicket(
                    generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());

            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);

            generateTicketResponseDto.setStatus(ResponseStatus.SUCCESS);
            return generateTicketResponseDto;
        } catch (NoParkingSpotFoundException e){
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        } catch( Exception e){
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setStatus(ResponseStatus.FAILURE);
            generateTicketResponseDto.setFailureMessage(e.getMessage());
            return generateTicketResponseDto;
        }

    }
}
