package org.pico.kind

import scala.language.higherKinds

trait λabc[T[_, _, _]] {
  type abc[A, B, C] = T[A, B, C]

  type acb[A, B, C] = T[A, C, B]

  type bac[A, B, C] = T[B, A, C]

  type bca[A, B, C] = T[B, C, A]

  type cab[A, B, C] = T[C, A, B]

  type cba[A, B, C] = T[C, B, A]
}
