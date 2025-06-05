public class EmployeeDaoProxy implements EmployeeDao {

    EmployeeDao employeeDaoObj;

    EmployeeDaoProxy() {
        employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        if(client.equals("ADMIN")) {
            employeeDaoObj.create(client, obj);
        }
        throw new Exception("Access denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN")) {
            employeeDaoObj.delete(client, employeeId);
        }
        throw new Exception("Access denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        if(client.equals("ADMIN") || client.equals("EMPLOYEE")) {
            return employeeDaoObj.get(client, employeeId);
        }
        throw new Exception("Access denied");
    }
}
