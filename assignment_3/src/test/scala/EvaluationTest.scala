import breeze.linalg._


class EvaluationTest extends org.scalatest.funsuite.AnyFunSuite {
    test("Evaluation.mse") {
        val actual_y = DenseVector[Double](1, 2, 3, 4)
        assert(Evaluation.mse(actual_y, DenseVector[Double](1, 2, 3, 4)) == 0)
        assert(Evaluation.mse(actual_y, DenseVector[Double](3, 2, 3, -2)) == 10)
    }
}
