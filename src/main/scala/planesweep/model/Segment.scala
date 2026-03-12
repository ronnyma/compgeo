package ai.transfinite
package planesweep.model

case class Segment(p1: Point, p2: Point) {
  override def toString: String = s"$p1 --> $p2"

  def intersectsSweepLine(ys: Double): Boolean =
    isParameterInRange(parameterAt(ys))

  def xAtSweepLine(ys: Double): Double =
    p1.x + parameterAt(ys) * (p2.x - p1.x)

  private def isParameterInRange(t: Double): Boolean =
    0 <= t && t <= 1

  private def parameterAt(ys: Double): Double =
    (ys - p1.y) / (p2.y - p1.y)
}
