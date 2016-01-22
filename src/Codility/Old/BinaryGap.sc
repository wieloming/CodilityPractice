//TODO(POPRAWIONE):is surrounded by ones at both ends in the
//A binary gap within a positive integer N is
//any maximal sequence of consecutive zeros that
//binary representation of N.
//
//For example, number 9 has binary 1001 and gap of length 2.
// The number 529 has binary 1000010001 and gaps: 4 and 3.
// The number 20 has binary 10100 and contains one gap 1.
// The number 15 has binary 1111 and has no gaps.

def solution(N: Int) = {
  def dropRightWhile(s: String, p: Char => Boolean) =
    s.take(s.lastIndexWhere(!p(_))+1)
  val binary = dropRightWhile(N.toBinaryString, _ != '1')
  val splitted = binary.split('1').map(_.length)
  if (splitted.length > 0) splitted.max else 0
}
solution(9)
solution(529)
solution(20)
solution(15)
solution(1041)
solution(51712)//110010100000000
//that, given a positive integer N,
//returns the length of its longest binary gap.
