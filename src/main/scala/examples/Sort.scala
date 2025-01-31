package com.zounon
package examples

class Sort:

  def quickSort(xs: Array[Int]): Array[Int] =
    if (xs.length <= 1) xs
    else
      val pivot = xs(xs.length / 2)
      Array.concat(
        quickSort(xs filter (_ < pivot)),
        xs filter (_ == pivot),
        quickSort(xs filter (_ > pivot))
      )

