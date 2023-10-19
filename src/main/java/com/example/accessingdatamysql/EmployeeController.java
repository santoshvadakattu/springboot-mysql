package com.example.accessingdatamysql;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.format.annotation.DateTimeFormat;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/employee") // This means URL's start with /demo (after Application path)
public class EmployeeController {

	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private SalaryRepository salaryRepository;
	
	@Autowired
	private Salaries1Repository salaries1Repository;
	
	@Autowired
	private EmployeePortalRepository employeeportalRepository;
	
	@Autowired
	private HolidaysRepository holidaysRepository;

	@Autowired
	private PaymentsRepository paymentRepository;

	@Autowired
	private LeavesRepository leavesRepository;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date doj;

	private QueryService myService;

	@Autowired
	public EmployeeController(QueryService myService) {
		this.myService = myService;
	}

	@PostMapping(path = "/create") // Map ONLY POST Requests
	public String addNewEmployee(@RequestParam String name, @RequestParam String depName, @RequestParam String salary,
			Model model) {
		// @RequestParam String city,@RequestParam Date doj,
		// @RequestParam String street, @RequestParam String state, @RequestParam String
		// leavesTaken
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		System.out.println("entered the create Employee method");
		Employee emp = new Employee();
		// int idNum = Integer.parseInt(id);
		// emp.setId(idNum);
		emp.setName(name);

		System.out.println("depName is : " + depName);
		Department dep = new Department();

		dep.setName(depName);
		departmentRepository.save(dep);

		Address address = new Address();
		// address.setStreet(street);
		// address.setCity(city);
		// address.setState(state);
		addressRepository.save(address);

		Salary salObj = new Salary();
		// int leaves = Integer.parseInt(leavesTaken);
		int sal = Integer.parseInt(salary);

		// salObj.setLeavesTaken((long) leaves);
		// salObj.setDoj(doj);
		salObj.setSalary((long) sal);
		salaryRepository.save(salObj);

		emp.setDepartment(dep);
		emp.setAddress(address);
		emp.setSalary(salObj);
		employeeRepository.save(emp);
		System.out.println("Employee has been created!");
		model.addAttribute("employee", emp);

		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("reqHtml", "Employee with the name " + name + "  has been created!");
		model.addAttribute("employeeList", jsonObj);
		return "emplist";
	}

	@GetMapping(path = "/create")
	public String greetingForm(Model model) {
		System.out.println("inside get create employee method");
		model.addAttribute("employee", new Employee());
		return "empcreate";
	}
	
	@GetMapping(path = "/employeeportal")
	public String employeedetails(Model model) {
		System.out.println("inside get create employee method");
		model.addAttribute("employee", new Employee());
		return "employeeportal";
	}
	
	@PostMapping(path="/employeeportal")
	public String addNewEmployee(@ModelAttribute EmployeePortal employeeportalForm, Model model) {

	    // Create a new Employee object and set its attributes based on the registration form data

	    EmployeePortal employee = new EmployeePortal();
	    employee.setFirstname(employeeportalForm.getFirstname() + " , " + employeeportalForm.getSurname());
	    employee.setPrimarymobileno(employeeportalForm.getPrimarymobileno() + " , " + employeeportalForm.getSecondarymobileno());
	    employee.setEmailid(employeeportalForm.getEmailid());
	    employee.setSex(employeeportalForm.getSex());
	    employee.setAadharno(employeeportalForm.getAadharno());
	    employee.setAddress(employeeportalForm.getAddress());
	    employee.setLandmark(employeeportalForm.getLandmark());
	    employee.setZipcode(employeeportalForm.getZipcode());
	    employee.setDoj(employeeportalForm.getDoj());
	    employee.setProjectname(employeeportalForm.getProjectname());
	    employee.setProjectallocationdate(employeeportalForm.getProjectallocationdate());
	    employee.setWorktype(employeeportalForm.getWorktype());
	    employee.setMonthlysalary(employeeportalForm.getMonthlysalary());
	    employee.setWorkallocationdays(employeeportalForm.getWorkallocationdays());

	    // Save the new employee to the database

	    employeeportalRepository.save(employee);

	    // Redirect to the employee info tab or list page

	    return "employeeinformation"; // Replace with the appropriate URL

	}
	
	
	@GetMapping("/employeeinformation")

