//0 represents a car traveling east,
//1 represents a car traveling west.
//
//The goal is to count passing cars.
//We say that a pair of cars (P, Q),
//where 0 ≤ P < Q < N, is passing when P
//is traveling to the east and Q is traveling to the west.
//
//For example, consider array A such that:
//A[0] = 0
//A[1] = 1    01
//A[2] = 0    12
//A[3] = 1    03 23
//A[4] = 1    04 24

//We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
def solution(A: Array[Int]): Int = {
  var crossed = 0
  var easters = 0
  for {n <- A} {
    if (n == 1) crossed += easters
    if (n == 0) easters += 1
    if(crossed > 1000000000) return -1
  }
  crossed
}
solution(Array(0, 1, 0, 1, 1))
//The function should return −1 if the number of
// pairs of passing cars exceeds 1,000,000,000.
//  expected worst-case time complexity is O(N);