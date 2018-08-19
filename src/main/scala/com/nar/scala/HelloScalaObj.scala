package com.nar.scala

import java.util.Date;
import Array._;
//---------Class in Scals
class User (private var name : String, var age : Int) { // Var is mutable , val will be immutable

  //With var getter and setter both available
  //With val getter available setter not
  // With default no getter no setter
  def printName: Unit = {
    println (name)
  }

  // ------Auxilary constructor
  def this () {
    //Required to call above constructor
    this("nare" , 28)
  }

  def this (name : String) {
    this ("nare", 28)
  }
}

object HelloScalaObj {
  def main (args : Array[String]): Unit = {
    println("----------------Class-----------")
    var user : User = new User("nare",28)
    var user2 : User = new User()
    var user3 : User = new User ("nare")
    user.printName
    println(user.age)

    println("----------------String interpolation (3 types:)-----------")
    val age : Int = 10;
    val name : String = "nare";
    println("name is: "+name + ", age is: "+age);
    println(s"name is: $name , age is: $age"); //Not type safe
    println(f"name is: $name%s , age id: $age%d"); //Type safe

    println("Hello \n World");
    println(raw"Hello \n World");

    //If Else statement new way
    println("----------------If Else statement new way-----------")
    val a = 10;
    val b = 20;
    var result:String = "";
    result = if(a == 10) "a is 10" else "a is not 10";
    println(result);

    println("----------------While / do while is same as java-----------")

    println("----------------For Loop ----------------")

    for (i <- 1 to 5 ) {
      println(i);
    }

    for (i <- 1.to(5) ) {
      println("i using to "+i);
    }

    for (i <- 1.until(6) ) {
      println("i using untill "+i);
    }

    for (i <- 1.to(5) ; j <- 1.to(3) ) {
      println("i using multiple range "+i +", "+j);
    }

    var list = List(1,2,3,4,5,6,7);

    for (i <- list){
      println ("i using list "+i);
    }

    for (i <- list ; if(i <4)){
      println ("i using list filter "+i);
    }


    println("---------------Match Expression--------------")
    val age2= 20;

    //--normal
    age2 match {
      case 10 => println ("age is 10");
      case 20 => println ("age is 20");
      case 30 => println ("age is 30");

      case _ => println ("no match found");
    }

    //--value return
    var resultVal = age match {
      case 10 => 10;
      case 20 => 20;
      case _ => "default";
    }
    println ("result is "+resultVal);

    //--- multiple cases
    val numVal = 10;
    numVal match {
      case 2|4|6|8|10 => println ("even no");
      case 1|3|5|7|9 => println ("odd no");
    }

    println("------------Functions---------------");
    println("add :"+add(6,3));
    println("substract :"+substract(6,3));
    println("multiply :"+multiply(6,3));
    println("divide :"+divide(6,3));

    println("class funtion add: "+Math.add(4,5));
    println("class funtion substract: "+Math.substract(5,4));

    //Anonymos function
    var adding = (x : Int, y : Int ) => x+y;
    println("adding anonymous function :"+ adding(8,7));

    //Function with default value
    println ("adding with default "+ addingWithDefault());
    println ("2 adding with default "+ addingWithDefault(3));

    //Function which doesn't return
    noReturnFunction(10,20);

    println("--------------Higher Order Function-------------");
    //Function that takes function as argument

    var resultAdd = math(10, 20, (x, y) => x+y);
    println("Higher order function with addition "+resultAdd);
    var resultMultiplication = math(10, 20, (x, y) => x*y);
    println("Higher order function with addition "+resultMultiplication);
    var resultMax = math(10, 20, (x, y) => x max y);
    println("Higher order function with max "+resultMax);

    resultAdd  = math(10, 20, 30, (x, y) => x+y);
    println("Higher order function with 3 addition "+resultAdd);
    resultMax  = math(10, 20, 30, (x, y) => x max y);
    println("Higher order function with 3 max "+resultMax);

    //using wild card
    resultAdd  = math(10, 20, 30, _ + _);
    println("Higher order function with 3 addition with wild card "+resultAdd);
    resultMax  = math(10, 20, 30, _ max _);
    println("Higher order function with 3 max with wild card "+resultMax);

    println("---------------Partially Applied Function--------------");
    val sum = (x:Int, y:Int, z:Int) => x+y+z;

    val f = sum(10, _:Int, _:Int);
    println("sum of partially applied function "+f(20,30));

    //Use case: logger with date
    val newLog = log(new Date, _:String);

    newLog("message 1");
    newLog("message 2");
    newLog("message 3");
    newLog("message 4");

    println("------------------Closure in Function--------------");
    //When function uses variable that is outside of fuction
    println("addUsingClosure "+ addUsingClosure(10));

    //takes last modified state
    number = 50;
    println("last modified state addUsingClosure "+ addUsingClosure(10));

    // Can also change number value inside function
    // Impure closure : when datatype of number is var,
    // Pure closure :  when datatype of number is val

    println("-------------Currying---------------");
    /*Currying is a technique of transforming a function that
    takes multiple arguments into a function that takes a single argument*/
    println("sum using currying "+addCur3(4)(5));

    //Can also apply partial function
    val addCur40 = addCur2(40);
    println("sum using currying "+addCur40(3));

    println("------------String-------------")
    //Use java.lang.String
    var str1:String = "Hello world";
    var str2:String = "Raghav";
    var num:Int = 10;
    var num2 = 10.24
    println(str1.concat(str2));
    printf("%s----%d ------ %f ",str1, num, num2);
    println("");

    println("------------Array-------------")
    //Different declarations
    var arr1:Array[String] = new Array[String](4);
    var arr2 = new Array[String](4);
    var arr3 = Array (1,2,3,4);
    var arr4 = Array (5,6,7,8);
    var arr5 = concat (arr3, arr4);

    println(arr3);
    for(x <- arr3) {
      println(x);
    }

    for (x <- 0 to arr3.length-1){
      println(arr3(x));
    }

    for(x <- arr5) {
      println(x);
    }

    println("------------List-------------")
    val myList : List[Int] = List(1,2,3,4,5);
    val names : List[String] = List("a","b","c","d")
    println(myList)
    println(names)
    println(0 :: myList)// appending 0 to starting
    //myList(0)=10 Cant modify list
    //println(myList)
    println(1 :: 2 :: 5 :: Nil)
    println(names.head)
    println(names.tail)
    println(name.isEmpty)
    println(names.reverse)
    println(List.fill(5)(2))

    for(x <- names) {
      println(x)
    }

    names.foreach(println)

    var sumValue:Int = 0
    myList.foreach(sumValue += _);
    println("sumValue list "+sumValue);

    println("------------Sets-------------")
    //by default its immutable
    val mySet : Set[Int] = Set(1,2,3,4,5,5)
    val mySet2 : Set[Int] = Set(4,5,7,8,9,10)
    println(mySet)

    //Mutable
    var mutableSet : scala.collection.mutable.Set[Int] = scala.collection.mutable.Set(1,2,3);
    var mutableSet2 = scala.collection.mutable.Set(1,2,3);

    //Adding value which create new
    println(mySet +10);

    //Check value presetn or not
    println("check 5 is presetn :"+mySet(5));

    //head tail isEmpty min max
    println(mySet.head)
    println(mySet.tail)
    println(mySet.isEmpty)
    println(mySet.min)
    println(mySet.max)

    //Contatenation
    println(mySet ++ mySet2)
    println(mySet.++(mySet2))

    //Interseaction
    println(mySet.&(mySet2))
    println(mySet.intersect(mySet2))

    // Iterate
    mySet.foreach(println)
    for(x <- mySet){
      println(x)
    }

    println("------------Maps-------------")
    val myMap : Map[Int, String] = Map(801->"a", 802->"b", 803->"c");
    val myMap2 : Map[Int, String] = Map(804->"d", 805->"e");
    println(myMap)
    println(myMap(801))
    //println(myMap(2)) Throws error as it not contains 2
    println(myMap.contains(2)) //Correct way
    println(myMap.keys)
    println(myMap.values)
    println(myMap.isEmpty)

    myMap.keys.foreach {
      key =>
        println (key +" : "+myMap(key))
    }

    println(myMap ++ myMap2)

    println("-------------------Tuples-----------------")
    //Contains different datatye values
    val mytuple = (1, 2, "abc", true)
    println(mytuple)
    val mytuple2 = new Tuple4(20,"nare",true, (1, 3)) //last character indicates length

    //accessing
    println(mytuple._3)
    println(mytuple2._4._2)

    //Iterate
    mytuple.productIterator.foreach {
      a => println(a)
    }

    //new way to create tuple, can have only two elements
    println ( 1-> "name" -> true)

    println("-----------------------Options---------------------")
    //Some or Non
    val opt : Option[Int] = Some(4)
    println("option some: "+opt)
    println("option some is empty: "+opt.isEmpty)
    val optNon : Option[Int] = None
    println("option none: "+optNon)

    val listn:List[Int] = List (1,2,3)
    val mapn:Map[Int, String] = Map(1->"a", 2->"b", 3->"c")

    println("list find none: "+ listn.find(_ > 6))
    println("list find some: "+ listn.find(_ > 2))
    println("list find some actual value: "+ listn.find(_ > 2).get)

    println("map get some: "+mapn.get(3))
    println("map get none: "+mapn.get(5))
    println("map get some actual value: "+mapn.get(3).get)
    println("map getorelse get actual value: "+mapn.get(2).getOrElse("No name found"))
    println("map getorelse not get: "+mapn.get(6).getOrElse("No name found"))

    println("-----------------------Map FlatMap Flattern---------------------")
    val listv:List[Int] = List (1,2,3,4,5)
    val mapv:Map[Int, String] = Map(1->"a", 2->"b", 3->"c")

    //Map
    println("map double: "+listv.map( _ * 2))
    println("2 map double: "+listv.map( x => x * 2))
    println("3 map double: "+listv.map( x => "hi" * x))
    println("4 map double: "+mapv.map( x => "hi" + x))
    println("4 map double: "+mapv.mapValues( x => "hi " + x))

    println("hello".map(_.toUpper))

    //Flattern
    println(List( List(1,2,3), List(4,5,6)).flatten)

    //FlatMap
    println(listv.map(x => List(x, x+1))) //Map vs Flatmap
    println(listv.flatMap(x => List(x, x+1))) //Flatma

    //Filter
    println( "Filtered even:  "+listv.filter( x => x%2==0)) // Filter function accept predicate which takes a value and return boolean

    println("-----------------------Reduce Fold Scan---------------------")
    val listr:List[Int] = List (1,2,3,4,5)
    val listr2:List[String] = List ("A", "B", "C")
    //val mapr:Map[Int, String] = Map(1->"a", 2->"b", 3->"c")

    //Reduce
    println("reduce left :"+listr.reduceLeft(_ + _))
    println("reduce left :"+listr2.reduceLeft(_ + _))

    println(listr.reduceLeft( (x, y) => {
      println( x+" , "+y); x+y;
    }))

    println("reduce left :"+listr.reduceRight(_ + _))

    //Fold (Reduce + initial value)
    println("fold left :"+listr.foldLeft(100)(_ + _))
    println("fold left :"+listr2.foldLeft("z")(_ + _))

    //Scan (Can get intermediate steps)
    println("scan left :"+listr.scanLeft(100)(_ + _))
    println("scan left :"+listr2.scanLeft("z")(_ + _))
    println("scan rigth :"+listr2.scanRight("z")(_ + _))










  }

