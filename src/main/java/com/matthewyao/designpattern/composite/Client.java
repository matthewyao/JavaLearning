package com.matthewyao.designpattern.composite;

/**
 * Created by yaokuan on 2018/6/2.
 */
public class Client {
    public static void main(String[] args) {
        /** Step 1.Initial root folder */
        Folder root = new Folder("Root folder");
        root.addFile(new VideoFile("Get started.mp4"));

        Folder imageFolder = new Folder("Images folder");
        imageFolder.addFile(new ImageFile("1.jpg"));
        imageFolder.addFile(new ImageFile("2.jpg"));
        ImageFile image3 = new ImageFile("3.jpg");
        imageFolder.addFile(image3);

        Folder studyFolder = new Folder("Study folder");
        studyFolder.addFile(new TextFile("Python guide.txt"));
        studyFolder.addFile(new TextFile("Thinking in Java.txt.txt"));

        root.addFile(imageFolder);
        root.addFile(studyFolder);

        /** Step 2.Remove image file: 3.jpg, Add text file: Head first php.txt */
//        imageFolder.removeFile(image3);
//        studyFolder.addFile(new TextFile("Head first php.txt"));

        root.display();
    }
}
