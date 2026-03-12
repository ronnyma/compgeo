package ai.transfinite
package planesweep.model

case class Segment(p1: Point, p2: Point) {

  def lineIntersects(ys: Double): Boolean =
    isInsideSegmentsYInterval(computeLineFraction(ys: Double))

  def xCoordinateGivenSweepline(ys: Double): Double =
    p1.x + computeLineFraction(ys: Double) * (p2.x - p1.x)

  private def isInsideSegmentsYInterval(sweepLine: Double): Boolean =
    0 <= sweepLine && sweepLine <= 1

  private def computeLineFraction(ys: Double): Double =
    (ys - p1.y) / (p2.y - p1.y)
}