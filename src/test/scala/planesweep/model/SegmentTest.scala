package ai.transfinite
package planesweep.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SegmentTest extends AnyFlatSpec with Matchers {

  "lineIntersects" should "return true when the sweep line crosses the segment within bounds" in {
    val segment = Segment(Point(0.2, 0.0), Point(0.8, 1.0))
    segment.lineIntersects(0) shouldBe true
  }

  it should "return false when the intersection is outside the (0, 1) range" in {
    val segment = Segment(Point(2.0, 0.0), Point(3.0, 1.0))
    segment.lineIntersects(0) shouldBe false
  }

  it should "return false when the intersection is exactly at 0 (exclusive bound)" in {
    val segment = Segment(Point(0.0, 0.0), Point(1.0, 1.0))
    segment.lineIntersects(0) shouldBe false
  }

  it should "return false when the intersection is exactly at 1 (exclusive bound)" in {
    val segment = Segment(Point(1.0, 0.0), Point(2.0, 1.0))
    segment.lineIntersects(0) shouldBe false
  }

  it should "return true for a midpoint sweep line" in {
    val segment = Segment(Point(0.2, 0.0), Point(0.8, 2.0))
    segment.lineIntersects(1) shouldBe true
  }
}
