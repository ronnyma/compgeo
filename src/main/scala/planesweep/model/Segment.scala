package ai.transfinite
package planesweep.model

case class Segment(p1: Point, p2: Point) {

  def lineIntersects(ys: Double): Boolean = {
    val t = (ys - p1.y) / (p2.y - p1.y)
    isInsideSegmentsYInterval(t)
  }

  private def isInsideSegmentsYInterval(sweepLine: Double): Boolean =
    0 <= sweepLine && sweepLine <= 1

}