//TODO: can be done by simple recursion... but now I am to tired...
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
  var firstType = 0
  var secondType = 0
  var thirdType = 0
  if (S.isEmpty) 1
  else {
    var lastOpened = List[Int]()
    def canBeClosed(n: Int, typ: Int) = {
      typ > 0 && lastOpened.nonEmpty && lastOpened.head == n
    }
    for (n <- S) {
      n match {
        case '(' =>
          lastOpened = 1 :: lastOpened
          firstType += 1
        case ')' =>
          if (canBeClosed(1, firstType)) {
            lastOpened = lastOpened.tail
            firstType -= 1
          }
          else return 0
        case '[' =>
          lastOpened = 2 :: lastOpened
          secondType += 1
        case ']' =>
          if (canBeClosed(2, secondType)) {
            lastOpened = lastOpened.tail
            secondType -= 1
          }
          else return 0
        case '{' =>
          lastOpened = 3 :: lastOpened
          thirdType += 1
        case '}' =>
          if (canBeClosed(3, thirdType)) {
            lastOpened = lastOpened.tail
            thirdType -= 1
          }
          else return 0
      }
    }
    if (firstType == 0 && secondType == 0 && thirdType == 0) 1
    else 0
  }
}
//that, given a string S consisting of N characters,
//returns 1 if S is properly nested and 0 otherwise.
solution("{[()()]}")
solution("([)()]")
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