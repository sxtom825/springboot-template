package com.example.demo.util;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public record Customer(String id, String name, PhoneNumber phoneNumber, Address address) {

    }

    public record PhoneNumber(String areaCode, String number) {
    }

    public record Address(String city, String address, String zipCode) {
    }


    public static void main(String[] args) {

        try {
            processLines();
         } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    static String path = "/Users/song/Desktop/cache/doc/idea/springboot-template/target/classes/";

    private static void processLines() throws IOException {
        String html = Arrays.stream(new File(path).list()).filter(name -> name.endsWith(".html")).findFirst().get();
        File file = new File(path + html);
        List<String> linesAll = Files.readAllLines(file.toPath());
        List<String> linesCode = new ArrayList<>();
        List<String> linesJdk = new ArrayList<>();
        boolean flagCode = false;
        boolean flagJdk = false;
        for (String line : linesAll) {
            if (line.contains(">code</H3>")) {
                flagCode = true;
            }
            if (line.contains(">jdk</H3>")) {
                flagJdk = true;
            }

           if (flagCode) {
               linesCode.add(line);
           }

        }

        String partten = "<DT><A HREF=";
        List<String> lines1 = linesCode.stream().filter(line -> line.trim().startsWith(partten)).toList();


        Set<String> set1 = step1(lines1);
        Files.write(Path.of(path+"a"), set1);
    }

    Map<String, Objects> map = new HashMap<>();

    private static Set<String> step1(List<String> dataLines) {
//        String data0 = dataLines.get(0);
//        String substring0 = data0.substring(data0.indexOf("=")+1, data0.lastIndexOf("</A"));
//        System.err.println(substring0);
//
//
//        String data2 = dataLines.get(2);
//        String substring2 = data2.substring(data0.indexOf("=")+1, data2.lastIndexOf("</A"));
//        System.err.println(substring2);

        Set<String> collect = dataLines.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        Map<String,String> map1 = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        collect.forEach(value ->{
            String substring = value.substring(value.indexOf("<DT><A HREF=") + 13, value.indexOf("ADD_DATE=")-2);
            map1.put(substring,value);
        });
        map1.keySet().forEach( key->{
            set1.add(map1.get(key));
        });
        Set<String> set2 = new HashSet<>();
        set2 = set1.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        return set2;
    }


//    <DT><A HREF="https://www.darkmap.cn/" ADD_DATE="1709120711"ICON="data:image/pn">天文通 - 全球光污染地图 - Light Pollution Map</A>
//    <DT><A HREF="https://lln.kim/layui/doc/index.html" ADD_DATE="1731555926">Layui 开发使用文档 - 入门指南</A>



}
