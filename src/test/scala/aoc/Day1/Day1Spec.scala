package aoc.Day1

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers.mustBe

class Day1Spec extends AnyWordSpec {

  private val day1 = Day1()

  "doTurn" should {

    "turn Left when given Lx" in {
      day1.doTurn(90, "L10") mustBe 80
      day1.doTurn(90, "L32") mustBe 58
    }

    "turn Right when given Rx" in {
      day1.doTurn(80, "R10") mustBe 90
      day1.doTurn(43, "R32") mustBe 75
    }

    "cycle when move left past 0" in {
      day1.doTurn(10, "L20") mustBe 90
    }

    "cycle when move right past 99" in {
      day1.doTurn(92, "R10") mustBe 2
    }

  }

  "findPassword" should {

    "doExampleSupplied" in {
      val example = "L68\nL30\nR48\nL5\nR60\nL55\nL1\nL99\nR14\nL82".split("\n").toList
      day1.findPassword(example) mustBe 3
    }

  }

}
