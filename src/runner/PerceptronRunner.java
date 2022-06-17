package runner;

import model.Perceptron;

import static java.lang.Math.abs;

public class PerceptronRunner {

    /* AND */
    private static Double[][][] database = {
            { { 0D, 0D }, { 0D } },
            { { 0D, 1D }, { 0D } },
            { { 1D, 0D }, { 0D } },
            { { 1D, 1D }, { 1D } }
    };


    /* XOR
    private static Double[][][] database = {
            { { 0D, 0D }, { 0D } },
            { { 0D, 1D }, { 1D } },
            { { 1D, 0D }, { 1D } },
            { { 1D, 1D }, { 0D } }
    };
    */

    /* OR
    private static Double[][][] database = {
            { { 0D, 0D }, { 0D } },
            { { 0D, 1D }, { 1D } },
            { { 1D, 0D }, { 1D } },
            { { 1D, 1D }, { 1D } }
    };
    */

    /* Robô
    private static Double[][][] database = {
            { { 0D, 0D, 0D }, { 1D, 1D } },
            { { 0D, 0D, 1D }, { 0D, 1D } },
            { { 0D, 1D, 0D }, { 1D, 0D } },
            { { 0D, 1D, 1D }, { 0D, 1D } },
            { { 1D, 0D, 0D }, { 1D, 0D } },
            { { 1D, 0D, 1D }, { 1D, 0D } },
            { { 1D, 1D, 0D }, { 1D, 0D } },
            { { 1D, 1D, 1D }, { 1D, 0D } }
    }; */

    public static void main(String[] args) {
        final Double NI = 0.1;
        final int N_EPOCAS = 1000;

        Perceptron perceptron = new Perceptron(database[0][0].length, database[0][1].length, NI);
        Double erroEp = 0D, erroAm = 0D;

        for(int e = 0; e < N_EPOCAS; e++) {
            erroEp = 0D;
            for (Double[][] sample : database) {
                Double[] x = sample[0];
                Double[] y = sample[1];
                Double[] out = perceptron.learn(x, y);

                erroAm = sumErro(y, out);
                erroEp += erroAm;
            }

            System.out.printf("Época: %s - Erro: %6f\n", (e+1), erroEp);
        }
    }

    private static Double sumErro(Double[] y, Double[] out) {
        double sum = 0D;
        for(int i = 0; i < y.length; i++) {
            sum += abs(y[i] - out[i]);
        }

        return sum;
    }
}
