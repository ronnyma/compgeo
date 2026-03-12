package ai.transfinite
package planesweep.model

case class XOrderGivenSweep(segment: Segment, sweepYCoordinate: Double) {

  def xIntercept: Double = // getOrder
    segment.xAtSweepLine(sweepYCoordinate)

}
