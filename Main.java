import functions.*;
import functions.basic.*;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		// Создание тестовых данных
		FunctionPoint[] points1 = {
				new FunctionPoint(0.0, 1.0),
				new FunctionPoint(1.0, 3.0),
				new FunctionPoint(2.0, 5.0)
		};

		FunctionPoint[] points2 = {
				new FunctionPoint(0.0, 1.0),
				new FunctionPoint(1.0, 3.0),
				new FunctionPoint(2.0, 5.0)
		};

		FunctionPoint[] points3 = {
				new FunctionPoint(0.0, 1.0),
				new FunctionPoint(1.0, 3.5), // Отличается от points1 и points2
				new FunctionPoint(2.0, 5.0)
		};

		// Создание объектов функций
		ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
		ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
		ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);

		LinkedListTabulatedFunction linkedFunc1 = new LinkedListTabulatedFunction(points1);
		LinkedListTabulatedFunction linkedFunc2 = new LinkedListTabulatedFunction(points2);
		LinkedListTabulatedFunction linkedFunc3 = new LinkedListTabulatedFunction(points3);

		// Тестирование toString()
		System.out.println("1. Тестирование toString():");
		System.out.println("arrayFunc1: " + arrayFunc1);
		System.out.println("linkedFunc1: " + linkedFunc1);
		System.out.println();

		// Тестирование equals()
		System.out.println("2. Тестирование equals():");
		System.out.println("arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2));
		System.out.println("arrayFunc1.equals(arrayFunc3): " + arrayFunc1.equals(arrayFunc3));
		System.out.println("linkedFunc1.equals(linkedFunc2): " + linkedFunc1.equals(linkedFunc2));
		System.out.println("linkedFunc1.equals(linkedFunc3): " + linkedFunc1.equals(linkedFunc3));
		System.out.println("arrayFunc1.equals(linkedFunc1): " + arrayFunc1.equals(linkedFunc1));
		System.out.println("linkedFunc2.equals(arrayFunc1): " + linkedFunc2.equals(arrayFunc1));
		System.out.println();

		// Тестирование hashCode()
		System.out.println("3. Тестирование hashCode():");
		System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
		System.out.println("arrayFunc2.hashCode(): " + arrayFunc2.hashCode());
		System.out.println("arrayFunc3.hashCode(): " + arrayFunc3.hashCode());
		System.out.println("linkedFunc1.hashCode(): " + linkedFunc1.hashCode());
		System.out.println("linkedFunc2.hashCode(): " + linkedFunc2.hashCode());
		System.out.println("linkedFunc3.hashCode(): " + linkedFunc3.hashCode());

		// Проверка согласованности equals и hashCode
		System.out.println("\nСогласованность equals и hashCode:");
		System.out.println("arrayFunc1.equals(arrayFunc2): " + (arrayFunc1.equals(arrayFunc2)) );
		System.out.println("arrayFunc1.hashCode() == arrayFunc2.hashCode(): " + (arrayFunc1.hashCode() == arrayFunc2.hashCode()) );

		System.out.println("\narrayFunc1.equals(arrayFunc3): " + (arrayFunc1.equals(arrayFunc3)) );
		System.out.println("arrayFunc1.hashCode() == arrayFunc3.hashCode(): " + (arrayFunc1.hashCode() == arrayFunc3.hashCode()) );
		System.out.println();

		// Тестирование изменения объекта и хэш-кода
		System.out.println("4. Тестирование изменения объекта:");
		System.out.println("До изменения - arrayFunc3: " + arrayFunc3);
		System.out.println("Хэш-код до изменения: " + arrayFunc3.hashCode());
		arrayFunc3.setPointY(1, 3.501); // Незначительное изменение
		System.out.println("После изменения - arrayFunc3: " + arrayFunc3);
		System.out.println("Хэш-код после изменения: " + arrayFunc3.hashCode());
		System.out.println();

		// Тестирование clone()
		System.out.println("5. Тестирование clone() и глубокого копирования:");

		// Клонирование ArrayTabulatedFunction
		ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayFunc1.clone();
		System.out.println("arrayFunc1: " + arrayFunc1);
		System.out.println("arrayClone: " + arrayClone);
		System.out.println("arrayFunc1 == arrayClone: " + (arrayFunc1 == arrayClone));
		System.out.println("arrayFunc1.equals(arrayClone): " + arrayFunc1.equals(arrayClone));

		// Проверка глубокого копирования для массива
		arrayFunc1.setPointY(0, 999.0); // Изменяем оригинал
		System.out.println("После изменения arrayFunc1:");
		System.out.println("arrayFunc1: " + arrayFunc1);
		System.out.println("arrayClone: " + arrayClone);
		System.out.println("Клон не изменился: " + (!arrayFunc1.equals(arrayClone)));
		System.out.println();

		// Клонирование LinkedListTabulatedFunction
		LinkedListTabulatedFunction linkedClone = (LinkedListTabulatedFunction) linkedFunc1.clone();
		System.out.println("linkedFunc1: " + linkedFunc1);
		System.out.println("linkedClone: " + linkedClone);
		System.out.println("linkedFunc1 == linkedClone: " + (linkedFunc1 == linkedClone));
		System.out.println("linkedFunc1.equals(linkedClone): " + linkedFunc1.equals(linkedClone));

		// Проверка глубокого копирования для связного списка
		linkedFunc1.setPointY(0, 888.0); // Изменяем оригинал
		System.out.println("После изменения linkedFunc1:");
		System.out.println("linkedFunc1: " + linkedFunc1);
		System.out.println("linkedClone: " + linkedClone);
		System.out.println("Клон не изменился: " + (!linkedFunc1.equals(linkedClone)));
	}
}