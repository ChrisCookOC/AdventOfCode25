package aoc.Day6

import scala.io.Source

trait Input {
  def calculate: Long
}
case class Add(list: List[Long]) extends Input {
  override def calculate: Long = list.sum
}
case class Multiply(list: List[Long]) extends Input {
  override def calculate: Long = list.product
}

case class Day6() {

  def parseInput(input: List[String]): List[Input] = {
    input.map(_.split("\\s+").toList)
      .transpose
      .map(list => list.last match {
        case "+" => Add(list.dropRight(1).map(_.toInt))
        case "*" => Multiply(list.dropRight(1).map(_.toInt))
      })
  }

  def calculateSum(sum: Add): Long = sum.calculate

  def calculateProduct(product: Multiply): Long = product.calculate

  def getGrandTotal(input: List[Input]): Long = input.map(_.calculate).sum
  
  def run(): Unit = {

    val file = Source.fromResource("Day6Input.txt")

    val list = file
      .getLines()
      .toList
    
    val inputs = parseInput(list)

    System.out.println("Thing is " + getGrandTotal(inputs))

  }

}
