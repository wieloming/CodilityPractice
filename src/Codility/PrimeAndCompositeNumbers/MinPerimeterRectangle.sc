//An integer N is given, representing the
//area of some rectangle.
//
//The area of a rectangle whose sides are of
//length A and B is A * B, and the perimeter
//is 2 * (A + B).
//
//The goal is to find the minimal perimeter of
//any rectangle whose area equals N. The sides
//of this rectangle should be only integers.
//
//For example, given integer N = 30, rectangles of area 30 are:
//
//(1, 30), with a perimeter of 62,
//(2, 15), with a perimeter of 34,
//(3, 10), with a perimeter of 26,
//(5, 6), with a perimeter of 22.
import annotation.tailrec

def solution(N: Int) = {
  @tailrec
  def h(sqr: Int): Int = {
    if (N % sqr == 0) 2 * (sqr + (N / sqr))
    else if (sqr > 0) h(sqr - 1)
    else -1
  }
  h(Math.round(Math.sqrt(N)).toInt)
}
solution(30)
solution(10)
//that, given an integer N, returns the minimal
//perimeter of any rectangle whose area is
//exactly equal to N.
//
//For example, given an integer N = 30, the function should return 22, as explained above.
//expected worst-case time complexity is O(sqrt(N));