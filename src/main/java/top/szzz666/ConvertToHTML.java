package top.szzz666;

import java.util.HashMap;
import java.util.Map;

public class ConvertToHTML {
    public static String convertToHTML(String input) {

        HashMap<Character, String> styleMap = new HashMap<>();

        for (Map.Entry<String, String> entry : InitConfig.getStyleMap().entrySet()) {
            char keyChar = entry.getKey().charAt(0); // 获取键的第一个字符
            String value = entry.getValue();
            styleMap.put(keyChar, value); // 将键值对存入colorMap
        }

        StringBuilder output = new StringBuilder();
        boolean isFormattingCode = false;
        int x = 0;

        for (char c : input.toCharArray()) {
            if (c == '§') {
                isFormattingCode = true;
            } else if (isFormattingCode && styleMap.containsKey(c)) {
                output.append("<span style=\"").append(styleMap.get(c)).append("\">");
                isFormattingCode = false;
                x++;
            }
            else if (isFormattingCode) {
                isFormattingCode = false; // 忽略未找到对应颜色的格式化代码
            } else {
                output.append(c);
            }
        }
        for (int i = 0; i < x; i++) {
            output.append("</span>");
        }

        return output.toString();
    }


}