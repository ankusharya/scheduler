package com.arya
import fastparse._
import NoWhitespace._
import com.arya.model.Seconds
import com.arya.core.{SchedulerGrammer, SchedulerParser}

object Scheduler {
  def run(time: String, loopFunction: () => Unit) = {
    val parsedTime = parse(time, SchedulerGrammer.cronParser(_))
    val timeValue = parsedTime match {
      case Parsed.Success(value, _) => value
      case _ => Seconds(0)
    }
    SchedulerParser.cronitor(timeValue, loopFunction)
  }
}
