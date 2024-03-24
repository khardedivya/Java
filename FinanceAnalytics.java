import java.util.*;

// Model classes
class Budget {
    private String category;
    private double amount;

    public Budget(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    // Getters and setters
}

class Expense {
    private String category;
    private double amount;
    private Date date;

    public Expense(String category, double amount, Date date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
}

class Investment {
    private String name;
    private double amount;
    private Date date;

    public Investment(String name, double amount, Date date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
}

// Service classes
class BudgetService {
    private List<Budget> budgets;

    public BudgetService() {
        this.budgets = new ArrayList<>();
    }

    public void addBudget(Budget budget) {
        budgets.add(budget);
    }

    public List<Budget> getBudgets() {
        return budgets;
    }
}

class ExpenseService {
    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}

class InvestmentService {
    private List<Investment> investments;

    public InvestmentService() {
        this.investments = new ArrayList<>();
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    public List<Investment> getInvestments() {
        return investments;
    }
}

// Controller classes
class BudgetController {
    private BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    public void addBudget(String category, double amount) {
        Budget budget = new Budget(category, amount);
        budgetService.addBudget(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetService.getBudgets();
    }
}

class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void addExpense(String category, double amount, Date date) {
        Expense expense = new Expense(category, amount, date);
        expenseService.addExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseService.getExpenses();
    }
}

class InvestmentController {
    private InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    public void addInvestment(String name, double amount, Date date) {
        Investment investment = new Investment(name, amount, date);
        investmentService.addInvestment(investment);
    }

    public List<Investment> getAllInvestments() {
        return investmentService.getInvestments();
    }
}

// Main application class
public class FinancialAnalysisApp {
    public static void main(String[] args) {
        // Initialize services and controllers
        BudgetService budgetService = new BudgetService();
        ExpenseService expenseService = new ExpenseService();
        InvestmentService investmentService = new InvestmentService();

        BudgetController budgetController = new BudgetController(budgetService);
        ExpenseController expenseController = new ExpenseController(expenseService);
        InvestmentController investmentController = new InvestmentController(investmentService);

        // Start application logic here
        // For example, add budgets, expenses, and investments
        budgetController.addBudget("Food", 500.00);
        budgetController.addBudget("Transportation", 200.00);
        expenseController.addExpense("Groceries", 80.00, new Date());
        expenseController.addExpense("Transportation", 50.00, new Date());
        investmentController.addInvestment("Stocks", 1000.00, new Date());

        // Retrieve and display data
        List<Budget> budgets = budgetController.getAllBudgets();
        List<Expense> expenses = expenseController.getAllExpenses();
        List<Investment> investments = investmentController.getAllInvestments();

        // Display budgets, expenses, and investments
        System.out.println("Budgets:");
        for (Budget budget : budgets) {
            System.out.println(budget.getCategory() + ": $" + budget.getAmount());
        }

        System.out.println("\nExpenses:");
        for (Expense expense : expenses) {
            System.out.println(expense.getCategory() + ": $" + expense.getAmount() + " (Date: " + expense.getDate() + ")");
        }

        System.out.println("\nInvestments:");
        for (Investment investment : investments) {
            System.out.println(investment.getName() + ": $" + investment.getAmount() + " (Date: " + investment.getDate() + ")");
        }
    }
}
