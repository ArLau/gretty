/*
 * gretty
 *
 * Copyright 2013  Andrey Hihlovskiy.
 *
 * See the file "license.txt" for copying and usage permission.
 */
package org.akhikhl.gretty

import org.eclipse.jetty.security.HashLoginService
import org.eclipse.jetty.security.LoginService
import org.eclipse.jetty.server.Connector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.bio.SocketConnector
import org.eclipse.jetty.webapp.WebAppClassLoader
import org.eclipse.jetty.webapp.WebAppContext

class GrettyHelper {

  public static Connector[] createConnectors(int port) {
    SocketConnector connector = new SocketConnector()
    // Set some timeout options to make debugging easier.
    connector.setMaxIdleTime(1000 * 60 * 60)
    connector.setSoLingerTime(-1)
    connector.setPort(port)
    return [connector ] as Connector[]
  }

  public static LoginService createLoginService(String realmName, String realmConfigFile) {
    return new HashLoginService(realmName, realmConfigFile)
  }

  public static Server createServer() {
    return new Server()
  }

  public static void setClassLoader(WebAppContext context, URLClassLoader classLoader) {
    context.setClassLoader(new WebAppClassLoader(classLoader, context))
  }

  public static WebAppContext createWebAppContext() {
    return new WebAppContext()
  }
}
