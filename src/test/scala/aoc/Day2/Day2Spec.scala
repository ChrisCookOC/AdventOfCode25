package aoc.Day2

import org.scalatest.matchers.must.Matchers.mustBe
import org.scalatest.wordspec.AnyWordSpec

class Day2Spec extends AnyWordSpec {

  private val day2 = Day2()

  "expandRange" should {

    "getAllNumbersInRange" in {
      day2.expandRange("11-22") mustBe List(11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    }

  }

  "checkPalindrome" should {

    "find them" in {
      day2.checkPalindrome("11-22") mustBe List(11, 22)
      day2.checkPalindrome("95-115") mustBe List(99)
      day2.checkPalindrome("998-1012") mustBe List(1010)
      day2.checkPalindrome("222220-222224") mustBe List(222222)
      day2.checkPalindrome("1188511880-1188511890") mustBe List(1188511885)
      day2.checkPalindrome("1698522-1698528") mustBe List.empty
      day2.checkPalindrome("446443-446449") mustBe List(446446)
      day2.checkPalindrome("38593856-38593862") mustBe List(38593859)

    }

  }

  "palindromeSum" should {

    "do the sum" in {
      day2.palindromeSum("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
        "1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827," +
        "2121212118-2121212124") mustBe 1227775554
    }
  }

}
