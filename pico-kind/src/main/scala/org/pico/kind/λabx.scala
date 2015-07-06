package org.pico.kind

import scala.language.higherKinds

trait λabx[T[_, _, _], X] {
  type ab[A, B] = T[A, B, X]
}
