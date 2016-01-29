//TODO: inspect
//A non-empty zero-indexed array A
//consisting of N integers is given.
//
//The leader of this array is the value
//that occurs in more than half of the
//elements of A.
//
//An equi leader is an index S such that
//0 ≤ S < N − 1 and two sequences
//A[0], A[1], ..., A[S] and A[S + 1],
//A[S + 2], ..., A[N − 1] have leaders
//of the same value.
//
//For example, given array A such that:
// 4 3 4 4 4 2

//0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
//2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
//the function should return 2, as explained above.

def solution(A: Array[Int]): Int = {
  def findLeader(A: Array[Int]): Int = {
    A.foldLeft(Map.empty[Int, Int].withDefaultValue(0)) {
      case (m, v) => m.updated(v, m(v) + 1)
    }.maxBy(_._2)._1
  }
  def getLeaderOccurencesTillIndex(A: Array[Int], candidate: Int): Array[Int] = {
    val occurrences = new Array[Int](A.length)
    for (ind <- A.indices) {
      if (ind > 0) occurrences(ind) = occurrences(ind - 1)
      if (A(ind) == candidate) occurrences(ind) += 1
    }
    occurrences
  }
  if (A == null || A.length == 0) 0
  else {
    val leader = findLeader(A)
    val numOfLeaders = A.count(_ == leader)
    if (numOfLeaders <= A.length / 2) 0
    else {
      val occurrences = getLeaderOccurencesTillIndex(A, leader)
      var leaders = 0
      for (ind <- 0 until A.length - 1) {
        def isLeaderInFirstPart = occurrences(ind) > (ind + 1) / 2
        def isLadderInSecondPart = (numOfLeaders - occurrences(ind)) > (A.length - ind - 1) / 2
        if (isLeaderInFirstPart && isLadderInSecondPart) {
          leaders += 1
        }
      }
      leaders
    }
  }
}

solution(Array(4, 3, 4, 4, 4, 2))
//
//returns the number of equi leaders.
//
//  expected worst-case time complexity is O(N);