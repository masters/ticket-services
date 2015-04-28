package org.rage.ticket.client;


import org.rage.ticket.exception.TicketServiceDownException;
import org.rage.ticket.model.Catalog;

import java.util.List;


/**
 * CatalogClient
 *
 * @version $Id$
 * @since 11/03/2015
 *
 */
public interface CatalogClient
{

   /**
    * Represents getCatalogList
    *
    * @param name
    * @return list
    * @throws TicketServiceDownException
    * @since 11/03/2015
    *
    */
   public List <Catalog> getCatalogList (String name) throws TicketServiceDownException;


   /**
    * Represents getCatalogById
    *
    * @param name
    * @param id
    * @return catalog
    * @throws TicketServiceDownException
    * @since 11/03/2015
    *
    */
   public Catalog getCatalogById (final String name, Integer id) throws TicketServiceDownException;
}
