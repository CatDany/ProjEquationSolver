package catdany.proj.equationsolver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
	public static final Main main = new Main();
	
	private final BufferedReader reader;
	
	public Main()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
		println("Добро пожаловать в программу для решения квадратных уравнений.");
		while (true)
		{
			println("Представьте квадратное уравнение в виде ax^2 + bx + c = 0 и запишите его коэффициенты в алфавитном порядке, разделяя пробелом.");
			coef: while (true)
			{
				try
				{
					String s = readLine("a b c").trim();
					String[] coef = s.split(" ", 3);
					double[] roots = solveQuadratic(Double.parseDouble(coef[0]), Double.parseDouble(coef[1]), Double.parseDouble(coef[2]));
					println("Уравнение '%sx^2 + %sx + %s = 0' решено.", coef[0], coef[1], coef[2]);
					println("x1 = %s", roots[0]);
					println("x2 = %s", roots[1]);
					break coef; 
				}
				catch (Throwable t)
				{
					err(t, "Неправильный формат. Пример: '1 1 -2' для x^2 + x - 2 = 0");
				}
			}
		}
	}
	
	private static double[] solveQuadratic(double a, double b, double c)
	{
		double[] roots = new double[2];
		roots[0] = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;
		roots[1] = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c)) / 2*a;
		return roots;
	}
	
	public static void main(String[] args) {}
	
	private String readLine(String prompt)
	{
		String s = null;
		print(prompt + " > ");
		try
		{
			s = reader.readLine();
		}
		catch (Throwable t)
		{
			err(t, "An error occured whilst trying to read from BufferedReader(System.in)");
		}
		return s;
	}
	
	private void print(String s, Object... args)
	{
		System.out.print(String.format(s, args));
	}
	
	private void println(String s, Object... args)
	{
		System.out.println(String.format(s, args));
	}
	
	private void err(Throwable t, String msg)
	{
		System.err.println("Error: " + msg);
		if (t != null)
		{
			t.printStackTrace();
		}
	}
}
