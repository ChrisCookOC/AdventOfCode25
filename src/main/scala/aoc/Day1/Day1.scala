package aoc.Day1

import scala.io.Source

case class Day1() {

  def run(): Unit = {

    val file = Source.fromResource("Day1Input.txt")

    val lists = file.getLines()
      .map(_.split("\\s+"))
      .collect{ case Array(left, right) => (left.toInt, right.toInt)}
      .toList
      .unzip

  }

}
