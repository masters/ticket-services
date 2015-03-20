package org.rage.ticket.manager;


import org.rage.ticket.exception.DatabaseTicketException;
import org.rage.ticket.exception.TicketServiceDownException;
import org.rage.ticket.exception.ValidationTicketException;
import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.enu.TicketStatus;

import java.util.List;


/**
 * TicketManager represents ...
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
public interface TicketManager
{
   /**
    * Represents getTicketById
    *
    * @param id
    * @return ticket
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @throws TicketServiceDownException
    * @since 20/02/2015
    *
    */
   Ticket getTicketById (Integer id) throws DatabaseTicketException, ValidationTicketException,
         TicketServiceDownException;


   /**
    * Represents getTicketList
    *
    * @param status
    * @return ticketList
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @throws TicketServiceDownException
    * @since 20/02/2015
    *
    */
   List <Ticket> getTicketList (TicketStatus status) throws DatabaseTicketException, ValidationTicketException,
         TicketServiceDownException;


   /**
    * Represents saveTicket
    *
    * @param ticket
    * @return ticket
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @throws TicketServiceDownException
    * @since 20/02/2015
    *
    */
   Ticket saveTicket (Ticket ticket) throws DatabaseTicketException, ValidationTicketException,
         TicketServiceDownException;
}
