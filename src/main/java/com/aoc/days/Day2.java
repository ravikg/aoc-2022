import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

// rock paper siccisor
    // a = x = rock = 1
    //b = y = papr = 2       win = 6 and loosse = 0 
    //c = z = scissior = 3        draw =3

    public class Day2 {
        static int score1=0; static int score2 = 0;
         
        static boolean win(char c,char d) {
            if(c==('A')) {
                return (d==('Z'));
            }
            else if (c==('B')) {
                return d==('X');
            } 
            else {
                return d==('Y');
            }
        }

        static boolean draw(char c, char d) {
            if(c==('A')) {
                return (d==('X'));
            }
            else if (c==('B')) {
                return d==('Y');
            } 
            else {
                return d==('Z');
            }
        }
    
        
        static public void main(String args[]) throws IOException {
            Stream<String> lines = Files.lines(Path.of("day2.txt"));
            
            lines.forEach(line -> {
                if (line.length() == 3) {
                    char p1 = line.charAt(0);
                    char p2 = line.charAt(2);
                    if(win(p1,p2)) {
                        //System.out.println("Player 1 win");
                        if(p1=='A' && p2=='Z') {
                            score1+=7;
                            score2+=3;
                        }
                        else if(p1=='B' && p2=='X') {
                            score1+=8;
                            score2+=1;
                        }
                        else {
                            score1+=9;
                            score2+=2;
                        }
                        
                    }
                    else if(draw(p1, p2)) {
                        //System.out.println("Draw");
                        score1+=3;
                        score2+=3;

                    }
                    else {
                        //System.out.println("player 2 win");
                        if(p1=='C' && p2=='X'){
                            score1+=3;
                            score2+=7;
                        }
                        else if(p1=='A' && p2=='Y'){
                            score1+=1;
                            score2+=8;
                        }
                        else {
                            score1+=2;
                            score2+=9;
                        }
                    }


                } else {
                    System.out.println("Not a valid input!");
                }
            });
            System.out.println(score1+" "+score2);
        }
    }
    
            
             

            
