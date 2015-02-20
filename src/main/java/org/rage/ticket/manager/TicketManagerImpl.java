package org.rage.ticket.manager;


import org.rage.ticket.exception.DatabaseTicketException;
import org.rage.ticket.exception.ValidationTicketException;
import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.enu.TicketStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * TicketManagerImpl represents ...
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
@Component ("ticketManager")
public class TicketManagerImpl implements TicketManager
{

   /**
    * Overrides getTicketById
    *
    * @param id
    * @return
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @since 20/02/2015
    * @see org.rage.ticket.manager.TicketManager#getTicketById(java.lang.Integer)
    */
   public Ticket getTicketById (final Integer id) throws DatabaseTicketException, ValidationTicketException
   {
      // TODO Auto-generated method stub
      final Ticket ticket = new Ticket ();
      ticket.setId (1);
      ticket.setCreationDate (new Date ());

      return ticket;
   }


   /**
    * Overrides getTicketList
    *
    * @param status
    * @return
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @since 20/02/2015
    * @see org.rage.ticket.manager.TicketManager#getTicketList(org.rage.ticket.model.enu.TicketStatus)
    */
   public List <Ticket> getTicketList (final TicketStatus status) throws DatabaseTicketException,
         ValidationTicketException
   {
      // TODO Auto-generated method stub
      final List <Ticket> tickets = new ArrayList <Ticket> ();
      final Ticket ticket = new Ticket ();
      ticket.setId (1);
      ticket.setCreationDate (new Date ());
      tickets.add (ticket);
      return tickets;
   }


   /**
    * Overrides saveTicket
    *
    * @param ticket
    * @return
    * @throws DatabaseTicketException
    * @throws ValidationTicketException
    * @since 20/02/2015
    * @see org.rage.ticket.manager.TicketManager#saveTicket(org.rage.ticket.model.Ticket)
    */
   public Ticket saveTicket (final Ticket ticket) throws DatabaseTicketException, ValidationTicketException
   {
      // TODO Auto-generated method stub
      ticket.setValid (Boolean.TRUE);
      return ticket;
   }

}
