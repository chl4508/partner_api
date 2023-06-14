package cys.partner.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "test_id")
    private UUID testId;

    @Column(name="test_name", length = 50, nullable = false)
    private String testName;

    @Column(name="test_desc", length = 200, nullable = false)
    private String testDesc;

    public Test(){}

    public Test(String testName, String testDesc){
        this.testId = UUID.randomUUID();
        this.testName = testName;
        this.testDesc = testDesc;
    }
}
