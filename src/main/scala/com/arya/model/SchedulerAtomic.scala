package com.arya.model

trait SchedulerAtomic
case class Seconds(seconds: Int)  extends SchedulerAtomic
case class Minutes(minutes: Int)  extends SchedulerAtomic
case class Hour(hours: Int)  extends SchedulerAtomic
