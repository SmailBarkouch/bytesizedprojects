import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.{ComboBox, MenuBar, TextField}
import javafx.scene.layout.{BorderPane, VBox}
import javafx.scene.text.{Font, FontWeight, Text}
import javafx.stage.Stage

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {
  override def start(stage: Stage): Unit = {

    val borderPane: BorderPane = new BorderPane()
    val menuBar: MenuBar = getMenuBar
    val vBox: VBox = constructVBox()

    borderPane.setCenter(vBox)
    borderPane.setTop(menuBar)

    stage.setScene(new Scene(borderPane, 700, 600))
    stage.show()
  }

  private def constructVBox(): VBox = {
    val vBox = new VBox()

    vBox.setPadding(new Insets(10))
    vBox.setSpacing(10)

    val titleText = getTitleFont
    val languageChoice1 = new ComboBox[String]
    val languageChoice2 = new ComboBox[String]
    val translateText1 = new TextField
    val translateText2 = new TextField

    translateText1.setMinSize(100, _)
    translateText2.setMinSize(100, _)

    vBox.getChildren.addAll(
      titleText,
      languageChoice1,
      translateText1,
      languageChoice2,
      translateText2
    )

    vBox
  }

  private def getTitleFont(): Text = {
    val titleText: Text = new Text()

    titleText.setText("Stealth Translator")
    titleText.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50))

    titleText
  }

  private def getMenuBar(): MenuBar = {
    val menuBar = new MenuBar

    menuBar
  }

}
