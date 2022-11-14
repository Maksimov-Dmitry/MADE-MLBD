import breeze.linalg._


object LinReg {
    def add_bias(matrix: DenseMatrix[Double]) : DenseMatrix[Double] = {
        val bias_matrix = DenseMatrix.ones[Double](matrix.rows, matrix.cols + 1)
        bias_matrix(::, 1 to -1) := matrix
        bias_matrix
    }

    def calculate_weights(X: DenseMatrix[Double], y: DenseVector[Double]) : DenseVector[Double] = {
        val weights = inv(X.t * X) * X.t * y
        weights
    }

    def predict(X: DenseMatrix[Double], w: DenseVector[Double]) : DenseVector[Double] = {
        val predict = X * w
        predict
    }
}
