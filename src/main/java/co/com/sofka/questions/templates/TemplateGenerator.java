package co.com.sofka.questions.templates;

public class TemplateGenerator {
    private final String question;
    private final String answer;

    public TemplateGenerator(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getTemplate(){
        return "<div style=\"border: 1px solid; margin: 60px; border-radius: 20px;\">\n" +
                "        <div>\n" +
                "            <h1 style=\"background-color: rgb(0, 0, 0); margin: 0; padding: 10px; border-top-left-radius: 20px; border-top-right-radius: 20px; text-align: center; color: aliceblue;\">Nueva respuesta agregada</h1>\n" +
                "            <div style=\"background-color: rgb(235, 235, 235); padding: 10px 20px 20px 20px; border-bottom-left-radius: 20px; border-bottom-right-radius: 20px;\">\n" +
                "                <h2 style=\"margin: 0;\">" + this.question + "</h2>\n" +
                "                <p style=\"font-size: 20px;\">Al parecer uno de nuestros usuarios ha encontrado respuesta a una de tus preguntas, por  lo que queremos compartirte su respuesta: <br> \n" +
                "                    Respuesta: " + this.answer + "\n" +
                "                </p>\n" +
                "                <div style=\"margin: 30px 0 10px 0;\">\n" +
                "                    <a href=\"#\" style=\"background-color: #ea3546; padding: 15px 30px 15px 30px; border-radius: 10px; color: aliceblue; text-decoration: none; font-size: 20px;\">Ir a revisar</a>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>";
    }
}
