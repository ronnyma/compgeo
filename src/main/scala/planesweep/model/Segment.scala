package ai.transfinite
package planesweep.model

case class Segment(p1: Point, p2: Point) {

  def lineIntersects(ys: Int): Boolean = {
    val t = (ys - p1.y) / (p2.y - p1.y)
    val result = p1.x + t * (p2.x - p1.x)
    result.isBetween(0, 1)
  }
}

implicit class RichDouble(val value: Double) extends AnyVal {
  def isBetween(min: Double, max: Double): Boolean =
    min < value && value < max
}