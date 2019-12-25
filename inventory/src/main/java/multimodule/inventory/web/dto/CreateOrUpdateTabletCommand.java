package multimodule.inventory.web.dto;

import lombok.Getter;
import lombok.Setter;
import multimodule.inventory.model.Tablet;

@Getter
@Setter
public class CreateOrUpdateTabletCommand {
    private String applicationAccount;

    public Tablet toTablet() {
        Tablet tablet =  new Tablet();
        tablet.setApplicationAccount(tablet.getApplicationAccount());
        return tablet;
    }
}
