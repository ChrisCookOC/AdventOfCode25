package aoc.Day5

import scala.io.Source

case class FreshRange(start: Long, end: Long)
case class Input(ranges: List[FreshRange], toCheck: List[Long])

case class Day5() {

  def parse(input: String): Input = {
    val halves = input.split("\n\n")
    val freshRangesRaw = halves(0)
    val toCheckRaw = halves(1)

    val freshRanges = freshRangesRaw
      .split("\n")
      .map(x => x.split("-"))
      .map(y => FreshRange(y(0).toLong, y(1).toLong))
      .toList

    val toCheck = toCheckRaw
      .split("\n")
      .map(_.toLong)
      .toList

    Input(freshRanges, toCheck)
  }

  def isFresh(toTest: Long, freshRanges: List[FreshRange]):Boolean = {
    freshRanges.exists(range => toTest >= range.start && toTest <= range.end)
  }

  def howManyAreFresh(input: Input): Long = {
    input.toCheck.map(no => isFresh(no, input.ranges)).count(_==true)
  }

  case class Iterat(lastRange: FreshRange, countOfFresh: Long)

  def totalPossibleFresh(input: Input): Long = {

    input.ranges.
      sortBy(_.start).
      foldLeft(Iterat(FreshRange(0L,0L),0L))((cur, next) => {
      if (cur.lastRange.end < next.start) {
        // add whole range
        Iterat(workOutRangeToPassInNextTime(cur.lastRange, next), cur.countOfFresh + next.end - next.start + 1)
      } else if (cur.lastRange.end == next.start){
        //Starting at same place last one ended, so don't count that one
        Iterat(workOutRangeToPassInNextTime(cur.lastRange, next), cur.countOfFresh + next.end - next.start)
      } else if (cur.lastRange.end < next.end){
        // Only take part the range
        Iterat(workOutRangeToPassInNextTime(cur.lastRange, next), cur.countOfFresh + next.end - cur.lastRange.end)
      } else if (cur.lastRange.end == next.end){
        // don't take anything
        Iterat(workOutRangeToPassInNextTime(cur.lastRange, next), cur.countOfFresh)
      } else {
        // completely consumed by last range
        Iterat(workOutRangeToPassInNextTime(cur.lastRange, next), cur.countOfFresh)
      }
    }

    ).countOfFresh

  }

  private def workOutRangeToPassInNextTime(lastRange: FreshRange, rangeJustDone: FreshRange) = {
    FreshRange(Math.min(lastRange.start, rangeJustDone.start),
      Math.max(lastRange.end, rangeJustDone.end))
  }

  def run(): Unit = {

    val file = Source.fromResource("Day5Input.txt")

    val text = file
      .getLines()
      .mkString("\n")

//    System.out.println("Thing is " + howManyAreFresh(parse(text)))
    System.out.println("Thing is " + totalPossibleFresh(parse(text)))

  }

}