	public String displayEmployeeInfo(Model model) {

	    // Fetch all employeeportal data from the database

	    List<EmployeePortal> employeeportals = employeeportalRepository.findAll();

	    // Pass the employeeportal data to the Thymeleaf template

	    model.addAttribute("employeeportals", employeeportals);

	    return "employeeinformation"; // Make sure "employeeinformation" is the correct template name

	}
	
	@GetMapping(path = "/salaries1")
	public String salariesForm(Model model) {
		System.out.println("inside get create employee method");
		model.addAttribute("employee", new Employee());
		return "salaries1";

	}

	

    @PostMapping(path="/salaries1")
    public String submitSalaryForm(@ModelAttribute Salaries1 salaryForm, Model model) {

        // Create a new Salary object and set its attributes based on the form data

        Salaries1 employee = new Salaries1();

        employee.setName(salaryForm.getName());
        employee.setDesignation(salaryForm.getDesignation());
        employee.setDoj(salaryForm.getDoj());
        employee.setPayperiod(salaryForm.getPayperiod());
        employee.setPaydate(salaryForm.getPaydate());
        employee.setPfnumber(salaryForm.getPfnumber());
        employee.setBankaccountnumber(salaryForm.getBankaccountnumber());

        // Save the new salary to the database

        salaries1Repository.save(employee);

        // Redirect to a confirmation page or the "salaries1" page
        return "payslips"; // Replace with the appropriate URL
    }

     
    @GetMapping("/payslips")
    public String displayPayslips(Model model) {

        // Fetch all salaries1 data from the database or your data source

        List<Salaries1> salaries1s = salaries1Repository.findAll(); // Implement this method to fetch payslips

        // Pass the salaries1 data to the Thymeleaf template

        model.addAttribute("salaries1", salaries1s);
        return "payslips"; // Ensure that "payslips" is the correct template name

    }
    
//    @GetMapping("/deleteprofile")
//    public String deleteEmployeeProfile(@RequestParam Long id) {
//        // Implement the code to delete the employee with the given ID
//        // You can use a service or repository to perform the deletion
//        employee.deleteEmployeeById(id); // Replace with the actual method
//        return "redirect:/employeeinformation"; // Redirect back to the employee information page
//    }



	
	@GetMapping(path = "/updateemployee")

	public String updateEmployee(@RequestParam long id, Model model) {

		System.out.println("inside the update salary controller method");

		model.addAttribute("employeeportal", new EmployeePortal());

		Optional<EmployeePortal> empData = employeeportalRepository.findById(id);

		EmployeePortal currentEmp = empData.get();

		model.addAttribute("empDetails", currentEmp);

		System.out.println("First name is : " + currentEmp.getFirstname());

		model.addAttribute("depDetails", currentEmp.getSurname());

		return "updateemployee";

	}
	  
	@PostMapping(path = "/updateemployee")
	public String updateEmployeeDetails(@ModelAttribute EmployeePortal updatedEmployee, Model model) {
	    // Get the original employee ID
	    long id = updatedEmployee.getId();

	    // Retrieve the existing employee data from the database
	    Optional<EmployeePortal> empData = employeeportalRepository.findById(id);

	    if (empData.isPresent()) {
	        EmployeePortal currentEmp = empData.get();

	        // Update the existing employee with the data from the form
	        currentEmp.setFirstname(updatedEmployee.getFirstname());
	        currentEmp.setPrimarymobileno(updatedEmployee.getPrimarymobileno());
	        currentEmp.setEmailid(updatedEmployee.getEmailid());
	        currentEmp.setProjectname(updatedEmployee.getProjectname());
	        currentEmp.setWorkallocationdays(updatedEmployee.getWorkallocationdays());
	        currentEmp.setMonthlysalary(updatedEmployee.getMonthlysalary());
	        currentEmp.setWorktype(updatedEmployee.getWorktype());

	        // Save the updated employee back to the database
	        employeeportalRepository.save(currentEmp);

	        // Redirect to a confirmation page or the relevant page
	        return "employeeinformation"; // Replace with the appropriate URL
	    } else {
	        // Handle the case where the employee with the specified ID was not found
	        return "errorPage"; // Replace with an error page URL
	    }
	}


	

