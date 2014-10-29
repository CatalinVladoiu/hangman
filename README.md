To run this app do:
1. deploy locally target/hangman.war
2. access: http://localhost:8080/hangman/2 from browser. 
	Is mandatory to add /2 at the end because that number represents the User ID.

Implementation details:
1. 3-tire app with Hibernate-JPA, Spring/Spring MVC and a in memory DB
2. The DB will be recreated at each start of Tomcat using populateDB.sql script.

Have to improve:
1. Validations for letter input field from game.jsp page.
2. Add Controller unit tests.
3. Add cache support.
4. Add user support.
5. Add security.
6. Improve look and feel.
7. Add even more unit/integration tests.
8. Create a separate script for tests to populate the DB.
9. Open to other suggestions.
