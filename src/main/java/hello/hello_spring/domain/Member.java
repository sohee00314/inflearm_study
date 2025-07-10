package hello.hello_spring.domain;
/**
 * 회원 ID와 이름이 들어있는 모델
 * */
public class Member {
    private long Id;
    private String name;

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        this.Id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
