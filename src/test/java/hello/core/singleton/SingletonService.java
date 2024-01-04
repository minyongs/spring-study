package hello.core.singleton;

public class SingletonService {
    //자기자신을 private , static 으로 가지고 있음 -> 클래스 레벨로 올라감
    private static final SingletonService instance = new SingletonService();

    //조회
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}


