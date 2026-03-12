package ai.transfinite
package planesweep.model

case class Point(x: Double, y: Double):
  override def toString: String = s"($x,$y)"
