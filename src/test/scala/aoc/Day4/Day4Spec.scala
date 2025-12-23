package aoc.Day4

import org.scalatest.matchers.must.Matchers.mustBe
import org.scalatest.wordspec.AnyWordSpec

class Day4Spec extends AnyWordSpec {

  private val day4 = Day4()

  //Generated from test output so hopefully is valid...
  private val exampleMap = Map((4, 1) -> Location(4, 1, true, false), (5, 2) -> Location(5, 2, true, false), (8, 0) -> Location(8, 0, false, false), (2, 9) -> Location(2, 9, true, false), (5, 6) -> Location(5, 6, true, false), (2, 2) -> Location(2, 2, true, false), (5, 4) -> Location(5, 4, true, false), (4, 8) -> Location(4, 8, true, false), (8, 5) -> Location(8, 5, true, false), (3, 4) -> Location(3, 4, true, false), (2, 1) -> Location(2, 1, true, false), (9, 9) -> Location(9, 9, false, false), (9, 3) -> Location(9, 3, false, false), (7, 8) -> Location(7, 8, true, false), (7, 5) -> Location(7, 5, false, false), (4, 7) -> Location(4, 7, false, false), (7, 9) -> Location(7, 9, true, false), (6, 1) -> Location(6, 1, true, false), (2, 5) -> Location(2, 5, false, false), (4, 2) -> Location(4, 2, false, false), (4, 4) -> Location(4, 4, true, false), (2, 0) -> Location(2, 0, true, false), (2, 6) -> Location(2, 6, true, false), (6, 0) -> Location(6, 0, false, false), (8, 4) -> Location(8, 4, true, false), (9, 7) -> Location(9, 7, false, false), (1, 8) -> Location(1, 8, true, false), (9, 1) -> Location(9, 1, false, false), (1, 2) -> Location(1, 2, true, false), (6, 5) -> Location(6, 5, true, false), (6, 2) -> Location(6, 2, false, false), (8, 2) -> Location(8, 2, true, false), (1, 4) -> Location(1, 4, true, false), (4, 5) -> Location(4, 5, true, false), (5, 8) -> Location(5, 8, false, false), (4, 6) -> Location(4, 6, true, false), (0, 1) -> Location(0, 1, false, false), (1, 1) -> Location(1, 1, true, false), (9, 0) -> Location(9, 0, true, false), (6, 7) -> Location(6, 7, true, false), (0, 4) -> Location(0, 4, false, false), (4, 9) -> Location(4, 9, true, false), (2, 7) -> Location(2, 7, false, false), (9, 4) -> Location(9, 4, true, false), (1, 9) -> Location(1, 9, true, false), (8, 1) -> Location(8, 1, true, false), (1, 6) -> Location(1, 6, true, false), (7, 7) -> Location(7, 7, true, false), (3, 8) -> Location(3, 8, true, false), (3, 0) -> Location(3, 0, true, false), (8, 3) -> Location(8, 3, true, false), (5, 9) -> Location(5, 9, true, false), (0, 5) -> Location(0, 5, true, false), (2, 4) -> Location(2, 4, true, false), (3, 7) -> Location(3, 7, false, false), (9, 2) -> Location(9, 2, true, false), (6, 3) -> Location(6, 3, true, false), (8, 8) -> Location(8, 8, true, false), (9, 8) -> Location(9, 8, true, false), (6, 4) -> Location(6, 4, false, false), (2, 8) -> Location(2, 8, true, false), (0, 9) -> Location(0, 9, false, false), (8, 9) -> Location(8, 9, false, false), (3, 2) -> Location(3, 2, true, false), (9, 6) -> Location(9, 6, true, false), (1, 5) -> Location(1, 5, false, false), (8, 6) -> Location(8, 6, true, false), (1, 0) -> Location(1, 0, true, false), (3, 1) -> Location(3, 1, false, false), (7, 1) -> Location(7, 1, false, false), (7, 2) -> Location(7, 2, true, false), (3, 9) -> Location(3, 9, false, false), (0, 0) -> Location(0, 0, false, false), (5, 0) -> Location(5, 0, false, false), (6, 8) -> Location(6, 8, true, false), (8, 7) -> Location(8, 7, true, false), (4, 0) -> Location(4, 0, true, false), (3, 3) -> Location(3, 3, true, false), (0, 7) -> Location(0, 7, true, false), (6, 9) -> Location(6, 9, true, false), (4, 3) -> Location(4, 3, true, false), (1, 7) -> Location(1, 7, false, false), (9, 5) -> Location(9, 5, true, false), (5, 1) -> Location(5, 1, true, false), (3, 6) -> Location(3, 6, false, false), (2, 3) -> Location(2, 3, true, false), (3, 5) -> Location(3, 5, true, false), (7, 3) -> Location(7, 3, true, false), (7, 0) -> Location(7, 0, true, false), (1, 3) -> Location(1, 3, false, false), (5, 5) -> Location(5, 5, true, false), (0, 8) -> Location(0, 8, true, false), (0, 6) -> Location(0, 6, true, false), (0, 3) -> Location(0, 3, true, false), (5, 7) -> Location(5, 7, true, false), (5, 3) -> Location(5, 3, true, false), (7, 4) -> Location(7, 4, true, false), (6, 6) -> Location(6, 6, false, false), (0, 2) -> Location(0, 2, true, false), (7, 6) -> Location(7, 6, true, false))
  "parseDiagram" should {

    "do thing" in {
      day4.parseDiagram("..@@.@@@@.\n@@@.@.@.@@") mustBe Map(
        (0,0) -> Location(0, 0, false, false),
        (0,1) -> Location(0, 1, false, false),
        (0,2) -> Location(0, 2, true, false),
        (0,3) -> Location(0, 3, true, false),
        (0,4) -> Location(0, 4, false, false),
        (0,5) -> Location(0, 5, true, false),
        (0,6) -> Location(0, 6, true, false),
        (0,7) -> Location(0, 7, true, false),
        (0,8) -> Location(0, 8, true, false),
        (0,9) -> Location(0, 9, false, false),
        (1,0) -> Location(1, 0, true, false),
        (1,1) -> Location(1, 1, true, false),
        (1,2) -> Location(1, 2, true, false),
        (1,3) -> Location(1, 3, false, false),
        (1,4) -> Location(1, 4, true, false),
        (1,5) -> Location(1, 5, false, false),
        (1,6) -> Location(1, 6, true, false),
        (1,7) -> Location(1, 7, false, false),
        (1,8) -> Location(1, 8, true, false),
        (1,9) -> Location(1, 9, true, false)
      )
    }
  }

