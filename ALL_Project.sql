	CREATE DATABASE ALL_PROJECT

	GO

	USE ALL_PROJECT

	GO

	CREATE TABLE Accounts(
		AccountID INT IDENTITY PRIMARY KEY,
		UserName VARCHAR(50),
		[Password] VARCHAR(50),
		CreationDate DATETIME DEFAULT GETDATE(),
		[Status] BIT
	)

	CREATE TABLE AccountInformations(
		AccountInfoID INT IDENTITY PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		LastName VARCHAR(50),
		FirstName VARCHAR(50),
		BirthDate DATETIME,
		[Address] VARCHAR(250),
		City VARCHAR(50),
		Region VARCHAR(50),
		Country VARCHAR(50),
		HomePhone VARCHAR(30),
		Tel VARCHAR(20),
		Email VARCHAR(100),
		Photo VARCHAR(100),
		Notes VARCHAR(MAX),
		[Status] BIT
	)


	CREATE TABLE CustomerTypes(
		CustomerTypeID INT IDENTITY PRIMARY KEY,
		CustomerTypeName VARCHAR(50),
		[Description] VARCHAR(MAX),
		[Status] BIT
		)

	CREATE TABLE Customers(
		CustomerID INT PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		CustomerTypeID INT FOREIGN KEY REFERENCES CustomerTypes(CustomerTypeID),
		CompanyName VARCHAR(50),
		[Status] BIT
	)			
		
	CREATE TABLE Departments(
		DepartmentID INT IDENTITY PRIMARY KEY,
		DepartmentName VARCHAR(50),
		[Description] VARCHAR(MAX),
		[Status] BIT
		)			
		
	CREATE TABLE Employees(
		EmployeeID INT IDENTITY PRIMARY KEY,
		DepartmentID INT FOREIGN KEY REFERENCES Departments(DepartmentID),
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		[Status] BIT		
		)	
	
	CREATE TABLE Factorys(
		FactoryID INT IDENTITY PRIMARY KEY,
		FactoryName VARCHAR(50),
		[Address] VARCHAR(50),
		City VARCHAR(50),
		Region VARCHAR(50),
		Country VARCHAR(50),
		[Status] BIT
	)
	
	CREATE TABLE Orders(
		OrderID INT IDENTITY PRIMARY KEY,
		CustomerID INT FOREIGN KEY REFERENCES Customers(CustomerID),
		OrderDate DATETIME,
		RequireDate DATETIME,
		ShipDate DATETIME,
		DeliveryDate DATETIME,
		IsPay BIT,
		[Status] BIT	
	)
	
	
	CREATE TABLE TypeLogs(
		TypeLogID INT IDENTITY PRIMARY KEY,
		TypeName VARCHAR(50),
		[Description] VARCHAR(MAX),
		[Status] BIT
	)
	
	CREATE TABLE LogStores(
		LogID INT IDENTITY PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		TypeLogID INT FOREIGN KEY REFERENCES TypeLogs(TypeLogID),
		AtTime DATETIME,
		[Description] VARCHAR(MAX),
		[Status] BIT		
	)
	
	CREATE TABLE WareHouses(
		WareHouseID INT IDENTITY PRIMARY KEY,
		FactoryID INT FOREIGN KEY REFERENCES Factorys(FactoryID),
		WareHouseName VARCHAR(50),
		[Address] VARCHAR(50),
		City VARCHAR(50),
		Region VARCHAR(50),
		Country VARCHAR(50),
		[Status] BIT
	)
	
	CREATE TABLE ProductTypes(
		ProductTypeID INT IDENTITY PRIMARY KEY,
		ProductTypeName VARCHAR(50),
		[Description] VARCHAR(MAX),
		[Status] BIT
	)
	
	CREATE TABLE ProductCategorys(
		ProductCategoryID INT IDENTITY PRIMARY KEY,
		ProductTypeID INT FOREIGN KEY REFERENCES ProductTypes(ProductTypeID),
		productCategoryName VARCHAR(MAX),
		[Status] BIT
	)
	
	CREATE TABLE ProductDetails(
		ProductID INT IDENTITY PRIMARY KEY,
		WareHouseID INT FOREIGN KEY REFERENCES WareHouses(WareHouseID),
		ProductCategoryID INT FOREIGN KEY REFERENCES ProductCategorys(ProductCategoryID),
		ProductName VARCHAR(50),
		ProductDetail TEXT,
		UnitPrice MONEY,
		AmountInStock INT,
		Figure VARCHAR(250),
		[Status] BIT
	
	
	CREATE TABLE OrderDetails(
		OrderDetailID INT IDENTITY PRIMARY KEY,
		OrderID INT FOREIGN KEY REFERENCES Orders(OrderID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		Amount INT,
		TotalMoney MONEY,
		[Status] BIT
	)
	
	CREATE TABLE Plans(
		PlanID INT IDENTITY PRIMARY KEY,
		MonthPlan CHAR(10),
		YearPlan CHAR(5),
		[Status] BIT
	)
	
	CREATE TABLE PlanDetails(
		PlanDetailID INT IDENTITY PRIMARY KEY,
		PlanID INT FOREIGN KEY REFERENCES Plans(PlanID),
		FactoryID INT FOREIGN KEY REFERENCES Factorys(FactoryID),
		[Status] BIT	
	)
	
	CREATE TABLE Productions(
		ProductionID INT IDENTITY PRIMARY KEY,
		PlanDetailID INT FOREIGN KEY REFERENCES PlanDetails(PlanDetailID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		ExpectedAmount INT,
		ActualAmount INT,
		ErrorAmount INT,
		[Description] VARCHAR(MAX),
		[Status] BIT	
	)
	
	CREATE TABLE ProductsInStock(
		ProductInStockID INT IDENTITY PRIMARY KEY,
		WareHouseID INT FOREIGN KEY REFERENCES WareHouses(WareHouseID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		AmountStock INT,
		[Status] BIT
	)
	