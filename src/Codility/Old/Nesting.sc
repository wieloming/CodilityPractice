//TODO(solved): ')(' <- this is wrong
//A string S consisting of N characters is called
//properly nested if:
//
//S is empty;
//S has the form "(U)" where U is a
//properly nested string;
//S has the form "VW" where V and W
//are properly nested strings.
//
//For example, string "(()(())())"
//is properly nested but string "())" isn't.
//
//Write a function:
//
def solution(S: String):Int = {
  if(S.isEmpty) 1
  else{
    var opened = 0
    S.foreach{
      case '(' => opened += 1
      case ')' =>
        if(opened == 0) return 0
        opened -= 1
    }
    if(opened == 0) 1 else 0
  }
}
//
//that, given a string S consisting of N characters,
// returns 1 if string S is properly nested and 0 otherwise.
//
//For example, given S = "(()(())())", the function should return 1
//and given S = "())", the function should return 0, as explained above.
solution("(()(())())")
solution("())")
solution(")(")
//  Complexity:
//
//  expected worst-case time complexity is O(N);