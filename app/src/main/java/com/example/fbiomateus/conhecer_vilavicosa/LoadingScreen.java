package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoadingScreen extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        getSupportActionBar().hide(); //Remover barra de titulo

        dbHelper = new DBHelper(this);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    if (dbHelper.getPlacebyName("Palácio Ducal").isEmpty()){
                        dbHelper.insertPlace("Monumentos", "Palácio Ducal", "O Paço Ducal representa um dos mais emblemáticos monumentos de Vila Viçosa. A sua edificação iniciou-se em 1501 por ordem de D. Jaime, quarto duque de Bragança, mas as obras que lhe conferiram a grandeza e características que hoje conhecemos prolongaram-se pelos séculos XVI e XVII." +
                                "\n" +
                                "Os 110 metros de comprimento da fachada de estilo maneirista, totalmente revestida a mármore da região, fazem deste magnífico palácio real um exemplar único na arquitectura civil portuguesa, onde estadiaram personalidades de grande projecção nacional e internacional.", "10:00", "17:00", "268 980 659", "http://www.vamosaqui.pt/wp-content/uploads/2016/04/Pa%C3%A7o-Ducal-em-Vila-Vi%C3%A7osa-2-1.jpg", "38.782500", "-7.421944");
                    }
                    if (dbHelper.getPlacebyName("Restaurante Os Cucos").isEmpty()) {
                        dbHelper.insertPlace("Restaurantes", "Restaurante Os Cucos", "Situado em Vila Viçosa, o Restaurante \"Os Cucos\" é uma das principais referências no que concerne à excelência da cozinha regional alentejana.\n" +
                                "\n" +
                                "Com cerca de 150 lugares interiores e uma esplanada totalmente circundada por um espaço verdejante afastado da poluição citadina, este restaurante é um dos poucos espaços no Alentejo com caraterísticas para servir pratos regionais económicos de qualidade e com o espaço ideal para servir festas de casamento, batizados e aniversários.", "10:00", "23:00", "268 980 806", "http://boaescolha.pt/sites/default/files/imagecache/full_node/showcase/Image%206_40.png", "38.776049", "-7.419009");
                    }
                    if (dbHelper.getPlacebyName("Restaurante Taverna dos Conjurados").isEmpty()) {
                        dbHelper.insertPlace("Restaurantes", "Restaurante Taverna dos Conjurados", "Especialidades: Cogumelos na chapa recheados com presunto, Costeletas de borreguinho ao alecrim, Manjar dos Conjurados.",
                                "10:00", "23:00", "268 989 530", "http://boaescolha.pt/sites/default/files/imagecache/full_node/showcase/Image%206_40.png", "38.776049", "-7.419009");
                    }
                    if (dbHelper.getPlacebyName("Hotel Solar dos Mascarenhas").isEmpty()) {
                        dbHelper.insertPlace("Alojamento", "Hotel Solar dos Mascarenhas", "Localizado no centro histórico de Vila Viçosa, a 300 metros do Palácio Ducal, o Hotel Solar dos Mascarenhas inclui um edifício do século XVI, estábulos e jardins antigos. Apresenta acesso Wi-Fi gratuito e uma piscina exterior com um terraço para banhos de sol.\n" +
                                        "\n" +
                                        "Estes quartos decorados em estilo moderno dispõem de ar condicionado e estão situados num edifício novo no jardim. Cada quarto inclui uma televisão de ecrã plano com canais por cabo, telefone e casa de banho privativa com secador de cabelo.",
                                "00:00", "24:00", "268 886 000", "http://boaescolha.pt/sites/default/files/imagecache/full_node/showcase/Image%206_40.png", "38.780971", "-7.419574");
                    }
                    if (dbHelper.getPlacebyName("Alentejo Marmoris Hotel & Spa").isEmpty()){
                        dbHelper.insertPlace("Alojamento", "Alentejo Marmoris Hotel & Spa", "\n" +
                                "\n" +
                                "A 180 km Este de Lisboa, no coração do Alentejo e inserido na histórica vila “Vila Viçosa”, o Marmòris Hotel & Spa apresenta-se como dos mais luxuosos nos novos hotéis de Portugal. Exclusivo e distinto.\n" +
                                "\n" +
                                "Hotel único no Mundo, um verdadeiro museu dedicado ao mármore, sendo propriedade de uma família que há várias gerações trabalha nesse negócio. Localizado em Vila Viçosa, uma histórica vila alentejana que é um dos centros mundiais do mármore, o hotel ocupa um antigo lagar.\n" +
                                "\n" +
                                "Projectado pelo arquitecto João Paulo e decorado pelo arquitecto Miguel Câncio Martins (Buddha Bar, Pacha Marrakech entre outros), o hotel oferece um ambiente de enorme conforto e tranquilidade, uma hospitalidade genuína e um conjunto de serviços concebidos para oferecer experiências memoráveis.\n" +
                                "\n" +
                                "É o local ideal para uns dias em família ou para ser a sua “casa” durante uma visita a esta maravilhosa região de Portugal.\n", "Todo o dia", "", "268 887 010", "https://www.alentejomarmoris.com/images/sampledata/inicio/pt/01.jpg", "38.777200", "-7.419980");
                    }
                    if (dbHelper.getPlacebyName("Castelo de Vila Viçosa").isEmpty()) {
                        dbHelper.insertPlace("Monumentos", "Castelo de Vila Viçosa", "O castelo medieval apresenta planta quadrada, com muralhas de cerca de sessenta metros de lado, reforçadas, nos ângulos Oeste e Leste, por grandes torreões de planta circular. A sua face Noroeste e parte da Nordeste eram comuns à cerca da vila. Em seu interior ergueu-se a igreja matriz, sede da primeira paróquia da vila, e que hoje é o importante Santuário de Nossa Senhora da Conceição de Vila Viçosa, proclamada padroeira de Portugal em 1646.",
                                " "," "," "," ","38.7801"," -7.415117" );
                    }
                    if (dbHelper.getPlacebyName("Museu do Marmorre").isEmpty()) {
                        dbHelper.insertPlace("Entretenimento", "Museu do Marmore", "O magnífico mármore Português chega a todo o Mundo, oriundo das pedreiras de Vila Viçosa, Borba e Estremoz. A sua qualidade superior permite a exploração desde o período romano."
                                + "\n" + "Tendo como grande desígnio a promoção do Mármore Português e a percepção sobre os processos de extracção e transformação desta rocha ornamental de Qualidade, o Museu do Mármore de Vila Viçosa abriu as suas portas em Outubro de 2000 na antiga estação de comboios desta Vila.\n" +
                                        " \n" +
                                        "Recentemente, o Museu foi instalado na Pedreira da Gradinha, junto à saída para Borba.",
                                " 09:30","18:00 "," "," ","38.786584"," -7.424383" );
                    }
                    if (dbHelper.getPlacebyName("Igreja São Bartolomeu").isEmpty()) {
                        dbHelper.insertPlace("Monumentos", "Igreja São Bartolomeu", "Na Praça da República ergue-se este templo seiscentista, também conhecido como Igreja do Colégio ou de São Bartolomeu, edificado por ordem dos Duques de Bragança (1636), para acolher o colégio jesuíta de São João Evangelista, fundado anos antes, em 1601." +
                                "\n" +
                                "A imponente fachada, revestida com os mármores da região, é rasgada por três ordens de janelas e o mesmo número de portais, ladeados por colunas dóricas.\n" +
                                        "\n" +
                                        "Flanqueada por duas torres sineiras quadrangulares, conta ainda na fachada com o relógio ali colocado em 1822 pela autarquia.\n" +
                                        "\n" +
                                        "No seu interior, o templo é um exemplar clássico da arquitectura barroca, destacando-se o retábulo do altar-mor feito em talha dourada pelo calipolense Bartolomeu Gomes em 1726.",
                                " "," "," "," ","38.778113"," -7.419300" );
                    }
                    else{
                        Log.d("Conhecer Vila Viçosa", "Default Points not working");
                    }
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
