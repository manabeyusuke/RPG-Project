import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		JFrame mainFrame = new JFrame();
		mainFrame.setTitle("JAVA　QUEST");
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(320,160);
        mainFrame.setLocationRelativeTo(null);
         // JFrameよりContentPaneを取得
         Container contentPane = mainFrame.getContentPane();
      // テキストフィールドのインスタンスを生成
         final JTextField textField = new JTextField();
         // テキストエリアのインスタンスを生成
         final JTextArea textArea = new JTextArea(5,0);
      // スクロールペインにテキストエリアを追加
         JScrollPane scrollPane = new JScrollPane(textArea);
         // ラベルのインスタンスを生成
         JLabel label = new JLabel("SwingLabel");
         // ボタンのインスタンスを生成
         JButton button = new JButton("SwingButton");
        // ラベルをContentPaneに配置
        contentPane.add(label, BorderLayout.CENTER);
        // ボタンをContentPaneに配置
        contentPane.add(button, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
	    
	}

}
