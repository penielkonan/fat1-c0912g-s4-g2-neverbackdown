
	USE MASTER
	
	GO
	
	DROP DATABASE ALL_PROJECT
	
	GO

	CREATE DATABASE ALL_PROJECT

	GO

	USE ALL_PROJECT

	GO

	CREATE TABLE Accounts(
		AccountID INT IDENTITY PRIMARY KEY,
		Email VARCHAR(50),
		[Password] VARCHAR(50),		
		[Status] BIT
	)
	
	GO
	
	INSERT INTO Accounts VALUES('haitt@gmail.com','123456',1)	
	INSERT INTO Accounts VALUES('thanhnh@gmail.com','123456',1)
	INSERT INTO Accounts VALUES('hiennn@gmail.com','123456',1)
	INSERT INTO Accounts VALUES('linhptt@gmail.com','123456',1)
	INSERT INTO Accounts VALUES('test@gmail.com','123456',1)
	INSERT INTO Accounts VALUES('test2@gmail.com','123456',1)
	INSERT INTO Accounts VALUES('test3@gmail.com','123456',1)
	
	GO
		

	CREATE TABLE AccountInformations(
		AccountInfoID INT IDENTITY PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		Title NVARCHAR(20),
		FirstName NVARCHAR(50),
		LastName NVARCHAR(50),		
		BirthDate DATETIME,
		Company NVARCHAR(50),
		[Address] NVARCHAR(250),
		[Address2] NVARCHAR(250),
		City NVARCHAR(50),
		[State] NVARCHAR(50),
		Zip NVARCHAR(50),
		Country NVARCHAR(50),
		AdditionalInformation NVARCHAR(300),
		HomePhone VARCHAR(30),
		Tel VARCHAR(20),
		AddressAlias NVARCHAR(50) 	
	)
	
	GO
		
	
	INSERT INTO AccountInformations VALUES (1,'Mr.','Tran Trong','Hai',CONVERT(datetime, '19890419',112),'','Thuong Tin','','Ha Noi','','20000','Viet Nam','','84904886361','0433888888','Thuong Tin')
	INSERT INTO AccountInformations VALUES (2,'Mr.','Nguyen Hong','Thanh',CONVERT(datetime, '19890820',112),'','Dat To','','Phu Tho','','20000','Viet Nam','','841684477009','043366666','Dat To')
	INSERT INTO AccountInformations VALUES (3,'Mr.','Nguyen Ngoc','Hien',CONVERT(datetime, '19900613',112),'','Dong Da','','Ha Noi','','20000','Viet Nam','','84934384483','043999999','Dong Da')
	INSERT INTO AccountInformations VALUES (4,'Ms.','Pham Thi Thuy','Linh',CONVERT(datetime, '19890419',112),'','Ha Dong','','Ha Noi','','20000','Viet Nam','','84974270833','0433686868','Bo Sua')
	INSERT INTO AccountInformations VALUES (5,'Ms.','Test1','Test1',CONVERT(datetime, '19890419',112),'','Cau Giay','','Ha Noi','','20000','Viet Nam','','123456789','123456789','Test1')
	INSERT INTO AccountInformations VALUES (6,'Ms.','Test2','Test2',CONVERT(datetime, '19890419',112),'','Van Kiep','','Da Nang','','40000','Viet Nam','','987654321','987654321','Test2')
	INSERT INTO AccountInformations VALUES (7,'Ms.','Test3','Test3',CONVERT(datetime, '19890419',112),'','Q1','','Ho Chi Minh','','80000','Viet Nam','','112233445','566778899','Test3')
	
	GO	
	
		
	CREATE TABLE Departments(
		DepartmentID INT IDENTITY PRIMARY KEY,
		DepartmentName VARCHAR(50),
		[Description] VARCHAR(MAX),		
	)
	
	GO
	
	INSERT INTO Departments VALUES ('Admin','Manager Dealer')
	INSERT INTO Departments VALUES ('Dealer','Manager Customer')
	INSERT INTO Departments VALUES ('Customer','Buy Product')
	
	GO			
		
	CREATE TABLE Employees(
		EmployeeID INT IDENTITY PRIMARY KEY,
		DepartmentID INT FOREIGN KEY REFERENCES Departments(DepartmentID),
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID)	
	)
	
	GO
	
	INSERT INTO Employees VALUES (1,1)
	INSERT INTO Employees VALUES (2,2)
	INSERT INTO Employees VALUES (2,3)
	INSERT INTO Employees VALUES (2,4)
	INSERT INTO Employees VALUES (3,5)
	INSERT INTO Employees VALUES (3,6)
	INSERT INTO Employees VALUES (3,7)
	
	GO
		
	CREATE TABLE TypeLogs(
		TypeLogID INT IDENTITY PRIMARY KEY,
		TypeName VARCHAR(50),
		[Description] VARCHAR(MAX)		
	)		
	
	GO
	
	INSERT INTO TypeLogs VALUES ('Login','Informations details Login')
		
	GO	
		
	CREATE TABLE LogStores(
		LogID INT IDENTITY PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		TypeLogID INT FOREIGN KEY REFERENCES TypeLogs(TypeLogID),
		AtTime DATETIME DEFAULT GETDATE(),		
		[Status] BIT DEFAULT 1		
	)
	
	GO
	
	INSERT INTO LogStores VALUES (5,1,GETDATE(),1)
	
	GO	
		
	
	CREATE TABLE Factorys(
		FactoryID INT IDENTITY PRIMARY KEY,
		FactoryName VARCHAR(50),
		[Address] VARCHAR(50),
		City VARCHAR(50),
		Region VARCHAR(50),
		Country VARCHAR(50),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO Factorys VALUES ('Ha Noi Factory','Ha Noi','Auto Ancillaries Limited','Outskirts Northern','Viet Nam',1)
	INSERT INTO Factorys VALUES ('Da Nang Factory','Da Nang','Auto Ancillaries Limited','Outskirts Central','Viet Nam',1)
	INSERT INTO Factorys VALUES ('Ho Chi Minh Factory','Ho Chi Minh','Auto Ancillaries Limited','Outskirts Southern','Viet Nam',1)
	
	GO
	
	
	CREATE TABLE WareHouses(
		WareHouseID INT IDENTITY PRIMARY KEY,
		FactoryID INT FOREIGN KEY REFERENCES Factorys(FactoryID),
		WareHouseName VARCHAR(50),
		[Address] VARCHAR(50),
		City VARCHAR(50),
		Region VARCHAR(50),
		Country VARCHAR(50),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO WareHouses VALUES (1,'Ha Noi WareHouses','1A Yet Kieu','Auto Ancillaries Limited','Northern','Viet Nam',1)
	INSERT INTO WareHouses VALUES (2,'Da Nang WareHouses','356 Tran Phu','Auto Ancillaries Limited','Central','Viet Nam',1)
	INSERT INTO WareHouses VALUES (3,'Ho Chi Minh WareHouses','278 Cac Mang Thang 8','Auto Ancillaries Limited','Southern','Viet Nam',1)

	GO
	
	CREATE TABLE Payments(
		PaymentID INT IDENTITY PRIMARY KEY,
		PaymentName varchar(50)	
	)
	
	GO
	
	INSERT INTO Payments VALUES ('CheQue')
	INSERT INTO Payments VALUES ('Bank Wire')	
	
	GO
	
	CREATE TABLE Orders(
		OrderID INT IDENTITY PRIMARY KEY,
		AccountID INT FOREIGN KEY REFERENCES Accounts(AccountID),
		WareHouseID INT FOREIGN KEY REFERENCES WareHouses(WareHouseID),	
		PaymentID INT FOREIGN KEY REFERENCES Payments(PaymentID),	
		OrderDate DATETIME,
		DeliveryAdress VARCHAR(200),		
		RequireDate DATETIME,
		ShipDate DATETIME,
		DeliveryDate DATETIME,
		IsPay BIT DEFAULT 0,
		[Status] BIT DEFAULT 1	
	)					
	
	GO		
	
	--INSERT INTO Orders VALUES (5,1,1,GETDATE(),'Cung Van Hoa Huu Nghi Viet Xo',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),0,1)
	--INSERT INTO Orders VALUES (6,1,1,GETDATE(),'247 Nguyen Van Cuu , Da Nang',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),0,1)
	--INSERT INTO Orders VALUES (7,1,1,GETDATE(),'231 Cho Tan Binh , HCM',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),0,1)
	--INSERT INTO Orders VALUES (5,2,1,GETDATE(),'Cung Van Hoa Huu Nghi Viet Xo',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),0,1)
	--INSERT INTO Orders VALUES (6,2,1,GETDATE(),'247 Nguyen Van Cuu , Da Nang',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),0,1)
	--INSERT INTO Orders VALUES (7,2,2,GETDATE(),'231 Cho Tan Binh , HCM',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),1,1)
	--INSERT INTO Orders VALUES (5,3,2,GETDATE(),'Cung Van Hoa Huu Nghi Viet Xo',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),1,1)
	--INSERT INTO Orders VALUES (6,3,2,GETDATE(),'247 Nguyen Van Cuu , Da Nang',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),1,1)
	--INSERT INTO Orders VALUES (7,3,2,GETDATE(),'231 Cho Tan Binh , HCM',CONVERT(datetime, '20120809',112),CONVERT(datetime, '20120810',112),CONVERT(datetime, '20120812',112),1,1)
	--GO
	
	CREATE TABLE ProductCategorys(
		ProductCategoryID INT IDENTITY PRIMARY KEY,		
		productCategoryName NVARCHAR(30),
		[Description] NVARCHAR(MAX),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO ProductCategorys VALUES('CAR TYRES','Nowadays we have great opportunities to satisfy our demands with the high quality products. We are proud to present our wonderful choice of wheels and tires. Our delivery and shipping system is always ready to comply with your order.',1)
	INSERT INTO ProductCategorys VALUES('TRUCK TYRES','Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties.',1)
	INSERT INTO ProductCategorys VALUES('SPORTS TYRES','We guarantee the premium quality and fair prices of our goods. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends.',1)
	INSERT INTO ProductCategorys VALUES('SPORTS WHEELS','We care about the durability of our products and we are sure that it is perfect. As you understand the products of our store are a unique combination of original design, reasonable price and undoubted reliability.',1)
	INSERT INTO ProductCategorys VALUES('ACCESSORIES','Our assortment can satisfy any client'+'s whim because it'+'s literally unlimited. You must remember that we have a great number of different promos so you can get a pretty good discount in our store.',1)
	
	GO	
	
	CREATE TABLE ProductDetails(
		ProductID INT IDENTITY PRIMARY KEY,		
		ProductCategoryID INT FOREIGN KEY REFERENCES ProductCategorys(ProductCategoryID),
		ProductName VARCHAR(50),
		ProductDetail TEXT,
		ProductMoreInfo TEXT,
		UnitPrice MONEY,		
		Figure VARCHAR(250),
		Width VARCHAR(20),
		Height VARCHAR(20),
		Depth  VARCHAR(20),
		[Weight] VARCHAR(20),
		Sizes VARCHAR(20),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO ProductDetails VALUES (1,'Michelin Pilot Alpin','Nowadays we have great opportunities to satisfy our demands with the high quality products. We are proud to present our wonderful choice of wheels and tires. Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties.','Nowadays we have great opportunities to satisfy our demands with the high quality products. We are proud to present our wonderful choice of wheels and tires. Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We are proud to present our wonderful choice of wheels and tires. Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods.',549,'1-1.jpg','10"','15"','10"','0.5 Kg','L',1)
	INSERT INTO ProductDetails VALUES (1,'Bridgestone Potenza RE050A','We are proud to present our wonderful choice of wheels and tires. Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods. ','Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods. Besides dont forget that our 24/7 support system will help you solve your problems anytime.Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends.',215,'1-2.jpg','15"','5"','15"','1 Kg','XL',1)
	INSERT INTO ProductDetails VALUES (1,'ATS DTM Competition','Without a doubt we are the leading company in this sphere. Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods. Besides dont forget that our 24/7 support system will help you solve your problems anytime.','We guarantee the premium quality and fair prices of our goods. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends. We care about the durability of our products and we are sure that it is perfect. You must remember that we have a great number of different promos so you can get a pretty good discount in our store. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends. We care about the durability of our products and we are sure that it is perfect. As you understand the products of our store are a unique combination of original design, reasonable price and undoubted reliability.',215,'1-3.jpg','5"','10"','5"','0.3 Kg','XXL',1)	
	INSERT INTO ProductDetails VALUES (1,'Dunlop SP Sport Maxx TT','Our company is the pioneer of this business because we provide a great number of new technologies concerning design solutions and some technological specialties. We guarantee the premium quality and fair prices of our goods. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends.','We care about the durability of our products and we are sure that it is perfect. As you understand the products of our store are a unique combination of original design, reasonable price and undoubted reliability. Our assortment can satisfy any clients whim because its literally unlimited. Besides dont forget that our 24/7 support system will help you solve your problems anytime. As you understand the products of our store are a unique combination of original design, reasonable price and undoubted reliability. Our assortment can satisfy any clients whim because its literally unlimited. You must remember that we have a great number of different promos so you can get a pretty good discount in our store. We are proud to present our wonderful choice of wheels and tires.',315,'1-4.jpg','10"','15"','10"','2 Kg','L',1)
	INSERT INTO ProductDetails VALUES (1,'Adrenalin Potenza RE001','We guarantee the premium quality and fair prices of our goods. The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends. We care about the durability of our products and we are sure that it is perfect. You must remember that we have a great number of different promos so you can get a pretty good discount in our store.','Our assortment can satisfy any clients whim because its literally unlimited. You must remember that we have a great number of different promos so you can get a pretty good discount in our store. We care about our customers and our main purpose is to satisfy their demands. Besides dont forget that our 24/7 support system will help you solve your problems anytime. You must remember that we have a great number of different promos so you can get a pretty good discount in our store. We care about our customers and our main purpose is to satisfy their demands. Besides dont forget that our 24/7 support system will help you solve your problems anytime. Our delivery and shipping system is always ready to comply with your order.',270,'1-5.jpg','15"','10"','15"','0.5 Kg','XL',1)
	INSERT INTO ProductDetails VALUES (1,'ATS Classic','The interesting design is very important thing in our sphere and we are trying to stay in touch with the latest fashion trends. We care about the durability of our products and we are sure that it is perfect. As you understand the products of our store are a unique combination of original design, reasonable price and undoubted reliability.','We care about our customers and our main purpose is to satisfy their demands. Besides dont forget that our 24/7 support system will help you solve your problems anytime. Our delivery and shipping system is always ready to comply with your order. Nowadays we have great opportunities to satisfy our demands with the high quality products. Without a doubt we are the leading company in this sphere. Besides dont forget that our 24/7 support system will help you solve your problems anytime. Our delivery and shipping system is always ready to comply with your order. Nowadays we have great opportunities to satisfy our demands with the high quality products. We are proud to present our wonderful choice of wheels and tires. Without a doubt we are the leading company in this sphere.',620,'1-6.jpg','5"','15"','10"','1 Kg','M',1)
	
	GO
	
	
	CREATE TABLE OrderDetails(
		OrderDetailID INT IDENTITY PRIMARY KEY,
		OrderID INT FOREIGN KEY REFERENCES Orders(OrderID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		Price MONEY,
		Amount INT,
		TotalMoney MONEY,
		[Status] BIT DEFAULT 1
	)
	
	GO
		--INSERT INTO OrderDetails VALUES (1,1,549,5,2745,1)
		--INSERT INTO OrderDetails VALUES (2,2,249,5,2745,1)
		--INSERT INTO OrderDetails VALUES (2,3,349,10,2745,1)
		--INSERT INTO OrderDetails VALUES (2,4,215,20,2745,1)
		--INSERT INTO OrderDetails VALUES (3,1,315,5,2745,1)
		--INSERT INTO OrderDetails VALUES (3,3,415,5,6000,1)
	
		
	GO
	
	CREATE TABLE ProductsInStock(
		ProductInStockID INT IDENTITY PRIMARY KEY,
		WareHouseID INT FOREIGN KEY REFERENCES WareHouses(WareHouseID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		AmountStock INT,
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO ProductsInStock VALUES (1,1,50,1)
	INSERT INTO ProductsInStock VALUES (1,2,60,1)
	INSERT INTO ProductsInStock VALUES (1,3,70,1)
	INSERT INTO ProductsInStock VALUES (1,4,80,1)
	INSERT INTO ProductsInStock VALUES (1,5,90,1)
	INSERT INTO ProductsInStock VALUES (1,6,100,1)
		
	
	GO
	
	CREATE TABLE ProductComments(
		ProductCommentID INT IDENTITY PRIMARY KEY,
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		[Name] NVARCHAR(50),
		Email VARCHAR(50),
		[Title] NVARCHAR(50),
		Comment TEXT,
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO ProductComments VALUES (1,'Kevin Nguyen','kevinguyen@gmail.com','Michelin Pilot Alpin','product very good',1)
	
	GO
	
	CREATE TABLE Plans(
		PlanID INT IDENTITY PRIMARY KEY,
		MonthPlan CHAR(10),
		YearPlan CHAR(5),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO Plans VALUES ('8','2012',1)
	
	GO
	
	
	CREATE TABLE PlanDetails(
		PlanDetailID INT IDENTITY PRIMARY KEY,
		PlanID INT FOREIGN KEY REFERENCES Plans(PlanID),
		FactoryID INT FOREIGN KEY REFERENCES Factorys(FactoryID),
		[Status] BIT DEFAULT 1	
	)
	
	GO
	
	INSERT INTO PlanDetails VALUES (1,1,1)
	
	GO
	
	CREATE TABLE Productions(
		ProductionID INT IDENTITY PRIMARY KEY,
		PlanDetailID INT FOREIGN KEY REFERENCES PlanDetails(PlanDetailID),
		ProductID INT FOREIGN KEY REFERENCES ProductDetails(ProductID),
		ExpectedAmount INT,
		ActualAmount INT,
		ErrorAmount INT,
		[Description] VARCHAR(MAX),
		[Status] BIT DEFAULT 1
	)
	
	GO
	
	INSERT INTO Productions VALUES (1,1,200,180,20,'in month to sell 100 products',1)
	
	
	--SELECT TOP 4 * FROM ProductDetails pd ORDER BY NEWID()
	
	select * from Accounts
	select * from AccountInformations
	select * from Employees
	select * from Orders
	select * from OrderDetails
	select * from ProductDetails 