package com.arya.core
import fastparse._
import NoWhitespace._
import com.arya.model.{Hour, Minutes, Seconds}
object SchedulerGrammer {

  def secsParser[_:P] = P(CharIn("0-9").rep.!.map(x => Seconds(x.toInt)) ~ (CharIn("sec") | CharIn("secs")))
  def minuteParser[_:P] = P(CharIn("0-9").rep.!.map(x => Minutes(x.toInt)) ~ (CharIn("min") | CharIn("mins")))
  def hourParser[_:P] = P(CharIn("0-9").rep.!.map(x => Hour(x.toInt)) ~ (CharIn("hour") | CharIn("hours")))


  def cronParser[_:P] = P(secsParser | minuteParser | hourParser)
}


//def convertToNanoSeconds(x: SchedulerAtomic): Any = {
//  x match {
//  case sec: Seconds => sec.sec * 1000
//
//  case minute: Minute => minute.minute* 60 * 1000
//  case hour: Hour => hour.hour * 60 * 60 * 1000
//  case daily: Daily => daily.at match {
//  case Some(x) => convertToNanoSeconds(x)
//  case None => convertToNanoSeconds(Seconds(0))
//}
//  case _ => x
//}
//}