	@GetMapping(path = "/emplist")
	public String listUsers(Model model) {
		System.out.println("inside the employee list controller methods");
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		return "emplist";
	}

	@GetMapping(path = "/all-sals")
	public String allSals(Model model) {
		System.out.println("inside the salaries list controller methods");
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		return "all-sals";
	}
	
	@GetMapping(path = "/updateprofile")
	public String updateProfile(@RequestParam long id, Model model) {
		System.out.println("hereeeeeee");
		model.addAttribute("user", new Employee());
		Optional<Employee> empData = employeeRepository.findById(id);
		Employee currentEmployee  = empData.get();
		model.addAttribute("usersDetails", currentEmployee);
		return "updateprofile";

	}

	@GetMapping(path = "/update-pdf")
	public String updatePDF(Model model) {
		System.out.println("inside the Updaet PDF Model controller methods");
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		return "update-pdf";
	}

	private long getTotalSalaries(String item) {
		ArrayList<Employee> allEmployees = (ArrayList<Employee>) employeeRepository.findAll();
		long salTotal = 0;
		for (Iterator<Employee> iterator = allEmployees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			Salary sal = employee.getSalary();
			if (item.equalsIgnoreCase("sal"))
				salTotal = salTotal + sal.getSalaryForCurrentMonth();
			else if (item.equalsIgnoreCase("tax"))
				salTotal = salTotal + (sal.getSalaryForCurrentMonth() * sal.getTaxSlabPercent() / 100);
			else if (item.equalsIgnoreCase("salAfter"))
				salTotal = salTotal + (sal.getSalaryForCurrentMonth()
						- (sal.getSalaryForCurrentMonth() * sal.getTaxSlabPercent() / 100));
		}

		return salTotal;
	}

	@GetMapping(path = "/sal-gen")
	public String salGen(Model model) {
		System.out.println("inside the salaries list controller methods");
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		long totSals = getTotalSalaries("sal");
		long totTax = getTotalSalaries("tax");
		long totSalAfterTax = getTotalSalaries("salAfter");
		model.addAttribute("employeeList", jsonObj);
		model.addAttribute("totSals", totSals);
		model.addAttribute("totTax", totTax);
		model.addAttribute("totSalAfterTax", totSalAfterTax);
		return "sal-gen";
	}

	@GetMapping(path = "/list-salaries")
	public String listSalaries(Model model) {
		System.out.println("inside the LIST salaries  controller methods");
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		long totSals = getTotalSalaries("sal");
		long totTax = getTotalSalaries("tax");
		long totSalAfterTax = getTotalSalaries("salAfter");
		model.addAttribute("employeeList", jsonObj);
		model.addAttribute("totSals", totSals);
		model.addAttribute("totTax", totTax);
		model.addAttribute("totSalAfterTax", totSalAfterTax);
		return "list-salaries";
	}

	@GetMapping(path = "/generate-sals")
	public String generateSalaries() {
		System.out.println("inside the Generate Salary controller method");
		return "generate-sals";
	}

