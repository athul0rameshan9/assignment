public class BookRepository {
    private Context context;

    public BookRepository(Context context) {
        this.context = context;
    }

    public List<book> getBooks() {
        List<book> bookList = new ArrayList<>();
        try {
            InputStream is = context.getResources().openRawResource(R.raw.books);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            JSONArray array = new JSONArray(builder.toString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                bookList.add(new Book(
                        obj.getString("title"),
                        obj.getString("author"),
                        obj.getString("thumbnail")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
