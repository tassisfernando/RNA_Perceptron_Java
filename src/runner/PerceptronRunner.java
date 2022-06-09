package runner;

import model.Perceptron;

public class PerceptronRunner {

    private static Double[][][] baseE = new Double[][][]{
            { {0D, 0D}, {0D} },
            { {0D, 1D}, {0D} },
            { {1D, 0D}, {0D} },
            { {1D, 1D}, {1D} },
    };

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron(2, 1, 0.1);
        Double erroEp = 0D, erroAm = 0D;

        for(int e = 0; e < 1000; e++) {
            erroEp = 0D;
            for(int a = 0; a < baseE.length; a++) {
                Double[] x = baseE[a][0];
                Double[] y = baseE[a][1];
                Double[] out = perceptron.learn(x, y);

                //TODO calcular o erro da amostra
                //erroAm = somatorio(mod | yj - Tetaj |) j=0 -> K

                erroEp += erroAm;
            }

            System.out.printf("Época: %s - Erro: %s", e, erroEp);
        }
    }
}
