package view.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import view.ConsoleUI;

public class AddDayOfBirthday extends Commands {
    private final String name = "add birthday";
    private final String help = name + ":`dd.mm.yyyy` - добавить дату рождения, к текущему `id`\n";

    public AddDayOfBirthday(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {

        int id = this.getConsole().getCurrent_id();
        if (id == 0) {
            this.getConsole().print("For editing: Need change current `id`");
            return;
        }

        Date doc_date;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            doc_date = format.parse(map.get(this.name));
        } catch (Exception e) {
            this.getConsole().print("error date format!");
            return;
        }

        this.getConsole()
                .getPresenter()
                .commandAddDOB(id, doc_date);
    }

}