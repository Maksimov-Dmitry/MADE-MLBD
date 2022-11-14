object Main extends App {
    val TEST_SIZE = 0.3
    val train_path = args(0)
    val test_path = args(1)
    val train = Dataset.readcsv(train_path)
    val test = Dataset.readcsv(test_path)

    val train_with_bias = LinReg.add_bias(train)
    val test_with_bias = LinReg.add_bias(test)

    val (x_train, y_train, x_val, y_val) = Dataset.train_test_split(train_with_bias, TEST_SIZE)

    val weights = LinReg.calculate_weights(x_train, y_train)
    val val_predict = LinReg.predict(x_val, weights)
    Evaluation.save_metrics(y_val, val_predict)

    val test_predict = LinReg.predict(test_with_bias, weights)
    Dataset.save_predict(test_predict)
}
