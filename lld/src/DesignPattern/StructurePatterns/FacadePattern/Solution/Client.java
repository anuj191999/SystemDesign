package DesignPattern.StructurePatterns.FacadePattern.Solution;

import DesignPattern.StructurePatterns.FacadePattern.Problem.OrderService;
import DesignPattern.StructurePatterns.FacadePattern.Problem.PaymentService;
import DesignPattern.StructurePatterns.FacadePattern.Problem.UserService;

public class Client {
    public static void main(String[] args) {
        APIGateway apiGateway = new APIGateway();
        System.out.println(apiGateway.getFullOrderDetails("123","456","789"));
    }
}
