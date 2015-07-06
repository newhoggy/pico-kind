package org.pico.kind

import scala.language.higherKinds

trait λaxy[T[_, _, _], X, Y] {
  type a[A] = T[A, X, Y]
}
