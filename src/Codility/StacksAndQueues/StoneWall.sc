//TODO: one more time
// The wall should be built of cuboid stone blocks
//(that is, all sides of such blocks are rectangular).
//Your task is to compute the minimum number of blocks needed to build the wall.
import collection._
def solution(H: Array[Int]): Int = {
  val stack = new mutable.Stack[Int]
  var needed = 0
  for(n <- H) {
    while(stack.nonEmpty && stack.top > n) {
      stack.pop()
    }
    if(stack.isEmpty || stack.top != n) {
      stack.push(n)
      needed += 1
    }
  }
  needed
}
//solution(Array(8,8,5,7,9,8,7,4,8))
solution(Array(8,8,5,7))
//solution(Array(8,8,5,7,9))
//
//that, given a zero-indexed array H of N positive integers specifying
//the height of the wall, returns the minimum number of blocks needed to build it.
//
//For example, given array H containing N = 9 integers:
//H[0] = 8    H[1] = 8    H[2] = 5
//H[3] = 7    H[4] = 9    H[5] = 8
//H[6] = 7    H[7] = 4    H[8] = 8
//
//the function should return 7. The figure shows one possible arrangement of seven blocks.
//
//Assume that:
//
//  N is an integer within the range [1..100,000];
//each element of array H is an integer within the range [1..1,000,000,000].
//
//Complexity:
//
//  expected worst-case time complexity is O(N);