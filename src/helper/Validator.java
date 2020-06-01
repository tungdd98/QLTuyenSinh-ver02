package helper;

import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tungdd
 */
public class Validator {

    private String value;
    private String[] rules;
    private String field;
    private String text;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getRules() {
        return rules;
    }

    public void setRules(String[] rules) {
        this.rules = rules;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Validator(String value, String[] rules, String field) {
        this.value = value;
        this.rules = rules;
        this.field = field;
    }

    public Validator() {
    }

    public boolean required(String value) {
        if (!"".equals(value) && value != null) {
            return true;
        }
        return false;
    }

    public boolean isInteger(String value) {
        String regex = "^[0-9]*$";
        return Pattern.matches(regex, value);
    }
    
    public boolean isDecimal(String value) {
        String regex = "^[1-9][0-9]*(\\.[0-9]+)?$";
        return Pattern.matches(regex, value);
    }

    public boolean isString(String value) {
        String regex = "^[^0-9]*$";
        return Pattern.matches(regex, value);
    }

    public boolean isScore(String value) {
        String regex = "^[1-9][0-9]*(\\.[0-9]+)?$";

        if (Pattern.matches(regex, value)) {
            if (Float.parseFloat(0 + value) >= 0 && Float.parseFloat(0 + value) <= 10) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean validate(JFrame home) {
        boolean isSuccess = true;
        int size = rules.length;

        for (int i = 0; i < size; i++) {
            String rule = rules[i];
            switch (rule) {
                case "required":
                    if (!required(value)) {
                        isSuccess = false;
                        JOptionPane.showMessageDialog(home, field + " không được để trống");
                    }
                    break;
                case "isInteger":
                    if (!isInteger(value)) {
                        isSuccess = false;
                        JOptionPane.showMessageDialog(home, field + " phải là số");
                    }
                    break;
                case "isString":
                    if (!isString(value)) {
                        isSuccess = false;
                        JOptionPane.showMessageDialog(home, field + " phải là chữ");
                    }
                    break;
                case "isScore":
                    if (!isScore(value)) {
                        isSuccess = false;
                        JOptionPane.showMessageDialog(home, field + " không hợp lệ");
                    }
                    break;
                case "isDecimal":
                    if (!isDecimal(value)) {
                        isSuccess = false;
                        JOptionPane.showMessageDialog(home, field + " không hợp lệ");
                    }
                    break;
            }
        }

        return isSuccess;
    }

    public boolean setTextField(JFrame home) {
        if (validate(home)) {
            text = value;
            return true;
        }

        return false;
    }
}
