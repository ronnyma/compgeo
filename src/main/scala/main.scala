package ai.transfinite

import planesweep.fileutils.PointFromFile


@main
def main(): Unit = {
  val segments = PointFromFile.readSegments("lines.txt")

  val ys = 3.65

  val strings = segments.map(s => s.toString + " " + s.lineIntersects(ys))

  println(strings)
}

