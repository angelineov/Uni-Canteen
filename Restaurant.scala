

package UniCanteen

import java.time.LocalDate
import UniCanteen._
import scala.io.Source
import scala.util.parsing.json._

class CC[T] { def unapply(a: Any): Option[T] = Some(a.asInstanceOf[T]) }

object M extends CC[Map[String, Any]]
object L extends CC[List[Any]]
object S extends CC[String]
object D extends CC[Double]
object B extends CC[Boolean]

class Restaurant(name : String) {
  
  val restoname = name
  
  //test if the JSON parsing is valid
  def testJSON(restaurant: String) = {
    val resto = JSON.parseFull(restaurant)

    resto match {
      // Matches if jsonStr is valid JSON and represents a Map of Strings to Any
      case Some(M(map: Map[String, Any])) => println("Successful")
      case None                           => println("Parsing failed")
      case other                          => println("Unknown data structure: " + other)
    }
  }
  
  //return list of map for menus which include day and courses
  def mapofmenu(restaurant: String) = {
    val restaurant1 = JSON.parseFull(restaurant)
    val map = (restaurant1.get).asInstanceOf[Map[String, Any]]
    val menus1 = map.get("menus")
    val menus2 = menus1.get.asInstanceOf[List[Map[String, Any]]]
    menus2
  }
  
  //check if the menu list of courses is empty
  def isMenuEmpty(restaurant: String) = {
    val menulist = mapofmenu(restaurant)
    if (menulist.isEmpty) true else false
  }
  

  // get menus of restaurant in form of list of map (titles and properties)
  def getMenu(restaurant: String) = {
    val menulist = mapofmenu(restaurant)
    if (isMenuEmpty(restaurant)) {
      menulist
    } else {
      val courses = menulist(0)("courses").asInstanceOf[List[Map[String, Any]]]
      courses 
    }
  }

  //get the titles of the food only, returns vector
  def getTitle(restaurant: String) = {
    val courses = getMenu(restaurant)
    if (courses.isEmpty) courses else {
      for (index <- courses.indices)
      yield (courses(index)("title")) 
    }
  }
  
  //get the properties of the food only, returns vector of lists
  def getProp(restaurant: String) = {
    val courses = getMenu(restaurant)
    if (courses.isEmpty) courses else {
      for (index <- courses.indices)
      yield (courses(index)("properties"))
    }
  }

  // print menu and properties (for testing)
  def printMenusAndProp(menus: List[Map[String, Any]]) = {
    val data = menus.map(_.values)
    data.foreach(x => println(x.mkString(" "))) 

  }

  //print all components in a list (for testing)
  def printList(args: List[_]): Unit = {
    args.foreach(println)
  }

}