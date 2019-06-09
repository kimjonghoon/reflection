# java reflection example

### how to run
	~/reflection$ cd src/net/java_school/examples/
	~/reflection/src/net/java_school/examples$ javac -d ../../../../bin *.java
	~/reflection/src/net/java_school/examples$ cd -
	~/reflection$ java -cp ./bin net.java_school.examples.Test
	1.
	false
	true
	
	2.
	name = setOwner
	decl class = class net.java_school.examples.BankAccount
	param #0 class java.lang.String
	return type = void
	------------------------------------------
	name = withdraw
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	exception #0 class java.lang.RuntimeException
	return type = int
	------------------------------------------
	name = getAccountNo
	decl class = class net.java_school.examples.BankAccount
	return type = int
	------------------------------------------
	name = setAccountNo
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	return type = void
	------------------------------------------
	name = getBalance
	decl class = class net.java_school.examples.BankAccount
	return type = int
	------------------------------------------
	name = setBalance
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	return type = void
	------------------------------------------
	name = deposit
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	return type = int
	------------------------------------------
	name = toString
	decl class = class net.java_school.examples.BankAccount
	return type = class java.lang.String
	------------------------------------------
	name = getOwner
	decl class = class net.java_school.examples.BankAccount
	return type = class java.lang.String
	------------------------------------------
	
	3.
	name = net.java_school.examples.BankAccount
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	param #1 class java.lang.String
	--------------------------------------
	name = net.java_school.examples.BankAccount
	decl class = class net.java_school.examples.BankAccount
	--------------------------------------
	name = net.java_school.examples.BankAccount
	decl class = class net.java_school.examples.BankAccount
	param #0 int
	param #1 class java.lang.String
	param #2 int
	exception #0 class java.lang.RuntimeException
	--------------------------------------
	
	4.
	name = SWIFT_CODE
	decl class = class net.java_school.examples.BankAccount
	type = class java.lang.String
	modifiers = public static final
	-------------------------------------
	name = accountNo
	decl class = class net.java_school.examples.BankAccount
	type = int
	modifiers = private
	-------------------------------------
	name = owner
	decl class = class net.java_school.examples.BankAccount
	type = class java.lang.String
	modifiers = private
	-------------------------------------
	name = balance
	decl class = class net.java_school.examples.BankAccount
	type = int
	modifiers = private
	-------------------------------------
	name = message
	decl class = class net.java_school.examples.BankAccount
	type = class java.lang.String
	modifiers = public
	-------------------------------------
	
	5.
	200
	
	6.
	Account No:2222|Owner:Jane Doe|Balance:1000|Message:Created at Mon Mar 04 19:49:58 KST 2019
	
	7.
	Account No:3333|Owner:Alice|Balance:500|Message:Created at Mon Mar 04 19:49:58 KST 2019
	Account No:3333|Owner:Alice|Balance:500|Message:Message changed with Reflection API
	Exception in thread "main" java.lang.NoSuchFieldException: balance
		at java.base/java.lang.Class.getField(Class.java:1958)
	at net.java_school.examples.Test.main(Test.java:108)