package fourteam.swagger.parts;

import java.util.HashMap;

import org.json.JSONObject;

public class Response {
    int code;
    String description;
    JSONObject content;

    public Response(int code) {
        this.code = code;
        this.description = "";
        // this.content = new JSONObject();
        // this.content.put("application/json", new JSONObject());
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("description", this.description);
        // obj.put("content", this.content);
        return obj;
    }

    public HashMap<String, Object> toHasMap() {
        HashMap<String, Object> obj = new HashMap<String, Object>();
        obj.put("description", this.description);
        // obj.put("content", this.content);
        return obj;
    }
}
