package Questao2.BranchAndBound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Node {
    private int level, profit, bound;
    private float weight;

    public Node(int level, int profit, int bound) {
    }
}