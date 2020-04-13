import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.{Canvas, GraphicsContext}
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Paint
import javafx.stage.Stage

object App {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[App], args:_*)
  }
}

class App extends Application {
  override def start(stage: Stage): Unit = {
    val borderPane = new BorderPane()
    val canvas = new Canvas()

    drawSpace(canvas.getGraphicsContext2D, stage.getWidth, stage.getHeight)
    borderPane.setCenter(canvas)



    stage.setScene(new Scene(new BorderPane(canvas), 500, 500))
    stage.show()
  }

  def drawSpace(graphicsContext: GraphicsContext, width: Double, height: Double): Unit = {
    graphicsContext.fillRect(0, 0, width, height)
  }
}
