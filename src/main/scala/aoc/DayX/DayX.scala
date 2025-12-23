package aoc.DayX

import scala.io.Source

case class DayX() {
  
  def run(): Unit = {

    val file = Source.fromResource("DayXInput.txt")

    val list = file
      .getLines()
      .toList

//    System.out.println("Thing is " + routine(list))

  }

}
