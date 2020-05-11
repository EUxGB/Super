package StepikFinishProject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {

        MailMessage[] messages = {
                new MailMessage("Stiv", "Robin", "Hello friend, how are you"),
                new MailMessage("Stiv", "Mickael", "Так не пойдет, возвращаемся к первому варианту"),
                new MailMessage("Mickael", "Stiv", "Согласен, но как быть с заказчиком"),
                new MailMessage("Stiv", "Mickael", "Do not worry, i will solve this problem")
        };

                Salary salary1 = new Salary("Amazon", "Stiv", 15_000);
                Salary salary2 = new Salary("Google", "Stiv", 10_000);
                Salary salary3 = new Salary("SBER", "Mickael", 150);
                Salary salary4 = new Salary("Amazon", "Robin", 1_500);
                Salary salary5 = new Salary("SVN", "Robin", 20_000);

        List<MailMessage> mailMessageList1 = Arrays.asList(messages);

        MailService<String> mailService = new MailService<>();
        mailMessageList1.stream().forEachOrdered(mailService); //Consumer принимает занчение и ничего не отдает

        Map<String, List<String>> mailBox = mailService.getMailBox();// Supplier не принимает значение а отдает


        // Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();
        Arrays.asList(salary1,salary2,salary3,salary4,salary5).forEach(salaryService);


// Обработка списка зарплат почтовым сервисом


    }
}
