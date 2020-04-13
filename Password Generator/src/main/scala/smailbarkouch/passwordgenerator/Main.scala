import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.text.{Font, FontWeight, Text}
import javafx.stage.Stage

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args:_*)
  }
}

class Main extends Application{
  override def start(stage: Stage): Unit = {
    val vBox = new VBox()
    val titleText = new Text
    val passwordField = new javafx.scene.control.TextField
    val submitButton = new Button("Generate")

    titleText.setFont(Font.font("Courier", FontWeight.BOLD, 20))
    titleText.setText("Random Password Generator")

    submitButton.setOnAction(_ => {
      val password = Random.nextBytes(5)

      passwordField.setText(password.toString.substring(3))
    })

    vBox.getChildren.addAll(titleText, passwordField, submitButton)

    vBox.setPadding(new Insets(10))
    vBox.setSpacing(5)

    stage.setScene(new Scene(vBox))
    stage.show()
  }
}