	/**
	 * WIP here ::::
	 * 
	 * @param month
	 * @param year
	 * @param model
	 * @return
	 */
	@PostMapping(path = "/generate-sals")
	public String generateSalariesPost(@RequestParam int month, @RequestParam int year, Model model) {
		System.out
				.println("inside the Generate Salary Post Controller method month | year ::: " + month + " : " + year);
		long totSals = 0;
		long totTax = 0;
		long totSalAfterTax = 0;
		List<Employee> empData = employeeRepository.findAll();
		List<SalaryExporter> salExporterList = new ArrayList<SalaryExporter>();
		for (Iterator<Employee> iterator = empData.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println("Employee Controller | emp.getId() is : " + emp.getId());
			long numOfDaysInMonth = 30;
			long totLeavesAvailable = 0;// to be updated dynamically

			int totLeavesTakenForThisMonth = getLeavesCountInAMonth(emp.getId(), month);
			long currentMonthSalary = emp.getSalary().getSalary();
			totLeavesAvailable = totLeavesAvailable - totLeavesTakenForThisMonth;
			long perDaySal = emp.getSalary().getSalary() / numOfDaysInMonth;
			if (totLeavesAvailable < 0) {
				long salDays = numOfDaysInMonth + totLeavesAvailable;
				currentMonthSalary = perDaySal * salDays;
			}
			long tds = emp.getSalary().getTaxSlabPercent(); // currentSalary.getTaxSlabPercent();
			long currentMonthSalAfterTax = currentMonthSalary - (currentMonthSalary * tds / 100);

			PaymentsTable paymentsTable = new PaymentsTable();
			paymentsTable.setEmpId(emp.getId());
			paymentsTable.setMonthNumber(month);
			paymentsTable.setYearNumber(year);
			Salary sal = emp.getSalary();
			paymentsTable.setSalaryForCurrentMonth(currentMonthSalary);
			paymentsTable.setSalAfterAllDeductions(currentMonthSalAfterTax);
			paymentsTable.setTds(sal.getTaxSlabPercent() * currentMonthSalary / 100);
			paymentsTable.setNumOfLeavesTakenInAMonth(totLeavesTakenForThisMonth);
			// paymentRepository.save(paymentsTable);

		}

		System.out.println("all the payments updated in the payment table");
		return "generate-sals";

	}

	private int getLeavesCountInAMonth(int id, int month) {

		List<Long> queryResults = myService.leavesQuery(id, month, 2023, "leaves_table");
		System.out.println("queryResults is : " + queryResults);
		int count = 0;
		for (Iterator iterator2 = queryResults.iterator(); iterator2.hasNext();) {
			Long currentLeaveId = (Long) iterator2.next();
			Optional<LeavesTable> currentLeaveTable = leavesRepository.findById(currentLeaveId);
			LeavesTable cLT = currentLeaveTable.get();

			Date leaveFromDate1 = cLT.getLeaveFromDate();
			Date leaveToDate1 = cLT.getLeaveToDate();
			if (leaveFromDate1 != null && leaveToDate1 != null) {
				LocalDate leaveFromDate = getLocalDateObj(leaveFromDate1);
				LocalDate leaveToDate = getLocalDateObj(leaveToDate1);

				LocalDate currentDate = LocalDate.of(2023, month, 1);

				while (!leaveFromDate.isAfter(leaveToDate)) {
					if (leaveFromDate.getMonth() == currentDate.getMonth()
							&& (leaveFromDate.getDayOfWeek().toString() != "SATURDAY")
							&& leaveFromDate.getDayOfWeek().toString() != "SUNDAY") {
						count++;
					}
					leaveFromDate = leaveFromDate.plusDays(1);
				}
			}

		}
		if (count > 0)
			System.out.println("update leave count is :================ " + count);
		return count;

	}

	private LocalDate getLocalDateObj(Date leaveFromDate1) {
		String fStr = leaveFromDate1.toString();
		String[] fStrArr = fStr.split("-");
		String dateStr = fStrArr[2];
		dateStr = dateStr.split(" ")[0];
		LocalDate leaveFromDate = LocalDate.of(Integer.parseInt(fStrArr[0]), Integer.parseInt(fStrArr[1]),
				Integer.parseInt(dateStr));
		return leaveFromDate;
	}

