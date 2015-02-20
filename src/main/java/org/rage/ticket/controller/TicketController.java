package org.rage.ticket.controller;


import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.TicketListWrapper;
import org.rage.ticket.model.enu.TicketStatus;
import org.rage.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * TicketController represents ...
 *
 * @version $Id$
 * @since 18/02/2015
 *
 */
@RestController
@Controller ("ticketController")
public class TicketController
{

   private transient TicketService ticketService;


   /**
    * Represents getTicket
    *
    * @param idTicket
    * @return ticket
    * @since 18/02/2015
    *
    */
   @RequestMapping ("/ticket/{id}")
   public Ticket getTicket (@PathVariable ("id") final Integer idTicket)
   {
      return ticketService.getTicketById (idTicket);
   }


   /**
    * Represents saveTicket
    *
    * @param ticket
    * @return ticket
    * @since 18/02/2015
    *
    */
   @RequestMapping (value = "/ticket", method = RequestMethod.POST, consumes = "application/json")
   public @ResponseBody Ticket saveTicket (@RequestBody final Ticket ticket)
   {
      return ticketService.saveTicket (ticket);
   }


   /**
    * Represents getTicketList
    *
    * @return TicketListWrapper
    * @since 18/02/2015
    *
    */
   @RequestMapping ("/ticket/list")
   public TicketListWrapper getTicketList ()
   {

      return null;
   }


   /**
    * Represents getTicketList
    *
    * @return TicketListWrapper
    * @since 18/02/2015
    *
    */
   @RequestMapping ("/ticket/list/open")
   public TicketListWrapper getOpenTicketList ()
   {

      return ticketService.getTicketByStatus (TicketStatus.OPEN);
   }


   /**
    * Represents getTicketList
    *
    * @return TicketListWrapper
    * @since 18/02/2015
    *
    */
   @RequestMapping ("/ticket/list/closed")
   public TicketListWrapper getClosedTicketList ()
   {
      return ticketService.getTicketByStatus (TicketStatus.CLOSED);
   }


   /**
    * Represents getTicketList
    *
    * @return TicketListWrapper
    * @since 18/02/2015
    *
    */
   @RequestMapping ("/ticket/list/pending")
   public TicketListWrapper getPendingTicketList ()
   {

      return ticketService.getTicketByStatus (TicketStatus.PENDING);
   }



   /**
    * @param ticketService the ticketService to set
    */
   @Autowired
   public void setTicketService (final TicketService ticketService)
   {
      this.ticketService = ticketService;
   }

}
