package com.xql.clientmdb;

// pgseliso@gmail.com
// husnifahmi@outlook.com
// 2023-08-05

public class App {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080";
        // String baseUrl = "http://api001.multidb.net:8080";

        // List of virtual schemas
        String url = baseUrl + "/api/v1/schemas";
        ListSchemas listSchemas = new ListSchemas();
        listSchemas.setUrl(url);
        listSchemas.getSchemas();
        System.out.println();

        // List of database sources
        url = baseUrl + "/api/v1/dbconns";
        ListDbconns listDbconns = new ListDbconns();
        listDbconns.setUrl(url);
        listDbconns.getDbconns();
        System.out.println();

        // Cannot remove dbconn which is still being used by schemas
        // Remove schemas first before removing dbconns
        GetDbconnColumnList getDbconnColumnList = new GetDbconnColumnList();
        getDbconnColumnList.setBaseUrl(baseUrl);

        // incorrect input
        // 1. get list of columns from physical table: dbconn null, table null
        System.out.println("1. get list of columns from physical table: dbconn null, table null");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName(null);
        getDbconnColumnList.setTableName(null);

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 2. get list of columns from physical table: dbconn blank
        System.out.println("2. get list of columns from physical table: dbconn blank, table null");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("     ");
        getDbconnColumnList.setTableName("categories");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 3. get list of columns from physical table: table blank
        System.out.println("3. get list of columns from physical table: table blank");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("     ");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 4. get list of columns from physical table: dbconn blank, table blank
        System.out.println("4. get list of columns from physical table: dbconn blank, table blank");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("     ");
        getDbconnColumnList.setTableName("     ");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 5. get list of columns from physical table: table space
        System.out.println("5. get list of columns from physical table: table space");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("cate gories");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 6. get list of columns from physical table: table special char #
        System.out.println("6. get list of columns from physical table: table special char #");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("cate#gories");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 7. get list of columns from physical table: psql_northwind/categoriesx
        System.out.println("7. get list of columns from physical table: psql_northwind/categoriesx");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("categoriesx");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // incorrect input
        // 8. get list of columns from physical table: psql_northwind/categories/
        System.out.println("8. get list of columns from physical table: psql_northwind/categories/");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("categories/");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // correct input
        // 9. get list of columns from physical table: psql_northwind/categories
        System.out.println("9. get list of columns from physical table: psql_northwind/categories");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("psql_northwind");
        getDbconnColumnList.setTableName("categories");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // correct input
        // 10. get list of columns from physical table: mysql_northwind/employees
        System.out.println("10. get list of columns from physical table: mysql_northwind/employees");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("mysql_northwind");
        getDbconnColumnList.setTableName("employees");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // correct input
        // 11. get list of columns from physical table: csv_northwind/products
        System.out.println("11. get list of columns from physical table: csv_northwind/products");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("csv_northwind");
        getDbconnColumnList.setTableName("products");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // correct input
        // 12. get list of columns from physical table: ora_northwind/suppliers
        System.out.println("12. get list of columns from physical table: ora_northwind/suppliers");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("ora_northwind");
        getDbconnColumnList.setTableName("suppliers");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

        // correct input
        // 13. get list of columns from physical table: msq_northwind/orders
        System.out.println("13. get list of columns from physical table: msq_northwind/orders");
        url = baseUrl + "/api/v1/dbconns/";
        getDbconnColumnList.setUrl(url);
        getDbconnColumnList.setDbconnName("msq_northwind");
        getDbconnColumnList.setTableName("orders");

        getDbconnColumnList.getDbconnColumnList();
        System.out.println();

    }
}
