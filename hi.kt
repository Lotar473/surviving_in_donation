//Chat$1.class
package chzzk.chat;

class null implements Runnable {
  public void run() {
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage(");
    Chat.this.getServer().broadcastMessage("ash_magic");
    Chat.st(chatChannelId);
  }
}

//Chat$2$1.class
package chzzk.chat;

import java.util.TimerTask;

class null extends TimerTask {
  public void run() {
    Chat.null.this.sendPing();
  }
}

//Chat$2$2.class
package chzzk.chat;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

class null extends BukkitRunnable {
  public void run() {
    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), finalCommand);
  }
}

//Chat$2.class
package chzzk.chat;

import java.net.URI;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONArray;
import org.json.JSONObject;

class null extends WebSocketClient {
  null(URI arg0) {
    super(arg0);
  }
  
  public void onOpen(ServerHandshake serverHandshake) {
    Bukkit.broadcastMessage(");
    JSONObject bdy = new JSONObject();
    bdy.put("devType", 2001);
    bdy.put("accTkn", accessToken);
    bdy.put("auth", "READ");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("ver", "2");
    jsonObject.put("cmd", 100);
    jsonObject.put("svcid", "game");
    jsonObject.put("cid", chatId);
    jsonObject.put("tid", 1);
    jsonObject.put("bdy", bdy);
    send(jsonObject.toString());
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
          public void run() {
            Chat.null.this.sendPing();
          }
        },  0L, 30000L);
  }
  
  public void onMessage(String s) {
    JSONObject jsonObject = new JSONObject(s);
    int cmd = jsonObject.getInt("cmd");
    if (cmd == 93102) {
      JSONArray bdyArray = jsonObject.getJSONArray("bdy");
      JSONObject bdyObject = bdyArray.getJSONObject(0);
      String uid = bdyObject.getString("uid");
      String nickname = "";
      String msg = bdyObject.getString("msg");
      String extras = bdyObject.getString("extras");
      JSONObject extrasObject = new JSONObject(extras);
      if (extrasObject.has("payAmount")) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        int payAmount = extrasObject.getInt("payAmount");
        String payAmount_comma = numberFormat.format(payAmount);
        if (!uid.equals("anonymous")) {
          String profile = bdyObject.getString("profile");
          JSONObject profileObject = new JSONObject(profile);
          nickname = profileObject.getString("nickname");
        } 
        if (uid.equals("anonymous"))
          nickname = "; 
        if (((Chat)Chat.getPlugin(Chat.class)).getConfig().getString(") != "") {
          if (Bukkit.getServer().getPlayer(((Chat)Chat.getPlugin(Chat.class)).getConfig().getString(")) != null) {
            Player player = Bukkit.getServer().getPlayer(((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("));
            player.sendMessage("+ nickname + "+ payAmount_comma + " );
            if (!msg.equals("")) {
              player.sendMessage("+ msg);
              String nickname1 = nickname;
              player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.7F, 1.0F);
              player.sendTitle("+ payAmount_comma + " , nickname1 + ": " + msg, 20, 60, 20);
            } else {
              String nickname1 = nickname;
              player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.7F, 1.0F);
              player.sendTitle("+ payAmount_comma + " , nickname1 + ", 20, 60, 20);
            } 
          } 
        } else {
          Bukkit.broadcastMessage("+ nickname + "+ payAmount_comma + " );
          if (!msg.equals("")) {
            Bukkit.broadcastMessage("+ msg);
            String nickname1 = nickname;
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.7F, 1.0F));
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("+ payAmount_comma + " , nickname1 + ": " + msg, 20, 60, 20));
          } else {
            String nickname1 = nickname;
            Bukkit.getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.7F, 1.0F));
            Bukkit.getOnlinePlayers().forEach(player -> player.sendTitle("+ payAmount_comma + " , nickname1 + ", 20, 60, 20));
          } 
        } 
        String[] amountKeys = { "amount1", "amount2" };
        String[] commandKeys = { "amount1_command", "amount2_command" };
        Map<Integer, String> amountCommands = new HashMap<>();
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount1")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount1_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount2")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount2_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount3")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount3_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount4")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount4_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount5")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount5_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount6")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount6_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount7")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount7_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount8")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount8_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount9")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount9_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount10")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount10_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount11")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount11_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount12")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount12_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount13")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount13_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount14")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount14_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount15")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount15_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount16")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount16_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount17")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount17_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount18")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount18_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount19")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount19_command"));
        amountCommands.put(Integer.valueOf(((Chat)Chat.getPlugin(Chat.class)).getConfig().getInt("amount20")), ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("amount20_command"));
        int largestAmount = 0;
        String largestCommand = null;
        for (Map.Entry<Integer, String> entry : amountCommands.entrySet()) {
          int amount = ((Integer)entry.getKey()).intValue();
          String command = entry.getValue();
          if (payAmount >= amount && amount > largestAmount) {
            largestAmount = amount;
            largestCommand = command;
          } 
        } 
        if (largestCommand != null) {
          final String finalCommand = largestCommand;
          (new BukkitRunnable() {
              public void run() {
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), finalCommand);
              }
            }).runTask((Plugin)Chat.getPlugin(Chat.class));
        } 
      } 
    } else if (cmd == 93101 && ((
      (Chat)Chat.getPlugin(Chat.class)).getConfig().getInt(") == 1 || ((Chat)Chat.getPlugin(Chat.class)).getConfig().getString(") == null)) {
      JSONArray bdyArray = jsonObject.getJSONArray("bdy");
      JSONObject bdyObject = bdyArray.getJSONObject(0);
      String msg = bdyObject.getString("msg");
      String profile = bdyObject.getString("profile");
      JSONObject profileObject = new JSONObject(profile);
      String nickname = profileObject.getString("nickname");
      if (((Chat)Chat.getPlugin(Chat.class)).getConfig().getString(") != "") {
        if (Bukkit.getServer().getPlayer(((Chat)Chat.getPlugin(Chat.class)).getConfig().getString(")) != null) {
          Player player = Bukkit.getServer().getPlayer(((Chat)Chat.getPlugin(Chat.class)).getConfig().getString("));
          player.sendMessage("+ nickname + ": " + msg);
        } 
      } else {
        Bukkit.broadcastMessage("+ nickname + ": " + msg);
      } 
    } 
    if (cmd == 0) {
      jsonObject.put("ver", "2");
      jsonObject.put("cmd", 10000);
      send(jsonObject.toString());
    } 
  }
  
  public void onClose(int i, String s, boolean b) {
    Bukkit.broadcastMessage(");
  }
  
  public void onError(Exception e) {
    Bukkit.broadcastMessage(");
  }
}

//Chat.class
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;

public final class Response implements Closeable {
  final Request request;
  
  final Protocol protocol;
  
  final int code;
  
  final String message;
  
  @Nullable
  final Handshake handshake;
  
  final Headers headers;
  
  @Nullable
  final ResponseBody body;
  
  @Nullable
  final Response networkResponse;
  
  @Nullable
  final Response cacheResponse;
  
  @Nullable
  final Response priorResponse;
  
  final long sentRequestAtMillis;
  
  final long receivedResponseAtMillis;
  
  @Nullable
  private volatile CacheControl cacheControl;
  
  Response(Builder builder) {
    this.request = builder.request;
    this.protocol = builder.protocol;
    this.code = builder.code;
    this.message = builder.message;
    this.handshake = builder.handshake;
    this.headers = builder.headers.build();
    this.body = builder.body;
    this.networkResponse = builder.networkResponse;
    this.cacheResponse = builder.cacheResponse;
    this.priorResponse = builder.priorResponse;
    this.sentRequestAtMillis = builder.sentRequestAtMillis;
    this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
  }
  
  public Request request() {
    return this.request;
  }
  
  public Protocol protocol() {
    return this.protocol;
  }
  
  public int code() {
    return this.code;
  }
  
  public boolean isSuccessful() {
    return (this.code >= 200 && this.code < 300);
  }
  
  public String message() {
    return this.message;
  }
  
  @Nullable
  public Handshake handshake() {
    return this.handshake;
  }
  
  public List<String> headers(String name) {
    return this.headers.values(name);
  }
  
  @Nullable
  public String header(String name) {
    return header(name, null);
  }
  
  @Nullable
  public String header(String name, @Nullable String defaultValue) {
    String result = this.headers.get(name);
    return (result != null) ? result : defaultValue;
  }
  
  public Headers headers() {
    return this.headers;
  }
  
  public ResponseBody peekBody(long byteCount) throws IOException {
    Buffer result;
    BufferedSource source = this.body.source();
    source.request(byteCount);
    Buffer copy = source.buffer().clone();
    if (copy.size() > byteCount) {
      result = new Buffer();
      result.write(copy, byteCount);
      copy.clear();
    } else {
      result = copy;
    } 
    return ResponseBody.create(this.body.contentType(), result.size(), (BufferedSource)result);
  }
  
  @Nullable
  public ResponseBody body() {
    return this.body;
  }
  
  public Builder newBuilder() {
    return new Builder(this);
  }
  
  public boolean isRedirect() {
    switch (this.code) {
      case 300:
      case 301:
      case 302:
      case 303:
      case 307:
      case 308:
        return true;
    } 
    return false;
  }
  
  @Nullable
  public Response networkResponse() {
    return this.networkResponse;
  }
  
  @Nullable
  public Response cacheResponse() {
    return this.cacheResponse;
  }
  
  @Nullable
  public Response priorResponse() {
    return this.priorResponse;
  }
  
  public List<Challenge> challenges() {
    String responseField;
    if (this.code == 401) {
      responseField = "WWW-Authenticate";
    } else if (this.code == 407) {
      responseField = "Proxy-Authenticate";
    } else {
      return Collections.emptyList();
    } 
    return HttpHeaders.parseChallenges(headers(), responseField);
  }
  
  public CacheControl cacheControl() {
    CacheControl result = this.cacheControl;
    return (result != null) ? result : (this.cacheControl = CacheControl.parse(this.headers));
  }
  
  public long sentRequestAtMillis() {
    return this.sentRequestAtMillis;
  }
  
  public long receivedResponseAtMillis() {
    return this.receivedResponseAtMillis;
  }
  
  public void close() {
    if (this.body == null)
      throw new IllegalStateException("response is not eligible for a body and must not be closed"); 
    this.body.close();
  }
  
  public String toString() {
    return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request
      
      .url() + '}';
  }
  
  public static class Builder {
    @Nullable
    Request request;
    
    @Nullable
    Protocol protocol;
    
    int code = -1;
    
    String message;
    
    @Nullable
    Handshake handshake;
    
    Headers.Builder headers;
    
    @Nullable
    ResponseBody body;
    
    @Nullable
    Response networkResponse;
    
    @Nullable
    Response cacheResponse;
    
    @Nullable
    Response priorResponse;
    
    long sentRequestAtMillis;
    
    long receivedResponseAtMillis;
    
    public Builder() {
      this.headers = new Headers.Builder();
    }
    
    Builder(Response response) {
      this.request = response.request;
      this.protocol = response.protocol;
      this.code = response.code;
      this.message = response.message;
      this.handshake = response.handshake;
      this.headers = response.headers.newBuilder();
      this.body = response.body;
      this.networkResponse = response.networkResponse;
      this.cacheResponse = response.cacheResponse;
      this.priorResponse = response.priorResponse;
      this.sentRequestAtMillis = response.sentRequestAtMillis;
      this.receivedResponseAtMillis = response.receivedResponseAtMillis;
    }
    
    public Builder request(Request request) {
      this.request = request;
      return this;
    }
    
    public Builder protocol(Protocol protocol) {
      this.protocol = protocol;
      return this;
    }
    
    public Builder code(int code) {
      this.code = code;
      return this;
    }
    
    public Builder message(String message) {
      this.message = message;
      return this;
    }
    
    public Builder handshake(@Nullable Handshake handshake) {
      this.handshake = handshake;
      return this;
    }
    
    public Builder header(String name, String value) {
      this.headers.set(name, value);
      return this;
    }
    
    public Builder addHeader(String name, String value) {
      this.headers.add(name, value);
      return this;
    }
    
    public Builder removeHeader(String name) {
      this.headers.removeAll(name);
      return this;
    }
    
    public Builder headers(Headers headers) {
      this.headers = headers.newBuilder();
      return this;
    }
    
    public Builder body(@Nullable ResponseBody body) {
      this.body = body;
      return this;
    }
    
    public Builder networkResponse(@Nullable Response networkResponse) {
      if (networkResponse != null)
        checkSupportResponse("networkResponse", networkResponse); 
      this.networkResponse = networkResponse;
      return this;
    }
    
    public Builder cacheResponse(@Nullable Response cacheResponse) {
      if (cacheResponse != null)
        checkSupportResponse("cacheResponse", cacheResponse); 
      this.cacheResponse = cacheResponse;
      return this;
    }
    
    private void checkSupportResponse(String name, Response response) {
      if (response.body != null)
        throw new IllegalArgumentException(name + ".body != null"); 
      if (response.networkResponse != null)
        throw new IllegalArgumentException(name + ".networkResponse != null"); 
      if (response.cacheResponse != null)
        throw new IllegalArgumentException(name + ".cacheResponse != null"); 
      if (response.priorResponse != null)
        throw new IllegalArgumentException(name + ".priorResponse != null"); 
    }
    
    public Builder priorResponse(@Nullable Response priorResponse) {
      if (priorResponse != null)
        checkPriorResponse(priorResponse); 
      this.priorResponse = priorResponse;
      return this;
    }
    
    private void checkPriorResponse(Response response) {
      if (response.body != null)
        throw new IllegalArgumentException("priorResponse.body != null"); 
    }
    
    public Builder sentRequestAtMillis(long sentRequestAtMillis) {
      this.sentRequestAtMillis = sentRequestAtMillis;
      return this;
    }
    
    public Builder receivedResponseAtMillis(long receivedResponseAtMillis) {
      this.receivedResponseAtMillis = receivedResponseAtMillis;
      return this;
    }
    
    public Response build() {
      if (this.request == null)
        throw new IllegalStateException("request == null"); 
      if (this.protocol == null)
        throw new IllegalStateException("protocol == null"); 
      if (this.code < 0)
        throw new IllegalStateException("code < 0: " + this.code); 
      if (this.message == null)
        throw new IllegalStateException("message == null"); 
      return new Response(this);
    }
  }
}
