public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        System.out.println("Employee created");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("Employee deleted");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("Employee get");
        return new EmployeeDo();
    }
}
