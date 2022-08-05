package sample;


/**
 * 単体テストの検査対象クラス
 */
public class Sample {
	/**
	 * 加算処理
	 * @param number1 第1引数
	 * @param number2 第2引数
	 * @return 加算結果
	 */
	public int add(int number1, int number2) {
		return number1 + number2;
	}
	
	/**
	 * 除算処理
	 * @param number1 第1引数
	 * @param number2 第2引数
	 * @return 除算結果
	 */
	public int div(int number1, int number2) {
		//第2引数のチェック
		if(number2 == 0) {
			return -1;
		} else {
			return number1 / number2;
		}
	}
}
