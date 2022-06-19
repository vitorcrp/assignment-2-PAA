package Questao2.BranchAndBound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Vertex {
    private int level, profit, bound;
    private float weight;

    public Vertex(int level, int profit, int bound) {
    }
}