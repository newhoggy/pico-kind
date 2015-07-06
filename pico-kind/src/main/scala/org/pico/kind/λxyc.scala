package org.pico.kind

import scala.language.higherKinds

trait λxyc[T[_, _, _], X, Y] {
  type c[C] = T[X, Y, C]
}