	@PostMapping(path = "/list-salaries")
	public String listSalariesPost(@RequestParam int year, @RequestParam int month, Model model) {
		long totSals = 0;
		long totTax = 0;
		long totSalAfterTax = 0;
		System.out.println("inside the listSalariesPost method | year | month :::: " + year + "| " + month);
		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		List<Employee> empData = employeeRepository.findAll();
		List<SalaryExporter> salExporterList = new ArrayList<SalaryExporter>();
		for (Iterator<Employee> iterator = empData.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			List<Long> queryResults = myService.executeQuery(emp.getId(), month, year, "payments_table");
			System.out.println("queryResults is | List Salaries Post : " + queryResults);
			if (queryResults.size() > 0) {
				SalaryExporter salExp = new SalaryExporter();
				long paymentId = queryResults.get(0);
				Optional<PaymentsTable> pT = paymentRepository.findById(paymentId);
				PaymentsTable currentPayment = pT.get();
				salExp.setEmployeeID(currentPayment.getEmpId());
				salExp.setEmpName(emp.getName());
				salExp.setSalaryForCurrentMonth(currentPayment.getSalaryForCurrentMonth());
				salExp.setTds(currentPayment.getTds());
				salExp.setSalAfterAllDeductions(currentPayment.getSalAfterAllDeductions());
				salExporterList.add(salExp);
				totSals = totSals + currentPayment.getSalaryForCurrentMonth();
				totTax = totTax + currentPayment.getTds();
				totSalAfterTax = totSalAfterTax + currentPayment.getSalAfterAllDeductions();
			}
		}
		model.addAttribute("totSals", totSals);
		model.addAttribute("totTax", totTax);
		model.addAttribute("totSalAfterTax", totSalAfterTax);
		model.addAttribute("reqPaymentData", salExporterList);
		return "list-salaries";
	}

	@GetMapping(path = "/updatesalary")
	public String updateSalary(@RequestParam long id, Model model) {
		System.out.println("inside the update salary controller method");
		model.addAttribute("employee", new Employee());
		Optional<Employee> empData = employeeRepository.findById(id);
		Employee currentEmp = empData.get();
		model.addAttribute("empDetails", currentEmp);
		System.out.println("department name is : " + currentEmp.getDepartment().getName());
		model.addAttribute("depDetails", currentEmp.getDepartment());
		return "updatesalary";
	}

	@GetMapping(path = "/emp-getsal")
	public String empGetSalary(@RequestParam long id, Model model) {
		System.out.println("inside the update salary controller method");
		List<PaymentsTable> paymentData = paymentRepository.findAll();
		List<PaymentsTable> reqPaymentData = new ArrayList<PaymentsTable>();
		for (Iterator<PaymentsTable> iterator = paymentData.iterator(); iterator.hasNext();) {
			PaymentsTable paymentsTable = (PaymentsTable) iterator.next();
			// System.out.println("paymentsTable.getEmpId() is : " +
			// paymentsTable.getEmpId());
			boolean test = paymentsTable.getEmpId() == id;
			System.out.println("test is : " + test);
			if (paymentsTable.getEmpId() == id)
				reqPaymentData.add(paymentsTable);
		}
		model.addAttribute("reqPaymentData", reqPaymentData);
		return "emp-getsal";
	}



	@GetMapping("/employeeleave")

		    public String listLeaves(Model model) {

		        Iterable<Holidays> leaveHolidays = holidaysRepository.findAll();

		        model.addAttribute("leaveHolidays", leaveHolidays);

	 

		        return "holidays"; // You need to create a corresponding HTML template to display the leave dates.

		    }

		  

		  @PostMapping("/employeeleave")

		    public String submitLeave(@ModelAttribute Holidays leave, Model model) {

		        // Here, 'Holidays' should be a class that represents the leave data.

		        // Save the leave data to your repository.

		        holidaysRepository.save(leave);

	 

		        return "notfound"; // Redirect to a page that lists leave data.

		    }
		  
		  

	@GetMapping(path = "/emp-leave")

