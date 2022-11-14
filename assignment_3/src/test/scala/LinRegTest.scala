import breeze.linalg._
import breeze.numerics.abs


class LinRegTest extends org.scalatest.funsuite.AnyFunSuite {
    test("LinReg.add_bias") {
        val train = DenseMatrix((1.0, 2.0), (3.0, 4.0), (5.0, 6.0))
        val actual = LinReg.add_bias(train)
        val expected = DenseMatrix((1.0, 1.0, 2.0), (1.0, 3.0, 4.0), (1.0, 5.0, 6.0))
        assert(all(actual :== expected))
    }
    test("LinReg.calculate_weights") {
        val x = DenseMatrix((1.0, 1.0, 2.0), (1.0, 4.0, -1.0), (1.0, 3.0, -3.0))
        val y = DenseVector(-5.0, 4.0, 7)
        val actual = LinReg.calculate_weights(x, y)
        val expected = DenseVector(-2.0, 1.0, -2.0)
        assert(max(abs(actual - expected)) < 1E-5)
    }
    test("LinReg.predict") {
        val x = DenseMatrix((1.0, 1.0, 2.0), (1.0, 4.0, -1.0), (1.0, 3.0, -3.0))
        val w = DenseVector(-2.0, 1.0, -2.0)
        val actual = LinReg.predict(x, w)
        val expected = DenseVector(-5.0, 4.0, 7)
        assert(all(actual :== expected))
    }
}
