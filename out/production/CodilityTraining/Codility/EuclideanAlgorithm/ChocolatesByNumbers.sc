//Two positive integers N and M are given.
//Integer N represents the number of chocolates
//arranged in a circle, numbered from 0 to N − 1.
//
//You start to eat the chocolates. After eating a
//chocolate you leave only a wrapper.
//
//if you ate chocolate number X, then you will next
//eat the chocolate with number (X + M)
//modulo N (remainder of division).
//
//You stop eating when you encounter an empty wrapper.
//
//given integers N = 10 and M = 4. You will eat the
//following chocolates: 0, 4, 8, 2, 6.
//
//The goal is to count the number of chocolates that you will eat, following the above rules.
//
import annotation.tailrec
def solution(N: Int, M: Int):Int = {
  val newN = N.toLong
  val newM = M.toLong
  @tailrec
  def gcd(a: Long, b: Long):Long =
    if (a % b == 0) b
    else gcd(b, a % b)
  val leastCommonMultiple = (newN * newM) / gcd(newN, newM)
  (leastCommonMultiple / newM).toInt
}
val N = Math.pow(3, 9) * Math.pow(2, 14)
val M = Math.pow(2, 14) * Math.pow(2, 14)
solution(N.toInt, M.toInt)
//  expected worst-case time complexity is O(log(N+M));