package net.kevinboone.apacheintegration.camel_flattenxml; 

import org.apache.camel.*;
import org.apache.camel.impl.*;
import org.apache.camel.builder.*;

public class MainApp 
  {
  public static void main(String... args) throws Exception 
    {
    new MainApp().run();
    }

  void run() throws Exception 
    {
    final CamelContext camelContext = new DefaultCamelContext();
     
    camelContext.addRoutes(createRouteBuilder());
                
    camelContext.start();

    Runtime.getRuntime().addShutdownHook(new Thread() 
      {
      public void run() 
        {
        try 
          {
          camelContext.stop();
          } 
        catch (Exception e) 
          {
          throw new RuntimeException(e);
          }
        }
      });
    waitForStop();
    }

  RouteBuilder createRouteBuilder() 
    {
    return new MyRouteBuilder();
    }

  void waitForStop() 
    {
    while (true) 
      {
      try 
        {
        Thread.sleep(Long.MAX_VALUE);
        } 
      catch (InterruptedException e) 
        {
        break;
        }
      }
    }
  }
