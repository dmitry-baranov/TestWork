public class Util {

    // Метод создает list уникальных значений Country
    public static MyList<String> uniqueArray(MyList<User> list) {
        MyList<String> result = new MyList<String>();
        for (int i = 0; i < list.length(); i++) {
            if (list.get(i) != null && !result.contains(list.get(i).getCountry())){
                result.add(list.get(i).getCountry());
            }
        }
        return result;
    }

    //Метод конвертирует list строк разделенных ";" в list объектов User
    public static MyList<User> convertToUser(MyList<String> list) {
        MyList<User> userMyList = new MyList<User>();
        for (int i = 1; i < list.length(); i++) {
            if (list.get(i) != null && !list.get(i).equals("user_id;count;country")) {
                String[] arr = list.get(i).split(";");
                userMyList.add(new User(arr[0],Integer.parseInt(arr[1]),arr[2]));
            }
        }
        return  userMyList;
    }
    //Метод создает результируюзий list статистики атрибуты как в задании
    public static MyList<Country> result(MyList<String> stringMyList, MyList<User> userMyList) {
        MyList<Country> newStringList = new MyList<Country>();
        for (int i = 0; i < stringMyList.length(); i++) {
            Country country = new Country(stringMyList.get(i));
            newStringList.add(country);
            for (int j = 0; j < userMyList.length(); j++){
                if (stringMyList.get(i) != null && userMyList.get(j) != null && stringMyList.get(i).equals(userMyList.get(j).getCountry())) {
                    country.addSumCount(userMyList.get(j).getCount());
                    country.addCountUser();
                }
            }
        }
        return newStringList;
    }

    // Сортировка результатов пузырек
    public static void sortListUser(MyList<Country> list) {
        for (int i = list.length() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) != null && list.get(i).getName() != null && list.get(j).getCountUser() > list.get(j + 1).getCountUser()) {
                    Country t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                }
                if (list.get(i) != null && list.get(i).getName() != null && list.get(j).getCountUser() == list.get(j + 1).getCountUser()){
                    if (list.get(j).getSumCount() > list.get(j + 1).getSumCount()) {
                        Country t = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, t);
                    }
                }
            }
        }
    }
}
