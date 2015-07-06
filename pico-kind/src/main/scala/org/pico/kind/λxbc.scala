package org.pico.kind

import scala.language.higherKinds

trait λxbc[T[_, _, _], X] {
  type bc[B, C] = T[X, B, C]
}
