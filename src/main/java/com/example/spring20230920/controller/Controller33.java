package com.example.spring20230920.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main33")
public class Controller33 {
    @GetMapping("sub1")
    public void method1() {

    }


    // 전송한 파일은 MultipartFile 데이터타입으로 쓰면됨. 파라미터명은 jsp에 input에 name으로 쓴것
    @PostMapping("sub2")
    public void method2(String name,
                        Integer age,
                        MultipartFile myfile) throws IOException{
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        if(myfile != null) {
            String fileName = myfile.getOriginalFilename();
            System.out.println("fileName = " + fileName);

            String path = "C:\\Temp\\upload_" + fileName;
            InputStream inputStream = myfile.getInputStream();// 클라이언트에서 컨트롤러로 갈떈 인풋파일
            FileOutputStream outputStream = new FileOutputStream(path); //꺼낼땐 아웃스트림

            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            try(bis; bos; inputStream; outputStream) {
                byte[] data = new byte[1024];
                int len = 0;

                while ((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }

    @GetMapping("sub3")
    public void method3()  {

    }

    @PostMapping("sub4")
    public void method4(MultipartFile upload) throws IOException {
        //업로드한 파일을 C:\\Temp\\   폴더 내에 저장하기

        if(upload != null) {
            String fileName = upload.getOriginalFilename();

            String path= "C:\\Temp\\";

            BufferedInputStream bis = new BufferedInputStream(upload.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + fileName));

            try(bis; bos) {
                byte[] data = new byte[2048];
                int len = 0;

                while((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }


    @GetMapping("sub5")
    public void method5() {

    }

    //파일 여러개보내기
    @PostMapping("sub6")
    public void method6(MultipartFile[] files) throws IOException {
//        System.out.println("files.length = " + files.length); //파일 선택 안하고 전송버튼 눌러도 length는 1이 뜨니까 주의
        System.out.println("업로드 파일 크기들.");
        for( MultipartFile file: files) {
            System.out.println("file.getSize() = " + file.getSize()); //파일 크기는 선택 안하면 0으로 뜸

            if(file.getSize() > 0) { //파일 크기가 0보다 클때 이용.
                String path = "C:\\Temp\\";
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));
                try ( bis; bos) {
                    int len = 0;
                    byte[] data = new byte[2048];

                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);

                    }
                    bos.flush();
                }
            }
        }
    }

        @GetMapping("sub7")
        public void method7() {

        }

        @PostMapping("sub8")
        public void method8(@RequestParam(value = "files", required = false) MultipartFile[] fileList) throws IOException {
            // @RequestParam와 jsp의 name의 이름만 같으면됨

            //여러 업로드된 파일을
            //  C:\\Temp\\upload\\
            // 에 저장 (upload라는 폴더가 없으면 만드는 코드까지 해야함)
            for (MultipartFile file: fileList) {
                if( file.getSize() > 0) {

                        String dirPath = "C:\\Temp\\upload";
                        String filePath = dirPath + "\\" + file.getOriginalFilename();
                        File dir = new File(dirPath);
                        if(!dir.exists()) {
                            dir.mkdirs();
                        }
                        BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));

                    try(bis; bos) {
                        int len = 0;
                        byte[] data = new byte[2048];

                        while(( len = bis.read(data))!= -1) {
                            bos.write(data, 0, len);
                        }
                        bos.flush();
                    }




                }
            }
        }








}


