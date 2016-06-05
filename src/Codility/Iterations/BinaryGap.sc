//number 20 has binary representation 10100 and contains
//one binary gap of length 1. The number 15 has binary
//representation 1111 and has no binary gaps.
def solution(N: Int): Int = {
  val binary = N.toBinaryString
  var counting = false
  var counter = 0
  var maxCounter = 0
  for (n <- binary.reverse) {
    if (counting) {
      if (n == '0') counter += 1
      if (n == '1') {
        if (maxCounter < counter) maxCounter = counter
        counter = 0
      }
    }
    if (n == '1') counting = true
  }
  maxCounter
}

//that, given a positive integer N, returns the length of its longest binary gap.
//The function should return 0 if N doesn't contain a binary gap.
//
//For example, given N = 1041 the function should return 5,
//because N has binary representation 10000010001 and so
//its longest binary gap is of length 5.
//expected worst-case time complexity is O(log(N));
//expected worst-case space complexity is O(1).

