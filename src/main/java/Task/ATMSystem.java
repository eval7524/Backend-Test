/**
 * 정창민
 */
package Task;

import java.util.Scanner;

/**
 * 사용자가 출금 요청시, 잔액 부족 예외 처리를 하고, 출금을 하면 잔액을 출력하는 프로그램
 * 예외는 NumberFormatException, InsufficientBalanceException을 사용한다.
 */

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액 부족!");
        }
        balance -= amount;
        System.out.println("출금 완료! 남은 잔액 : " + balance);
    }

}

public class ATMSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000);
        Scanner scanner = new Scanner(System.in);
        System.out.print("출금할 금액 입력 : ");
        String input = scanner.nextLine();
        try {
            account.withdraw(Integer.parseInt(input));
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        } finally {
            scanner.close();
            System.out.println("거래 기록이 저장되었습니다.");
        }
    }
}