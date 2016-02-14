# Company - Vitaliy Gorbatiouk

**RESTful Company Web Service**
- RESTful Company Web Service produces and consumes "application/json" and provide functionality listed below:

	In this example, we have our table Company empty. First we have to create our first Company:

	- Create a new company:

        curl -H 'Accept: application/json' -X POST -d '{"employee":[{"id":"1","name":"Victor"}],"name":"Maria","address":"3212 McDonaldAve","city":"Miami","country":"USA","email":"maria@gmail.com","phoneNumber":"923-324-4334"}' -D - http://localhost:8080/Company_REST/company/add

		The company has been created satisfactorily. 

	Now we can look for all companies:
		
	- List of Companies:

	    curl -X GET -D - http://localhost:8080/Company_REST/company/all
		
		curl return this:
		
				[{"id":1,"name":"Maria","address":"3212 McDonaldAve","city":"Miami","country":"USA","email":"maria@gmail.com",
				"phoneNumber":"923-324-4334","employee":[{"id":2,"name":"Victor"}],"beneficialOwner":[]}]
		
		 It returns only one company since we have only saved one up to now.

	- Get one Company:
	
		In order to do this, at the end of this route http://localhost:8080/Company_REST/company/view/, we add: id. In our case is 1.
	
		curl -X GET -D - http://localhost:8080/Company_REST/company/view/1
		
		curl return this:
		
				[{"id":1,"name":"Maria","address":"3212 McDonaldAve","city":"Miami","country":"USA","email":"maria@gmail.com",
				"phoneNumber":"923-324-4334","employee":[{"id":2,"name":"Victor"}],"beneficialOwner":[]}]
		
		It is the same Company that we have inserted recently.
		
	- Update a Company:
	
		 curl -i -H "Accept: application/json" -H "X-HTTP-Method-Override: PUT" -X POST -d "employee":[{"id":"1","name":"Victor"}],"name":"Maria","address":"34 Obama Ave","city":"Orlando","country":"USA","email":"maria@gmail.com","phoneNumber":"945-754-3565s" http://localhost:8080/Company_REST/company/update/1
	
		In the end, curl will update the previous Company.
	
	- Remove Company for given id (path variable):

	    curl -X DELETE -D - http://localhost:8080/Company_REST/company/delete/1
		
		It returns an empty page , which means that the company has been deleted satisfactorily . 
		

**Spring RESTful Web Service example:**

- GET /all - all users: 

		@RestController
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public @ResponseBody List<Company> getAllCompanies() {
			System.out.println("GET ALL");
			return companyService.findAll();
		}

- GET /view/1 - get company identified by 1 id: 

		@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
		@ResponseStatus(value = HttpStatus.OK)
		public @ResponseBody Company getCompany(@PathVariable String id) {

- PUT /update/1 - update user identified by 1 id: 
		
		@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
		public void update(@PathVariable String id,@RequestBody String body) {

- Used annotations:
    - [@RestController](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-restcontrolle)
    - [@RequestMapping](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping)
    - [@PathVariable](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-uri-templates)
    - [@RequestParam](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestparam)
		

	Any questions, you can write me here and I will answer as soon as possible :)
	
	Vitaliy
