package org.pico.kind

import scala.language.higherKinds

trait λaxc[T[_, _, _], X] {
  type ac[A, C] = T[A, X, C]
}
