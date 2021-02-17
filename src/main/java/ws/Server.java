package ws;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Server {
    public static Map<String, Object> model = new HashMap<>();

    public static void main(String[] args){
        staticFiles.location("/public");
        webSocket("/echo", EchoWebSocket.class);


        get("/", (req, res) -> {
            model.clear();
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "websocket.html"));
        });


    }

}