  "adjacentCellRollCount" should {
    "count 8 if all around are paper" in {
      val example = Map(
        (0,0) -> Location(0, 0, true, false),
        (0,1) -> Location(0, 1, true, false),
        (0,2) -> Location(0, 2, true, false),
        (1,0) -> Location(1, 0, true, false),
        (1,1) -> Location(1, 1, false, false),
        (1,2) -> Location(1, 2, true, false),
        (2,0) -> Location(2, 0, true, false),
        (2,1) -> Location(2, 1, true, false),
        (2,2) -> Location(2, 2, true, false),
      )
      day4.adjacentCellRollCount((1,1), example) mustBe 8
    }

    "count 0 if all around are empty" in {
      val example = Map(
        (0, 0) -> Location(0, 0, false, false),
        (0, 1) -> Location(0, 1, false, false),
        (0, 2) -> Location(0, 2, false, false),
        (1, 0) -> Location(1, 0, false, false),
        (1, 1) -> Location(1, 1, false, false),
        (1, 2) -> Location(1, 2, false, false),
        (2, 0) -> Location(2, 0, false, false),
        (2, 1) -> Location(2, 1, false, false),
        (2, 2) -> Location(2, 2, false, false),
      )
      day4.adjacentCellRollCount((1, 1), example) mustBe 0
    }

    "not go out of bounds if at 0,0" in {
      val example = Map(
        (0, 0) -> Location(0, 0, false, false),
        (0, 1) -> Location(0, 1, true, false),
        (0, 2) -> Location(0, 2, true, false),
        (1, 0) -> Location(1, 0, true, false),
        (1, 1) -> Location(1, 1, false, false),
        (1, 2) -> Location(1, 2, true, false),
        (2, 0) -> Location(2, 0, true, false),
        (2, 1) -> Location(2, 1, true, false),
        (2, 2) -> Location(2, 2, true, false),
      )
      day4.adjacentCellRollCount((0, 0), example) mustBe 2
    }

    "not go out of bounds if at other corner" in {
      val example = Map(
        (0, 0) -> Location(0, 0, false, false),
        (0, 1) -> Location(0, 1, true, false),
        (0, 2) -> Location(0, 2, true, false),
        (1, 0) -> Location(1, 0, true, false),
        (1, 1) -> Location(1, 1, false, false),
        (1, 2) -> Location(1, 2, true, false),
        (2, 0) -> Location(2, 0, true, false),
        (2, 1) -> Location(2, 1, true, false),
        (2, 2) -> Location(2, 2, true, false),
      )
      day4.adjacentCellRollCount((2, 2), example) mustBe 2
    }
    
  }

  "canBeAccessedByForklift" should {
    "false" in {
      val example = Map(
        (0, 0) -> Location(0, 0, true, false),
        (0, 1) -> Location(0, 1, true, false),
        (0, 2) -> Location(0, 2, true, false),
        (1, 0) -> Location(1, 0, true, false),
        (1, 1) -> Location(1, 1, false, false),
        (1, 2) -> Location(1, 2, true, false),
        (2, 0) -> Location(2, 0, true, false),
        (2, 1) -> Location(2, 1, true, false),
        (2, 2) -> Location(2, 2, true, false),
      )
      day4.canBeAccessedByForklift((1, 1), example) mustBe false

    }

    "true" in {
      val example = Map(
        (0, 0) -> Location(0, 0, false, false),
        (0, 1) -> Location(0, 1, false, false),
        (0, 2) -> Location(0, 2, false, false),
        (1, 0) -> Location(1, 0, false, false),
        (1, 1) -> Location(1, 1, false, false),
        (1, 2) -> Location(1, 2, false, false),
        (2, 0) -> Location(2, 0, false, false),
        (2, 1) -> Location(2, 1, false, false),
        (2, 2) -> Location(2, 2, false, false),
      )
      day4.canBeAccessedByForklift((1, 1), example) mustBe true
    }
  }
  
  "howManyCanBeAccessed" should {
    
    "doThat" in {
      
      day4.howManyCanBeAccessed(exampleMap) mustBe 13
      
    }
    
  }


}
