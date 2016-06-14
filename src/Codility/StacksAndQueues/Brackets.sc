//A string S consisting of N characters is
//considered to be properly nested if any
//of the following conditions is true:
//
//S is empty;
//S has the form "(U)" or "[U]" or "{U}"
//where U is a properly nested string;
//S has the form "VW" where V and W
//are properly nested strings.
//
//For example, the string "{[()()]}" is properly nested but "([)()]" is not.
def solution(S: String): Int = {
  def rec(S: List[Char], first: Int, second: Int, third: Int, lastOpened: List[Int]): Int = {
    if (S.isEmpty) 1
    else {
      def canBeClosed(n: Int, typ: Int) = typ > 0 && lastOpened.nonEmpty && lastOpened.head == n
      S match {
        case '(' :: tail =>
          rec(tail, first + 1, second, third, 1 :: lastOpened)
        case ')' :: tail if canBeClosed(1, first) =>
          rec(tail, first - 1, second, third, lastOpened.tail)
        case '[' :: tail =>
          rec(tail, first, second + 1, third, 2 :: lastOpened)
        case ']' :: tail if canBeClosed(2, second) =>
          rec(tail, first, second - 1, third, lastOpened.tail)
        case '{' :: tail =>
          rec(tail, first, second, third + 1, 3 :: lastOpened)
        case '}' :: tail if canBeClosed(3, third) =>
          rec(tail, first, second, third - 1, lastOpened.tail)
        case Nil if first == 0 && second == 0 && third == 0 => 1
        case _ => 0
      }
    }
  }
  rec(S.toList, 0, 0, 0, List.empty)
}
//that, given a string S consisting of N characters,
//returns 1 if S is properly nested and 0 otherwise.
solution("{[()()]}") == 1
solution("([)()]") == 0
//For example, given S = "{[()()]}", the function
//should return 1 and given S = "([)()]", the function
//should return 0, as explained above.
//
//  Assume that:
//
//  N is an integer within the range [0..200,000];
//string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
//
//  Complexity:
//
//  expected worst-case time complexity is O(N);