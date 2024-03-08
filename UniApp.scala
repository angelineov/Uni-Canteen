package UniCanteen

import java.awt.BorderLayout
import java.awt.Font._
import java.awt.{ Color, Graphics2D }
import scala.swing._
import scala.io.Source._
import swing.event._
import scala.collection.mutable.Buffer
import UniCanteen._

object SwingExample extends App {

  val uni = new UniCanteen() //new class of uni-canteen

  //Abloc menu list, showing "No Menu Available" if there is nothing in the list of Abloctitle
  // otherwise has all the lists of Abloc title and properties
  val ablocpanel = new BoxPanel(Orientation.Vertical) {
    border = Swing.LineBorder(Color.pink, 5)
    val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    contents += love
    var title = new Label("							" + uni.Abloc.restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
    listenTo(love)
    reactions += {
      case ButtonClicked(love) => {
        if (love.selected) {
          title.foreground = Color.red
          title.repaint()
          title.revalidate()
        } else {
          title.foreground = Color.black
          title.repaint()
          title.revalidate()
        }
      }
    }
    contents += Swing.VStrut(5)
    contents += title
    contents += Swing.VStrut(10)
    if (uni.Abloctitle.isEmpty) {
      contents += Swing.VStrut(20)
      contents += new Label("							" + "No Menu Available")
      contents += new Label("							" + "──────────────────────────────")
    } else {
      var index = 0
      while (index < uni.Abloctitle.length) {
        contents += new Label("							" + uni.Abloctitle(index).toString() + "  " + uni.Ablocproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    }
  }

  //Alvari menu list, showing "No Menu Available" if there is nothing in the list of Alvarititle
  // otherwise has all the lists of Alvari title and properties
  val alvaripanel = new BoxPanel(Orientation.Vertical) {
    border = Swing.LineBorder(Color.pink, 5)
    val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    contents += love
    var title = new Label("							" + uni.Alvari.restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
    listenTo(love)
    reactions += {
      case ButtonClicked(love) => {
        if (love.selected) {
          title.foreground = Color.red
          title.repaint()
          title.revalidate()

        } else {
          title.foreground = Color.black
          title.repaint()
          title.revalidate()
        }
      }
    }
    contents += Swing.VStrut(5)
    contents += title
    contents += Swing.VStrut(10)
    if (uni.Alvarititle.isEmpty) {
      contents += Swing.VStrut(20)
      contents += new Label("							" + "No Menu Available")
      contents += new Label("							" + "──────────────────────────────")
    } else {
      var index = 0
      while (index < uni.Alvarititle.length) {
        contents += new Label("							" + uni.Alvarititle(index).toString() + "  " + uni.Alvariproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    }
    background = Color.white
  }

  //Studio Kipsari(SK) menu list, showing "No Menu Available" if there is nothing in the list of SKtitle
  // SK list sometimes has empty title on index 0, thus it has extra else if, which returns all the title and properties,
  // except index 0 if it is empty.
  // otherwise has all the lists of SK title and properties
  val SKpanel = new BoxPanel(Orientation.Vertical) {
    border = Swing.LineBorder(Color.pink, 5)
    val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    contents += love
    var title = new Label("							" + uni.StudioKipsari.restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
    listenTo(love)
    reactions += {
      case ButtonClicked(love) => {
        if (love.selected) {
          title.foreground = Color.red
          title.repaint()
          title.revalidate()
        } else {
          title.foreground = Color.black
          title.repaint()
          title.revalidate()
        }
      }
    }
    contents += Swing.VStrut(5)
    contents += title
    contents += Swing.VStrut(10)
    if (uni.SKtitle.isEmpty) {
      contents += Swing.VStrut(20)
      contents += new Label("							" + "No Menu Available")
      contents += new Label("							" + "──────────────────────────────")
    } else if (uni.SKtitle(0).toString().isEmpty()) {
      var index = 1
      while (index < uni.SKtitle.length) {
        contents += new Label("							" + uni.SKtitle(index).toString() + "  " + uni.SKproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    } else {
      var index = 0
      while (index < uni.SKtitle.length) {
        contents += new Label("							" + uni.SKtitle(index).toString() + "  " + uni.SKproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    }
    background = Color.white
  }

  //Taffa menu list, showing "No Menu Available" if there is nothing in the list of TFtitle
  // otherwise has all the lists of Taffa title and properties
  val TFpanel = new BoxPanel(Orientation.Vertical) {
    border = Swing.LineBorder(Color.pink, 5)
    val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    contents += love
    var title = new Label("							" + uni.Taffa.restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
    listenTo(love)
    reactions += {
      case ButtonClicked(love) => {
        if (love.selected) {
          title.foreground = Color.red
          title.repaint()
          title.revalidate()
        } else {
          title.foreground = Color.black
          title.repaint()
          title.revalidate()
        }
      }
    }
    contents += Swing.VStrut(5)
    contents += title
    contents += Swing.VStrut(10)
    if (uni.TFtitle.isEmpty) {
      contents += Swing.VStrut(20)
      contents += new Label("							" + "No Menu Available")
      contents += new Label("							" + "──────────────────────────────")
    } else {
      var index = 0
      while (index < uni.TFtitle.length) {
        contents += new Label("							" + uni.TFtitle(index).toString() + "  " + uni.TFproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    }
  }

  //Vare menu list, showing "No Menu Available" if there is nothing in the list of Varetitle
  // Vare list sometimes has empty title on index 0, thus it has extra else if, which returns all the title and properties,
  // except index 0 if it is empty.
  // otherwise has all the lists of Vare title and properties
  val Varepanel = new BoxPanel(Orientation.Vertical) {
    border = Swing.LineBorder(Color.pink, 5)
    //val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
    contents += love
    var title = new Label("							" + uni.Vare.restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
    listenTo(love)
    reactions += {
      case ButtonClicked(love) => {
        if (love.selected) {
          title.foreground = Color.red
          title.repaint()
          title.revalidate()
        } else {
          title.foreground = Color.black
          title.repaint()
          title.revalidate()
        }
      }
    }
    contents += Swing.VStrut(5)
    contents += title
    contents += Swing.VStrut(10)
    if (uni.Varetitle.isEmpty) {
      contents += Swing.VStrut(20)
      contents += new Label("							" + "No Menu Available")
      contents += new Label("							" + "──────────────────────────────")
    } else if (uni.Varetitle(0).toString().isEmpty()) {
      var index = 1
      while (index < uni.Varetitle.length) {
        contents += new Label("							" + uni.Varetitle(index).toString() + "  " + uni.Vareproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    } else {
      var index = 0
      while (index < uni.Varetitle.length) {
        contents += new Label("							" + uni.Varetitle(index).toString() + "  " + uni.Vareproplist(index).toString.drop(4))
        contents += new Label("							" + "──────────────────────────────")
        index += 1
      }
    }
  }

  //Main Frame of the GUI
  val frame = new MainFrame {

    title = "Uni-Canteen"

    contents = new BoxPanel(Orientation.Vertical) {
      background = Color.pink

      contents += Swing.VStrut(15)

      // Title of the GUI
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("U n i  -  C a n t e e n") { font = new Font("Times New Roman", ITALIC + BOLD, 25); this.foreground = Color.black }
        background = Color.pink
      }

      //line design
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("─────────────────────────────")
        background = Color.pink
      }

      contents += Swing.VStrut(5)
      
      //////////////////////////////////////////////////// FUNCTIONS ////////////////////////////////////////////////////////////////
      //function of menu list when the list is empty for buttons
      def menuempty(panel: BoxPanel, title: scala.collection.immutable.Seq[Any]) {
        panel.contents += Swing.VStrut(20)
        panel.contents += new Label("							" + "No Menu Available")
        panel.contents += new Label("							" + "──────────────────────────────")
      }

      // function of menu list when list is not empty for buttons
      def menunotemp(panel: BoxPanel, title: scala.collection.immutable.Seq[Any], prop: scala.collection.immutable.Seq[List[String]]) {
        var index = 0
        while (index < title.length) {
          panel.contents += new Label("							" + title(index).toString() + "  " + prop(index).toString.drop(4))
          panel.contents += new Label("							" + "──────────────────────────────")
          index += 1
        }
      }

      // function of menu list when first title index is empty (only for Vare and SK) for buttons
      def menufirstemp(panel: BoxPanel, title: scala.collection.immutable.Seq[Any], prop: scala.collection.immutable.Seq[List[String]]) {
        var index = 1
        while (index < title.length) {
          panel.contents += new Label("							" + title(index).toString() + "  " + prop(index).toString.drop(4))
          panel.contents += new Label("							" + "──────────────────────────────")
          index += 1
        }
      }

      // function of menu list for allergies
      def menuallergens(panel: BoxPanel, menu: Buffer[String]) {
        var index = 0
        while (index < menu.length) {
          panel.contents += new Label(menu(index))
          panel.contents += new Label("							" + "──────────────────────────────")
          index += 1
        }
      }

      // function of the label contents
      def repaintcontent(panel: BoxPanel, restoname: String) {
        panel.contents.clear
        panel.border = Swing.LineBorder(Color.pink, 5)
        val love = new RadioButton("❤") { font = new Font("", BOLD, 20); this.foreground = Color.red }
        panel.contents += love
        var title = new Label("							" + restoname) { font = new Font("Times New Roman", ITALIC + BOLD, 17) }
        listenTo(love)
        reactions += {
          case ButtonClicked(`love`) => {
            if (love.selected) {
              title.foreground = Color.red
              title.repaint()
              title.revalidate()
            } else {
              title.foreground = Color.black
              title.repaint()
              title.revalidate()
            }
          }
        }
        panel.contents += Swing.VStrut(5)
        panel.contents += title
        panel.contents += Swing.VStrut(10)
      }  
      ///////////////////////////////////// TODAY, TOMORROW, AND DAY AFTER TOMORROW (Variables and Actions) ////////////////////////////////////////
      
      //3 buttons for today's menu, tomorrow's menu and day after tomorrow's menu
      val today = new Button("Today")
      val tomorrow = new Button("Tomorrow")
      val datom = new Button("Day After Tomorrow")
      // listening to the buttons
      listenTo(today)
      listenTo(tomorrow)
      listenTo(datom)
      // the Actions of each buttons
      reactions += {
        case ButtonClicked(`today`) => {
          
          //abloc repaint today
          repaintcontent(ablocpanel, uni.Abloc.restoname)
          if (uni.Abloctitle.isEmpty) menuempty(ablocpanel, uni.Abloctitle) else menunotemp(ablocpanel, uni.Abloctitle, uni.Ablocproplist)
          ablocpanel.repaint()
          ablocpanel.revalidate()

          //alvari repaint today
          alvaripanel.contents.clear
          repaintcontent(alvaripanel, uni.Alvari.restoname)
          if (uni.Alvarititle.isEmpty) menuempty(alvaripanel, uni.Alvarititle) else menunotemp(alvaripanel, uni.Alvarititle, uni.Alvariproplist)
          alvaripanel.repaint()
          alvaripanel.revalidate()

          //SK repaint today
          repaintcontent(SKpanel, uni.StudioKipsari.restoname)
          if (uni.SKtitle.isEmpty) { menuempty(SKpanel, uni.SKtitle) }
          else if (uni.SKtitle(0).toString().isEmpty()) { menufirstemp(SKpanel, uni.SKtitle, uni.SKproplist) }
          else menunotemp(SKpanel, uni.SKtitle, uni.SKproplist)
          SKpanel.repaint()
          SKpanel.revalidate()

          //TF repaint today
          repaintcontent(TFpanel, uni.Taffa.restoname)
          if (uni.TFtitle.isEmpty) menuempty(TFpanel, uni.TFtitle) else menunotemp(TFpanel, uni.TFtitle, uni.TFproplist)
          TFpanel.repaint()
          TFpanel.revalidate()

          //Vare repaint today
          repaintcontent(Varepanel, uni.Vare.restoname)
          if (uni.Varetitle.isEmpty) menuempty(Varepanel, uni.Varetitle)
          else if (uni.Varetitle(0).toString().isEmpty()) { menufirstemp(Varepanel, uni.Varetitle, uni.Vareproplist) }
          else menunotemp(Varepanel, uni.Varetitle, uni.Vareproplist)
          Varepanel.repaint()
          Varepanel.revalidate()
        }

        case ButtonClicked(`tomorrow`) => {
          //abloc repaint tomorrow
          repaintcontent(ablocpanel, uni.Abloc.restoname)
          if (uni.Abloctitleto.isEmpty) menuempty(ablocpanel, uni.Abloctitleto) else menunotemp(ablocpanel, uni.Abloctitleto, uni.Ablocpropto)
          ablocpanel.repaint()
          ablocpanel.revalidate()

          //alvari repaint tomorrow
          repaintcontent(alvaripanel, uni.Alvari.restoname)
          if (uni.Alvarititleto.isEmpty) menuempty(alvaripanel, uni.Alvarititleto) else menunotemp(alvaripanel, uni.Alvarititleto, uni.Alvaripropto)
          alvaripanel.repaint()
          alvaripanel.revalidate()

          // SK repaint tomorrow
          repaintcontent(SKpanel, uni.StudioKipsari.restoname)
          if (uni.SKtitleto.isEmpty) { menuempty(SKpanel, uni.SKtitleto) }
          else if (uni.SKtitleto(0).toString().isEmpty()) { menufirstemp(SKpanel, uni.SKtitleto, uni.SKpropto) }
          else menunotemp(SKpanel, uni.SKtitleto, uni.SKpropto)
          SKpanel.repaint()
          SKpanel.revalidate()

          // TF repaint tomorrow
          repaintcontent(TFpanel, uni.Taffa.restoname)
          if (uni.TFtitleto.isEmpty) menuempty(TFpanel, uni.TFtitleto) else menunotemp(TFpanel, uni.TFtitleto, uni.TFpropto)
          TFpanel.repaint()
          TFpanel.revalidate()

          //Vare repaint tomorrow
          repaintcontent(Varepanel, uni.Vare.restoname)
          if (uni.Varetitleto.isEmpty) menuempty(Varepanel, uni.Varetitleto)
          else if (uni.Varetitleto(0).toString().isEmpty()) { menufirstemp(Varepanel, uni.Varetitleto, uni.Varepropto) }
          else menunotemp(Varepanel, uni.Varetitleto, uni.Varepropto)
          Varepanel.repaint()
          Varepanel.revalidate()
        }

        case ButtonClicked(`datom`) => {
          //abloc repaint day after tomorrow
          repaintcontent(ablocpanel, uni.Abloc.restoname)
          if (uni.Abloctitleaft.isEmpty) menuempty(ablocpanel, uni.Abloctitleaft) else menunotemp(ablocpanel, uni.Abloctitleaft, uni.Ablocpropaft)
          ablocpanel.repaint()
          ablocpanel.revalidate()

          //alvari repaint day after tomorrow
          repaintcontent(alvaripanel, uni.Alvari.restoname)
          if (uni.Alvarititleaft.isEmpty) menuempty(alvaripanel, uni.Alvarititleaft) else menunotemp(alvaripanel, uni.Alvarititleaft, uni.Alvaripropaft)
          alvaripanel.repaint()
          alvaripanel.revalidate()

          //SK repaint day after tomorrow
          repaintcontent(SKpanel, uni.StudioKipsari.restoname)
          if (uni.SKtitleaft.isEmpty) { menuempty(SKpanel, uni.SKtitleaft) }
          else if (uni.SKtitleaft(0).toString().isEmpty()) { menufirstemp(SKpanel, uni.SKtitleaft, uni.SKpropaft) }
          else menunotemp(SKpanel, uni.SKtitleaft, uni.SKpropaft)
          SKpanel.repaint()
          SKpanel.revalidate()

          //TF repaint day after tomorrow
          repaintcontent(TFpanel, uni.Taffa.restoname)
          if (uni.TFtitleaft.isEmpty) menuempty(TFpanel, uni.TFtitleaft) else menunotemp(TFpanel, uni.TFtitleaft, uni.TFpropaft)
          TFpanel.repaint()
          TFpanel.revalidate()

          //Vare repaint day after tomorrow
          repaintcontent(Varepanel, uni.Vare.restoname)
          if (uni.Varetitleaft.isEmpty) menuempty(Varepanel, uni.Varetitleaft)
          else if (uni.Varetitleaft(0).toString().isEmpty()) { menufirstemp(Varepanel, uni.Varetitleaft, uni.Varepropaft) }
          else menunotemp(Varepanel, uni.Varetitleaft, uni.Varepropaft)
          Varepanel.repaint()
          Varepanel.revalidate()
        }
      }
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      // Adding today, tomorrow and day aft. tomorrow buttons on main frame
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += today
        contents += tomorrow
        contents += datom
        background = Color.pink
      }

      contents += Swing.VStrut(5)

      ///////////////////////////////////////////// ALLERGIES PANEL ////////////////////////////////////////////////
      
      contents += new BoxPanel(Orientation.Horizontal) {
        val checkA = new CheckBox("A+")
        val checkG = new CheckBox("G")
        val checkL = new CheckBox("L")
        val checkE = new CheckBox("E")
        val checkH = new CheckBox("H")
        val checkM = new CheckBox("M")
        val checkS = new CheckBox("S")
        val checkV = new CheckBox("VV")
        val filter = new Button("Filter Today's Menu")
        contents += new Label("Choose one allergen to filter	:") { font = new Font("", BOLD, 12) }
        contents += Swing.HStrut(5)
        contents += checkA
        contents += checkG
        contents += checkL
        contents += checkE
        contents += checkH
        contents += checkM
        contents += checkS
        contents += checkV
        contents += Swing.HStrut(15)
        contents += filter
        background = Color.pink

        listenTo(checkA)
        listenTo(checkG)
        listenTo(checkL)
        listenTo(checkE)
        listenTo(checkH)
        listenTo(checkM)
        listenTo(checkS)
        listenTo(checkV)
        listenTo(filter)
        reactions += {
          case ButtonClicked(`checkA`) =>
            if (checkA.selected) { uni.allergies += "A+" } else { uni.allergies -= "A+" }
          case ButtonClicked(`checkG`) =>
            if (checkG.selected) { uni.allergies += "G" } else { uni.allergies -= "G" }
          case ButtonClicked(`checkL`) =>
            if (checkL.selected) { uni.allergies += "L" } else { uni.allergies -= "L" }
          case ButtonClicked(`checkE`) =>
            if (checkE.selected) { uni.allergies += "E" } else { uni.allergies -= "E" }
          case ButtonClicked(`checkH`) =>
            if (checkH.selected) { uni.allergies += "H" } else { uni.allergies -= "H" }
          case ButtonClicked(`checkM`) =>
            if (checkM.selected) { uni.allergies += "M" } else { uni.allergies -= "M" }
          case ButtonClicked(`checkS`) =>
            if (checkS.selected) { uni.allergies += "S" } else { uni.allergies -= "S" }
          case ButtonClicked(`checkV`) =>
            if (checkV.selected) { uni.allergies += "VV" } else { uni.allergies -= "VV" }
          case ButtonClicked(`filter`) =>

            //abloc repaint today with allergies
            repaintcontent(ablocpanel, uni.Abloc.restoname)
            if (uni.Abloctitle.isEmpty) menuempty(ablocpanel, uni.Abloctitle)
            else if (uni.allergies.isEmpty) menunotemp(ablocpanel, uni.Abloctitle, uni.Ablocproplist)
            else menuallergens(ablocpanel, uni.filterAllergen(uni.allergies, uni.Ablocproplist, uni.Abloctitle))
            ablocpanel.repaint()
            ablocpanel.revalidate()

            //alvari repaint today with allergies
            repaintcontent(alvaripanel, uni.Alvari.restoname)
            if (uni.Alvarititle.isEmpty) menuempty(alvaripanel, uni.Alvarititle)
            else if (uni.allergies.isEmpty) menunotemp(alvaripanel, uni.Alvarititle, uni.Alvariproplist)
            else menuallergens(alvaripanel, uni.filterAllergen(uni.allergies, uni.Alvariproplist, uni.Alvarititle))
            alvaripanel.repaint()
            alvaripanel.revalidate()

            // SK repaint today with allergies
            repaintcontent(SKpanel, uni.StudioKipsari.restoname)
            if (uni.SKtitle.isEmpty) { menuempty(SKpanel, uni.SKtitle) }
            else if ((uni.allergies.isEmpty) && (uni.SKtitleaft(0).toString().isEmpty())) { menufirstemp(SKpanel, uni.SKtitle, uni.SKproplist) }
            else if (uni.allergies.isEmpty) menunotemp(SKpanel, uni.SKtitle, uni.SKproplist)
            else menuallergens(SKpanel, uni.filterAllergen(uni.allergies, uni.SKproplist, uni.SKtitle))
            SKpanel.repaint()
            SKpanel.revalidate()

            // TF repaint today with allergies
            repaintcontent(TFpanel, uni.Taffa.restoname)
            if (uni.TFtitle.isEmpty) menuempty(TFpanel, uni.TFtitle)
            else if (uni.allergies.isEmpty) menunotemp(TFpanel, uni.TFtitle, uni.TFproplist)
            else menuallergens(TFpanel, uni.filterAllergen(uni.allergies, uni.TFproplist, uni.TFtitle))
            TFpanel.repaint()
            TFpanel.revalidate()

            //Vare repaint today with allergies
            repaintcontent(Varepanel, uni.Vare.restoname)
            if (uni.Varetitle.isEmpty) menuempty(Varepanel, uni.Varetitle)
            else if ((uni.allergies.isEmpty) && (uni.Varetitleaft(0).toString().isEmpty())) { menufirstemp(Varepanel, uni.Varetitle, uni.Vareproplist) }
            else if (uni.allergies.isEmpty) menunotemp(Varepanel, uni.Varetitle, uni.Vareproplist)
            else menuallergens(Varepanel, uni.filterAllergen(uni.allergies, uni.Vareproplist, uni.Varetitle))
            Varepanel.repaint()
            Varepanel.revalidate()
        }
      }
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////

      contents += Swing.VStrut(10)

      // Menu Panel includes all the restaurants' menu lists
      var menu_panel = new GridPanel(3, 2) {
        background = Color.pink

        contents += ablocpanel
        contents += new ScrollPane(ablocpanel)

        contents += alvaripanel
        contents += new ScrollPane(alvaripanel)

        contents += SKpanel
        contents += new ScrollPane(SKpanel)

        contents += TFpanel
        contents += new ScrollPane(TFpanel)

        contents += Varepanel
        contents += new ScrollPane(Varepanel)
      }

      // Adding menu panel on the main frame
      contents += menu_panel

      contents += Swing.VStrut(10)

      // Design Line
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("───────────────────────")
        background = Color.pink
      }

      contents += Swing.VStrut(3)

      /////////////  Information of Allergen symbols panels adding on the main frame  /////////////
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("Information of allergen symbols:") { font = new Font("", BOLD, 13) }
        background = Color.pink
      }
      
      contents += Swing.VStrut(3)

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("	A+ = contains Allergen			")
        contents += new Label("	G = Gluten free			")
        contents += new Label("	L = Lactose free			")
        contents += new Label("	E = Egg free			")
        background = Color.pink
      }

      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("	H = Healthier choice			")
        contents += new Label("	M = Milk free			")
        contents += new Label("	S = Soy free			")
        contents += new Label("	VV = Vegetarian			")
        background = Color.pink
      }
      
      /////////////////////////////////////////////////////////////////////////////////////////////

      contents += Swing.VStrut(10)

      //Design Line
      contents += new BoxPanel(Orientation.Horizontal) {
        contents += new Label("───────────────────────")
        background = Color.pink
      }

      contents += Swing.VStrut(10)

    }

    // Menu Bar on top left corner has one menu item (Quit to exit the program)
    menuBar = new MenuBar {
      contents += new Menu("Program") {
        contents += new MenuItem(Action("Quit") {
          sys.exit(0)
        })
      }
    }

    size = new Dimension(900, 800)
    centerOnScreen

  }

  frame.visible = true

}
