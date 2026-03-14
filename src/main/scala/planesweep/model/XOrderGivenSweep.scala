package ai.transfinite
package planesweep.model

case class XOrderGivenSweep(segment: Segment, sweepYCoordinate: Double) {
  def xIntercept: Double =
    segment.xAtSweepLine(sweepYCoordinate)
}
