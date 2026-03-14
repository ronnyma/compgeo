package ai.transfinite

import planesweep.fileutils.PointFromFile
import planesweep.model.XOrderGivenSweep

import scala.collection.mutable
import scala.math.BigDecimal.double2bigDecimal


@main
def testmain(): Unit = {
  val segments = PointFromFile.readSegments("lines.txt")

  given xOrdering: Ordering[XOrderGivenSweep] with
    override def compare(x: XOrderGivenSweep, y: XOrderGivenSweep): Int = x.xIntercept.compareTo(y.xIntercept)

  extension (segmentOrder: XOrderGivenSweep)
    def pretty: String = segmentOrder.segment.name + ": x = " + segmentOrder.xIntercept + ", Coord = (" + segmentOrder.segment.p1 + "," + segmentOrder.segment.p2 + ")"

  extension (segmentOrder: XOrderGivenSweep)
    def crude: String = segmentOrder.segment.name


  extension (q: mutable.PriorityQueue[XOrderGivenSweep])
    def compact: String = q.dequeueAll.map(_.segment.name).mkString


  def sortSegments(ys: Double, q: mutable.PriorityQueue[XOrderGivenSweep]): Unit = {
    segments.map(s => XOrderGivenSweep(s, ys)).filter(s => s.shouldEnqueue).foreach(q.enqueue(_))
  }

  def find(ys: Double, seq: String): Unit = { //TODO: recursive function to support checks
    val q = mutable.PriorityQueue[XOrderGivenSweep]()
    sortSegments(ys, q)
    val stringrepr = q.compact
    //If Levenshtein has changed => lines cross
    //If length has increased and Levenshtein[-1] has changed => lines cross
    println(ys + " " + stringrepr)
    find(ys, stringrepr)
  }

  (0.0 to 9.5 by 0.1).reverse.foreach(c => find(c.toDouble,""))
}

