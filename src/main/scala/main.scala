package ai.transfinite

import planesweep.fileutils.PointFromFile
import planesweep.model.XOrderGivenSweep

import scala.collection.mutable


@main
def main(): Unit = {
  val segments = PointFromFile.readSegments("lines.txt")
  val ys = 3.65

  given xOrdering: Ordering[XOrderGivenSweep] with // reverseOrdering
    override def compare(x: XOrderGivenSweep, y: XOrderGivenSweep): Int = x.xIntercept.compareTo(y.xIntercept)

  extension (segmentOrder: XOrderGivenSweep)
    def pretty: String = segmentOrder.segment.name + ": x = " + segmentOrder.xIntercept + ", Coord = (" + segmentOrder.segment.p1 + "," + segmentOrder.segment.p2 + ")"

  val q = mutable.PriorityQueue[XOrderGivenSweep]()
  segments.map(s => XOrderGivenSweep(s, ys)).foreach(q.enqueue(_))

  println(ys + " " + q.dequeueAll.map(s=>s.pretty))

}

