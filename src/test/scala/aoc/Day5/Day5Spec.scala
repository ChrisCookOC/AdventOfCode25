package aoc.Day5

import org.scalatest.matchers.must.Matchers.mustBe
import org.scalatest.wordspec.AnyWordSpec

class Day5Spec extends AnyWordSpec {

  private val day5 = Day5()

  private val testFreshRanges = List(FreshRange(3, 5), FreshRange(10, 14), FreshRange(16, 20), FreshRange(12, 18))
  private val testInput = Input(
    testFreshRanges,
    List(1, 5, 8, 11, 17, 32)
  )

  "routine" should {

    "parse" in {
      day5.parse("3-5\n10-14\n16-20\n12-18\n\n1\n5\n8\n11\n17\n32") mustBe testInput

    }
  }

  "isFresh" should {

    "check that" in {

      day5.isFresh(1, testFreshRanges) mustBe false
      day5.isFresh(5, testFreshRanges) mustBe true
      day5.isFresh(8, testFreshRanges) mustBe false
      day5.isFresh(11, testFreshRanges) mustBe true
      day5.isFresh(17, testFreshRanges) mustBe true
      day5.isFresh(32, testFreshRanges) mustBe false

    }
  }

  "howManyAreFresh" should {

    "check that" in {

      day5.howManyAreFresh(testInput) mustBe 3

    }
  }

  "totalPossibleFresh" should {

    "do that" in {

      day5.totalPossibleFresh(testInput) mustBe 14

    }

    "test cases to try and find bug" in {
      val case1 = Input(List(
        FreshRange(1, 3)
      ),
        List.empty)

      day5.totalPossibleFresh(case1) mustBe 3

      val case2 = Input(List(
        FreshRange(1, 3),
                FreshRange(1,1),
        //        FreshRange(1, 2),
        //        FreshRange(2, 3),
        //        FreshRange(1,3)
      ),
        List.empty)

      day5.totalPossibleFresh(case2) mustBe 3

      val case3 = Input(List(
        FreshRange(1, 3),
                FreshRange(1, 2),
      ),
        List.empty)

      day5.totalPossibleFresh(case3) mustBe 3

      val case4 = Input(List(
        FreshRange(1, 3),
                FreshRange(2, 3),
      ),
        List.empty)

      day5.totalPossibleFresh(case4) mustBe 3

      val case5 = Input(List(
        FreshRange(1, 3),
        FreshRange(1,1),
        FreshRange(2, 3),
      ),
        List.empty)

      day5.totalPossibleFresh(case5) mustBe 3

    }
  }

}
