package model;

import math.MathUtils;

import java.util.Random;

public class Perceptron {
    private Double ni;
    private int qtdIn;
    private int qtdOut;
    private Double[][] w;
    private Double[][] deltaW;

    private final static Double RANGE_MIN = -0.3;
    private final static Double RANGE_MAX = 0.3;

    public Perceptron(int qtdIn, int qtdOut, Double ni) {
        this.qtdIn = qtdIn;
        this.qtdOut = qtdOut;
        this.ni = ni;
        this.w = new Double[qtdIn + 1][qtdOut];
        this.deltaW = new Double[qtdIn + 1][qtdOut];

        // TODO gerar os pesos aleatórios
        this.gerarRandomW();
    }

    private void gerarRandomW() {
        Random random = new Random();
        for(int i = 0; i < w.length; i++) {
            for(int j = 0; j < w[0].length; j++) {
                double randomValue = random.nextDouble() * (RANGE_MAX - RANGE_MIN) + RANGE_MIN;
            }
        }

    }

    public Double[] learn(Double[] xIn, Double[] y) {
        Double[] x = new Double[xIn.length + 1];

        // copiar xIn em x e colocar x[x.length - 1] = 1
        Double[] out = new Double[y.length];
        for (int j = 0; j < y.length; j++) {
            double u = 0;
            for (int i = 0; i < x.length; i++) {
                u += x[i] * w[i][j];
            }
            // TODO testar a função sig (1/1+e^(-u))
            out[j] = MathUtils.sig(u);
        }

        for (int j = 0; j < y.length; j++) {
            for (int i = 0; i < x.length; i++) {
                w[i][j] += ni + (y[j] - x[j]) * x[i];
            }
        }
        return out;
    }
}