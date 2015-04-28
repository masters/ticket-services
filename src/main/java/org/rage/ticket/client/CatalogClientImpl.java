package org.rage.ticket.client;


import org.rage.ticket.exception.TicketServiceDownException;
import org.rage.ticket.model.Catalog;
import org.rage.ticket.model.CatalogListWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * CatalogClientImpl
 *
 * @since 20/03/2015
 *
 */
@Component ("catalogClient")
public class CatalogClientImpl implements CatalogClient
{
   private transient RestTemplate restTemplate;
   private transient String       server;
   private transient String       applicationPath;
   private transient String       listPath;
   private transient String       getByIdPath;


   private String getUrl (final String operation)
   {
      return this.server + this.applicationPath + operation;
   }


   /**
    * Overrides getCatalogList
    *
    * @param name
    * @return response
    * @since 20/03/2015
    * @see org.rage.ticket.client.CatalogClient#getCatalogList(java.lang.String)
    */
   public List <Catalog> getCatalogList (final String name) throws TicketServiceDownException
   {
      List <Catalog> catalogList = null;
      final Map <String, String> variables = new HashMap <String, String> ();
      variables.put ("name", name);
      CatalogListWrapper catalogListWrapper = null;

      try
      {
         catalogListWrapper = restTemplate.getForObject (getUrl (listPath), CatalogListWrapper.class, variables);
      }
      catch (final Exception exception)
      {
         throw new TicketServiceDownException (exception.getMessage (), exception);
      }

      if ( (catalogListWrapper != null) && catalogListWrapper.isValid ())
      {
         catalogList = catalogListWrapper.getCatalogList ();
      }
      return catalogList;
   }


   /**
    * Overrides getCatalogById
    *
    * @param name
    * @param id
    * @return response
    * @since 20/03/2015
    * @see org.rage.ticket.client.CatalogClient#getCatalogById(java.lang.String, java.lang.Integer)
    */
   public Catalog getCatalogById (final String name, final Integer id)
   {
      final Map <String, String> variables = new HashMap <String, String> ();
      variables.put ("name", name);
      return restTemplate.getForObject (getUrl (getByIdPath + "/" + id + "/"), Catalog.class, variables);
   }



   /**
    * @param listPathValue the listPath to set
    */
   @Value ("#{systemProperties.catalogList}")
   public void setListPath (final String listPathValue)
   {
      this.listPath = listPathValue;
   }


   /**
    * @param getByIdPathValue the getByIdPath to set
    */
   @Value ("#{systemProperties.catalogGetById}")
   public void setGetByIdPath (final String getByIdPathValue)
   {
      this.getByIdPath = getByIdPathValue;
   }


   /**
    * @param serverValue the server to set
    */
   @Value ("#{systemProperties.server}")
   public void setServer (final String serverValue)
   {
      this.server = serverValue;
   }


   /**
    * @param applicationPathValue the applicationPath to set
    */
   @Value ("#{systemProperties.catalogProject}")
   public void setApplicationPath (final String applicationPathValue)
   {
      this.applicationPath = applicationPathValue;
   }

}
