//TODO: one more time
//A semiprime is a natural number that is the product
//of two (not necessarily distinct) prime numbers. The
//first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
//
//You are given two non-empty zero-indexed arrays P and Q,
//each consisting of M integers. These arrays represent
//queries about the number of semiprimes within specified ranges.
//
//Query K requires you to find the number of semiprimes within
//the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
//
//For example, consider an integer N = 26 and arrays P, Q such that:
//P[0] = 1    Q[0] = 26
//P[1] = 4    Q[1] = 10
//P[2] = 16   Q[2] = 20
//
//The number of semiprimes within each of these ranges is as follows:
//
//(1, 26) is 10,
//(4, 10) is 4,
//(16, 20) is 0.
//
def solution(N: Int, P: Array[Int], Q: Array[Int]) = {
  def isSP(n: Int): Boolean = {
    var nf: Int = 0
    var l = n
    for (i <- 2 to l / 2) {
      while (l % i == 0) {
        if (nf == 2) return false
        nf += 1
        l /= i
      }
    }
    nf == 2
  }
  val semiprimes = (1 to N).scanLeft(0)((acc, el) => if (isSP(el)) acc + 1 else acc).view
  (P zip Q).map { case (a, b) => semiprimes(b) - semiprimes(a-1) }
}
solution(26, Array(1, 4, 16), Array(26, 10, 20))
//solution(26, Array(4), Array(10))
//
//that, given an integer N and two non-empty zero-indexed arrays
//P and Q consisting of M integers, returns an array consisting
//of M elements specifying the consecutive answers to all the queries.
//
//For example, given an integer N = 26 and arrays P, Q such that:
//P[0] = 1    Q[0] = 26
//P[1] = 4    Q[1] = 10
//P[2] = 16   Q[2] = 20
//
//the function should return the values [10, 4, 0], as explained above.
//  expected worst-case time complexity is O(N*log(log(N))+M)