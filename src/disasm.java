import java.io.*;

//
// Não alterar o nome da classe!
//
class disasm {
    public static void main(String[] args) {
        if (args.length == 0)
        {
            return;
        }

        String filename = args[0];

        try ( InputStream inputStream = new FileInputStream(filename); )
        {
            long _byte;
            String byteHex, endHex, opcode;

            do {
                opcode = "";
                endHex = "";
                byteHex = "";

                for (int i = 0; i < 2; i++) {
                    _byte = inputStream.read();

                    if(_byte == 0)
                        byteHex += "00";

                    else if(_byte < 16)
                        byteHex += "0" + Integer.toHexString((int) _byte);

                    else
                        byteHex += Integer.toHexString((int) _byte);
                }

                for (int i = 1; i < byteHex.length(); i++){
                    if (byteHex.charAt(i) == '0') {
                        if (endHex.length() != 0) {
                            endHex += byteHex.charAt(i);
                        }
                    }
                    else{
                        endHex += byteHex.charAt(i);
                    }
                }

                opcode = SelectOpcode(byteHex.charAt(0));
                if (endHex.length() == 0)
                    endHex = "0";

                if(HaveAddress(byteHex.charAt(0)))
                    System.out.println(opcode + " " + endHex);
                else
                    System.out.println(opcode);

            } while (inputStream.available() != 0);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean HaveAddress(char opcode){
        if (opcode == '5') return false;
        else if (opcode == '6') return false;
        else if (opcode == '7') return false;
        else if (opcode == 'a') return false;
        return true;
    }
    public static String SelectOpcode(char opcode){
        if (opcode == '0') return "jns";
        else if (opcode == '1') return "load";
        else if (opcode == '2') return "store";
        else if (opcode == '3') return "add";
        else if (opcode == '4') return "subt";
        else if (opcode == '5') return "input";
        else if (opcode == '6') return "output";
        else if (opcode == '7') return "halt";
        else if (opcode == '8') return "skipcond";
        else if (opcode == '9') return "jump";
        else if (opcode == 'a') return "clear";
        else if (opcode == 'b') return "addi";
        else if (opcode == 'c') return "jumpi";
        else if (opcode == 'd') return "loadi";
        else if (opcode == 'e') return "storei";
        else return null;
    }
}
