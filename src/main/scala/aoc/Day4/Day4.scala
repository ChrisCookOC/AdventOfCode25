package aoc.Day4

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
    val count = adjacentCellRollCount(cell, map)
    adjacentCellRollCount(cell, map) < 4
  }

  def howManyCanBeAccessed(map: Map[Coord, Location]): Int = {
    val blah = map.map(loc => loc._2.copy(isForkLiftable = canBeAccessedByForklift(loc._1, map)))
    map.map(loc => if loc._2.isPaper then loc._2.copy(isForkLiftable = canBeAccessedByForklift(loc._1, map)) else loc._2)
      .count(_.isForkLiftable)
  }

  def run(): Unit = {

    val file = Source.fromResource("Day4Input.txt")

    val list = file.getLines().mkString("\n")

    val map = parseDiagram(list)

    System.out.println("Thing is " + howManyCanBeAccessed(map))

  }

}
