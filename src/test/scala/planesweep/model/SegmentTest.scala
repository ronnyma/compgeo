package ai.transfinite
package planesweep.model

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SegmentTest extends AnyFlatSpec with Matchers {

  "lineIntersects" should "return true when sweep line is within the segment's y-interval" in {
    val segment = Segment(Point(2.0, 1.0), Point(4.0, 9.0))
    segment.lineIntersects(7) shouldBe true
  }

  it should "return true when sweep line is at p1.y (t=0, inclusive)" in {
    val segment = Segment(Point(0.2, 3.0), Point(0.8, 7.0))
    segment.lineIntersects(3) shouldBe true
  }

  it should "return true when sweep line is at p2.y (t=1, inclusive)" in {
    val segment = Segment(Point(0.2, 3.0), Point(0.8, 7.0))
    segment.lineIntersects(7) shouldBe true
  }

  it should "return false when sweep line is below the segment (t < 0)" in {
    val segment = Segment(Point(2.0, 2.0), Point(3.0, 5.0))
    segment.lineIntersects(1) shouldBe false
  }

  it should "return false when sweep line is above the segment (t > 1)" in {
    val segment = Segment(Point(1.0, 0.0), Point(2.0, 1.0))
    segment.lineIntersects(3) shouldBe false
  }

  it should "return true for a midpoint sweep line" in {
    val segment = Segment(Point(0.2, 0.0), Point(0.8, 2.0))
    segment.lineIntersects(1) shouldBe true
  }
}
