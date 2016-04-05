import scala.collection.mutable

val T = Array[Int](9, 1, 4, 9, 0, 4, 8, 9, 0, 1)


case class Node(var value: Int, var neighbours: List[Node]) {
}
def toNodes(array: List[(Int, Int)]): List[Node] ={
  array.flatMap { case (a, b) =>
    List(
      Node(a, toNodes(array.filter(o => o._2 == a))),
      Node(b, toNodes(array.filter(o => o._1 == b)))
    )
  }
}

def BFS(list: List[Node], i: Node): List[Node] = {
  val queue = mutable.Queue[Node]()        //create queue
  list.foreach(_.value = Integer.MAX_VALUE) // set all nodes to MAX
  i.value = 0                               //set i NODE to 0
  queue.enqueue(i)                          //add i NODE to QUEUE
  while (queue.nonEmpty) {
    val j = queue.dequeue()
    j.neighbours.foreach { n =>             // foreach neighbors of node on queue
      if (n.value == Integer.MAX_VALUE) {    // if neighbor value = MAX
        n.value = j.value + 1                 // set neighbor val to NODE + 1
        queue.enqueue(n)                      // and add neighbor to queue
      }
    }
  }
  list
}

def computeDistanceDistribution(list: List[Node]): collection.mutable.Map[Int, Int] = {
  val distancesMap = collection.mutable.Map() ++ list.indices.map(_ -> 0).toMap
  //map =  Map(2 -> 0, 5 -> 0, 4 -> 0... )
  list.foreach{ node =>
    BFS(list, node).foreach{graph =>
      distancesMap(graph.value) = distancesMap(graph.value) + 1
    }
  }
  distancesMap
}

computeDistanceDistribution(toNodes(T.zipWithIndex.toList))
//(0, 9)    (1, 1)    (2, 4)
//(3, 9)     (4, 0)    (5, 4)
//(6, 8)    (7, 9)    (8, 0)
//(9, 1)

//def countDistance(one: Int, two: Int, array: Array[Int]): Int = {
//  array.zipWithIndex
//}
//def countDistance(one: Int, two: Int, array: Array[Int]): Int = {
//  if(one == two) 0
//  else if(array(one) == two || array(two) == one) 1
//  else if(array(one) == one) 0 + countDistance(one, array(two), array)
//  else if(array(two) == two) 0 + countDistance(array(one), two, array)
//  else Math.max(1 + countDistance(array(one), two, array), 1 + countDistance(one, array(two), array))
//}
//countDistance(9, 1, T)
//countDistance(1, 1, T)
//countDistance(9, 7, T)
//def solution(T: Array[Int]) = {
//  val d = T.map(countDistance(_, 1, T))
//  (0 to T.length -1).map(u => d.count(i => i == u))
//}
//solution(T)