package net.kevinboone.apacheintegration.camel_flattenxml; 
import org.apache.camel.*;
import org.apache.camel.impl.*;
import org.apache.camel.builder.*;


public class MyRouteBuilder extends RouteBuilder 
  {
  public void configure() 
      {
      from ("file://in")
        .to ("xslt:test.xslt")
        .to ("log://foo");
      }
  }


