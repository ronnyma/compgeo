package ai.transfinite
package planesweep.model

object Counter:
  private var index: Int = 0

  def apply(): String =
    val name = s"S$index"
    index += 1
    name
