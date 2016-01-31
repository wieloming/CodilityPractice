//For example, 6 is a factor of 24,
//because M = 4 satisfies the above
//condition (24 = 6 * 4).
//
def solution(N: Int): Int = {
  if (N == 1) 1
  else {
    var factorCount = 2
    val root = Math.sqrt(N).toInt
    for (i <- 2 to root) {
      if (N % i == 0) factorCount += 2
    }
    factorCount
  }
}
solution(24)
solution(1)
//
//that, given a positive integer N, returns the number of its factors.
//
//For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.
//
//Assume that:
//
//  N is an integer within the range [1..2,147,483,647].
//
//Complexity:
//
//  expected worst-case time complexity is O(sqrt(N));