package org.rage.ticket.client;


import org.rage.ticket.model.Catalog;

import java.util.List;


/**
 * CatalogClient represents ...
 *
 * @author hector.mendoza
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
    * @return
    * @since 11/03/2015
    *
    */
   public List <Catalog> getCatalogList (String name);


   /**
    * Represents getCatalogById
    *
    * @param name
    * @param id
    * @return
    * @since 11/03/2015
    *
    */
   public Catalog getCatalogById (final String name, Integer id);
}
