package aoc.Day3

import scala.collection.mutable
import scala.io.Source

case class Day3() {

  def findMaxInLine(line: String): Int = {
    // Could try and be smart or could brute force??

    val possible = for {
      i <- line.indices
      j <- line.indices
      if i < j
    } yield s"${line(i)}${line(j)}"

    possible.foldLeft(0)((cur, pair) => if pair.toInt > cur then pair.toInt else cur)
  }

  def findMaxInLine12(line: String): Long = {

    println(s"Finding for $line")

    val stack = mutable.Stack[String]()
    var charsToRemove = line.length - 12
    for (char: Char <- line) {
        while (charsToRemove > 0 && stack.nonEmpty && stack.last < char.toString) do {
          stack.removeLast()
          charsToRemove -=1
        }
        stack.append(char.toString)
    }

    stack.take(12).mkString.toLong
  }

  def sumLines(lines: List[String]): Int = {
    lines.foldLeft(0)((sum, line) => sum + findMaxInLine(line))
  }

  def sumLines12(lines: List[String]): Long = {
    lines.foldLeft(0L)((sum, line) => sum + findMaxInLine12(line))
  }


  def run(): Unit = {

    val file = Source.fromResource("Day3Input.txt")

    val list = file
      .getLines()
      .toList

    System.out.println("Thing is " + sumLines12(list))

  }

}
