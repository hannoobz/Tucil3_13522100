# Tucil3_13522100
> Sebuah program yang dapat memberikan solusi dari permainan word ladder.

## Table of Contents
* [Deskripsi Program](#general-information)
* [Requirement](#requirement)
* [Cara Kompilasi](#compile)
* [Cara Menjalankan](#run)
* [Cara Menggunakan](#use)
* [Additional Note](#note)
* [Author](#Author)

## Deskripsi Program
Word ladder (juga dikenal sebagai Doublets, word-links, change-the-word puzzles,
paragrams, laddergrams, atau word golf) adalah salah satu permainan kata yang terkenal bagi
seluruh kalangan. Word ladder ditemukan oleh Lewis Carroll, seorang penulis dan
matematikawan, pada tahun 1877. Pada permainan ini, pemain diberikan dua kata yang disebut
sebagai start word dan end word. Untuk memenangkan permainan, pemain harus menemukan
rantai kata yang dapat menghubungkan antara start word dan end word. Banyaknya huruf pada
start word dan end word selalu sama. Tiap kata yang berdekatan dalam rantai kata tersebut hanya
boleh berbeda satu huruf saja.


Program ini merupakan sebuah program yang dapat memberikan
solusi dari permainan word ladder. Program mengimplementasikan tiga algoritma
pencarian, yaitu Uniform Cost Search, Greedy Best-First Search, dan A*. Bahasa yang
digunakan untuk memeriksa kebenaran atau validasi dari kata dalam persoalan ini adalah bahasa
Inggris.


## Requirement
- Minimum Java ver 11.0.22
- Apache Ant (untuk build program)


## Cara Kompilasi Menggunakan Ant
1. Buka directory utama dari repository ini
2. Jalankan perintah 
```
ant jar-no-build
```
3. File jar akan ada pada folder ```bin```

## Cara Kompilasi Manual
1. Masuk ke directory ```src``` dari repository ini
2. Jalankan perintah
```
javac -d ../bin Main.java
```
3. Class hasil kompilasi akan ada folder ```bin```
4. Copy ```Dictionary.txt``` pada folder ```src``` ke dalam folder ```bin``` 


## Cara Menjalankan
1. Pastikan file ```Dictionary.txt``` ada pada satu directory yang sama dengan file ```.jar``` atau ```.class``` hasil kompilasi
2. Untuk menjalankan file ```.jar``` gunakan perintah berikut, nama default dari hasil kompilasi adalah ```Tucil3_13522100.jar```
```
java -jar "Tucil3_13522100.jar"
```
3. Untuk menjalankan file ```.class``` masuk ke directory hasil kompilasi, dan jalankan perintah berikut
```
java Main
```

## Cara Menggunakan
1. Masukkan kata awal pada textfield start
2. Masukkan kata tujuan pada textfield target
3. Pilih algoritma yang akan digunakan dengan menekan tombol radio sesuai dengan label algoritma
4. Tekan tombol solve untuk melakukan pencarian solusi
5. Pop-up solusi akan muncul, pop-up dapat ditutup atau dibiarkan sebelum melakukan pencarian selanjutnya

## Additional Note
Algoritma GBFS sangat rentan dengan circular loop/infinite loop, sehingga terdapat kemungkinan looping akan dibreak untuk mencegah penggunaan resource berlebihan untuk mencari solusi GBFS. Dalam kasus ini, program akan menampilkan tampilan tidak ada solusi


## Author
Created by [M. Hanief Fatkhan Nashrullah - 13522100 - @hannoobz](https://www.github.com/hannoobz) - feel free to contact me!
