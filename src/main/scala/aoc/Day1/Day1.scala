package aoc.Day1

import scala.io.Source

case class Day1() {

  def doTurn(location: Int, turn: String): Int = {
    val numberBit = turn.substring(1).toInt

    turn.substring(0, 1) match {
      case "L" => (100 - numberBit + location) % 100
      case "R" => (location + numberBit) % 100
      case _ => throw new Exception("not left or right")
    }
  }

  def findPassword(list: List[String]): Int = {
    list.scanLeft(50)((cur, turn) => doTurn(cur, turn)).count(_==0)
  }

  def run(): Unit = {

    val file = Source.fromResource("Day1Input.txt")

    val list = file
      .getLines()
      .toList

    System.out.println("Password is " + findPassword(list))

  }

}
