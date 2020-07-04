package com.arya

import java.util.concurrent.Executors
import concurrent.{ExecutionContext, Await, Future}
import concurrent.duration._

object Main {
  def main(args: Array[String]): Unit = {
    // single threaded execution context
    implicit val context = ExecutionContext.fromExecutor(Executors.newSingleThreadExecutor())

    Future {
      Scheduler.run("2sec", () => {println("Executing")})
      println("Running asynchronously on another thread")
    }


  }
}
