package com.nar.inheritence

abstract  class Polygon {
  def area : Double

}

object Polygon {
  def main (args : Array[String]): Unit = {
    //var poly = new Polygon; cant do as Polygon is now abstract
    printArea(poly)
    var rect = new Rectangle(10, 20)
    printArea(rect)

  }

  def printArea (p: Polygon): Unit = {
    println (p.area)
  }
}
