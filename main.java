import javax.swing.*; // Brings in the visual components (Windows, Buttons, Text fields)
import java.awt.*;    // Brings in styling tools (Fonts, Colors)
import java.awt.event.ActionEvent; // Handles the data when a button is clicked
import java.awt.event.ActionListener; // Allows our program to listen to mouse clicks

// We use 'implements ActionListener' so this code can watch for button clicks
public class Main implements ActionListener {

    // --- STEP 1: CREATE THE PIECES FOR OUR CALCULATOR WINDOW ---
    JFrame window;       // The main outside window frame
    JTextField screen;   // The calculation display screen at the top

    // Creating our individual clickable buttons one by one with simple names
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JButton btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear;

    // Creating variables to hold our numbers and math calculations
    double firstNumber = 0;
    double secondNumber = 0;
    double finalAnswer = 0;
    char mathOperator; // Holds symbols like '+', '-', '*', or '/'

    // A nice, big bold font so the numbers are easy to read
    Font customFont = new Font("Arial", Font.BOLD, 24);

    // --- STEP 2: THE CONSTRUCTOR (This builds the layout from scratch) ---
    public Main() {
        
        // Build the main outside window frame
        window = new JFrame("My First Java Calculator");
        window.setSize(400, 600); // 400 pixels wide, 600 pixels tall
        window.setLayout(null);   // Clean absolute positioning layout
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the app when 'X' is clicked

        // Build the text display screen at the top
        screen = new JTextField();
        screen.setBounds(25, 25, 330, 60); // x=25, y=25, width=330, height=60
        screen.setFont(customFont);
        screen.setEditable(false); // Prevents user from typing letters with a physical keyboard
        screen.setHorizontalAlignment(JTextField.RIGHT); // Numbers start from the right side

        // Initialize our number buttons 0 through 9
        btn1 = new JButton("1"); btn2 = new JButton("2"); btn3 = new JButton("3");
        btn4 = new JButton("4"); btn5 = new JButton("5"); btn6 = new JButton("6");
        btn7 = new JButton("7"); btn8 = new JButton("8"); btn9 = new JButton("9");
        btn0 = new JButton("0");

        // Initialize our math action buttons
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");
        btnEqual = new JButton("=");
        btnClear = new JButton("C");

        // --- STEP 3: POSITION EVERY SINGLE BUTTON (X, Y, Width, Height) ---
        // Row 1: 1, 2, 3, +
        btn1.setBounds(25, 110, 70, 60);
        btn2.setBounds(110, 110, 70, 60);
        btn3.setBounds(195, 110, 70, 60);
        btnAdd.setBounds(280, 110, 75, 60);

        // Row 2: 4, 5, 6, -
        btn4.setBounds(25, 190, 70, 60);
        btn5.setBounds(110, 190, 70, 60);
        btn6.setBounds(195, 190, 70, 60);
        btnSub.setBounds(280, 190, 75, 60);

        // Row 3: 7, 8, 9, *
        btn7.setBounds(25, 270, 70, 60);
        btn8.setBounds(110, 270, 70, 60);
        btn9.setBounds(195, 270, 70, 60);
        btnMul.setBounds(280, 270, 75, 60);

        // Row 4: C, 0, =, /
        btnClear.setBounds(25, 350, 70, 60);
        btn0.setBounds(110, 350, 70, 60);
        btnEqual.setBounds(195, 350, 70, 60);
        btnDiv.setBounds(280, 350, 75, 60);

        // --- STEP 4: APPLY FONTS & CONNECT BUTTONS TO THE LISTENER ---
        // Grouping them into an array here makes it easy to style them in 3 lines of code!
        JButton[] allButtons = {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear};
        
        for (JButton button : allButtons) {
            button.setFont(customFont);
            button.addActionListener(this); // Tells the button to report clicks to this program
            button.setFocusable(false);    // Removes ugly highlight lines around the text
            window.add(button);            // Physically sticks the button onto the window panel
        }

        // Add the top screen to the window container frame
        window.add(screen);
        
        window.setLocationRelativeTo(null); // Centers the calculator window in the middle of your monitor
        window.setVisible(true);            // Renders the app visible
    }

    // --- STEP 5: THE CLICK INTERCEPTOR (Runs automatically whenever ANY button is pressed) ---
    @Override
public void actionPerformed(ActionEvent e) {
    Object clicked = e.getSource();

    // 1. NUMBER BUTTONS (Linked with else-if so they never interfere)
    if (clicked == btn1) {
        screen.setText(screen.getText().concat("1"));
    } else if (clicked == btn2) {
        screen.setText(screen.getText().concat("2"));
    } else if (clicked == btn3) {
        screen.setText(screen.getText().concat("3"));
    } else if (clicked == btn4) {
        screen.setText(screen.getText().concat("4"));
    } else if (clicked == btn5) {
        screen.setText(screen.getText().concat("5"));
    } else if (clicked == btn6) {
        screen.setText(screen.getText().concat("6"));
    } else if (clicked == btn7) {
        screen.setText(screen.getText().concat("7"));
    } else if (clicked == btn8) {
        screen.setText(screen.getText().concat("8"));
    } else if (clicked == btn9) {
        screen.setText(screen.getText().concat("9"));
    } else if (clicked == btn0) {
        screen.setText(screen.getText().concat("0"));
    }
    
    // 2. CLEAR BUTTON If Clear (C) is clicked, wipe the screen blank
    else if (clicked == btnClear) {
        screen.setText("");
        firstNumber = 0;
        secondNumber = 0;
        finalAnswer = 0;
    }

    // 3. OPERATOR BUTTONS (Only run if the screen actually has a number) 
    //Save the number on screen, remember the operator symbol, and clear the display for number 2.
    else if (!screen.getText().isEmpty()) {
        if (clicked == btnAdd) {
            firstNumber = Double.parseDouble(screen.getText());
            mathOperator = '+';
            screen.setText("");
        } else if (clicked == btnSub) {
            firstNumber = Double.parseDouble(screen.getText());
            mathOperator = '-';
            screen.setText("");
        } else if (clicked == btnMul) {
            firstNumber = Double.parseDouble(screen.getText());
            mathOperator = '*';
            screen.setText("");
        } else if (clicked == btnDiv) {
            firstNumber = Double.parseDouble(screen.getText());
            mathOperator = '/';
            screen.setText("");
        }
        
        // 4. EQUALS BUTTON (Kept completely inside its own secure block)
        //CALCULATING THE FINAL ANSWER (=) ---
        else if (clicked == btnEqual) {
            secondNumber = Double.parseDouble(screen.getText());
            
            switch (mathOperator) {
                case '+':
                    finalAnswer = firstNumber + secondNumber;
                    break;
                case '-':
                    finalAnswer = firstNumber - secondNumber;
                    break;
                case '*':
                    finalAnswer = firstNumber * secondNumber;
                    break;
                case '/':
                    if (secondNumber != 0) {
                        finalAnswer = firstNumber / secondNumber;
                    } else {
                        screen.setText("Error");
                        return;
                    }
                    break;
            }
            // Convert the numeric mathematical answer back into string text and display it

            screen.setText(String.valueOf(finalAnswer));
            firstNumber = finalAnswer; // Caches the answer safely inside the equals routine!
        }
    }
}

    // Standard starting engine execution point
    public static void main(String[] args) {
        new Main(); // Launches our clean, visual app window!
    }
}
