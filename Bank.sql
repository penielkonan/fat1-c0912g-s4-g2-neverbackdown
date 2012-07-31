	CREATE DATABASE Bank

	GO

	USE Bank

	GO
	
	CREATE TABLE Banks(
		BankID INT IDENTITY PRIMARY KEY,
		BankName VARCHAR(50)	
	)
	
	GO

	CREATE TABLE CreditCards(
		CreditCardID VARCHAR(20) PRIMARY KEY,
		PinCode VARCHAR(10) NOT NULL,
		BankID INT FOREIGN KEY REFERENCES Banks(BankID),		
		AccountNumber INT IDENTITY,
		AccountName NVARCHAR(50),
		Amount MONEY,				
		CreationDate DATETIME DEFAULT GETDATE()		
	)
	
	GO
	
	CREATE TABLE TransactionTypes(
		TransactionTypeID INT IDENTITY PRIMARY KEY,
		TypeName VARCHAR(20)		
	)
	
	GO
	
	CREATE TABLE TransactionHistorys(
		TransactionHistoryID INT IDENTITY PRIMARY KEY,
		CreditCardID VARCHAR(20) FOREIGN KEY REFERENCES CreditCards(CreditCardID),
		TransactionTypeID INT FOREIGN KEY REFERENCES TransactionTypes(TransactionTypeID),
		FromTo VARCHAR(30) DEFAULT '',
		TransDate DATETIME DEFAULT GETDATE()		
	)