package abstracts;

public class Trainee extends JavaCurriculumTrainee {

	public Trainee(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void doJavaCurriculum() {
		System.out.println("わたくし、" + super.getName() + "は、Javaカリキュラムをこなします(｀･ω･´)ゞ！" );
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
