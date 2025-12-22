package aoc.Day1

import scala.io.Source

case class Day1() {

  def doTurn(startLocation: Int, nextTurn: String): Int = {
    val moveToMake = nextTurn.substring(1).toInt
    val direction = nextTurn.substring(0, 1)
     direction match {
      case "L" => (100 - moveToMake + startLocation) % 100
      case "R" => (startLocation + moveToMake) % 100
      case _   => throw new Exception("not left or right")
    }
  }

  def doTurn2(currentLocation: (Int, Int), nextTurn: String): (Int, Int) = {
    val numberToMove = nextTurn.substring(1).toInt
    val currentPosition = currentLocation._1
    val zeroCount = currentLocation._2

    val direction = nextTurn.substring(0, 1)
    val result = direction match {
      case "L" => (Math.abs(100 + currentPosition - (numberToMove % 100)) % 100,
        zeroCount + Math.abs(100 - currentPosition + numberToMove) / 100 + (if currentPosition  == 0 then -1 else 0))
      case "R" => ((currentPosition + numberToMove) % 100,
        zeroCount + Math.abs(currentPosition + numberToMove) / 100)
      case _ => throw new Exception("not left or right")
    }

    result
  }

  def findPassword(list: List[String]): Int = {
    list.scanLeft(50)((cur, turn) => doTurn(cur, turn)).count(_ == 0)
  }

  def findNewerPassword(list: List[String]): Int = {
    list.scanLeft((50, 0))((current, nextTurn) => doTurn2(current, nextTurn)).last._2
  }

  def run(): Unit = {

    val file = Source.fromResource("Day1Input.txt")

    val list = file
      .getLines()
      .toList

//    System.out.println("Password is " + findPassword(list))
    System.out.println("Password is " + findNewerPassword(list))

  }

}
