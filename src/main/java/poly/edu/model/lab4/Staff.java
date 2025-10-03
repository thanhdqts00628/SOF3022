package poly.edu.model.lab4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Staff {

    private String id;

    private String name;

    @Builder.Default
    private String photo = "no-photo.jpg";

    @Builder.Default
    private boolean gender = false;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Builder.Default
    private Date dob = new Date();

    @Builder.Default
    private double salary = 123.456;

    @Builder.Default
    private Integer level = 0;
}
