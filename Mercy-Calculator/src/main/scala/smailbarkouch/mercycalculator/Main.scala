package smailbarkouch.mercycalculator

import java.util.{Timer, TimerTask}

import javafx.application.{Application, Platform}
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control._
import javafx.scene.layout.{BorderPane, GridPane}
import javafx.scene.text.{Font, FontPosture, FontWeight, Text}
import javafx.stage.Stage

object Main {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[Main], args: _*)
  }
}

class Main extends Application {

  override def start(stage: Stage): Unit = {

    val rootPane: BorderPane = new BorderPane()
    val gridPane: GridPane = new GridPane()

    val weightIntField1 = new TextField()
    val weightIntField2 = new TextField()
    val ageIntField1 = new TextField()
    val ageIntField2 = new TextField()
    val heightIntField1 = new TextField()
    val heightIntField2 = new TextField()
    val mmIntField1 = new TextField()
    val mmIntField2 = new TextField()
    val ptIntField1 = new TextField()
    val ptIntField2 = new TextField()

    val submitButton = new Button()
    val closeButton = new Button()

    val titleText = new Text

    titleText.setText("Mercy Calculator")
    titleText.setFont(
      Font.font("Impact", FontWeight.BLACK, FontPosture.REGULAR, 30)
    )

    submitButton.setText("See Results")
    closeButton.setText("Close")

    gridPane.add(titleText, 0, 0)

    gridPane.add(new Label("Enter Height:"), 0, 1)
    gridPane.add(new Label("Person 1:"), 0, 2)
    gridPane.add(weightIntField1, 1, 2)
    gridPane.add(new Label("Person 2:"), 0, 3)
    gridPane.add(weightIntField2, 1, 3)

    gridPane.add(new Label("Enter Age:"), 0, 4)
    gridPane.add(new Label("Person 1:"), 0, 5)
    gridPane.add(ageIntField1, 1, 5)
    gridPane.add(new Label("Person 2:"), 0, 6)
    gridPane.add(ageIntField2, 1, 6)

    gridPane.add(new Label("Enter Height:"), 0, 7)
    gridPane.add(new Label("Person 1:"), 0, 8)
    gridPane.add(heightIntField1, 1, 8)
    gridPane.add(new Label("Person 2:"), 0, 9)
    gridPane.add(heightIntField2, 1, 9)

    gridPane.add(new Label("Enter Muscle Mass:"), 0, 10)
    gridPane.add(new Label("Person 1:"), 0, 11)
    gridPane.add(mmIntField1, 1, 11)
    gridPane.add(new Label("Person 2:"), 0, 12)
    gridPane.add(mmIntField2, 1, 12)

    gridPane.add(new Label("Enter Pain Tolerance (1-10)"), 0, 13)
    gridPane.add(new Label("Person 1:"), 0, 14)
    gridPane.add(ptIntField1, 1, 14)
    gridPane.add(new Label("Person 2:"), 0, 15)
    gridPane.add(ptIntField2, 1, 15)

    gridPane.setPadding(new Insets(10))

    gridPane.add(submitButton, 0, 16)
    gridPane.add(closeButton, 1, 16)

    rootPane.setPadding(new Insets(10))

    submitButton.setOnAction(_ => {
      val results = new Dialog[ButtonType]

      results.getDialogPane.getButtonTypes.addAll(ButtonType.YES)

      val text = new Text
      val text1 = new Text

      text.setFont(
        Font.font("Impact", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 100)
      )
      text1.setFont(
        Font.font("Impact", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 90)
      )

      text.setText("KEVIN WINS")
      text1.setText("I mean, why the hell wouldn't he?!")
      results.getDialogPane.setContent(text)

      results.getDialogPane.setMinSize(1250, 200)

      val timer = new Timer()

      timer.schedule(new TimerTask {
        override def run(): Unit = {

          Platform.runLater(new Runnable() {
            override def run(): Unit = results.getDialogPane.setContent(text1)
          })
        }
      }, 3000)



      results.show
    })

    closeButton.setOnAction(_ => {
      stage.close()
    })

    rootPane.setCenter(gridPane)

    stage.setScene(new Scene(rootPane, 458, 450))
    stage.setTitle("Mercy Calculator")
    stage.show()

  }

}
