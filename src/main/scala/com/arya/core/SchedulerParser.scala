package com.arya.core

import com.arya.model.{Hour, Minutes, SchedulerAtomic, Seconds}

object SchedulerParser {
  def convertToNano(time: SchedulerAtomic) = {

    time match {
      case sec: Seconds => sec.seconds * 1000
      case min: Minutes => min.minutes * 60 * 1000
      case hour: Hour => hour.hours * 60 * 60 * 1000
    }
  }
  def cronitor(time: SchedulerAtomic, loopFuction: () => Unit) = {
    val nanoTime = convertToNano(time)
    while(true){
      loopFuction()
      Thread.sleep(nanoTime)
    }
  }
}
