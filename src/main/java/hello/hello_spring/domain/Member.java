package hello.hello_spring.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 회원 ID와 이름이 들어있는 모델
 * */
@Entity
public class Member {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
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
