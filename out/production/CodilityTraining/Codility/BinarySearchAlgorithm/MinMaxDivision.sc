//TODO: one more time
//You are given integers K, M and a non-empty
//zero-indexed array A consisting of N integers.
//Every element of the array is not greater than M.
//
//You should divide this array into K blocks of
//consecutive elements. The size of the block is
//any integer between 0 and N. Every element of
//the array should belong to some block.
//
//The sum of the block from X to Y equals
//A[X] + A[X + 1] + ... + A[Y].
//The sum of empty block equals 0.
//
//The large sum is the maximal sum of any block.
//
//For example, you are given integers K = 3, M = 5 and array A such that:
//
//2 1 5 1 2 2 2
//The array can be divided, for example, into the following blocks:
//
//[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
//[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
//[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
//[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
//The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
def solution(K: Int, M: Int, A: Array[Int]): Int = {
  def countPartsWithSumLessThan(target: Int, A: Array[Int]): Int = {
    var sum = 0
    var partNum = 1
    def addNewPart(el: Int) = {partNum += 1; sum = el}
    A.foreach { el =>
      if (sum + el > target) addNewPart(el)
      else sum += el
    }
    partNum
  }

  var minimalLargeSum = A.max
  var sum = A.sum
  while (minimalLargeSum <= sum) {
    val middleSum = (minimalLargeSum + sum) / 2
    if (countPartsWithSumLessThan(middleSum, A) > K) minimalLargeSum = middleSum + 1
    else sum = middleSum - 1
  }
  minimalLargeSum
}

solution(3, 5, Array(2, 1, 5, 1, 2, 2, 2))
//  For example, given K = 3, M = 5 and array A such that:
//the function should return 6, as explained above.
//  expected worst-case time complexity is O(N*log(N+M));