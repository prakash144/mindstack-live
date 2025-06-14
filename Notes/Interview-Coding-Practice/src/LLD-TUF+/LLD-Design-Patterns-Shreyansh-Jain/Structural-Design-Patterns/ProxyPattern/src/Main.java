/*

    +-----------------------------+    'is-a'      +--------------------------+
    |       EmployeeDao           |<---------------|  EmployeeDaoImpl         |
    |    (Interface)              |                +--------------------------+
    +-----------------------------+                              |
           ^                                                   'has-a'
           |                                                     v
    +-----------------------------+   'is-a'       +--------------------------+
    |    EmployeeDaoProxy         |<---------------|  EmployeeDaoImpl         |
    |  (Proxy - Adapter)          |                +--------------------------+
    +-----------------------------+
           |
           v
    +-----------------------------+   'is-a'        +-------------------------+
    |        EmployeeDo           |<----------------| EmployeeDaoProxy        |
    |     (Data Object)           |                 +-------------------------+
    +-----------------------------+

EmployeeDao Interface: Defines the operations for create, delete, and get employee.
EmployeeDaoImpl (is-a relation): Implements the actual logic of employee operations.
EmployeeDaoProxy (has-a relation): Uses EmployeeDaoImpl to enforce access control by acting as a proxy. The EmployeeDaoProxy is an Adapter that allows only ADMIN clients to perform create and delete operations, while both ADMIN and EMPLOYEE can perform get operations.
EmployeeDo: Represents the data object of an Employee.


 */

public class Main {
    public static void main(String[] args) {
//        Use for Access restriction, caching and pre-procession and post-processing
        try{
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("ADMIN", new EmployeeDo());
            System.out.println("Operation successful");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}