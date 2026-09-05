class Marathon {
    public static void main (String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };

        int bestOne = findBestOne(times);
        int secondOne = findTheSecondOne(times);

        System.out.println("The first One:"+names[bestOne] + ": " + times[bestOne]);
        System.out.println("The second One:"+names[secondOne] + ": " + times[secondOne]);
    }

    public static int findBestOne(int[] times){
        int bestOne = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[bestOne] < times[i]){ //当前保存的是最好，就进行下一次比较
                continue;
            } else {
                bestOne = i;         //这次的最好，就替换掉
            }
        }
        return bestOne;
    }

    public static int findTheSecondOne(int[] times){
        int bestOne = findBestOne(times); //先找到最好的
        int secondOne;

        if (bestOne == 0){    //确保bestOne不是第一个人
            secondOne = 1;
        } else {
            secondOne = 0;
        }

        for (int i = 0; i < times.length; i++) {
            if (i != bestOne){  //遇到最好的，直接进行下一次比较就行
                if (times[secondOne] < times[i]){
                    continue;
                } else {
                    secondOne = i;
                }
            }
        }
        return secondOne;
    }
}