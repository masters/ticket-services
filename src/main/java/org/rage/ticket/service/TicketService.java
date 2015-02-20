package org.rage.ticket.service;


import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.TicketListWrapper;
import org.rage.ticket.model.enu.TicketStatus;


/**
 * TicketService represents ...
 *
 * @version $Id$
 * @since 18/02/2015
 *
 */
public interface TicketService
{

   /**
    * Represents getTicketById
    *
    * @param id
    * @return ticket
    * @since 18/02/2015
    *
    */
   Ticket getTicketById (Integer id);


   /**
    * Represents saveTicket
    *
    * @param ticket
    * @return ticket
    * @since 18/02/2015
    *
    */
   Ticket saveTicket (final Ticket ticket);


   /**
    * Represents getTicketByStatus
    *
    * @param status
    * @return ticketListWrapper
    * @since 18/02/2015
    *
    */
   TicketListWrapper getTicketByStatus (TicketStatus status);
}