		public String empLeave(@RequestParam long id, Model model) {

			Optional<Employee> empData = employeeRepository.findById(id);

			List<LeavesTable> leavesData = leavesRepository.findAll();

			List<LeavesTable> reqLeavesData = new ArrayList<LeavesTable>();

			for (Iterator<LeavesTable> iterator = leavesData.iterator(); iterator.hasNext();) {

				LeavesTable leavesTable = (LeavesTable) iterator.next();

				// System.out.println("paymentsTable.getEmpId() is : " +

				// leavesTable.getEmpId());

				if (leavesTable.getEmpId() == id)

					reqLeavesData.add(leavesTable);

			}

			Employee currentEmp = empData.get();

			model.addAttribute("empDetails", currentEmp);

			model.addAttribute("reqLeavesData", reqLeavesData);

			getLeavesCountPerMonth(reqLeavesData, 12);

			return "emp-leave";

		}

	 

		private int getLeavesCountPerMonth(List<LeavesTable> reqLeavesData, int monthNum) {

			int totLeavesInMonth = 0;

	 

			for (Iterator<LeavesTable> iterator = reqLeavesData.iterator(); iterator.hasNext();) {

				LeavesTable leavesTable = (LeavesTable) iterator.next();

				// System.out.println("for the id : " + leavesTable.getEmpId());

				String leaveFrom = leavesTable.getLeaveFrom();

				String leaveTo = leavesTable.getLeaveTo();

				int monthLF = Integer.parseInt((leaveFrom).split("-")[1]);

				int monthLT = Integer.parseInt((leaveTo).split("-")[1]);

				if (monthLF == monthNum || monthLT == monthNum) {

					System.out.println("monthLF : " + monthLF);

					System.out.println("1111 : totLeavesInMonth " + totLeavesInMonth);

					System.out.println("leaveFrom beofre : " + leaveFrom);

					System.out.println("leaveTo beofre : " + leaveTo);

					if (monthLF == monthNum && monthLT > monthNum) {

						Calendar leaveFromCalObj = getCalendarObj(leaveFrom);

						int leaveToTemp = leaveFromCalObj.getActualMaximum(Calendar.DAY_OF_MONTH);

						String leaveFromDate = leaveFrom.split("-")[2];

						leaveTo = leaveFrom.replace(leaveFromDate, Integer.toString(leaveToTemp));

					} else if (monthLT == monthNum && monthLF < monthNum) {

						String leaveFromDateTemp = "1";
						String leaveFromMonth = leaveFrom.split("-")[1];
						String leaveFromDate = leaveFrom.split("-")[2];
						leaveFrom = leaveFrom.replace(leaveFromMonth, Integer.toString(monthLT)).replace(leaveFromDate,
								leaveFromDateTemp);

					}
					totLeavesInMonth = totLeavesInMonth + getLeavesCount(leaveFrom, leaveTo);
					System.out.println("totLeavesInMonth " + totLeavesInMonth);
				}	 
			}
			System.out.println("Tot Leaves in the month : " + monthNum + " is :::::: " + totLeavesInMonth);
			return totLeavesInMonth;

		}

	 

		@PostMapping(path = "/emp-leave")
		public String updateLeaves(@RequestParam long id, @RequestParam String leaveFrom, @RequestParam String leaveTo,
				Model model) {
			System.out.println("inside the Leaves controller method =======");
			System.out.println("leaveFrom : leaveTo :::: " + leaveFrom + " : " + leaveTo);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date leaveFromDate = null;
			Date leaveToDate = null;

			try {

				leaveFromDate = formatter.parse(leaveFrom);
				leaveToDate = formatter.parse(leaveTo);
				System.out.println("leaveFromDate is : " + leaveFromDate);
				System.out.println("leaveToDate is : " + leaveToDate);

			} catch (ParseException e) {

				e.printStackTrace();

			}

			long leavesCount = getLeavesCount(leaveFrom, leaveTo);
			long monthNum = 1;
			long yearNum = 2023;
			LeavesTable leavesTable = new LeavesTable();
			leavesTable.setEmpId(id);
			leavesTable.setLeaveFrom(leaveFrom);
			leavesTable.setLeaveTo(leaveTo);
			leavesTable.setMonthNumber(monthNum);
			leavesTable.setYearNumber(yearNum);
			leavesTable.setLeavesCount(leavesCount);
			leavesTable.setLeaveFromDate(leaveFromDate);
			leavesTable.setLeaveToDate(leaveToDate);
			Optional<Employee> empData = employeeRepository.findById(id);
			Employee currentEmp = empData.get();
			model.addAttribute("empDetails", currentEmp);
			leavesRepository.save(leavesTable);
			return "emp-leave";

		}
		
