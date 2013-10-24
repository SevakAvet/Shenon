import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shenon {
    private static HashMap<Character, Double> entropies = new HashMap<>();

    private double sum = 0;
    private List<Double> curEntrList = new ArrayList<>();
    private char[] args;
    private double entropy = -1;

    static {
        entropies.put(' ', 0.099);
        entropies.put('Î', 0.080);
        entropies.put('Å', 0.072);
        entropies.put('¨', 0.072);
        entropies.put('À', 0.062);
        entropies.put('È', 0.062);
        entropies.put('Ò', 0.053);
        entropies.put('Í', 0.053);
        entropies.put('Ñ', 0.045);
        entropies.put('Ð', 0.040);
        entropies.put('Â', 0.038);

        entropies.put('Ë', 0.035);
        entropies.put('Ê', 0.028);
        entropies.put('Ì', 0.026);
        entropies.put('Ä', 0.025);
        entropies.put('Ï', 0.023);
        entropies.put('Ó', 0.021);
        entropies.put('ß', 0.018);
        entropies.put('Û', 0.016);
        entropies.put('Ç', 0.016);
        entropies.put('Ü', 0.014);
        entropies.put('Ú', 0.014);

        entropies.put('Á', 0.014);
        entropies.put('Ã', 0.012);
        entropies.put('×', 0.012);
        entropies.put('É', 0.010);
        entropies.put('Õ', 0.009);
        entropies.put('Æ', 0.007);
        entropies.put('Þ', 0.006);
        entropies.put('Ø', 0.006);
        entropies.put('Ö', 0.004);
        entropies.put('Ù', 0.003);
        entropies.put('Ý', 0.003);
        entropies.put('Ô', 0.002);
    }

    public Shenon(String arg) {
        args = new char[arg.length()];

        arg = arg.toUpperCase();

        for (int i = 0; i < arg.length(); ++i) {
            args[i] = arg.charAt(i);
        }

        calcEntropy();
    }

    private void calcEntropy() {
        entropy = 0;

        for (char s : args) {
            double curEntr = entropies.get(s);

            curEntrList.add(curEntr);
            sum += curEntr;
        }

        for (int i = 0; i < curEntrList.size(); ++i) {
            curEntrList.set(i, curEntrList.get(i) / sum);

            double cur = curEntrList.get(i);
            entropy += cur * Math.log(cur);
        }

        entropy *= -1;
    }

    public double getEntropy() {
        return entropy;
    }

    public double getAmount() {
        return entropy * curEntrList.size();
    }

}