  // Functions representations
  def add (x:Int, y:Int): Int = {
    return x+y;
  }

  def substract ( x:Int, y:Int) : Int = {
    x - y; //Can skip return keyword as last statment will be returned
  }

  def multiply ( x:Int, y:Int): Int  = x*y; //Skip curly braces

  def divide ( x:Int, y:Int)  = x/y; //Skip return type

  object Math {
    def add (x:Int, y:Int): Int = {
      return x+y;
    }
    def substract ( x:Int, y:Int) : Int = {
      x - y;
    }
  }

  //Default function valuest
  def addingWithDefault (x:Int =10, y:Int=20) : Int = x+y;

  //Function which doesn't return
  def noReturnFunction (x:Int ,y:Int): Unit = println("doesnt return");

  //Higher order function
  def math (x:Double, y:Double, f: (Double, Double) => Double ) : Double = f(x, y);
  def math (x:Double, y:Double, z:Double, f:(Double, Double) => Double ) : Double = f(f(x, y),z);

  //Partially applied function use case
  def log ( date:Date, message:String) = {
    println(date + "  "+message);

  }

  //Closure function
  var number = 10;
  var addUsingClosure = (x:Int) => {
    x+number;
  }

  // Currying
  def addCur (x:Int, y:Int) = x+y;
  def addCur2 (x:Int) = (y:Int) => x+y;
  def addCur3 (x:Int) (y:Int) = x+y; //Provided by scala for simplicity
}