		private int getLeavesCount(String leaveFrom, String leaveTo) {

			// TO DO - write code to find out the working days between these dates!

			Calendar frmCalendar = getCalendarObj(leaveFrom);
			Calendar toCalendar = getCalendarObj(leaveTo);

			int workingDays = 0;

			System.out.println("frmCalendar.get(Calendar.MONTH) is : " + frmCalendar.get(Calendar.MONTH));
			System.out.println("toCalendar.get(Calendar.MONTH) is : " + toCalendar.get(Calendar.MONTH));
			while (toCalendar.get(Calendar.MONTH) >= frmCalendar.get(Calendar.MONTH)) {
				if (toCalendar.get(Calendar.MONTH) > frmCalendar.get(Calendar.MONTH)) {
					int dayOfWeek = frmCalendar.get(Calendar.DAY_OF_WEEK);
					if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
						workingDays++;
					}

					frmCalendar.add(Calendar.DAY_OF_MONTH, 1);
				} else {
					if (toCalendar.get(Calendar.DATE) >= frmCalendar.get(Calendar.DATE)) {
						int dayOfWeek = frmCalendar.get(Calendar.DAY_OF_WEEK);
						if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
							workingDays++;

						}

						frmCalendar.add(Calendar.DAY_OF_MONTH, 1);

					} else {

						break;

					}
				}
			}

			System.out.println("workingDays are : " + workingDays);
			return workingDays;
		}

		private static Calendar getCalendarObj(String dateStr) {

		// dateStr in the format of "2023-09-21"

			String[] str = dateStr.split("-");
			String year = str[0];
			String month = str[1];
			String date = str[2];
			
			int yearNum = Integer.parseInt(year);
			int monthNum = Integer.parseInt(month);
			int dateNum = Integer.parseInt(date);
			String breakPt = " : ";
			System.out.println("year : month : date : " + year + breakPt + month + breakPt + date);
			Calendar calendar = Calendar.getInstance();
			calendar.set(yearNum, monthNum - 1, dateNum);
			return calendar;
		}

	@PostMapping(path = "/updatesalary")
	public String updateProfilePost(@ModelAttribute Employee empFrmReq, @RequestParam long leavesTaken,
			@RequestParam String depName, @RequestParam long availableLeaves, @RequestParam long taxSlabPercent,
			@RequestParam long yearNum, @RequestParam long monthNum, Model model) {
		System.out.println("From the request object empFrmReq : name " + empFrmReq.getName());
		System.out.println("From the request object leavesTaken : leavesTaken " + leavesTaken);

		Optional<Employee> empData = employeeRepository.findById((long) empFrmReq.getId());
		Employee currentEmp = empData.get();
		Salary currentSalary = currentEmp.getSalary();
		currentSalary.setAvailableLeaves(availableLeaves);
		long currentMonthSalary = currentSalary.getSalary();
		currentEmp.setName(empFrmReq.getName());
		currentEmp.getDepartment().setName(depName);
		currentSalary.setLeavesTaken(leavesTaken);
		long numOfDaysInMonth = 30;
		long totLeavesAvailable = availableLeaves;// currentSalary.getAvailableLeaves();
		totLeavesAvailable = totLeavesAvailable - leavesTaken;
		long perDaySal = currentMonthSalary / numOfDaysInMonth;
		if (totLeavesAvailable < 0) {
			long salDays = numOfDaysInMonth + totLeavesAvailable;
			currentMonthSalary = perDaySal * salDays;
		}
		currentSalary.setSalaryForCurrentMonth(currentMonthSalary);
		long tds = taxSlabPercent; // currentSalary.getTaxSlabPercent();
		currentSalary.setTaxSlabPercent(taxSlabPercent);
		long currentMonthSalAfterTax = currentMonthSalary - (currentMonthSalary * tds / 100);
		currentSalary.setSalAfterAllDeductions(currentMonthSalAfterTax);
		employeeRepository.save(currentEmp);

		updatePaymentsTable(currentEmp, yearNum, monthNum);

		ArrayList<Employee> jsonObj = (ArrayList<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", jsonObj);
		return "sal-gen";
	}

	private void updatePaymentsTable(Employee currentEmp, long yearNum, long monthNum) {
		System.out.println("insde payments update table");
		PaymentsTable paymentsTable = new PaymentsTable();
		paymentsTable.setEmpId(currentEmp.getId());
		paymentsTable.setMonthNumber(monthNum);
		paymentsTable.setYearNumber(yearNum);
		Salary sal = currentEmp.getSalary();
		paymentsTable.setSalaryForCurrentMonth(sal.getSalaryForCurrentMonth());
		paymentsTable.setSalAfterAllDeductions(sal.getSalAfterAllDeductions());
		paymentsTable.setTds(sal.getTaxSlabPercent() * sal.getSalaryForCurrentMonth() / 100);
		paymentsTable.setNumOfLeavesTakenInAMonth(sal.getLeavesTaken());
		paymentRepository.save(paymentsTable);

	}

	@PostMapping(path = "/update-pdf")
	public String updatePDFPost(Model model) {
		System.out.println("Inside pdf post");
		try {
			// Load the source PDF document
			PDDocument sourceDocument = PDDocument
					.load(new File("/Users/santoshvadakattu/Downloads/APHYD00644260000000138_2023.pdf"));

			/**
			 * PDPageTree pages = sourceDocument.getDocumentCatalog().getPages(); for
			 * (PDPage page : pages) { PDResources res = page.getResources();
			 * 
			 * for (COSName fontName : res.getFontNames()) { PDFont font = null; try { font
			 * = res.getFont(fontName); System.out.println("Fonts are : " + font); } catch
			 * (IOException e) { e.printStackTrace(); } } }
			 **/

			// Create a new PDF document for the destination
			PDDocument destinationDocument = new PDDocument();

			// Create a PDFTextStripper object
			PDFTextStripper pdfTextStripper = new PDFTextStripper();

			// Get the text from the PDF and print it to the console
			String pdfText = pdfTextStripper.getText(sourceDocument);
			pdfText = pdfText.replace("\r", "");// pdfText.replace("\n", "").replace("\r", "");
			System.out.println(pdfText);

			// Create a new page for the destination document
			PDPage destinationPage = new PDPage();
			destinationDocument.addPage(destinationPage);

			// Create a content stream for the destination page
			PDPageContentStream contentStream = new PDPageContentStream(destinationDocument, destinationPage);

			// Set font and size for the text
			contentStream.setFont(PDType1Font.ZAPF_DINGBATS, 12);

			// Add the extracted text to the destination page
			contentStream.beginText();
			contentStream.newLineAtOffset(50, 700); // Adjust the position as needed
			contentStream.showText(pdfText);
			contentStream.endText();

			// Close the content stream and save the destination PDF
			contentStream.close();
			destinationDocument.save("/Users/santoshvadakattu/Downloads/temp/Anil-DQ/temp-1.pdf");

			// Close the documents
			sourceDocument.close();
			destinationDocument.close();

			// Copy each page from the source to the destination
			for (int pageIndex = 0; pageIndex < sourceDocument.getNumberOfPages(); pageIndex++) {
				// System.out.println("here::: " +
				// sourceDocument.getDocumentInformation().getSubject());
				destinationDocument.addPage(sourceDocument.getPage(pageIndex));
			}

			// Save the destination PDF document to a file
			// destinationDocument.save("/Users/santoshvadakattu/Downloads/temp/Anil-DQ/temp.pdf");

			// Close the documents
			// sourceDocument.close();
			// destinationDocument.close();

			System.out.println("PDF copied successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "sal-gen";
	}
}
