package aoc.Day3

import org.scalatest.matchers.must.Matchers.mustBe
import org.scalatest.wordspec.AnyWordSpec

class Day3Spec extends AnyWordSpec {

  private val day3 = Day3()

  "findMaxInLine" should {

    "do that" in {
      day3.findMaxInLine("987654321111111") mustBe 98
      day3.findMaxInLine("811111111111119") mustBe 89
      day3.findMaxInLine("234234234234278") mustBe 78
      day3.findMaxInLine("818181911112111") mustBe 92
    }

  }

  "findMaxInLine12" should {

    "do that" in {
      day3.findMaxInLine12("987654321111111") mustBe 987654321111L
      day3.findMaxInLine12("811111111111119") mustBe 811111111119L
      day3.findMaxInLine12("234234234234278") mustBe 434234234278L
      day3.findMaxInLine12("818181911112111") mustBe 888911112111L
    }

  }

  "sumLines" should {

    "doThat" in {

      val input = "987654321111111\n811111111111119\n234234234234278\n818181911112111".split("\n")
      day3.sumLines(input.toList) mustBe 357

    }

  }

  "sumLines12" should {

    "doThat" in {

      val input = "987654321111111\n811111111111119\n234234234234278\n818181911112111".split("\n")
      day3.sumLines12(input.toList) mustBe 3121910778619L

    }

  }

}
