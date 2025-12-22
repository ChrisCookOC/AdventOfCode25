package aoc.Day2

import scala.io.Source

case class Day2() {

  def expandRange(range: String): List[Long] = {
    val splits = range.split("-")
    val start = splits(0).toLong
    val end = splits(1).toLong
    Range.Long.inclusive(start, end, 1).toList
  }

  def checkPalindrome(range: String): List[Long] = {
    val nosToCheck = expandRange(range)
    //TODO maybe move to string if part 2 works?
    nosToCheck.map {
      case x if x < 10 => 0
      case x if x < 100 => if x / 10 == x % 10 then x else 0
      case x if x < 1000 => 0
      case x if x < 10000 => if x / 100 == x % 100 then x else 0
      case x if x < 100000 => 0
      case x if x < 1000000 => if x / 1000 == x % 1000 then x else 0
      case x if x < 10000000 => 0
      case x if x < 100000000 => if x / 10000 == x % 10000 then x else 0
      case x if x < 1000000000 => 0
      case x => if x / 100000 == x % 100000 then x else 0
    }.filterNot(_ == 0)
  }

  def palindromeSum(ranges: String): Long = {
    val rangeList = ranges.split(",").toList
    rangeList.flatMap(checkPalindrome).sum
  }

  def run(): Unit = {

    val file = Source.fromResource("Day2Input.txt")

//    val list = file
//      .getLines()
//      .toList

    System.out.println("Sum is " + palindromeSum(file.getLines().toList.head))
//    System.out.println("Password is " + findNewerPassword(list))

  }

}
