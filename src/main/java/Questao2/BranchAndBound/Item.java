package Questao2.BranchAndBound;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Item {
    private float weight;
    private int value;
}
