package com.zava.checktoolset

object MainServer extends Main

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

class Main extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {

  }
}
