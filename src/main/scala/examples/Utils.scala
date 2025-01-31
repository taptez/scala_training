package com.zounon
package examples

object Utils:
  def While(p: => Boolean)(s: => Unit): Any =
    if (p) then
      s
      While(p)(s)
