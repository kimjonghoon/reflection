package net.java_school.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//1. Simulating the instanceof Operator
		System.out.println("1.");
		Class<?> c = Class.forName("net.java_school.examples.BankAccount");
		boolean chk = c.isInstance(Integer.valueOf(10));
		System.out.println(chk);
		chk = c.isInstance(new BankAccount());
		System.out.println(chk);
		System.out.println();
		
		//2. Finding Out About Methods of a Class
		System.out.println("2.");
		Method[] ms = c.getDeclaredMethods();
        for (Method method : ms) {
            System.out.println("name = " + method.getName());
            System.out.println("decl class = " + method.getDeclaringClass());
            Class<?>[] ptypes = method.getParameterTypes();
            for (int i = 0; i < ptypes.length; i++) {
                System.out.println("param #" + i + " " + ptypes[i]);
            }
            Class<?>[] etypes = method.getExceptionTypes();
            for (int i = 0; i < etypes.length; i++) {
                System.out.println("exception #" + i + " " + etypes[i]);
            }
            System.out.println("return type = " + method.getReturnType());
            System.out.println("------------------------------------------");
        }
		System.out.println();

		//3. Obtaining Information About Constructors
		System.out.println("3.");
		Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> constructor = constructors[i];
            System.out.println("name = " + constructor.getName());
            System.out.println("decl class = " + constructor.getDeclaringClass());
            Class<?>[] params = constructor.getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                System.out.println("param #" + j + " " + params[j]);
            }
            Class<?>[] exceptions = constructor.getExceptionTypes();
            for (int j = 0; j < exceptions.length; j++) {
                System.out.println("exception #" + j + " " + exceptions[j]);
            }
            System.out.println("--------------------------------------");
        }
        System.out.println();
        
        //4. Finding Out About Class Fields
        System.out.println("4.");
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("name = " + field.getName());
            System.out.println("decl class = " + field.getDeclaringClass());
            System.out.println("type = " + field.getType());
            int mod = field.getModifiers();
            System.out.println("modifiers = " + Modifier.toString(mod));
            System.out.println("-------------------------------------");
        }
        System.out.println();
        
        //5. Invoking Methods by Name
        System.out.println("5.");
        Class<?>[] paramTypes = new Class[1];
        paramTypes[0] = Integer.TYPE;
        Method method = c.getMethod("deposit", paramTypes);
        BankAccount johnAccount = new BankAccount(1111, "John Doe", 100);
        Object[] arguments = new Object[1];
        arguments[0] = Integer.valueOf(100);
        Object retobj = method.invoke(johnAccount, arguments);
        Integer retval = (Integer) retobj;
        System.out.println(retval.intValue());
        System.out.println();

        //6. Obtaining Information About Constructors
        System.out.println("6.");
        paramTypes = new Class[3];
        paramTypes[0] = Integer.TYPE;
        paramTypes[1] = String.class;
        paramTypes[2] = Integer.TYPE;
        Constructor<?> constructor = c.getConstructor(paramTypes);//Find constructor with parameter array
        arguments = new Object[3];
        arguments[0] = Integer.valueOf(2222);//Account No
        arguments[1] = "Jane Doe";//Owner
        arguments[2] = Integer.valueOf(1000);//initial Balance
        retobj = constructor.newInstance(arguments);
        System.out.println(retobj);
        System.out.println();
        
        //7. Changing Values of Fields
        System.out.println("7.");
        BankAccount aliceAccount = new BankAccount(3333, "Alice", 500);
        Field field = c.getField("message");
        System.out.println(aliceAccount);
        field.set(aliceAccount, "Message changed with Reflection API");
        System.out.println(aliceAccount);
        field = c.getField("balance");//Runtime error. cannot access private field.
        field.setDouble(aliceAccount, 1000000);
	}

}
