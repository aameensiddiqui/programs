package com.jdbc.imageinserter;

public class Main {
	public static void main(String[] args) {
		InsertTable.insertMethod("INSERT INTO images(image) VALUES(?)");
		AlterTable.alterMethod("ALTER TABLE images ADD name VARCHAR(20)");
	}
}
