package kabutz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.Serializable;

public final class Person implements Serializable, ObjectInputValidation
{
	private final String firstName;
	private final String lastName;
	private final int age;

	public Person(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		try
		{
			validateObject();
		}
		catch (InvalidObjectException ex)
		{
			throw new IllegalArgumentException(ex.getMessage());
		}
	}

	@Override
	public void validateObject() throws InvalidObjectException
	{
		if (age < 0)
		{
			throw new InvalidObjectException("age negative");
		}
		if (age > 150)
		{
			throw new InvalidObjectException("age more than 150");
		}
		if (firstName == null || firstName.isEmpty())
		{
			throw new InvalidObjectException("firstName empty");
		}
		if (lastName == null || lastName.isEmpty())
		{
			throw new InvalidObjectException("firstName empty");
		}
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.registerValidation(this, 0);
		in.defaultReadObject();
	}

	@Override
	public String toString()
	{
		return firstName + " " + lastName + " is " + age + " years old";
	}
}