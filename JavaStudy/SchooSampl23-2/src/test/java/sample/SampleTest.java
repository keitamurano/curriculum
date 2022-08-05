package sample;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleTest {
	//テスト対象クラス
	private Sample sample;
	
	//テスト開始前の準備
	@BeforeEach
	public void setUp() {
		sample = new Sample();
	}
	
	//テスト１：足し算テスト
	@Test
	public void test001() {
		//期待値（合格とする値）の準備
		int expected = 3;
		//実行結果の取得（メソッド等の実行）
		int actual = sample.add(1, 2);
		//実行結果と期待値の確認
		assertThat(actual, is(expected));
	}
	
	//テスト２：割り算テスト
	@Test
	public void test002() {
		//期待値の準備
		int expected = 2;
		//実行結果の取得（メソッド等の実行）
		int actual = sample.div(4, 2);
		//実行結果と期待値の確認
		assertThat(actual, is(expected));
	}
	
	//テスト２：割り算テスト（異常値）
	//divメソッドは第2引数に0が入るとマイナス1を返却する
	//という仕様を検証することが目的
	@Test
	public void test003() {
		//期待値の準備
		int expected = -1;
		//実行結果の取得（メソッド等の実行）
		int actual = sample.div(4,  0);
		//実行結果と期待値の確認
		assertThat(actual, is(expected));
	}
}
