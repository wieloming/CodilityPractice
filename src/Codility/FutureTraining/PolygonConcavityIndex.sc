//TODO: 63%
//A polygon is convex if and only if, for any edge of the polygon,
//all vertices belong to the semiplane whose boundary contains the edge.
//
//For example, the polygon consisting of vertices whose Cartesian
// coordinates are consecutively:
//(-1, 3)   (3, 1)   (0, -1)   (-2, 1)
//is convex.
//
//The convex hull of a finite set of points in a 2D plane is the smallest convex polygon
//that contains all points in this set. For example, the convex hull of a set
//consisting of six points whose Cartesian coordinates are:
//
//(-1, 3)   (3, 1)   (1, 1)
//(0, -1)   (-2, 1)  (-1, 2)
//is a polygon that has four vertices. When traversed clockwise, its vertices are:
//(-1, 3)   (3, 1)   (0, -1)   (-2, 1)
case class Point2D(var x: Int, var y: Int)

def solution(A: Array[Point2D]) = {
  def grahamScan(points: List[Point2D]): List[Point2D] = {
    //is way a->b->c turning counterwise
    def isCounterWise(a: Point2D, b: Point2D, c: Point2D): Boolean = {
      (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x) >= 0
    }
    def scan(points: List[Point2D]): List[Point2D] = points match {
      case Nil => List()
      case x :: y :: Nil => points
      case x :: y :: z :: xs if isCounterWise(x, y, z) => x :: scan(y :: z :: xs)
      case x :: y :: z :: xs => scan(x :: z :: xs)
    }
    val origin: Point2D = points.minBy(_.y)
    //sort the rest of the points according to their polar angle
    //(the angle between the line defined by the origin and the
    //current point, and the x-axis)
    val pointsFromOrigin = origin :: points.filterNot(_ == origin)
    def polarAngle = (point: Point2D) => Math.atan2(point.y - origin.y, point.x - origin.x)
    val pointsSorted = pointsFromOrigin.sortBy(polarAngle)
    //do the graham scan
    scan(pointsSorted)
  }
  val difference = A.filterNot(grahamScan(A.toList).toSet)
  if (difference isEmpty) -1
  else A.indexOf(difference.head)
}

val convex = Array(Point2D(-1, 3), Point2D(3, 1), Point2D(0, -1), Point2D(-2, 1))
val notConvex = Array(Point2D(-1, 3), Point2D(3, 1), Point2D(1, 1), Point2D(0, -1), Point2D(-2, 1), Point2D(-1, 2))
solution(convex)
solution(notConvex)
//
//that, given a non-empty zero-indexed array A consisting of N elements
//describing a polygon, returns −1 if the polygon is convex.
//Otherwise, the function should return the index of any
//point that doesn't belong to the convex hull.
//
//  expected worst-case time complexity is O(N);