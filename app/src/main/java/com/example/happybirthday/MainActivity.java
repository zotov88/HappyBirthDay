package com.example.happybirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String[] one = {"от всего сердца и души", "в твой праздник с удовольствием поднимаю бокал и", "с Днем Рождения!", "поздравляю!", "в твой прерасный день рождения",
            "даже солнце сегодня встало с улыбкой, потому что знает - у тебя сегодня день рождения!", "в этот самый светлый день",
            "спешу поздравить с днем рождения!", "прими мои искренние поздравления!", "в этот прекрасный, радостный день",
            "ты знаешь, что не только в твой день рождения, но и в любой другой день", "искренне хочу поздравить тебя!", "День рождения - особенный праздник."};
    private final String[] two = {"оставаться такой же сияющей, жизнерадостной, очаровательной и просто прекрасной.",
            "успехов, удачи, везения. В делах - мудрости. В семье - тепла и уюта. И пусть здоровье не дает сбоев и судьба никогда не подвдит.",
            "впереди - счастливых лет, здоровья, радостей, побед!", "чтобы все мечты и желания сбывались.",
            "здоровья крепчайшего, необычайного счастья, бескрайних успехов, бодрости, улыбок, оптимизма и море позитива.",
            "оставаться счастливым человеком, радоваться каждому новому дню, находить удовольствие в мелочах.",
            "чтобы жизнь не стояла на месте, а менялась в лучшую сторону, приподнося только приятные сюрпризы!", "самой счастливой, чудесной и прекрасной жизни!",
            "твердо стоять на ногах и ощущать надежную поддержку рядом.", "купаться в океане позитива, жить в радости и не знать печали.",
            "купаться в любви и деньгах, помнить, что ночь сменяется рассветом, а после дождя всегда на небе появляется солнце.",
            "здоровья, успехов, достатка! ", "удачи и верных друзей. Огромного счастья и солнечных дней!"};
    private final String[] three = {"всегда любимой и очень-очень счастливой,", "всегда такой же яркой", "легка на подъем, как парус корабля,",
            "всегда молодой, красивой и жизнерадостной,", "счастлива каждую секунду.",
            "сильной и могучей, как сосна, чтобы тебе были нипочем ни ураган, ни шторм, ни холод, ни зной.", "всегда самой красивой",
            "такой же прекрасной и всегда любимой.", "здорова, любима, красива и счастлива.", "душиста, как малина.", "всегда на высоте.",
            "уверена во всем. Все будет отлично! Счастья, денег и чудесного настроения!", "всегда прекрасна и красива как сейчас."};
    private final String[] four = {"не будет неразрешимых проблем в твоей жизни!", "всегда рядом будут люди, способные помочь и поддержать.",
            "каждый день приносит радость и самые яркие, позитивные впечатления!",
            "жизнь, как яркая мозаика, складывается из добра, радости и прекрасных событий!",
            "каждый новый день дарит тебе отличное настроение и вдохновляет на успех во всех делах!",
            "звезды сойдутся на небе в благоприятный для твоей судьбы узор и дары жизни сыпятся на тебя, как из рога изобилия!",
            "карьера стремительно идет вверх и перемены в жизни будут только в лучшую сторону!",
            "радует то, что у тебя есть, а судьба дарит как можно счастливых событий и новостей!",
            "сбываются все мечты и планы, пусть будет все прекрасно дома и на работе, и близкие всегда только радуют!",
            "твоей судьбе всегда сопутствуют успех, удача и любовь!",
            "в окна твоего дома всегда светят солнце, добро, любовь и взаимопонимание!",
            "жизнь дарит тысячи счастливых возможностей, чтобы каждая из них была использованна на все сто. Счастья, удачи, благополучия. С днем рождения!",
            "сбудутся твои мечты. Пусть окунешься в счастье ты, пусть будет ярким настроенье! Будь с позитивом! С днем рождения!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.et_input);
        Button copy = findViewById(R.id.bt_copy);
        Button generate = findViewById(R.id.bt_generate);
        Button share = findViewById(R.id.bt_share);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(generateText());
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = input.getText().toString();
                if (value.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Generate text", Toast.LENGTH_SHORT).show();
                } else {
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Data", value);
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(getApplicationContext(), "Copied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = input.getText().toString();
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Share it"));
            }
        });
    }

    private String generateText() {
        StringBuilder result = new StringBuilder("Дорогая именинница, ");
        Random random = new Random();
        result.append(one[random.nextInt(13)]);
        result = changeLetter("я", "желаю ", result);
        result.append(two[random.nextInt(13)]);
        result.append(" Будь ");
        result.append(three[random.nextInt(13)]);
        result = changeLetter("и", "пусть ", result);
        result.append(four[random.nextInt(13)]);

        return result.toString();
    }

    private StringBuilder changeLetter(String start, String end, StringBuilder stringBuilder) {
        if (stringBuilder.toString().charAt(stringBuilder.toString().length() - 1) == '!' ||
                stringBuilder.toString().charAt(stringBuilder.toString().length() - 1) == '.') {
            stringBuilder.append(" " + start.toUpperCase() + " ");
        } else {
            stringBuilder.append(" " + start + " ");
        }
        return stringBuilder.append(end);
    }
}