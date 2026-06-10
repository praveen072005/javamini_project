import psycopg2
from psycopg2 import Error

def connect():
    try:
        connection = psycopg2.connect(
            user="postgres",
            password='1234',
            host="localhost",
            port="5432",
            database="EmployeeVacationSystem"
        )
        return connection
    except (Exception, Error) as error:
        print("Error while connecting to PostgreSQL", error)
        return None

def create_tables():
    connection = connect()
    if connection:
        try:
            cursor = connection.cursor()

            # Employees table
            cursor.execute('''
                CREATE TABLE IF NOT EXISTS employees (
                    employee_id SERIAL PRIMARY KEY,
                    name VARCHAR(255),
                    department VARCHAR(255),
                    position VARCHAR(255),
                    hire_date DATE
                );
            ''')

            # VacationRequests table
            cursor.execute('''
                CREATE TABLE IF NOT EXISTS vacation_requests (
                    request_id SERIAL PRIMARY KEY,
                    employee_id INT,
                    start_date DATE,
                    end_date DATE,
                    status VARCHAR(50),
                    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
                );
            ''')

            connection.commit()
            print("Tables created successfully.")
        except (Exception, Error) as error:
            print("Error creating tables:", error)
        finally:
            if connection:
                cursor.close()
                connection.close()
                

# Add similar functions for inserting employees, vacation requests, and handling returns
# ... (previous code)

# Implement similar functions for inserting employees, handling returns, and viewing data

def handle_return():
    try:
        connection = connect()
        if connection:
            cursor = connection.cursor()

            # Get return information from the user
            request_id = input("Enter request ID to handle return: ")

            # Update the status of the vacation request to 'Returned'
            cursor.execute('''
                UPDATE vacation_requests
                SET status = 'Returned'
                WHERE request_id = %s
            ''', (request_id,))

            connection.commit()
            print("Return handled successfully.")
        else:
            print("Error: Unable to establish a database connection.")
    except (Exception, Error) as error:
        print("Error handling return:", error)
    finally:
        if connection:
            cursor.close()
            connection.close()

def view_employees():
    try:
        connection = connect()
        if connection:
            cursor = connection.cursor()

            # Fetch all rows from the 'employees' table
            cursor.execute("SELECT * FROM employees;")
            rows = cursor.fetchall()

            # Display the data
            print("\nEmployees Table:")
            for row in rows:
                print(row)
        else:
            print("Error: Unable to establish a database connection.")
    except (Exception, Error) as error:
        print("Error viewing data from employees table:", error)
    finally:
        if connection:
            cursor.close()
            connection.close()

def view_vacation_requests():
    try:
        connection = connect()
        if connection:
            cursor = connection.cursor()

            # Fetch all rows from the 'vacation_requests' table
            cursor.execute("SELECT * FROM vacation_requests;")
            rows = cursor.fetchall()

            # Display the data
            print("\nVacation Requests Table:")
            for row in rows:
                print(row)
        else:
            print("Error: Unable to establish a database connection.")
    except (Exception, Error) as error:
        print("Error viewing data from vacation_requests table:", error)
    finally:
        if connection:
            cursor.close()
            connection.close()

# ... (remaining code)


def insert_employee():
    try:
        connection = connect()
        if connection:
            cursor = connection.cursor()

            # Get employee information from the user
            name = input("Enter employee name: ")
            department = input("Enter employee department: ")
            position = input("Enter employee position: ")
            hire_date = input("Enter hire date (YYYY-MM-DD): ")

            # Insert employee information into the 'employees' table
            cursor.execute('''
                INSERT INTO employees (name, department, position, hire_date)
                VALUES (%s, %s, %s, %s)
            ''', (name, department, position, hire_date))

            connection.commit()
            print("Employee information inserted successfully.")
        else:
            print("Error: Unable to establish a database connection.")
    except (Exception, Error) as error:
        print("Error inserting employee information:", error)
    finally:
        if connection:
            cursor.close()
            connection.close()

# Implement similar functions for inserting vacation requests, handling returns, and viewing data

def insert_vacation_request():
    try:
        connection = connect()
        if connection:
            cursor = connection.cursor()

            # Get vacation request information from the user
            employee_id = input("Enter employee ID: ")
            start_date = input("Enter start date (YYYY-MM-DD): ")
            end_date = input("Enter end date (YYYY-MM-DD): ")

            # Insert vacation request information into the 'vacation_requests' table
            cursor.execute('''
                INSERT INTO vacation_requests (employee_id, start_date, end_date, status)
                VALUES (%s, %s, %s, %s)
            ''', (employee_id, start_date, end_date, 'Pending'))

            connection.commit()
            print("Vacation request inserted successfully.")
        else:
            print("Error: Unable to establish a database connection.")
    except (Exception, Error) as error:
        print("Error inserting vacation request:", error)
    finally:
        if connection:
            cursor.close()
            connection.close()

# Implement similar functions for handling returns and viewing data

# ...

# Main program
while True:
    choice = input("Choose an option:\n1. Create Tables\n2. Insert Employee\n3. Insert Vacation Request\n4. View Employees\n5. View Vacation Requests\n6. Quit\nEnter your choice: ")

    if choice == "1":
        create_tables()
    elif choice == "2":
        insert_employee()
    elif choice == "3":
        insert_vacation_request()
    elif choice == "4":
        view_employees()
    elif choice == "5":
        view_vacation_requests()
    elif choice == "6":
        break
    else:
        print("Invalid choice")






