import java.time.LocalDateTime;
import java.util.Scanner;
public class TaxTools {
        static boolean validNINumber(String NiNum) {
            if (NiNum.length() != 9) {
                return false;
            } else {
                String firsttwochar = NiNum.substring(0, 2).toUpperCase();
                String firstchar = NiNum.substring(0, 1).toUpperCase();
                String secondchar = NiNum.substring(1, 2).toUpperCase();
                String lastchar = NiNum.substring(NiNum.length() - 1).toUpperCase();
                if (NiNum.charAt(0) < 'A' || NiNum.charAt(0) > 'Z') {
                    return false;
                }else if (NiNum.charAt(1) < 'A' || NiNum.charAt(1) > 'Z') {
                    return false;
                }else if (firstchar.equals("D") || firstchar.equals("F")
                        || firstchar.equals("I") || firstchar.equals("Q")
                        || firstchar.equals("U") || firstchar.equals("V")) {
                    return false;
                } else if (secondchar.equals("D") || secondchar.equals("F")
                        || secondchar.equals("I") || secondchar.equals("Q")
                        || secondchar.equals("U") || secondchar.equals("V") || secondchar.equals("O")) {
                    return false;
                } else if (firsttwochar.equals("BG") || firsttwochar.equals("GB") || firsttwochar.equals("KN") ||
                        firsttwochar.equals("NK") || firsttwochar.equals("NT") || firsttwochar.equals("TN") ||
                        firsttwochar.equals("ZZ") || firsttwochar.equals("OO") || firsttwochar.equals("FY") ||
                        firsttwochar.equals("NC") || firsttwochar.equals("PP") || firsttwochar.equals("PZ")
                        || firsttwochar.equals("PY")) {
                    return false;}
                else if (!(lastchar.equals("A") ||
                        lastchar.equals("B") ||
                        lastchar.equals("C") ||
                        lastchar.equals("D"))) {
                    return false;
                } else {
                    for (int i = 2; i < 8; i++) {
                        if (!Character.isDigit(NiNum.charAt(i))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        static LocalDateTime startOfTaxYearForDate (LocalDateTime DateTime){

            int year = DateTime.getYear();
            LocalDateTime TaxStart = LocalDateTime.of(year, 4, 6, 0, 0);

            if (DateTime.isBefore(TaxStart)) {
                TaxStart = TaxStart.minusYears(1);
            }
            return TaxStart;
        }
}