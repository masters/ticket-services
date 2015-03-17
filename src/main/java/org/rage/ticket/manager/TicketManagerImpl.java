package org.rage.ticket.manager;


import org.rage.ticket.client.CatalogClient;
import org.rage.ticket.exception.DatabaseTicketException;
import org.rage.ticket.exception.ValidationTicketException;
import org.rage.ticket.model.Catalog;
import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.enu.Catalogs;
import org.rage.ticket.model.enu.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

   private CatalogClient catalogClient;


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

      // fillCatalogs
      fillCatalogInformation (ticket);

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

      for (final Ticket ticket : tickets)
      {
         // fillCatalogs
         fillCatalogInformation (ticket);
      }
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


   private void fillCatalogInformation (final Ticket ticket)
   {
      if (ticket.getArea () != null)
      {
         final Catalog area = this.catalogClient.getCatalogById (Catalogs.REPORT.name (), ticket.getArea ().getId ());
         ticket.setArea (area);
      }
      if (ticket.getPriority () != null)
      {
         final Catalog priority = this.catalogClient.getCatalogById (Catalogs.PRIORITY.name (), ticket.getPriority ()
               .getId ());
         ticket.setPriority (priority);
      }
      if (ticket.getReport () != null)
      {
         final Catalog report = this.catalogClient.getCatalogById (Catalogs.REPORT.name (), ticket.getReport ()
               .getId ());
         ticket.setReport (report);
      }
      if (ticket.getServiceType () != null)
      {
         final Catalog serviceType = this.catalogClient.getCatalogById (Catalogs.SERVICE_TYPE.name (), ticket
               .getServiceType ().getId ());
         ticket.setServiceType (serviceType);
      }
   }


   /**
    * @param catalogClient the catalogClient to set
    */
   @Autowired
   public void setCatalogClient (final CatalogClient catalogClient)
   {
      this.catalogClient = catalogClient;
   }
}
