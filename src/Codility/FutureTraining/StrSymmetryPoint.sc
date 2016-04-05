import annotation.tailrec
def solution(S: String): Int = {
  @tailrec
  def getIndex(S: String, init: Int):Int = {
    if(S.isEmpty) -1
    else if(S.length == 1) init
    else if(S.head == S.last) getIndex(S.init.tail, init + 1)
    else -1
  }
  getIndex(S, 0)
}
solution("racecar")
solution("raceecar")
solution("x")
//
//returns index (counting from 0) of a character such
//that the part of the string to the left of that
//character is a reversal of the part of the string
//to its right. The function should return −1 if no
//such index exists.
//
//Note: reversing an empty string (i.e. a string whose
//length is zero) gives an empty string.
//
//"racecar"
//return 3, because the substring to the left of
//the character "e" at index 3 is "rac", and the one to the right is "car".
//"x"
//
//the function should return 0, because both substrings are empty.
//  expected worst-case time complexity is O(length(S));