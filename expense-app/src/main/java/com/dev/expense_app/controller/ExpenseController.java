package com.dev.expense_app.controller;

import com.dev.expense_app.entity.Expense;
import com.dev.expense_app.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(Pageable page) {
        return expenseService.getAllExpenses(page).toList();
//        int number =1;
//        calculateFactorial(number);
        //toList() -> convert Page to List<Expense> return type
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense){
        //System.out.println("Printing the expense details: "+ expense);
        return expenseService.saveExpenseDetails(expense);
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id){
        return expenseService.updateExpenseDetails(id, expense);
    }

    //general exception handler
    //A recursion program can create exception
    //public int calculateFactorial(int number){
        //return number * calculateFactorial(number - 1);
    //}

    @GetMapping("/expenses/category")
    public  List<Expense> getExpenseByCategory(@RequestParam String category, Pageable page){
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page){
        return expenseService.readByName(keyword, page);
    }

    @GetMapping("/expenses/date")
    public List<Expense> getExpensesByDate(
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            Pageable page){
        return expenseService.readByDate(startDate, endDate, page);
    }
}
