import java.util.*;

fun <T> checkSubtype(t: T) = t

class NotRange1() {

}

abstract class NotRange2() {
  abstract operator fun iterator() : Unit
}

abstract class ImproperIterator1 {
  abstract operator fun hasNext() : Boolean
}

abstract class NotRange3() {
  abstract operator fun iterator() : ImproperIterator1
}

abstract class ImproperIterator2 {
  abstract operator fun next() : Boolean
}

abstract class NotRange4() {
  abstract operator fun iterator() : ImproperIterator2
}

abstract class ImproperIterator3 {
  abstract <error>operator</error> fun hasNext() : Int
  abstract operator fun next() : Int
}

abstract class NotRange5() {
  abstract operator fun iterator() : ImproperIterator3
}

abstract class AmbiguousHasNextIterator {
  abstract operator fun hasNext() : Boolean
  val hasNext : Boolean get() = false
  abstract operator fun next() : Int
}

abstract class NotRange6() {
  abstract operator fun iterator() : AmbiguousHasNextIterator
}

abstract class ImproperIterator4 {
  val hasNext : Int get() = 1
  abstract operator fun next() : Int
}

abstract class NotRange7() {
  abstract operator fun iterator() : ImproperIterator3
}

abstract class GoodIterator {
  abstract operator fun hasNext() : Boolean
  abstract operator fun next() : Int
}

abstract class Range0() {
  abstract operator fun iterator() : GoodIterator
}

abstract class Range1() {
  abstract operator fun iterator() : Iterator<Int>
}

fun test(notRange1: NotRange1, notRange2: NotRange2, notRange3: NotRange3, notRange4: NotRange4, notRange5: NotRange5, notRange6: NotRange6, notRange7: NotRange7, range0: Range0, range1: Range1) {
  for (i in <error>notRange1</error>);
  for (i in <error>notRange2</error>);
  for (i in <error>notRange3</error>);
  for (i in <error>notRange4</error>);
  for (i in <error>notRange5</error>);
  for (i in notRange6);
  for (i in <error>notRange7</error>);
  for (i in range0);
  for (i in range1);

  for (i in (checkSubtype<List<Int>>(ArrayList<Int>())));
}

