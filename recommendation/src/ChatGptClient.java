


import ChatGptConfig.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;


public class ChatGptClient {

    public static void main(String[] args) {


        OpenAiService service = new OpenAiService("your_token");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Somebody once told me the world is gonna roll me")
                .model("ada")
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }

}
