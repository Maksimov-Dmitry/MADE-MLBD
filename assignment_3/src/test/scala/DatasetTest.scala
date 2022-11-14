import breeze.linalg._


class DatasetTest extends org.scalatest.funsuite.AnyFunSuite {
    test("Dataset.train_test_split") {
        val train = DenseMatrix.ones[Double](12, 5)
        val (x_train, y_train, x_val, y_val) = Dataset.train_test_split(train, 0.25)
        assert(x_train.rows == 9)
        assert(x_train.cols == 4)
        assert(x_val.rows == 3)
        assert(x_val.cols == 4)

        assert(y_train.length == 9)
        assert(y_val.length == 3)
    }
}
