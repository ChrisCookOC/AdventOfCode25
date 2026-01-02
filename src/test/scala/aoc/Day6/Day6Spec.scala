package aoc.Day6

import org.scalatest.matchers.must.Matchers.mustBe
import org.scalatest.wordspec.AnyWordSpec

class Day6Spec extends AnyWordSpec {

  private val day6 = Day6()

  "parse input" should {

    "do thing" in {
      val input = "123 328  51 64\n45 64  387 23\n6 98  215 314\n*   +   *   +  ".split("\n").toList

      day6.parseInput(input) mustBe List(Multiply(List(123, 45, 6)), Add(List(328, 64, 98)), Multiply(List(51, 387, 215)), Add(List(64, 23, 314)))

    }
  }

  "calculateSum" should {
    "do that" in {
      day6.calculateSum(Add(List(328, 64, 98))) mustBe 490
    }
  }


  "calculateProduct" should {
    "do that" in {
      day6.calculateProduct(Multiply(List(123, 45, 6))) mustBe 33210
      day6.calculateProduct(Multiply(List(51, 387, 215))) mustBe 4243455
    }
  }
  
  "getGrandTotal" should {
    "do that" in {
      var testData = List(Multiply(List(123, 45, 6)), Add(List(328, 64, 98)), Multiply(List(51, 387, 215)), Add(List(64, 23, 314)))

      day6.getGrandTotal(testData) mustBe 4277556
    }
  }


}
