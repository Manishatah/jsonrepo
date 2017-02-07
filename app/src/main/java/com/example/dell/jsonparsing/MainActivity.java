package com.example.dell.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    //  JSONObject jobj=new JSONObject(in )
    // JSONObject glossary=jobj .getJSONObject("glossary") ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String json = "{" +
                "       'glossary': {\n" +
                "        \"title\": \"example glossary\",\n" +
                "\t\t\"GlossDiv\": {\n" +
                "            \"title\": \"S\",\n" +
                "\t\t\t\"GlossList\": {\n" +
                "                \"GlossEntry\": {\n" +
                "                    \"ID\": \"SGML\",\n" +
                "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
                "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
                "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
                "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
                "\t\t\t\t\t\"GlossDef\": {\n" +
                "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
                "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
                "                    },\n" +
                "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
                "                }" +
                "            }" +
                "        }" +
                "    }" +
                "}";

        try {
            JsonDemo(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void JsonDemo(String json) throws JSONException {
        String in;
        JSONObject jobj=new JSONObject(json);

        JSONObject mainObj =new JSONObject(json);
        // get sub json object
        JSONObject subObj = mainObj.getJSONObject("glossary");
        // get title from glossary
        String title = subObj.getString("title");

        Log.d("myapp","Glossary title: "+ title);

        JSONObject subsubObj = subObj.getJSONObject("GlossDiv");
        String subTitle = subsubObj.getString("title");
        Log.d("myapp","sub title: "+subTitle);


        JSONObject glosslistobj=subsubObj .getJSONObject("GlossList");
        JSONObject glossEntryobj =glosslistobj  .getJSONObject("GlossEntry") ;
        String id=glossEntryobj .getString("ID");
        Log.d("myapp",":"+id   );
        String sortAs=glossEntryobj .getString("SortAs") ;
        Log .d("myapp","sortAs"+sortAs );

        String glossterm=glossEntryobj.getString("GlossTerm");
        Log .d("myapp","glossterm"+glossterm );

        String accroynm=glossEntryobj.getString("Acronym");
        Log .d("myapp","accronym"+accroynm  );

        String abbrev=glossEntryobj.getString("Abbrev");
        Log .d("myapp","abbrev"+abbrev  );

        JSONObject glossDef =glossEntryobj .getJSONObject("GlossDef");
        String stan=glossDef .getString("stan");
        Log .d("myapp","stan"+stan );

        JSONArray glossSeeAlso=glossDef .getJSONArray("GlossSeeAlso");
        for(int i=0;i<glossSeeAlso .length() ;i++){
            String temp=glossSeeAlso .getString(i);
            Log.d("myapp","glossSeeAlso"+temp);
        }
String glossSee=glossEntryobj .getString("GlossSee") ;
        Log .d("myapp","glossSee"+glossSee );

mainObj .get("Glossary");
    }

}
