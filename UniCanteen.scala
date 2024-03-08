
package UniCanteen

import UniCanteen._
import java.time.LocalDate
import scala.collection.mutable.Buffer

class UniCanteen {

  // allergies
  var allergies: Buffer[String] = Buffer()

  //Restaurants
  val Abloc = new Restaurant("A-bloc")
  val Alvari = new Restaurant("Alvari")
  val StudioKipsari = new Restaurant("Studio Kipsari")
  val Taffa = new Restaurant("Täffä")
  val Vare = new Restaurant("Väre")

  //tomorrow's date and day after tomorrow's date
  val tomorrow = LocalDate.now().plusDays(1)
  val dayaftom = LocalDate.now().plusDays(2)

  //////////////////////////////////////////// FOR TESTING ////////////////////////////////////////////////////
  //URL for 15th of January 2020 (for testing of full normal menu when the restaurants are opened, changing today's menu)
  //val Ablocj = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/52/menu?day=2020-01-15&lang=en").mkString
  //val Alvarij = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/5/menu?day=2020-01-15&lang=en").mkString
  //val StudioKipsarij = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/51/menu?day=2020-01-15&lang=en").mkString
  //val Varej = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/50/menu?day=2020-01-15&lang=en").mkString
  //val TFj = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/3/menu?day=2020-01-15&lang=en").mkString

  //URL today
  val TFj = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/3/menu?day=" + LocalDate.now() + "&lang=en").mkString
  val Varej = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/50/menu?day=" + LocalDate.now() + "&lang=en").mkString
  val StudioKipsarij = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/51/menu?day=" + LocalDate.now() + "&lang=en").mkString
  val Ablocj = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/52/menu?day=" + LocalDate.now() + "&lang=en").mkString
  val Alvarij = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/5/menu?day=" + LocalDate.now() + "&lang=en").mkString

  // URL tomorrow
  val TFtom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/3/menu?day=" + tomorrow + "&lang=en").mkString
  val Varetom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/50/menu?day=" + tomorrow + "&lang=en").mkString
  val SKtom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/51/menu?day=" + tomorrow + "&lang=en").mkString
  val Abloctom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/52/menu?day=" + tomorrow + "&lang=en").mkString
  val Alvaritom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/5/menu?day=" + tomorrow + "&lang=en").mkString

  // URL day after tomorrow
  val TFaftom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/3/menu?day=" + dayaftom + "&lang=en").mkString
  val Vareaftom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/50/menu?day=" + dayaftom + "&lang=en").mkString
  val SKaftom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/51/menu?day=" + dayaftom + "&lang=en").mkString
  val Ablocaftom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/52/menu?day=" + dayaftom + "&lang=en").mkString
  val Alvariaftom = scala.io.Source.fromURL("https://kitchen.kanttiinit.fi/restaurants/5/menu?day=" + dayaftom + "&lang=en").mkString

  // Today's title and props
  val Abloctitle = this.Abloc.getTitle(Ablocj)
  val Ablocproplist = this.Abloc.getProp(Ablocj).map(_.asInstanceOf[List[String]])

  val Alvarititle = this.Alvari.getTitle(Alvarij)
  val Alvariproplist = this.Alvari.getProp(Alvarij).map(_.asInstanceOf[List[String]])

  val SKtitle = this.StudioKipsari.getTitle(StudioKipsarij)
  val SKproplist = this.StudioKipsari.getProp(StudioKipsarij).map(_.asInstanceOf[List[String]])

  val TFtitle = this.Taffa.getTitle(TFj)
  val TFproplist = this.Taffa.getProp(TFj).map(_.asInstanceOf[List[String]])

  val Varetitle = this.Vare.getTitle(Varej)
  val Vareproplist = this.Vare.getProp(Varej).map(_.asInstanceOf[List[String]])

  // Tomorrow's title and props
  val Abloctitleto = this.Abloc.getTitle(Abloctom)
  val Ablocpropto = this.Abloc.getProp(Abloctom).map(_.asInstanceOf[List[String]])

  val Alvarititleto = this.Alvari.getTitle(Alvaritom)
  val Alvaripropto = this.Alvari.getProp(Alvaritom).map(_.asInstanceOf[List[String]])

  val SKtitleto = this.StudioKipsari.getTitle(SKtom)
  val SKpropto = this.StudioKipsari.getProp(SKtom).map(_.asInstanceOf[List[String]])

  val TFtitleto = this.Taffa.getTitle(TFtom)
  val TFpropto = this.Taffa.getProp(TFtom).map(_.asInstanceOf[List[String]])

  val Varetitleto = this.Vare.getTitle(Varetom)
  val Varepropto = this.Vare.getProp(Varetom).map(_.asInstanceOf[List[String]])

  // Day aft tomorrow's title and props
  val Abloctitleaft = this.Abloc.getTitle(Ablocaftom)
  val Ablocpropaft = this.Abloc.getProp(Ablocaftom).map(_.asInstanceOf[List[String]])

  val Alvarititleaft = this.Alvari.getTitle(Alvariaftom)
  val Alvaripropaft = this.Alvari.getProp(Alvariaftom).map(_.asInstanceOf[List[String]])

  val SKtitleaft = this.StudioKipsari.getTitle(SKaftom)
  val SKpropaft = this.StudioKipsari.getProp(SKaftom).map(_.asInstanceOf[List[String]])

  val TFtitleaft = this.Taffa.getTitle(TFaftom)
  val TFpropaft = this.Taffa.getProp(TFaftom).map(_.asInstanceOf[List[String]])

  val Varetitleaft = this.Vare.getTitle(Vareaftom)
  val Varepropaft = this.Vare.getProp(Vareaftom).map(_.asInstanceOf[List[String]])

  def filterAllergen(allergens: Buffer[String], proplist0: scala.collection.immutable.Seq[List[String]], title: scala.collection.immutable.Seq[Any]): Buffer[String] = {
    var index = 0
    var titlebuf = title.toBuffer
    var filteredmenu: Buffer[String] = Buffer()
    var proplist = proplist0.toBuffer
    for (allergy <- allergens) {
      while (index < proplist.length) {
        if (proplist(index).toBuffer.contains(allergy.toString)) {
          filteredmenu += "							" + title(index).toString() + "		" + proplist(index).toString.drop(4)
          index += 1
        } else {
          index += 1
        }
      }
    }
    if (filteredmenu.isEmpty) {
      filteredmenu += "							" + "No Menu Available"
      filteredmenu
    } else {
      filteredmenu
    }
  }
  
}
