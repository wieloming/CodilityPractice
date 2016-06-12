//TODO: one mote time
//TODO: 75%
//There are N ropes numbered from 0 to N − 1,
//whose lengths are given in a zero-indexed array A,
//lying on the floor in a line. For each I
//(0 ≤ I < N), the length of rope I on the line is A[I].
//
//We say that two ropes I and I + 1 are adjacent.
//Two adjacent ropes can be tied together with a knot,
//and the length of the tied rope is the sum of lengths
//of both ropes. The resulting new rope can then be tied again.
//
//For a given integer K, the goal is to tie the ropes in
//such a way that the number of ropes whose length is
//greater than or equal to K is maximal.
//
//For example, consider K = 4 and array A such that:
//
//A[0] = 1
//A[1] = 2
//A[2] = 3
//A[3] = 4
//A[4] = 1
//A[5] = 1
//A[6] = 3
//rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
//rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
//After that, there will be three ropes whose lengths are greater than or equal
//to K = 4. It is not possible to produce four such ropes.
//
def solution(K: Int, A: Array[Int]): Int = {
  var lines = 0
  var currrent = 0
  for (line <- A) {
    val newLine = currrent + line
    if (newLine >= K) {
      lines += 1
      currrent = 0
    } else {
      currrent = newLine
    }
  }
  lines
}
solution(4, Array(1, 2, 3, 4, 1, 1, 3))
solution(1, Array(1))
solution(2, Array(1))
//
//that, given an integer K and a non-empty zero-indexed
//array A of N integers, returns the maximum number of
//ropes of length greater than or equal to K that can be created.
//
//the function should return 3, as explained above.
//  expected worst-case time complexity is O(N);