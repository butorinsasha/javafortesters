package com.javafortesters.chap007basicsofjavarevisited.examples;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExampleTest {
    public ClassExampleTest(){
        super();
    }

    private ClassExampleTest(String name) {
        this.name = name;
    }

    @Test
    public void aJavaDocComment() {
        assertTrue(addTwoNumbers(4,3) == 7);
    }

    /**
     * Add two integers and return an int.
     *
     * There is a risk of overflow since two big
     * integers would max out the return int.
     *
     * @param a is the first number to add
     * @param b is the second number to add
     * @return a + b as an int
     */
    public int addTwoNumbers(int a, int b) {
        return a+b;
    }

    public String getName() {
        return this.name; // you can use just 'return name'
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void variableNaming() {
        String $aString = "bob";
        float ￡owed = 10F;
        int aMount = 4;
        long Amount = 5;
        String A0123456789bCd$f="ugh";

        assertEquals(4, aMount);
        assertEquals(5, Amount);
        assertEquals(10.5F, ￡owed, 0.5F);
        assertEquals("bob", $aString);
        assertEquals("ugh", A0123456789bCd$f);

    }

    public static final String CONSTANT = "a constant string";
    public static String aClassField = "a class field";
    protected static String protField = "a class field";
    public String pubField = "a public field";
    private String privField = "a private field";
    private String name;

    @Test
    public void fieldAndMethodScopes() {
        // CONSTANT = "new string for constant"; // Error: java: cannot assign a value to final variable CONSTANT
        assertEquals("a class field", ClassExampleTest.aClassField);

        ClassExampleTest instance = new ClassExampleTest("sasha");
        instance.aClassField = "changed"; // You can access class fields from instance objects, but	the	IDE	may	warn you, or the field may not show up in code completion
        assertEquals("a public field", instance.pubField);
        instance.pubField = "amended public field";
        assertEquals("amended public field", instance.pubField);
    }

    @org.junit.Test
    public void nonImportedTest() {
        org.junit.Assert.assertEquals(3, 2+1);
    }

    @Test
    public void carriageReturnOrNewline() {
        System.out.println("Hello\nNewline");
        System.out.println("Hello\rCarriageReturn");
    }

    @Test
    public  void someStringMethods() {
        String aString = "abcdef";

        assertEquals(6, aString.length());
//        System.out.println(aString.compareToIgnoreCase("abcdef"));
        assertTrue(aString.compareToIgnoreCase("ABCDEF")==0);
        assertTrue( aString.contains("bcde") );
        assertTrue( aString.startsWith("abc") );

        // string indexing starts at 0
        assertEquals( 'c', aString.charAt(2) );
        assertEquals( "ef", aString.substring(4) );

    }

    @Test
    public void incrementDecrementOperatorsExplored() {
        int num = 10;
        assertEquals(11, ++num); // { actual = ++num } <=> { num = num + 1; actual = num; }
        assertEquals(10, --num);
        assertEquals(10, num++); // { actual = num++} <=> { actual = num; num = num + 1 }
        assertEquals(11, num);
        assertEquals(11, num--);
    }

    @Test
    public void ifStatementExplored() {
        int x = 0; // `int x;` - Error: java: (local) variable x might not have been initialized

        if (2 > 3)
            x = x + 1;
        else
            x = x + 2;

        System.out.println(x);
        assertEquals(2, x);
    }

    @Test
    public void integerTypeExplored() {
        byte aByteHas1Byte;
        short aShortHas2Bytes;
        int anIntHas4Bytes;
        long aLongHas8Bytes;

        System.out.println(
                "* `byte` range: " +
                Byte.MIN_VALUE + " to " +
                Byte.MAX_VALUE
        );

        System.out.println(
                "* `short` range: " +
                Short.MIN_VALUE + "to" +
                Short.MAX_VALUE
        );

        System.out.println(
                "* `int` range: " +
                        Integer.MIN_VALUE + " to " +
                        Integer.MAX_VALUE
        );

        System.out.println(
                "* `long` range: " +
                Long.MIN_VALUE + " to " +
                Long.MAX_VALUE
        );

        aLongHas8Bytes = 0L; // add suffix L for long (useful when integer is typed but should be assigned as long)
        assertEquals(0, aLongHas8Bytes);

//        aWordHas1Byte = 0x80; // Java has no unsigned integer types
        aByteHas1Byte = (byte) 0x80; // 0x80 = -128(dec)
        System.out.println(aByteHas1Byte);
        aByteHas1Byte = 0x7F; // 0x7F = 7F(hex) = 127(dec) add prefix 0x for Hex
        assertEquals(127, aByteHas1Byte);

        anIntHas4Bytes = 020000000000; // 020000000000 = 20000000000(oct) = -2147483648(dec) add 'zero' prefix for Octal
        System.out.println(anIntHas4Bytes);
        assertEquals(-2147483648, anIntHas4Bytes);

        aByteHas1Byte = 0b0010; // Jva 1.7 added 0b 'zero b' for binary
        assertEquals(2, aByteHas1Byte);

        // Java 1.7 allows underscores for readability
        aLongHas8Bytes = 9_000_000_000L; // 9000 million
        assertEquals(9000000000L, aLongHas8Bytes);

    }

    @Test
    public void floatingPointType() {
        float singlePrecision32bit;
        double doublePrecision64bit;

        System.out.println(
                "* `float` range: " +
                        Float.MIN_VALUE + " to " +
                        Float.MAX_VALUE
        );

        System.out.println(
                "* `double` range: " +
                        Double.MIN_VALUE + " to " +
                        Double.MAX_VALUE
        );

        singlePrecision32bit = 10.1f; // suffix f or R fto get a float
        assertEquals(10.0f, singlePrecision32bit, 2);

        doublePrecision64bit = 20.1; // default to double
        assertEquals(20.0, doublePrecision64bit, 2);

    }

    @Test
    public void ternaryOperatorExplored() {
        int x = 0;
        x = 4 > 3 ? 2 : 1;
        assertEquals(2, x);
        assertTrue( 5 >= 4 ? true : false);
        assertFalse( 5 >= 6 ? true : false);
    }

    @Test
    public void bitwiseOperatorsExplored() {
        int x = 010; // 10(oct) = 8(dec) = 1000(bin)
        System.out.println(Integer.toBinaryString(x) + '\n' + Integer.toBinaryString(~x)); // ~ bitwise two’s complement (invert the bits)
        assertEquals("11111111111111111111111111110111", Integer.toBinaryString(~x));
    }


    @Test
    public void exploreCharacterType() {
        char aChar = '\u0026'; // '\u0026' is a Unicode code fro '&'
        assertEquals(aChar, '&');
    }

    @Test
    public void bitwiseShiftOperatorsExplored() {
        int a = 56;
        Integer b = 48;

        assertEquals(a*2, a<<1);
        assertEquals(b*2, b<<1);

        a <<= 2; // a = a << 2
        a = a << 1;
        assertEquals(56*8, a);

        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(minInt) + " = " + minInt);
        System.out.println( String.format("%32s", Integer.toBinaryString(maxInt) ) + " = " + maxInt );
        System.out.println( String.format("%32s", Integer.toBinaryString(maxInt<<31) ) + " = " + maxInt + "<<31" );
        System.out.println( String.format("%32s", Integer.toBinaryString(~maxInt) ) + " = ~" + maxInt );
    }
}