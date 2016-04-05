case class Tree(var x: Int, var l: Tree, var r: Tree)


def solution(T: Tree): Int = {
  def helper(T: Tree, max: Int): Int = {
    if (T == null) 0
    else{
      if (T.x >= max) 1 + helper(T.l, T.x) + helper(T.r, T.x)
      else helper(T.l, max) + helper(T.r, max)
    }
  }
  helper(T, Int.MinValue)
}



val test = Tree(5, Tree(3, Tree(20, null, null), Tree(21, null, null)), Tree(10, Tree(1, null, null), null))
solution(test)