package org.pico.kind

import scala.language.higherKinds

trait λxby[T[_, _, _], X, Y] {
  type b[B] = T[X, B, Y]
}
