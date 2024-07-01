package lk.ijse.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import lk.ijse.Model.MealModel;

public class MainForm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AP01;

    @FXML
    private Text time;


    @FXML
    private AnchorPane AP02;

    @FXML
    private AnchorPane AP03;

    @FXML
    private AnchorPane AP04;

    @FXML
    private Circle C4;

    @FXML
    private Circle C41;

    @FXML
    private Circle C42;

    @FXML
    private Circle C421;

    @FXML
    private Circle C4211;

    @FXML
    private AnchorPane MainFormPane;

    @FXML
    private ImageView PIC01;

    @FXML
    private ImageView PIC02;

    @FXML
    private ImageView PIC03;

    @FXML
    private ImageView PIC04;

    @FXML
    private ImageView PT180;

    @FXML
    private ImageView PT30;

    @FXML
    private ImageView PT80;

    @FXML
    private TextField SearchBar;

    @FXML
    private AnchorPane buttionpane;

    @FXML
    private Circle c1;

    @FXML
    private Circle c11;

    @FXML
    private Text c1txt;

    @FXML
    private Text c1txt1;

    @FXML
    private Text c1txt11;

    @FXML
    private Text c1txt111;

    @FXML
    private Text c1txt1111;

    @FXML
    private Circle c2;

    @FXML
    private ImageView chainaPT;

    @FXML
    private ImageView chainapic;

    @FXML
    private Text chainesfood;

    @FXML
    private Text chainesfood1;

    @FXML
    private Text chainesfood11;

    @FXML
    private ImageView chart1;

    @FXML
    private ImageView chart11;

    @FXML
    private ImageView chart12;

    @FXML
    private ImageView chocojuicepic;

    @FXML
    private Text dailyTrendingMenu;

    @FXML
    private Text date;

    @FXML
    private Text hello;

    @FXML
    private ImageView idianfoodpic;

    @FXML
    private ImageView indianPT;

    @FXML
    private Text interesttxt;

    @FXML
    private Text interesttxt1;

    @FXML
    private Text interesttxt11;

    @FXML
    private Text juicetxt;

    @FXML
    private Text juicetxt1;

    @FXML
    private Text juicetxt11;

    @FXML
    private ImageView koreanfoodpic;

    @FXML
    private ImageView korianPT;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Text liketxt;

    @FXML
    private Text liketxt1;

    @FXML
    private Text liketxt11;

    @FXML
    private ImageView morearrow;

    @FXML
    private Text msg5;

    @FXML
    private Text msg8;

    @FXML
    private Text msg81;

    @FXML
    private ImageView newstar;

    @FXML
    private ImageView newstar1;

    @FXML
    private ImageView newstar2;

    @FXML
    private ImageView newstar4;

    @FXML
    private ImageView newstar5;

    @FXML
    private ImageView newstar6;

    @FXML
    private ImageView newstar7;

    @FXML
    private ImageView notification;

    @FXML
    private ImageView oragecakepic;

    @FXML
    private Text p180;

    @FXML
    private Text p1801;

    @FXML
    private Text p18011;

    @FXML
    private Text p760;

    @FXML
    private Text p7601;

    @FXML
    private Text p76011;

    @FXML
    private Text p760111;

    @FXML
    private Text p7601111;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private AnchorPane pane4;

    @FXML
    private AnchorPane pane5;

    @FXML
    private AnchorPane paneNew;

    @FXML
    private Text perera;

    @FXML
    private ImageView pic1;

    @FXML
    private ImageView pic2;

    @FXML
    private ImageView pic3;

    @FXML
    private ImageView pic4;

    @FXML
    private ImageView pic5;

    @FXML
    private ImageView q;



    @FXML
    private Text rs2;

    @FXML
    private Text rs3;

    @FXML
    private Text rs4;

    @FXML
    private ImageView s1;

    @FXML
    private ImageView s10;

    @FXML
    private ImageView s11;

    @FXML
    private ImageView s12;

    @FXML
    private ImageView s2;

    @FXML
    private ImageView s3;

    @FXML
    private ImageView s4;

    @FXML
    private ImageView s5;

    @FXML
    private ImageView s6;

    @FXML
    private ImageView s7;

    @FXML
    private ImageView s8;

    @FXML
    private ImageView s9;

    @FXML
    private ImageView serchpic;

    @FXML
    private ImageView setting;

    @FXML
    private Text total;

    @FXML
    private Text total1;

    @FXML
    private Text total11;

    @FXML
    private Text totaltxt;

    @FXML
    private Text totaltxt1;

    @FXML
    private Text totaltxt11;

    @FXML
    private Text txt01;

    @FXML
    private Text txt02;

    @FXML
    private Text txt1;

    @FXML
    private Text txt12;

    @FXML
    private Text txt121;

    @FXML
    private Text txt1211;

    @FXML
    private Text txt12111;

    @FXML
    private Text txt2;

    @FXML
    private Text txt3;

    @FXML
    private Text txt4;

    @FXML
    private Text txtC;

    @FXML
    private Text txtC1;

    @FXML
    private Text txtC2;

    @FXML
    private Text txtC21;

    @FXML
    private Text txtC211;
    @FXML
    private Text rs1;

    @FXML
    private ImageView userpic;

    @FXML
    private ImageView watermelonpic;


    @FXML
    void initialize() {
       getDate();
       getPrice();
       getTime();

        assert AP01 != null : "fx:id=\"AP01\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert AP02 != null : "fx:id=\"AP02\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert AP03 != null : "fx:id=\"AP03\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert AP04 != null : "fx:id=\"AP04\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert C4 != null : "fx:id=\"C4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert C41 != null : "fx:id=\"C41\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert C42 != null : "fx:id=\"C42\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert C421 != null : "fx:id=\"C421\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert C4211 != null : "fx:id=\"C4211\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert MainFormPane != null : "fx:id=\"MainFormPane\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PIC01 != null : "fx:id=\"PIC01\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PIC02 != null : "fx:id=\"PIC02\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PIC03 != null : "fx:id=\"PIC03\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PIC04 != null : "fx:id=\"PIC04\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PT180 != null : "fx:id=\"PT180\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PT30 != null : "fx:id=\"PT30\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert PT80 != null : "fx:id=\"PT80\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert SearchBar != null : "fx:id=\"SearchBar\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert buttionpane != null : "fx:id=\"buttionpane\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1 != null : "fx:id=\"c1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c11 != null : "fx:id=\"c11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1txt != null : "fx:id=\"c1txt\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1txt1 != null : "fx:id=\"c1txt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1txt11 != null : "fx:id=\"c1txt11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1txt111 != null : "fx:id=\"c1txt111\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c1txt1111 != null : "fx:id=\"c1txt1111\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert c2 != null : "fx:id=\"c2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chainaPT != null : "fx:id=\"chainaPT\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chainapic != null : "fx:id=\"chainapic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chainesfood != null : "fx:id=\"chainesfood\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chainesfood1 != null : "fx:id=\"chainesfood1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chainesfood11 != null : "fx:id=\"chainesfood11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chart1 != null : "fx:id=\"chart1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chart11 != null : "fx:id=\"chart11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chart12 != null : "fx:id=\"chart12\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert chocojuicepic != null : "fx:id=\"chocojuicepic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert dailyTrendingMenu != null : "fx:id=\"dailyTrendingMenu\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert hello != null : "fx:id=\"hello\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert idianfoodpic != null : "fx:id=\"idianfoodpic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert indianPT != null : "fx:id=\"indianPT\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert interesttxt != null : "fx:id=\"interesttxt\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert interesttxt1 != null : "fx:id=\"interesttxt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert interesttxt11 != null : "fx:id=\"interesttxt11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert juicetxt != null : "fx:id=\"juicetxt\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert juicetxt1 != null : "fx:id=\"juicetxt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert juicetxt11 != null : "fx:id=\"juicetxt11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert koreanfoodpic != null : "fx:id=\"koreanfoodpic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert korianPT != null : "fx:id=\"korianPT\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert lblDate != null : "fx:id=\"lblDate\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert liketxt != null : "fx:id=\"liketxt\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert liketxt1 != null : "fx:id=\"liketxt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert liketxt11 != null : "fx:id=\"liketxt11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert morearrow != null : "fx:id=\"morearrow\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert msg5 != null : "fx:id=\"msg5\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert msg8 != null : "fx:id=\"msg8\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert msg81 != null : "fx:id=\"msg81\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar != null : "fx:id=\"newstar\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar1 != null : "fx:id=\"newstar1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar2 != null : "fx:id=\"newstar2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar4 != null : "fx:id=\"newstar4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar5 != null : "fx:id=\"newstar5\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar6 != null : "fx:id=\"newstar6\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert newstar7 != null : "fx:id=\"newstar7\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert notification != null : "fx:id=\"notification\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert oragecakepic != null : "fx:id=\"oragecakepic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p180 != null : "fx:id=\"p180\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p1801 != null : "fx:id=\"p1801\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p18011 != null : "fx:id=\"p18011\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p760 != null : "fx:id=\"p760\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p7601 != null : "fx:id=\"p7601\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p76011 != null : "fx:id=\"p76011\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p760111 != null : "fx:id=\"p760111\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert p7601111 != null : "fx:id=\"p7601111\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pane1 != null : "fx:id=\"pane1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pane2 != null : "fx:id=\"pane2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pane3 != null : "fx:id=\"pane3\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pane4 != null : "fx:id=\"pane4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pane5 != null : "fx:id=\"pane5\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert paneNew != null : "fx:id=\"paneNew\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert perera != null : "fx:id=\"perera\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pic1 != null : "fx:id=\"pic1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pic2 != null : "fx:id=\"pic2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pic3 != null : "fx:id=\"pic3\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pic4 != null : "fx:id=\"pic4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert pic5 != null : "fx:id=\"pic5\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert q != null : "fx:id=\"q\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert rs2 != null : "fx:id=\"rs2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert rs3 != null : "fx:id=\"rs3\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert rs4 != null : "fx:id=\"rs4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s1 != null : "fx:id=\"s1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s10 != null : "fx:id=\"s10\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s11 != null : "fx:id=\"s11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s12 != null : "fx:id=\"s12\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s2 != null : "fx:id=\"s2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s3 != null : "fx:id=\"s3\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s4 != null : "fx:id=\"s4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s5 != null : "fx:id=\"s5\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s6 != null : "fx:id=\"s6\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s7 != null : "fx:id=\"s7\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s8 != null : "fx:id=\"s8\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert s9 != null : "fx:id=\"s9\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert serchpic != null : "fx:id=\"serchpic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert setting != null : "fx:id=\"setting\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert total != null : "fx:id=\"total\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert total1 != null : "fx:id=\"total1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert total11 != null : "fx:id=\"total11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert totaltxt != null : "fx:id=\"totaltxt\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert totaltxt1 != null : "fx:id=\"totaltxt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert totaltxt11 != null : "fx:id=\"totaltxt11\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt01 != null : "fx:id=\"txt01\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt02 != null : "fx:id=\"txt02\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt12 != null : "fx:id=\"txt12\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt121 != null : "fx:id=\"txt121\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt1211 != null : "fx:id=\"txt1211\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt12111 != null : "fx:id=\"txt12111\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txt4 != null : "fx:id=\"txt4\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txtC != null : "fx:id=\"txtC\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txtC1 != null : "fx:id=\"txtC1\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txtC2 != null : "fx:id=\"txtC2\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txtC21 != null : "fx:id=\"txtC21\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert txtC211 != null : "fx:id=\"txtC211\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert userpic != null : "fx:id=\"userpic\" was not injected: check your FXML file 'MainForm.fxml'.";
        assert watermelonpic != null : "fx:id=\"watermelonpic\" was not injected: check your FXML file 'MainForm.fxml'.";

    }

    private void getTime() {

    }


    private void getPrice() {
    }

    private void getDate() {
        LocalDate now = LocalDate.now();
        date.setText(String.valueOf(now));
    }

}
