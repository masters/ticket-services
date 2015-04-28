package org.rage.ticket.util;


import org.rage.ticket.client.CatalogClient;
import org.rage.ticket.exception.TicketServiceDownException;
import org.rage.ticket.model.Catalog;
import org.rage.ticket.model.Ticket;
import org.rage.ticket.model.enu.Catalogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import java.util.List;


/**
 * CatalogFactory
 *
 * @version $Id$
 * @since 11/03/2015
 *
 */
@Component ("catalogFactory")
public class CatalogFactory
{

   private final static transient Logger LOG = Logger.getLogger (CatalogFactory.class);
   @Autowired
   private transient CatalogClient       catalogClient;


   /**
    * Represents getCatalogList
    *
    * @param catalogName
    * @return catalogList
    * @since Apr 28, 2015
    *
    */
   public List <Catalog> getCatalogList (final String catalogName)
   {
      List <Catalog> catalogList = null;
      try
      {
         catalogList = catalogClient.getCatalogList (catalogName);
      }
      catch (final TicketServiceDownException e)
      {
         // TODO check if we need catch this or return it as a converted exception
         LOG.error (e.getMessage (), e);
      }
      return catalogList;
   }


   /**
    * @param ticket
    * @throws TicketServiceDownException
    * */
   public void fillCatalogInformation (final Ticket ticket) throws TicketServiceDownException
   {
      if (ticket.getArea () != null)
      {
         final Catalog area = catalogClient.getCatalogById (Catalogs.REPORT.name (), ticket.getArea ().getId ());
         ticket.setArea (area);
      }
      if (ticket.getPriority () != null)
      {
         final Catalog priority = catalogClient.getCatalogById (Catalogs.PRIORITY.name (), ticket.getPriority ()
               .getId ());
         ticket.setPriority (priority);
      }
      if (ticket.getReport () != null)
      {
         final Catalog report = catalogClient.getCatalogById (Catalogs.REPORT.name (), ticket.getReport ().getId ());
         ticket.setReport (report);
      }
      if (ticket.getServiceType () != null)
      {
         final Catalog serviceType = catalogClient.getCatalogById (Catalogs.SERVICE_TYPE.name (), ticket
               .getServiceType ().getId ());
         ticket.setServiceType (serviceType);
      }
   }
}
