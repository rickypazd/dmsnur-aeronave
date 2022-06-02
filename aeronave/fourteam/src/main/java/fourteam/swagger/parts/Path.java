package fourteam.swagger.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Path {
    String path;
    String method;
    String summary;
    String description;
    String operationId;
    List<Response> responses;
    List<String> tags;

    public Path(String path, String method) {
        this.path = path;
        this.method = method;

        // this.summary = "SUMARY";
        // this.description = "description";
        String pat = path.toLowerCase();
        pat = pat.replaceAll("/", "_");
        pat = pat.replaceAll("\\{", "");
        pat = pat.replaceAll("\\}", "");

        this.operationId = method + pat;
        this.responses = new ArrayList<Response>();
        this.tags = new ArrayList<String>();

        this.responses.add(new Response(200));
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void addTag(String tag) {
        tags.add(tag);
    }


    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> p = new HashMap<String, Object>();
        HashMap<String, Object> obj = new HashMap<String, Object>();
        obj.put("summary", this.summary);
        if(this.description != null) {
            obj.put("description", this.description);
        }
        obj.put("operationId", this.operationId);
        obj.put("responses", this.getResponses());
        obj.put("tags", this.tags);

        p.put(this.method, obj);
        return p;
    }

    public HashMap<String, Object> getResponses() {
        HashMap<String, Object> obj = new HashMap<String, Object>();
        responses.iterator().forEachRemaining(a -> {
            obj.put(a.code + "", a.toHasMap());
        });
        return obj;
    }
}
