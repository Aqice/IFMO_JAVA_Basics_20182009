package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {
    private int bottleAtOnce;

    private int takenAmountOnStep(int bottleToTake, int currentAmount)
    {
        return bottleToTake > currentAmount ? currentAmount : bottleToTake;
    }

    private String numToWord(int bottleToTake, int currentAmount)
    {
        int bottleTakenAtOnce;
        bottleTakenAtOnce = bottleToTake > currentAmount ? currentAmount : bottleToTake;
        String bottleTakenAtOnceWord = "";
        if (bottleTakenAtOnce < 20) {
            switch (bottleTakenAtOnce) {
                case 1:
                    bottleTakenAtOnceWord = "one";
                    break;
                case 2:
                    bottleTakenAtOnceWord = "two";
                    break;
                case 3:
                    bottleTakenAtOnceWord = "three";
                    break;
                case 4:
                    bottleTakenAtOnceWord = "four";
                    break;
                case 5:
                    bottleTakenAtOnceWord = "five";
                    break;
                case 6:
                    bottleTakenAtOnceWord = "six";
                    break;
                case 7:
                    bottleTakenAtOnceWord = "seven";
                    break;
                case 8:
                    bottleTakenAtOnceWord = "eight";
                    break;
                case 9:
                    bottleTakenAtOnceWord = "nine";
                    break;
                case 10:
                    bottleTakenAtOnceWord = "ten";
                    break;
                case 11:
                    bottleTakenAtOnceWord = "eleven";
                    break;
                case 12:
                    bottleTakenAtOnceWord = "twelve";
                    break;
                case 13:
                    bottleTakenAtOnceWord = "thirteen";
                    break;
                case 14:
                    bottleTakenAtOnceWord = "fourteen";
                    break;
                case 15:
                    bottleTakenAtOnceWord = "fifteen";
                    break;
                case 16:
                    bottleTakenAtOnceWord = "sixteen";
                    break;
                case 17:
                    bottleTakenAtOnceWord = "seventeen";
                    break;
                case 18:
                    bottleTakenAtOnceWord = "eighteen";
                    break;
                case 19:
                    bottleTakenAtOnceWord = "nineteen";
                    break;

            }
        } else {

            int decade = bottleTakenAtOnce / 10;
            int digit = bottleTakenAtOnce % 10;
            String firstPart = "";
            String secondPart = "";

            switch (decade) {
                case 2:
                    firstPart = "twenty";
                    break;
                case 3:
                    firstPart = "thirty";
                    break;
                case 4:
                    firstPart = "forty";
                    break;
                case 5:
                    firstPart = "fifty";
                    break;
                case 6:
                    firstPart = "sixty";
                    break;
                case 7:
                    firstPart = "seventy";
                    break;
                case 8:
                    firstPart = "eighty";
                    break;
                case 9:
                    firstPart = "ninety";
                    break;
            }
            switch (digit) {
                case 1:
                    secondPart = " one";
                    break;
                case 2:
                    secondPart = " two";
                    break;
                case 3:
                    secondPart = " three";
                    break;
                case 4:
                    secondPart = " four";
                    break;
                case 5:
                    secondPart = " five";
                    break;
                case 6:
                    secondPart = " six";
                    break;
                case 7:
                    secondPart = " seven";
                    break;
                case 8:
                    secondPart = " eight";
                    break;
                case 9:
                    secondPart = " nine";
                    break;
            }
            bottleTakenAtOnceWord = firstPart + secondPart;
        }
        return bottleTakenAtOnceWord;
    }

    public BottleSong(int bottleTakenAtOnce) {
        if (bottleTakenAtOnce > 99 || bottleTakenAtOnce < 1)
        {
            throw new IllegalArgumentException();
        }
        this.bottleAtOnce = bottleTakenAtOnce;
    }


    public String getBottleSongLyrics() {
        int bottleAmount = 99;
        String result = "";
        while (bottleAmount > 0)
        {
            if (bottleAmount == 1)
                result += Integer.toString(bottleAmount) + " bottle of beer on the wall, "
                        + Integer.toString(bottleAmount) + " bottle of beer.\n";
            else
                result += Integer.toString(bottleAmount) + " bottles of beer on the wall, "
                        + Integer.toString(bottleAmount) + " bottles of beer.\n";
            result += "Take " + this.numToWord(this.bottleAtOnce, bottleAmount) +" down and pass around, ";
            bottleAmount -= this.takenAmountOnStep(this.bottleAtOnce, bottleAmount);
            if (bottleAmount == 0)
                result += "no more bottles of beer on the wall.\n";
            else if (bottleAmount == 1)
                result += Integer.toString(bottleAmount) + " bottle of beer on the wall.\n";
            else
                result += Integer.toString(bottleAmount) + " bottles of beer on the wall.\n";
        }
        result += "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        return result;
    }

}
