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
      .transpose // merge each row together
      .map(list => list.last match {
        case "+" => Add(list.dropRight(1).map(_.toInt))
        case "*" => Multiply(list.dropRight(1).map(_.toInt))
      })
  }

  def parseInput2(input: List[String]): List[Input] = {
     input.map(_.split("")) //get individual chars
       .transpose // get it by column
       .map(_.reverse) // put operator first
       .map(col =>
         (col.tail.reverse.mkString.trim.toLongOption.getOrElse(0L), // Build number, orElse to handle gap between things
           col.head)) // Op
       .foldLeft(List.empty[(String, List[Long])]) {
          case (acc, pair) if !pair._2.isBlank => (pair._2, List(pair._1)) :: acc
          case (cur :: tail, pair) if pair._1 != 0 => (cur._1, List(pair._1) ++ cur._2) :: tail
          case (acc, pair) => acc
        }
       .map(pair => pair._1 match {
          case "*" => Multiply(pair._2)
          case "+" => Add(pair._2)
          case _ => throw new Exception(pair.toString())
        })
  }

  private def buildNumbersAdd(input: List[String]) = {
    input.map(_.split(""))
      .map(_.reverse)
      .flatMap(_.zipWithIndex)
      .groupBy(_._2)
      .toList
      .map(_._2)
      .map(_.map(_._1))
      .map(_.mkString.toLong)
      .reverse //silly really just put in for test consistency
  }

  private def buildNumbersMultiply(input: List[String]) = {
    input.map(_.split(""))
      .map(_.reverse)
      .flatMap(_.zipWithIndex)
      .groupBy(_._2)
      .toList
      .map(_._2)
      .map(_.map(_._1))
      .map(_.mkString.toLong)
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
    val inputs2 = parseInput2(list)

    System.out.println("Thing is " + getGrandTotal(inputs2))

  }

}
