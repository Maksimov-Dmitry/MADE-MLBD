import breeze.linalg._
import java.io._


object Dataset {
    def readcsv(filepath: String) : DenseMatrix[Double] = {
        val usageMatrix = csvread(file=new File(filepath), separator=',', skipLines=1)
        usageMatrix
    }

    def train_test_split(train: DenseMatrix[Double], test_size: Double) : (
        DenseMatrix[Double],
        DenseVector[Double],
        DenseMatrix[Double],
        DenseVector[Double]) = {
        val test_size_abs: Int = (train.rows.toFloat * test_size).toInt
        (train(test_size_abs to -1, 0 to -2),
         train(test_size_abs to -1, -1),
         train(0 to test_size_abs - 1, 0 to -2),
         train(0 to test_size_abs - 1, -1),
        )
    }

    def save_predict(predict: DenseVector[Double]) : Unit = {
        val FILE_PATH = "results/prediction.txt"
        val pw = new PrintWriter(FILE_PATH)

        predict.foreach(vec => pw.write(vec.toString() + "\n"))
        pw.close()
    }
}