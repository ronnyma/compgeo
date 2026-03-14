package ai.transfinite
package planesweep.model

object SegmentNameGenerator:
  private var start: Char = 'A'

  def apply(): String =
    val name = start.toString
    start  = (start + 1).toChar
    name
