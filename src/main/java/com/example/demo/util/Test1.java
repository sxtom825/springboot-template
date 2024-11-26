package com.example.demo.util;

 public record  Test1(Integer id,String name,String email,Integer age){


  public static void main(String[] args) {
   Test1 lisi = new Test1(1001, "lisi", "lisi@qq.com", 20);
   System.out.println(lisi.toString());

   //定义 Java Record
   record SaleRecord(String saleId, String ProductName, Double money) {
   }

   //创建 Local Record
   SaleRecord saleRecord = new SaleRecord("S001", "显示器", 3000.01);
   //使用 SaleRecord
   System.out.println("saleRecord = " + saleRecord);

   Test2.Address address = new Test2.Address("大连", "旅顺口区兴发路216号", "10010");
   Test2.PhoneNumber phoneNumber = new Test2.PhoneNumber("010", "400-8080-105");
   Test2.Customer customer = new Test2.Customer("C1001", "李四", phoneNumber, address);
   System.out.println("customer = " + customer);
   String number = customer.phoneNumber().number();
   System.out.println("number = " + number);
   String address1 = customer.address().address();
   System.out.println("address1 = " + address1);


  }

}
