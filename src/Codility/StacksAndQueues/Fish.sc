//TODO: one more time
//Fish number P is represented by A[P] and B[P].
//Array A contains the sizes of the fish. All
//its elements are unique. Array B contains the
//directions of the fish. It contains only 0s and/or 1s, where:
//
//0 represents a fish flowing upstream,
//1 represents a fish flowing downstream.
//
//If two fish move in opposite directions and there are no other
//(living) fish between them, they will eventually meet each other.
//Then only one fish can stay alive − the larger fish eats the smaller
//one. More precisely, we say that two fish P and Q meet each other when
//P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them.
//After they meet:
//
//If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
//If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.

def solution(A: Array[Int], B: Array[Int]): Int = {
  var fighters = List[Int]()
  var eaten = 0
  def fight(i: Int): Unit = {
    for (f <- fighters) {
      eaten += 1
      if (f > A(i)) return
      else fighters = fighters.tail
    }
  }
  for (i <- A.indices) {
    if (B(i) == 1) fighters = A(i) :: fighters
    else if (fighters.nonEmpty) fight(i)
  }
  A.length - eaten
}
solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 1))
//A[0] = 4    B[0] = 0
//A[1] = 3    B[1] = 1
//A[2] = 2    B[2] = 0
//A[3] = 1    B[3] = 0
//A[4] = 5    B[4] = 0
//
//Initially all the fish are alive and all except fish number 1 are moving
//upstream. Fish number 1 meets fish number 2 and eats it, then it meets
//fish number 3 and eats it too. Finally, it meets fish number 4 and is
//eaten by it. The remaining two fish, number 0 and 4, never meet and
//therefore stay alive.

//
//For example, given the arrays shown above, the function should
//return 2, as explained above.
//
//  Assume that:
//
//  N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [0..1,000,000,000];
//each element of array B is an integer that can have one of the following values: 0, 1;
//the elements of A are all distinct.
//
//  Complexity:
//
//  expected worst-case time complexity is O(N);