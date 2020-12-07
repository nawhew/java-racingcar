package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String splitRegex = " ";
    
    private List<String> inputList;
    private int baseValue = 0;
    private int differentValue = 0;
    private String mark;

    public StringCalculator(String input) {
        this.inputList = this.splitInput(input);
    }

    /**
     * 입력 값을 쪼개어 리스트에 담습니다.
     * @param input
     * @return
     */
    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(StringCalculator.splitRegex));
    }

    /**
     * 입력 된 문자열 값을 계산합니다.
     * @return
     */
    public int calculate() {
        for (int i = 0 ; i < this.inputList.size() ; i++) {
            this.saveValueAndMark(this.inputList.get(i).trim(), i);
            executeCalculate(i);
        }
        return this.baseValue;
    }

    /**
     * 숫자 값 혹은 연산기호를 저장합니다.
     * @param input
     * @param index
     */
    public void saveValueAndMark(String input, int index) {
        System.out.println("set value : " + input);
        if(this.isCalculateIndex(index)) {
            this.differentValue = Integer.parseInt(input);
            return;
        }

        if(this.isNumberDataIndex(index)) {
            this.baseValue = Integer.parseInt(input);
            return;
        }

        this.mark = input;
    }

    /**
     * 숫자가 와야하는 인덱스인지 체크
     *  : 짝수 일 때 숫자가 와야한다.
     * @param index 
     * @return
     */
    public boolean isNumberDataIndex(int index) {
        return index % 2 == 0;
    }

    /**
     * 계산해야하는 인덱스인지 체크
     *  : 인덱스가 0이 아니여야함
     *  && this.isNumberDataIndex == true
     * @param index 
     * @return
     */
    public boolean isCalculateIndex(int index) {
        return index != 0 && this.isNumberDataIndex(index);
    }

    /**
     * 계산해야하는 인덱스이면 모인 값으로 계산합니다.
     * @param i
     */
    private void executeCalculate(int i) {
        if (this.isCalculateIndex(i)) {
            System.out.printf("f:%s, b:%s, m:%s" ,this.baseValue, this.differentValue, this.mark);
            this.baseValue = this.selectAndExecuteCalculation(this.baseValue, this.differentValue, this.mark);
        }
    }

    /**
     * 사칙연산을 선택하여 호출합니다.
     * @param a
     * @param b
     * @param mark
     * @return calculate result
     */
    public int selectAndExecuteCalculation(int a, int b, String mark) {
        if("+".equals(mark)) {
            return this.add(a, b);
        }
        throw new IllegalArgumentException("입력값의 기호가 사칙연산 기호가 아닙니다.");
    }

    /**
     * 두 수를 더합니다.
     * @param a
     * @param b
     * @return a + b
     */
    public int add(int a, int b) {
        return a + b;
    }


}