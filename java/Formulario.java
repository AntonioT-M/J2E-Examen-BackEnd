import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Formulario extends javax.swing.JFrame{
    public Formulario(){
        super("Formulario");
        getContentPane().setLayout(new FlowLayout());

        JPanel panelN = new JPanel();
        JPanel panelE = new JPanel();
        JPanel panelS = new JPanel();
        JPanel panelP = new JPanel();
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();
        JPanel panelContaint = new JPanel();

        JTextField textFieldN = new JTextField();
        JTextField textFieldE = new JTextField();
        JTextField textFieldS = new JTextField();
        JTextField textFieldP = new JTextField();
        JTextField textFieldA = new JTextField();

        JComboBox<String> cboSexo = new JComboBox<>(new String[]{"Selecciona", "Hombre", "Mujer"});
        cboSexo.setPreferredSize(new DimensionUIResource(230, 25));

        JButton button = new JButton("Enviar");
        
        panelN.setLayout(new FlowLayout());
        panelN.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        panelN.add(textFieldN);

        panelE.setLayout(new FlowLayout());
        panelE.setBorder(BorderFactory.createTitledBorder("Edad"));
        panelE.add(textFieldE);

        panelS.setLayout(new FlowLayout());
        panelS.setBorder(BorderFactory.createTitledBorder("Sexo"));
        panelS.add(cboSexo);

        panelP.setLayout(new FlowLayout());
        panelP.setBorder(BorderFactory.createTitledBorder("Peso"));
        panelP.add(textFieldP);

        panelA.setLayout(new FlowLayout());
        panelA.setBorder(BorderFactory.createTitledBorder("Altura"));
        panelA.add(textFieldA);

        panelB.setLayout(new FlowLayout());
        panelB.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelB.add(button);

        panelContaint.setLayout(new GridLayout(6,1));
        panelContaint.setBorder(BorderFactory.createTitledBorder("Datos de la persona"));
        panelContaint.add(panelN, null);
        panelContaint.add(panelE, null);
        panelContaint.add(panelS, null);
        panelContaint.add(panelP, null);
        panelContaint.add(panelA, null);
        panelContaint.add(panelB, null);

        textFieldN.setColumns(20);
        textFieldE.setColumns(20);
        textFieldS.setColumns(20);
        textFieldP.setColumns(20);
        textFieldA.setColumns(20);

        textFieldN.setMargin(new InsetsUIResource(2, 2, 2, 2));
        textFieldE.setMargin(new InsetsUIResource(2, 2, 2, 2));
        textFieldS.setMargin(new InsetsUIResource(2, 2, 2, 2));
        textFieldP.setMargin(new InsetsUIResource(2, 2, 2, 2));
        textFieldA.setMargin(new InsetsUIResource(2, 2, 2, 2));
        button.setMargin(new InsetsUIResource(10, 10, 10, 10));

        getContentPane().add(panelContaint);

        setSize(300,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //JOptionPane.showMessageDialog(getContentPane(), "Diste click", "Message", JOptionPane.INFORMATION_MESSAGE);
                if(textFieldN.getText().toString().trim().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "No has ingresado tu nombre", "Warning", JOptionPane.WARNING_MESSAGE);
                }else if(textFieldE.getText().toString().trim().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "No has ingresado tu edad", "Warning", JOptionPane.WARNING_MESSAGE);
                }else if(cboSexo.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(getContentPane(), "No has seleccionado tu sexo", "Warning", JOptionPane.WARNING_MESSAGE);
                }else if(textFieldP.getText().toString().trim().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "No has ingresado tu peso en Kg", "Warning", JOptionPane.WARNING_MESSAGE);
                }else if(textFieldA.getText().toString().trim().equals("")){
                    JOptionPane.showMessageDialog(getContentPane(), "No has ingresado tu altura en metros", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    try{
                    Persona persona = new Persona(textFieldN.getText().toString(), Integer.parseInt(textFieldE.getText().toString()), 
                    cboSexo.getSelectedItem().toString().charAt(0), Double.parseDouble(textFieldP.getText().toString()),Double.parseDouble(textFieldA.getText().toString()));
                    persona.generarNSS();
                    int result = persona.calcularIMC();
                    String imc;
                    if(result > 0){
                        imc = "Sobre Peso";
                    }else if(result < 0){
                        imc = "Falta de Peso";
                    }else{
                        imc = "Normal";
                    }
                    String[] botones = {"Siguiente"};
                    if(JOptionPane.showOptionDialog(getContentPane(), imc, "Detalles de tu IMC", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]) == 0){
                        if(JOptionPane.showOptionDialog(getContentPane(), persona.esMayorDeEdad() == true?"Mayor de edad":"Menor de edad", "Edad: "+persona.getEdad(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]) == 0){
                            if(JOptionPane.showOptionDialog(getContentPane(), persona.toString(), persona.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]) == 0){
                                JOptionPane.showMessageDialog(getContentPane(), "Proceso finalizado", "Message",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(getContentPane(), "Alguno de los datos ingresados no son correctos\nPor favor compruebelos", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
