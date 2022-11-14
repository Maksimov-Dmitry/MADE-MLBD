import breeze.linalg._
import breeze.numerics.pow
import java.io.PrintWriter


object Evaluation {
    def save_metrics(actual: DenseVector[Double], predict: DenseVector[Double]) : Unit = {
        val FILE_PATH = "results/metrics.txt"
        val mse = this.mse(actual, predict)
        val pw = new PrintWriter(FILE_PATH)
        pw.write("MSE: " + mse.toString)
        pw.close()
    }

    def mse(actual: DenseVector[Double], predict: DenseVector[Double]) : Double = {
        val mse = sum(pow(actual - predict, 2)) / actual.length
        mse
    }
}
