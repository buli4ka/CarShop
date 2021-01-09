package auto.shop.project.dto;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.CopyOnWriteArrayList;

@Data
@Builder
public class CarDto {

    private Integer Id;
    private String CarModel;
    private float CarPrice;
    private String CarDescription;


}
