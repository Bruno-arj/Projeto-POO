package Dao;

import java.lang.reflect.Type;
import com.google.gson.*;
import Model.*;

public class EspacoAdapter implements JsonSerializer<Espaco>, JsonDeserializer<Espaco> {

    private static final String CLASSNAME = "tipo";

    @Override
    public JsonElement serialize(Espaco src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src, src.getClass()).getAsJsonObject();
        jsonObject.addProperty(CLASSNAME, src.getClass().getSimpleName());
        return jsonObject;
    }

    @Override
    public Espaco deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
            throws JsonParseException {
        
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = (prim != null) ? prim.getAsString() : "";

        Class<?> klass = null;
        switch (className) {
            case "CabineIndividual":
                klass = CabineIndividual.class;
                break;
            case "Auditorio":
                klass = Auditorio.class;
                break;
            case "SalaDeReuniao":
                klass = SalaDeReuniao.class;
                break;
            default:
                // Tenta salvar caso o arquivo seja antigo (fallback)
                if (jsonObject.has("projetor")) klass = SalaDeReuniao.class;
                else if (jsonObject.has("precoPorHora") && jsonObject.get("precoPorHora").getAsDouble() == 120.0) klass = Auditorio.class;
                else klass = CabineIndividual.class;
        }
        return context.deserialize(jsonObject, klass);
    }
}