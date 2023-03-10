public class CreditDataWrite {
    static void writeData(CreditData credit, String[] inputData) throws Exception {
        if (Double.parseDouble(inputData[0]) <= 0
                || Double.parseDouble(inputData[1]) <= 0
                || Double.parseDouble(inputData[2]) < 0) {
            throw new Exception("Incorrect numerical data");
        } else if (!(inputData[3].trim().equals("business") || inputData[3].trim().equals("human"))) {
            throw new Exception("Incorrect credit type");
        } else if ((inputData[3].trim().equals("human")
                && Double.parseDouble(inputData[0]) * (1 + Double.parseDouble(inputData[2]) / 100) > 12 * Double.parseDouble(inputData[1])
                && ((Double.parseDouble(inputData[0]) * (1 + Double.parseDouble(inputData[2]) / 100) -
                12 * Double.parseDouble(inputData[1])) * (1 + Double.parseDouble(inputData[2]) / 100)) >= Double.parseDouble(inputData[0]))
                || (inputData[3].trim().equals("business") && Double.parseDouble(inputData[0]) > 12 * Double.parseDouble(inputData[1])
                && ((Double.parseDouble(inputData[0]) - 12 * Double.parseDouble(inputData[1])) *
                (1 + Double.parseDouble(inputData[2]) / 100)) >= Double.parseDouble(inputData[0]))) {
            throw new Exception("Impossible to pay");
        } else {
            credit.credit = Double.parseDouble(inputData[0]);
            credit.pay = Double.parseDouble(inputData[1]);
            credit.percent = Double.parseDouble(inputData[2]);
            credit.type = inputData[3].trim();
        }
    }
}