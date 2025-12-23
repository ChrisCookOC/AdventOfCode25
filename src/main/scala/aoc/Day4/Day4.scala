package aoc.Day4

import scala.annotation.tailrec
import scala.io.Source

case class Location(row: Int, col: Int, isPaper: Boolean, isForkLiftable: Boolean) {
  def getCell: Coord = (row, col)
}

type Coord = (Int, Int)

case class Day4() {

  def parseDiagram(diagram: String): Map[Coord, Location] = {
    diagram
      .split("\n")
      .zipWithIndex
      .flatMap(row => row._1
        .split("")
        .zipWithIndex
        .map(cell => ((row._2, cell._2), Location(row._2, cell._2, cell._1=="@", false)))
    ).toMap
  }

  def adjacentCellRollCount(cell: Coord, map: Map[Coord, Location]): Int = {
    val adjacentCells = List(
      (cell._1-1, cell._2-1), (cell._1-1, cell._2), (cell._1-1 , cell._2+1),
      (cell._1, cell._2-1), (cell._1, cell._2+1),
      (cell._1+1, cell._2-1), (cell._1+1, cell._2), (cell._1+1 , cell._2+1)
    )

    adjacentCells.flatMap(cell => map.get(cell)).count(_.isPaper)
  }

  def canBeAccessedByForklift(cell: Coord, map: Map[Coord, Location]): Boolean = {
    adjacentCellRollCount(cell, map) < 4
  }

  def howManyCanBeAccessed(map: Map[Coord, Location]): Int = {
    workOutWhatCanBeAccessed(map)
      .count(_._2.isForkLiftable)
  }

  private def workOutWhatCanBeAccessed(map: Map[Coord, Location]): Map[Coord, Location] = {
    map.map(loc => if loc._2.isPaper then loc._1 -> loc._2.copy(isForkLiftable = canBeAccessedByForklift(loc._1, map)) else loc)
  }

  def removingAndRepeating(map: Map[Coord, Location]): Int = {
    removingAndRepeatingInternal(0, map)
  }

  @tailrec
  private def removingAndRepeatingInternal(count: Int, map: Map[Coord, Location]): Int = {
    val newMap = workOutWhatCanBeAccessed(map)
    val howManyWereRemoved = newMap.count(_._2.isForkLiftable)
    if howManyWereRemoved == 0 then count
    else removingAndRepeatingInternal(count + howManyWereRemoved, cleanUpMap(newMap))
  }

  private def cleanUpMap(map:Map[Coord, Location]): Map[Coord, Location] =
    map.map(item => if item._2.isForkLiftable then item._1 -> item._2.copy(isPaper = false, isForkLiftable = false) else item)

  def run(): Unit = {

    val file = Source.fromResource("Day4Input.txt")

    val list = file.getLines().mkString("\n")

    val map = parseDiagram(list)

      System.out.println("Thing is " + howManyCanBeAccessed(map))
      System.out.println("Thing is " + removingAndRepeating(map))

  }

}
