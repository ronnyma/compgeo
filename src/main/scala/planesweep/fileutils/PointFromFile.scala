package ai.transfinite
package planesweep.fileutils

import planesweep.model.{Point, Segment}
import scala.io.Source

object PointFromFile {

  def readSegments(filename: String): List[Segment] =
    val source = Source.fromResource(filename)
    try
      source.getLines().map { line =>
        val Array(x1, y1, x2, y2) = line.trim.split("\\s+").map(_.toDouble)
        Segment(Point(x1, y1), Point(x2, y2))
      }.toList
    finally
      source.close()
}
