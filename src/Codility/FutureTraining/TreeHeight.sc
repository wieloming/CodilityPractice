class Tree(var x: Int, var l: Tree, var r: Tree)

def solution(T: Tree): Int = {
  case class Tree2(var x: Int, var l: Tree, var r: Tree)
  implicit def toTree2(t: Tree): Tree2 = Tree2(t.x,t.l,t.r)

  def rec(tree: Tree2):Int = tree match {
    case Tree2(_, null, null) => 0
    case Tree2(_, l, null) => rec(l) + 1
    case Tree2(_, null, r) => rec(r) + 1
    case Tree2(_, l, r) => Math.max(rec(l) + 1, rec(r) + 1)
  }
  rec(T)
}

val tree = new Tree(
  5,
  new Tree(3, new Tree(20, null, null), new Tree(21, null, null)),
  new Tree(10, new Tree(1, null, null), null)
)
solution(tree)

//  expected worst-case time complexity is O(N);