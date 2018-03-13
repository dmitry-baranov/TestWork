import java.io.*;

public class File {

    public MyList<String> copyFileToArray(String name) {
        try{
            FileInputStream fileInputStream = new FileInputStream("/home/dmitry/IdeaProjects/dmitry/" + name + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            String strLine;
            MyList<String> list = new MyList<String>();
            fileInputStream.getChannel().position(0);
            while ((strLine = br.readLine()) != null){
                list.add(strLine);
            }
            return list;
        }catch (IOException e){
            System.out.println("Ошибка считывания файла");
        }
        return null;
    }

    public void createResult(MyList<String> myList) {
        java.io.File file = new java.io.File("/home/dmitry/IdeaProjects/dmitry/result.txt");
        file.getParentFile();
        MyList<User> userMyList= Util.convertToUser(myList);
        MyList<String> uniqueCountryList = Util.uniqueArray(userMyList);
        MyList<Country> resultList = Util.result(uniqueCountryList, userMyList);

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < resultList.length(); i++){
                if (resultList.get(i) != null && resultList.get(i).getName() != null) {
                    bw.write(resultList.get(i).getName() + ";" + resultList.get(i).getSumCount() + ";" + resultList.get(i).getCountUser() + "\n");
                }
            }
            bw.write("Отсортированный \n");
            Util.sortListUser(resultList);
            for (int i = 0; i < resultList.length(); i++){
                if (resultList.get(i) != null && resultList.get(i).getName() != null) {
                    bw.write(resultList.get(i).getName() + ";" + resultList.get(i).getSumCount() + ";" + resultList.get(i).getCountUser() + "\n");
                }
            }
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
