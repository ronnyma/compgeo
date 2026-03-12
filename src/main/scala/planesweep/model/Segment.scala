package ai.transfinite
package planesweep.model

case class Segment(p1: Point, p2: Point) {

  def lineIntersects(ys: Int): Boolean = {
    val t = (ys - p1.y) / (p2.y - p1.y)
    val result = p1.x + t * (p2.x - p1.x)

    isBetween(result)
  }

  private def isBetween(sweepLine: Double): Boolean =
    0 < sweepLine && sweepLine < 1

}