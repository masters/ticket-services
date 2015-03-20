package org.rage.ticket.service;


import org.rage.ticket.exception.DatabaseTicketException;
import org.rage.ticket.exception.TicketServiceDownException;
import org.rage.ticket.exception.ValidationTicketException;
import org.rage.ticket.manager.TicketManager;
import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.TicketListWrapper;
import org.rage.ticket.model.enu.TicketStatus;
import org.rage.ticket.util.ErrorHandlerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import java.util.List;


/**
 * TicketServiceImpl represents ...
 *
 * @version $Id$
 * @since 20/02/2015
 *
 */
@Component ("ticketService")
public class TicketServiceImpl implements TicketService
{

   private transient TicketManager       ticketManager;
   private final static transient Logger LOG = Logger.getLogger (TicketServiceImpl.class);


   /**
    * Overrides getTicketById
    *
    * @param id
    * @return ticket
    * @since 20/02/2015
    * @see org.rage.ticket.service.TicketService#getTicketById(java.lang.Integer)
    */
   public Ticket getTicketById (final Integer id)
   {
      Ticket ticket = null;
      try
      {
         ticket = ticketManager.getTicketById (id);
      }
      catch (final DatabaseTicketException e)
      {
         LOG.error (e.getMessage (), e);
         ticket = ErrorHandlerHelper.handleErrorMessages (ticket, e);
      }
      catch (final ValidationTicketException e)
      {
         LOG.error (e.getMessage (), e);
         ticket = ErrorHandlerHelper.handleErrorMessages (ticket, e);
      }
      catch (final TicketServiceDownException e)
      {
         LOG.error (e.getMessage (), e);
         ticket = ErrorHandlerHelper.handleErrorMessages (ticket, e);
      }
      return ticket;
   }


   /**
    * Overrides saveTicket
    *
    * @param ticket
    * @return ticket
    * @since 20/02/2015
    * @see org.rage.ticket.service.TicketService#saveTicket(org.rage.ticket.model.Ticket)
    */
   public Ticket saveTicket (final Ticket ticket)
   {
      Ticket output = null;
      try
      {
         output = ticketManager.saveTicket (ticket);
      }
      catch (final DatabaseTicketException e)
      {
         LOG.error (e.getMessage (), e);
         output = ErrorHandlerHelper.handleErrorMessages (output, e);
      }
      catch (final ValidationTicketException e)
      {
         LOG.error (e.getMessage (), e);
         output = ErrorHandlerHelper.handleErrorMessages (output, e);
      }
      catch (final TicketServiceDownException e)
      {
         LOG.error (e.getMessage (), e);
         output = ErrorHandlerHelper.handleErrorMessages (output, e);
      }
      return output;
   }


   /**
    * Overrides getTicketByStatus
    *
    * @param status
    * @return ticketListWrapper
    * @since 20/02/2015
    * @see org.rage.ticket.service.TicketService#getTicketByStatus(org.rage.ticket.model.enu.TicketStatus)
    */
   public TicketListWrapper getTicketByStatus (final TicketStatus status)
   {
      final TicketListWrapper wrapper = new TicketListWrapper ();
      try
      {
         final List <Ticket> tickets = ticketManager.getTicketList (status);
         wrapper.setTickets (tickets);
      }
      catch (final DatabaseTicketException e)
      {
         LOG.error (e.getMessage (), e);
         ErrorHandlerHelper.handleErrorMessages (wrapper, e);
      }
      catch (final ValidationTicketException e)
      {
         LOG.error (e.getMessage (), e);
         ErrorHandlerHelper.handleErrorMessages (wrapper, e);
      }
      catch (final TicketServiceDownException e)
      {
         LOG.error (e.getMessage (), e);
         ErrorHandlerHelper.handleErrorMessages (wrapper, e);
      }
      return wrapper;
   }


   /**
    * @param ticketManager the ticketManager to set
    */
   @Autowired
   public void setTicketManager (final TicketManager ticketManager)
   {
      this.ticketManager = ticketManager;
   }

}
